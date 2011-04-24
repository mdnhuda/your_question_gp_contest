package org.questions.utils;

import org.questions.ctlr.SearchCmd;
import org.questions.domain.AppUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * mdnhuda@gmail.com
 * Date: Jun 30, 2010
 */
public class Globals {
    public static final String ENCODING_SCHEME = "UTF-8";

    public static final int NUMBER_OF_ENTRIES_PER_PAGE = 3;
    public static final String LOGGED_USER_SESSION_KEY = "loggedUser";
    public static final String SEARCH_CMD_SESSION_KEY = "searchCmd";
    public static final String COMMON_MSG_KEY = "commonMsg";
    public static final String REDIRECT_TO_REQ_PARAM_NAME = "redirectTo";

    private static final String[] categories =
            new String[]{"Computer", "Programming", "Engineering",
                    "Teaching", "Coaching", "Tutoring", "Advocacy",
                    "Doctor", "Dentist", "Physician",
                    "Designing", "Fashion"};

    public static String[] getCategories() {
        return categories;
    }

    public static AppUser getLoggedUserFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (AppUser) session.getAttribute(LOGGED_USER_SESSION_KEY);
        }
        return null;
    }

    public static void setLoggedUserInSession(HttpServletRequest request, AppUser user) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.setAttribute(LOGGED_USER_SESSION_KEY, user);
        }
    }

    public static void setCommonMsgInSession(HttpServletRequest request, String commonMsg) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.setAttribute(COMMON_MSG_KEY, commonMsg);
        }
    }

    public static String getAndRemoveCommonMsgFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String commonMsg;
        if (session != null && (commonMsg = (String) session.getAttribute(COMMON_MSG_KEY)) != null) {
            session.removeAttribute(COMMON_MSG_KEY);
            return commonMsg;
        }
        return null;
    }

    public static SearchCmd getSearchCmdFromSession(HttpServletRequest request) {
        if (request.getSession(false) != null) {
            return (SearchCmd) request.getSession().getAttribute(SEARCH_CMD_SESSION_KEY);
        }
        return null;
    }

    public static void setSearchCmdInSession(HttpServletRequest request, SearchCmd cmd) {
        if (request.getSession() != null) {
            request.getSession().setAttribute(SEARCH_CMD_SESSION_KEY, cmd);
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().equals("");
    }

    public static boolean isGpNumber(String phoneNumber) {
        String pattern = "^(((\\+?)88)?(0))?17(\\d{8})$";
        return phoneNumber != null && phoneNumber.matches(pattern);
    }

    public static boolean isGpNumberWithout880(String phoneNumber) {
        String pattern = "^17(\\d{8})$";
        return phoneNumber != null && phoneNumber.matches(pattern);
    }
}
