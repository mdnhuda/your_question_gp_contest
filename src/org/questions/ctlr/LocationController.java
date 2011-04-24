package org.questions.ctlr;

import gp.ws.lbs.LBSResponse;
import org.questions.service.LbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: naim
 * Date: Jun 24, 2010
 */
@Controller
public class LocationController {

    @Autowired
    private LbsService lbsService;

    @RequestMapping(method = RequestMethod.GET, value = "/showLocation")
    public void showLocation(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        String msisdn = ServletRequestUtils.getStringParameter(request, "msisdn", null);
        if (msisdn != null) {
            LBSResponse locationResp = lbsService.getLocation(msisdn);
            String locationStr = "Status: " + locationResp.getStatus()
                    + "\n"
                    + "\n Location of " + msisdn
                    + "\n long: " + locationResp.getLongitude()
                    + "\n lat: " + locationResp.getLatitude();

            model.addAttribute("location", locationStr);
        }
    }
}
