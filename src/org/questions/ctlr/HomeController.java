package org.questions.ctlr;

import org.questions.dao.UserDao;
import org.questions.domain.AppUser;
import org.questions.domain.Question;
import org.questions.service.QuestionService;
import org.questions.utils.Globals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * mdnhuda@gmail.com
 * Date: Jun 30, 2010
 */

@Controller
public class HomeController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDao userDao;

    @Autowired
    private QuestionService questionService;

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String showHome(HttpServletRequest request, ModelMap model) {
        logger.debug("in home");
        SearchCmd cmd = new SearchCmd();
        Globals.setSearchCmdInSession(request, cmd);
        return show(cmd, model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public String showSearchResult(HttpServletRequest request, @RequestParam(value = "queryStr") String queryStr, ModelMap model) {
        logger.debug("in showSearchResult- queryStr={}", queryStr);

        if (!Globals.isEmpty(queryStr) && queryStr.length() > 3) {
            SearchCmd cmd = new SearchCmd();
            cmd.setQueryStr(queryStr);
            Globals.setSearchCmdInSession(request, cmd);

            return show(cmd, model);

        } else {
            return "redirect:home";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/next")
    public String showNextPage(HttpServletRequest request, ModelMap model) {
        logger.debug("in next - ");
        SearchCmd cmd = Globals.getSearchCmdFromSession(request);
        if (cmd != null) {
            cmd.setPageNumber(cmd.getPageNumber() + 1);
            Globals.setSearchCmdInSession(request, cmd);
        }
        return show(cmd, model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/prev")
    public String showPreviousPage(HttpServletRequest request, ModelMap model) {
        logger.debug("in prev - ");
        SearchCmd cmd = Globals.getSearchCmdFromSession(request);
        if (cmd != null && cmd.getPageNumber() > 1) {
            cmd.setPageNumber(cmd.getPageNumber() - 1);
            Globals.setSearchCmdInSession(request, cmd);
        }
        return show(cmd, model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/myQuestions")
    public String showMyQuestions(HttpServletRequest request, ModelMap model) {
        logger.debug("in showMyQuestions - ");

        AppUser appUser = Globals.getLoggedUserFromSession(request);
        if (appUser == null) {
            return "redirect:login";
        }

        SearchCmd cmd = new SearchCmd();
        cmd.setQuestionedByMe(true);
        cmd.setUser(appUser);
        Globals.setSearchCmdInSession(request, cmd);

        return show(cmd, model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/unanswered")
    public String showAllPending(HttpServletRequest request, ModelMap model) {
        logger.debug("in showAllPending - ");
        SearchCmd cmd = new SearchCmd();
        cmd.setUnanswered(true);
        Globals.setSearchCmdInSession(request, cmd);

        return show(cmd, model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/answered")
    public String showAllAnswered(HttpServletRequest request, ModelMap model) {
        logger.debug("in showAllAnswered - ");
        SearchCmd cmd = new SearchCmd();
        cmd.setAnswered(true);
        Globals.setSearchCmdInSession(request, cmd);

        return show(cmd, model);
    }

    private String show(SearchCmd cmd, ModelMap model) {
        List<Question> questions = questionService.search(cmd);

        model.addAttribute("categories", Globals.getCategories());
        model.addAttribute("questions", questions);
        model.addAttribute("topUsers", userDao.getTopAnswerCount());
        model.addAttribute("searchCmd", cmd);
        model.addAttribute("showNextLink", (questions.size() >= Globals.NUMBER_OF_ENTRIES_PER_PAGE));
        model.addAttribute("showPreviousLink", (cmd.getPageNumber() > 1));
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String showLoginForm(HttpServletRequest request, ModelMap model) {
        model.addAttribute("cmd", new LoginCmd());
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String processLogin(HttpServletRequest request, @ModelAttribute("cmd") LoginCmd cmd, BindingResult result) {
        ValidationUtils.rejectIfEmptyOrWhitespace(result, "email", "error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(result, "password", "error.empty");

        if (!result.hasErrors()) {
            AppUser user = userDao.get(cmd.getEmail(), cmd.getPassword());
            if (user != null) {
                Globals.setLoggedUserInSession(request, user);
                String redirectTo = ServletRequestUtils.getStringParameter(request, Globals.REDIRECT_TO_REQ_PARAM_NAME, "home");
                return "redirect:" + redirectTo;
            } else {
                result.reject("error.user.not.found");
            }
        }
        return "login";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logout(HttpServletRequest request) {
        if (request.getSession() != null) {
            request.getSession().invalidate();
        }
        return "redirect:home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/changeLanguage")
    public String changeLanguage(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam(value = "lang", defaultValue = "en") String lang) {
        response.addCookie(new Cookie("lang", lang));
        return "redirect:home";
    }
}
