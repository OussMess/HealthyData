package model;/* Created by Oussama on 30/04/2017. */

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient {
    private String id;
    private String lastName;
    private String firstName;
    private String adress;
    private Date birthday;
    private Float weight;
    private Float height;

    private List<Doctor> doctorList;
    private List<Doctor> doctorsLive;
    private List<Sensor> sensorList;
    private List<Measure> measureSelected;

    public List<Sensor> getSensorList() {
        return sensorList;
    }

    public Patient(String id) {
        this.id = id;
        this.firstName = "prenom" + id;
        this.lastName = "nom" + id;
        this.adress="Ville" + id;

        this.birthday = new Date();
        this.height = 1.75F;
        this.weight = 65F;
        this.sensorList = new ArrayList<>();
        for(int i =0; i<30;i++){
            Sensor sensor = new Sensor(i +"");
            sensor.setMeasureList();
            this.sensorList.add(sensor);
        }
    }

    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAdress() {
        return adress;
    }

    public String getBirthday() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("dd/MM/yyyy");
        return simpleDateFormat.format(birthday);
    }

    public Float getWeight() {
        return weight;
    }

    public Float getHeight() {
        return height;
    }
}
