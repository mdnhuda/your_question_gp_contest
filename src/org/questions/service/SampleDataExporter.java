package org.questions.service;

import org.questions.dao.UserDao;
import org.questions.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * mdnhuda@gmail.com
 * Date: Jul 3, 2010
 */
@Service
public class SampleDataExporter implements InitializingBean {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserDao userDao;

    @Autowired
    QuestionService questionService;

    public void afterPropertiesSet() throws Exception {

        Long userId = makeSampleUser();

        makeSampleQuestion("My 5 year old boy is suffering from fever for last 10 days. Can anyone get me the address of a good paediatrician from Dhaka?", null, userId);
        makeSampleQuestion("Can anybody give me the address of Drik gallery?", null, userId);
        makeSampleQuestion("I want to buy a laptop. Budget is 50k. Is any body interested to sell? Please contact @ 0123456780", null, userId);

    }

    private Long makeSampleUser() {
        AppUser user = new AppUser();
        user.setName("Test User");
        user.setAddress("Dhaka, Bangladesh");
        user.setEmail("test@example.com");
        user.setUserId("test");
        user.setPassword("test");
        user.setNote("This is a test user.");
        user.setDob(new Date(81, 1, 1));
        user.setPhoneNumber("8801717807270");
        user.setSpecialization("Computer, Software, Java");
        user.setNumberOfQuestionAnswered(3);
        return userDao.save(user);
    }

    private Long makeSampleQuestion(String questionStr, String answerStr, Long answeredById) {
        Question q = new Question();
        q.setText(questionStr);

        if (answerStr != null && answeredById != null) {
            q.setStatus(Status.ANSWERED);

            Answer answer = new Answer();
            answer.setText(answerStr);
            answer.setCreatedBy(userDao.get(answeredById));
            q.addAnswer(answer);
        } else {
            q.setStatus(Status.PENDING);
        }

        q.setReceivedAsSms(false);

        q.setCreatedBy(userDao.get(answeredById));

        return questionService.save(q);
    }
}
