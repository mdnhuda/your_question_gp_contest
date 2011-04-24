package org.questions.ctlr;

import org.questions.utils.Globals;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * mdnhuda@gmail.com
 * Date: Jun 30, 2010
 */

public class AuthFilter implements Filter {
    public static final String loginUrl = "/app/login";
    public static final List<String> restrictedUrls;

    static {
        restrictedUrls = new ArrayList<String>();
        restrictedUrls.add(".*/app/profiles.*");
        restrictedUrls.add(".*/app/editProfile.*");
        restrictedUrls.add(".*/app/viewProfile.*");
        restrictedUrls.add(".*/app/myQuestions.*");
        restrictedUrls.add(".*/app/questions/add.*");
        restrictedUrls.add(".*/app/questions/\\d+/answer.*");
    }


    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        // remove the context path from the Request URI
        if (isRestricted(request.getRequestURI())
                && (session == null || session.getAttribute(Globals.LOGGED_USER_SESSION_KEY) == null)) {
            StringBuilder redirectUrl = new StringBuilder(request.getContextPath()).append(loginUrl);

            String requestUri = request.getRequestURI();
            if (requestUri.startsWith(request.getContextPath())) {
                requestUri = requestUri.substring(request.getContextPath().length());
            }
            appendQueryProperties(redirectUrl, Globals.REDIRECT_TO_REQ_PARAM_NAME, requestUri);
            response.sendRedirect(redirectUrl.toString());
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

    private boolean isRestricted(String uri) {
        for (String e: restrictedUrls) {
            if (uri.matches(e)) {
                return true;
            }
        }
        return false;
    }

    protected void appendQueryProperties(StringBuilder targetUrl, String param, String value)
            throws UnsupportedEncodingException {

        // Extract anchor fragment, if any.
        String fragment = null;
        int anchorIndex = targetUrl.indexOf("#");
        if (anchorIndex > -1) {
            fragment = targetUrl.substring(anchorIndex);
            targetUrl.delete(anchorIndex, targetUrl.length());
        }

        // If there aren't already some parameters, we need a "?".
        if ((targetUrl.indexOf("?") < 0)) {
            targetUrl.append('?');
        } else {
            targetUrl.append('&');
        }

        String encodedKey = URLEncoder.encode(param, Globals.ENCODING_SCHEME);
        String encodedValue = (value != null ? URLEncoder.encode(value, Globals.ENCODING_SCHEME) : "");
        targetUrl.append(encodedKey).append('=').append(encodedValue);

        // Append anchor fragment, if any, to end of URL.
        if (fragment != null) {
            targetUrl.append(fragment);
        }
    }
}

