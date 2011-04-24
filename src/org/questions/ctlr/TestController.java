package org.questions.ctlr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String show(ModelMap model)
            throws Exception {
        model.addAttribute("greetings", "Hello World!");
        return "test";
    }
}
