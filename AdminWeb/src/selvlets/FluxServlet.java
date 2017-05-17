package selvlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Created by Oussama on 14/05/2017. */
@WebServlet(name = "FluxServlet" , urlPatterns = {"/flux"})
public class FluxServlet extends HttpServlet {
    public static final String ACCES_FLUX   = "/WEB-INF/flux.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print(request.getServletPath());
        this.getServletContext().getRequestDispatcher( ACCES_FLUX ).include( request, response );
    }
}
