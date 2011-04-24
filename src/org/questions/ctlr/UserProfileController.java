package org.questions.ctlr;

import org.questions.dao.UserDao;
import org.questions.domain.AppUser;
import org.questions.utils.Globals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * mdnhuda@gmail.com
 * Date: Jun 30, 2010
 */
@Controller
@SessionAttributes("cmd")
public class UserProfileController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
    }

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET, value = "/profiles")
    public String list(HttpServletRequest request, ModelMap model) {
        List<AppUser> users = userDao.list();
        model.addAttribute("users", users);
        return "profiles";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/createProfile")
    public String showProfile(HttpServletRequest request, ModelMap model) {
        model.addAttribute("cmd", new AppUser());
        return "profile";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createProfile")
    public String saveProfile(@ModelAttribute("cmd") AppUser user,
                              HttpServletRequest request, BindingResult result) {
        new AppUserValidator().validate(user, result);
        if (user.getId() != null && user.getId() > 0) {
            result.reject("error.unauthorized");
        }

        if (result.hasErrors()) {
            return "profile";
        } else {
            userDao.save(user);
            Globals.setCommonMsgInSession(request, "common.msg.profile.created");
            return "redirect:/app/home";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/viewProfile/{id}")
    public String viewProfile(@PathVariable("id") Long id, ModelMap model) {
        AppUser user = userDao.get(id);
        if (user == null) {
            logger.error("No Profile found for id = {}", id);
            throw new RuntimeException("No Profile found for id = " + id);
        }
        model.addAttribute("cmd", user);
        return "viewProfile";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editProfile/{id}")
    public String editProfile(@PathVariable("id") Long id, ModelMap model) {
        AppUser user = userDao.get(id);
        if (user == null) {
            logger.error("No Profile found for id = {}", id);
            throw new RuntimeException("No Profile found for id = " + id);
        }
        model.addAttribute("cmd", user);
        return "profile";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editProfile/{id}")
    public String editProfile(HttpServletRequest request, @ModelAttribute("cmd") AppUser user, BindingResult result) {
        new AppUserValidator().validate(user, result);

        if (user.getId() == null || user.getId() == 0) {
            result.reject("error.unauthorized");
        }

        if (result.hasErrors()) {
            return "profile";
        } else {
            userDao.save(user);
            Globals.setLoggedUserInSession(request, user);
            Globals.setCommonMsgInSession(request, "common.msg.profile.updated");
            return "redirect:/app/home";
        }
    }
}
