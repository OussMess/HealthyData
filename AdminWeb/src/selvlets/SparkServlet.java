package selvlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Created by Oussama on 14/05/2017. */
@WebServlet(name = "SparkServlet" , urlPatterns = {"/spark"})
public class SparkServlet extends HttpServlet {
    public static final String ACCES_SPARK   = "/WEB-INF/spark.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( ACCES_SPARK ).include( request, response );
    }
}
