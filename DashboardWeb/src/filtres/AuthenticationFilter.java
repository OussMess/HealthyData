package filtres;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/* Created by Oussama on 01/05/2017. */

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/*"}, initParams = {
        @WebInitParam(name = "encoding", value = "utf-8"),
        @WebInitParam(name = "ignore", value = "false")
})
public class AuthenticationFilter implements Filter {

    public static final String ACCES_CONNEXION = "/connexion";
    public static final String ACCES_RESOURCES = "/HealthyData/resources/";
    public static final String ATT_SESSION_USER = "doctor";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();

        String a = request.getRequestURI();
        Boolean b = session.getAttribute(ATT_SESSION_USER) != null || request.getRequestURI().startsWith(ACCES_RESOURCES);

        if (session.getAttribute(ATT_SESSION_USER) != null || request.getRequestURI().startsWith(ACCES_RESOURCES)) {
           chain.doFilter(req, resp);
        } else {
            request.getRequestDispatcher(ACCES_CONNEXION).forward(request, response);

        }
    }

    public void init(FilterConfig config) throws ServletException {


    }

}
