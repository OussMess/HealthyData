package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Created by Oussama on 12/05/2017. */
@WebServlet(name = "DoctorInfoServlet", urlPatterns = {"/doctorinfo"})
public class DoctorInfoServlet extends HttpServlet {

    public static final String ACCES_DOCTOR_INFO ="/WEB-INF/doctorInfo.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( ACCES_DOCTOR_INFO ).include( request, response );
    }
}
