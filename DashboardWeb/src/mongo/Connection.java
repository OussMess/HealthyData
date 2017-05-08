package mongo;/* Created by Oussama on 08/05/2017. */


import model.Doctor;
import model.Measure;
import model.Patient;
import model.Sensor;

import java.util.List;

public class Connection {
    //static DB db;

    public static void init(){
        //MongoClient mongo = new MongoClient("localhost",27017);
        //db =mongo.getDB("HealthyData");
    }


    public static Doctor getDoctor(String username,String password){

        return null;
    }


    public static List<Patient> getPatientList(String idDoctor){
        return null;
    }
    private static List<Sensor> getSensorList(String idSensor){
        return null;
    }
    private static List<Measure> getMeasureList(String idMeasure){
        return null;
    }




}
