package servlets;

import model.Doctor;
import model.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/* Created by Oussama on 02/05/2017. */
@WebServlet(name = "PatientInfoServlet", urlPatterns = {"/patient"})
public class PatientInfoServlet extends HttpServlet {
    public static final String ACCES_PATIENT_DATA   = "/WEB-INF/dataToSend/patientData.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Doctor doctor = (Doctor) request.getSession().getAttribute("doctor");
        doctor.setSelectedPatient( doctor.findPatientById(request.getParameter("idPatient")));
        this.getServletContext().getRequestDispatcher( ACCES_PATIENT_DATA ).include( request, response );

    }
}
