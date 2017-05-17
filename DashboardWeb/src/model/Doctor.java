package model;/* Created by Oussama on 30/04/2017. */

import com.mongodb.DBObject;
import mongo.Connection;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String id;
    private String name;
    private String hopital;
    private String specialite;
    private String service;
    private String mail;
    private String tel;

    private List<Patient> patientList;
    private Patient selectedPatient;


    public String getMail() {
        return mail;
    }

    public String getTel() {
        return tel;
    }

    public Doctor(DBObject document) {
        this.id = (String)document.get("_id");
        this.name = (String)document.get("name");
        this.hopital = (String)document.get("hospital");
        this.specialite = (String)document.get("speciality");
        this.service = (String)document.get("service");
        this.mail = (String)document.get("mail");
        this.tel = (String)document.get("tel");
        this.patientList= new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPatient(Patient patient) {
        this.patientList.add(patient);
    }

    public Patient getSelectedPatient() {
        return selectedPatient;
    }

    public void setSelectedPatient(Patient selectedPatient) {
        this.selectedPatient = selectedPatient;
    }

    public Patient findPatientById(String id){
        for(Patient patient : patientList){
            if(patient.getId().equals(id)){
                return patient;
            }
        }
        return null;

    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public String getHopital() {
        return hopital;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getService() {
        return service;
    }
}
