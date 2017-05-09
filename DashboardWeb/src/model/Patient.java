package model;/* Created by Oussama on 30/04/2017. */

import com.mongodb.DBObject;
import mongo.Connection;
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
    private Double weight;
    private Double height;

    private List<Doctor> doctorList;
    private List<Doctor> doctorsLive;
    private List<Sensor> sensorList;
    private List<Measure> measureSelected;



    public Patient(DBObject document){
        this.id = (String)document.get("_id");
        this.lastName = (String)document.get("lastname");
        this.firstName = (String)document.get("firstname");
        this.adress = (String)document.get("adress");
        this.weight = (Double) document.get("weight");
        this.height = (Double) document.get("height");
        this.birthday = new Date((String)document.get("birthday"));
        this.sensorList =  new ArrayList<>();

    }
    public void addSensor(Sensor sensor){
        this.sensorList.add(sensor);
    }

    public void setSensorList(){
        Connection.getSensorList(this);
    }

    public List<Sensor> getSensorList() {
        return sensorList;
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

    public Double getWeight() {
        return weight;
    }

    public Double getHeight() {
        return height;
    }
}
