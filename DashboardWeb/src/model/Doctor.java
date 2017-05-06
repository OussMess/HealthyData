package model;/* Created by Oussama on 30/04/2017. */

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String id;
    private String name;
    private String hopital;
    private String specialite;
    private String service;

    private List<Patient> patientList;
    private Patient selectedPatient;

    public Doctor(String id) {

        this.id = id;
        this.name="Fatima Kalai";
        this.patientList= new ArrayList<>();
        this.setPatientList();

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

    public void setPatientList() {

        for(int i=1;i<=50;i++){
            Patient patient = new Patient(i+"");
            patientList.add(patient);
        }
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
}
