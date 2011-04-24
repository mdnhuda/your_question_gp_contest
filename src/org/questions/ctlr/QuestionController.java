package org.questions.ctlr;

import org.questions.domain.Answer;
import org.questions.domain.AppUser;
import org.questions.domain.Question;
import org.questions.domain.Status;
import org.questions.service.QuestionService;
import org.questions.utils.Globals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * mdnhuda@gmail.com
 * Date: Jul 2, 2010
 */
@Controller
@RequestMapping(value = "/questions")
public class QuestionController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private QuestionService questionService;

    private void addRefDataForNewQuestion(ModelMap model) {
        model.addAttribute("categoryList", Globals.getCategories());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String showAllQuestions(HttpServletRequest request, ModelMap model) {
        logger.debug("in showAllQuestions");
        return "redirect:/app/home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String showQuestionForm(HttpServletRequest request, ModelMap model) {
        model.addAttribute("cmd", new Question());
        addRefDataForNewQuestion(model);

        return "addNewQuestion";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String submitQuestionsForm(HttpServletRequest request,
                                      @ModelAttribute("cmd") Question question,
                                      BindingResult result, ModelMap model) {
        logger.debug("in submitQuestionsForm");

        ValidationUtils.rejectIfEmpty(result, "category", "error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(result, "text", "error.empty");

        if (result.hasErrors()) {
            addRefDataForNewQuestion(model);
            return "addNewQuestion";
        }

        AppUser user = Globals.getLoggedUserFromSession(request);
        question.setCreatedBy(new AppUser(user.getId()));
        question.setStatus(Status.PENDING);
        logger.debug("Question: {}", question.getText());
        questionService.save(question);
        Globals.setCommonMsgInSession(request, "common.msg.question.saved");
        return "redirect:/app/home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String showAnswerForm(HttpServletRequest request, @PathVariable(value = "id") Long questionId, ModelMap model) {
        logger.debug("in showAnswerForm, for questionId={}", questionId);

        Answer answer = new Answer();
        model.addAttribute("cmd", answer);
        model.addAttribute("question", questionService.getQuestion(questionId));

        return "question";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/answer")
    public String submitAnswer(HttpServletRequest request, @PathVariable(value = "id") Long questionId,
                               @ModelAttribute(value = "cmd") Answer answer, BindingResult result, ModelMap model) {
        logger.debug("in submitAnswer, for questionId={}", questionId);

        if(questionId == null) {
            result.reject("error.question.id.not.null");
            return "redirect:/app/home";
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(result, "text", "error.empty");
        if (!result.hasErrors()) {
            AppUser loggedUser = Globals.getLoggedUserFromSession(request);
            answer.setCreatedBy(new AppUser(loggedUser.getId()));
            questionService.saveAnswer(questionId, answer);
            Globals.setCommonMsgInSession(request, "common.msg.answer.saved");
            return "redirect:/app/home";
        } else {
            model.addAttribute("question", questionService.getQuestion(questionId));
            return "question";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/receiveSms")
    public void invokeReceiveSms(HttpServletRequest request) {
        logger.warn("invokeReceiveSms() called from Controller");
        questionService.readSmsPeriodically();
    }
}
