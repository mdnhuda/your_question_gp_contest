package org.questions.ctlr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * mdnhuda@gmail.com
 * Date: Jun 30, 2010
 */
@Controller
public class ExceptionController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, HttpServletRequest request, ModelMap model) {
        logger.error(ex.getMessage(), ex);
        model.addAttribute("msg", ex.getMessage());
        return "error";
    }
}
