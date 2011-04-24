package org.questions.service;

import gp.ws.sms.ReceiveSMSResponse;
import org.questions.ctlr.SearchCmd;
import org.questions.dao.QuestionDao;
import org.questions.dao.UserDao;
import org.questions.domain.*;
import org.questions.utils.Globals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * mdnhuda@gmail.com
 * Date: Jul 4, 2010
 */
@Service
public class QuestionService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDao userDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private SmsService smsService;


    public Question getQuestion(Long id) {
        return questionDao.getQuestion(id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Long save(Question question) {
        return questionDao.save(question);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void update(Question question) {
        questionDao.update(question);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        questionDao.delete(id);
    }

    public List<Question> search(SearchCmd searchCmd) {
        return questionDao.search(searchCmd);
    }

    /**
     * Keep invoking the following method 10 minutes after the preceding invocation.
     */
//    @Scheduled(fixedDelay = 600000)
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void readSmsPeriodically() {
        List<AppUser> usersToAcknowledge = new ArrayList<AppUser>();
        List<ReceiveSMSResponse> responses = smsService.receiveSms();
        logger.debug("in readSmsPeriodically - number of sms received={}", responses.size());
        for (ReceiveSMSResponse resp : responses) {
            try {
                Question question = new Question();
                question.setText(resp.getMsgContent());

                String phnNumber = resp.getSenderMSISDN();
                if (Globals.isGpNumberWithout880(phnNumber)) {
                    phnNumber = "880" + phnNumber;
                }

                AppUser user = userDao.getUserByPhoneNumber(phnNumber);
                if (user == null) {
                    user = new AppUser();
                    user.setName("Anonymous User");
                    user.setUserId(phnNumber);
                    user.setPassword(phnNumber);
                    user.setPhoneNumber(phnNumber);
                    userDao.save(user);
                }
                question.setCreatedBy(user);
                question.setStatus(Status.PENDING);
                question.setReceivedAsSms(true);
                questionDao.save(question);
                usersToAcknowledge.add(user);
            } catch (Exception ex) {
                logger.error("Error occurred while processing sms. sender={}, content={}", resp.getSenderMSISDN(), resp.getMsgContent());
            }
        }
        smsService.sendAcknowldgement(usersToAcknowledge);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveAnswer(Long questionId, Answer answer) {
        Question question = getQuestion(questionId);
        question.setStatus(Status.ANSWERED);
        question.addAnswer(answer);
        questionDao.update(question);
        userDao.increamentNumberOfQuestionAnswered(answer.getCreatedBy().getId());

        if (question.isReceivedAsSms() && Globals.isGpNumber(question.getCreatedBy().getPhoneNumber())) {
            AnswerSms answerSms = new AnswerSms();
            answerSms.setAnswer(answer.getText());
            answerSms.setDestination(question.getCreatedBy().getPhoneNumber());
            answerSms.setSource(answer.getCreatedBy().getPhoneNumber());
            answerSms.setQuestionId(question.getId());
            answerSms.setQuestion(question.getText());
            answerSms.setSent(false);
            answerSms.setDateCreated(new Date());
            smsService.sendSms(answerSms);
        }
    }

    public Long save(Answer answer) {
        return questionDao.save(answer);
    }
}
