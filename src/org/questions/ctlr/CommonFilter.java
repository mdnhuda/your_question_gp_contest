package org.questions.ctlr;

import org.questions.domain.AppUser;
import org.questions.utils.Globals;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: naim
 * Date: Jul 8, 2010
 */
public class CommonFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding(Globals.ENCODING_SCHEME);
        }
        if (response.getCharacterEncoding() == null) {
            response.setCharacterEncoding(Globals.ENCODING_SCHEME);
        }

        AppUser user = Globals.getLoggedUserFromSession(request);
        if (user != null) {
            request.setAttribute(Globals.LOGGED_USER_SESSION_KEY, user);
        }

        String commonMsg = Globals.getAndRemoveCommonMsgFromSession(request);
        if (commonMsg != null) {
            request.setAttribute(Globals.COMMON_MSG_KEY, commonMsg);
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }
    public void destroy() {
    }
}
