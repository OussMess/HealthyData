package servlets;

import forms.AuthentificationForm;
import model.Doctor;
import mongo.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Created by Oussama on 01/05/2017. */
@WebServlet(name = "AuthenticationServlet" , urlPatterns = {"/connexion"})
public class AuthenticationServlet extends HttpServlet {
    public static final String ACCES_CONNEXION    = "/connexion.jsp";
    public static final String ACCES_DASHBOARD   = "/HealthyData/dashboard";

    @Override
    public void init() throws ServletException {
        super.init();
        Connection.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuthentificationForm authentificationForm = new AuthentificationForm(request.getParameter("pseudo"), request.getParameter("password"));
        Doctor doctor = authentificationForm.getDoctor();
        if(doctor !=null){
            request.getSession().setAttribute("doctor", doctor);
            response.sendRedirect(ACCES_DASHBOARD);
        }
        else{
            request.setAttribute("error", "Connexion refusée <br/> Nom de compte ou mot de passe incorrect.");
            this.getServletContext().getRequestDispatcher( ACCES_CONNEXION ).forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( ACCES_CONNEXION ).forward(request,response);
    }
}
