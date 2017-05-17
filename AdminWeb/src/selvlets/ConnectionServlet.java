package selvlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Created by Oussama on 14/05/2017. */
@WebServlet(name = "ConnectionServlet" ,urlPatterns = {"/"})
public class ConnectionServlet extends HttpServlet {
    public static final String ACCES_CONNECT   = "/WEB-INF/index.jsp";
    public static final String ACCES_FLUX   = "/flux";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath()+ACCES_FLUX);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( ACCES_CONNECT ).include( request, response );
    }
}
