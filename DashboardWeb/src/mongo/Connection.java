package mongo;/* Created by Oussama on 08/05/2017. */


import com.mongodb.*;
import model.Doctor;
import model.Measure;
import model.Patient;
import model.Sensor;

import java.util.List;

public class Connection {
    static DB db;

    public static void init(){
        MongoClient mongo = new MongoClient("localhost",27017);
        db =mongo.getDB("HealthyData");
    }


    public static Doctor getDoctor(String username,String password){
        BasicDBObject fields = new BasicDBObject();
        fields.put("username", username);
        fields.put( "password", password);
        DBObject doctorDocument = db.getCollection("doctor").findOne(fields);
        if(doctorDocument != null){
            Doctor doctor = new Doctor(doctorDocument);
            for(Object idPatient : (List<Object>)doctorDocument.get("patients")){
                Patient patient = getPatient((String)idPatient);
                doctor.addPatient(patient);
            }
            return doctor;
        }
        return null;
    }


    public static Patient getPatient(String idPatient){
        BasicDBObject fields = new BasicDBObject();
        fields.put("_id", idPatient);
        DBObject patientDocument = db.getCollection("patient").findOne(fields);
        if(patientDocument != null){
            Patient patient = new Patient(patientDocument);
            return patient;
        }
        return null;
    }

    public static void getSensorList(Patient patient){
        BasicDBObject fields = new BasicDBObject();
        fields.put("_id", patient.getId());
        DBObject patientDocument = db.getCollection("patient").findOne(fields);
        if(patientDocument != null){
            BasicDBList idSensor = (BasicDBList)patientDocument.get("sensors");

            for(Object id : idSensor){
                Sensor sensor = getSensor((String)id);

                patient.addSensor(sensor);
            }
        }
    }
    private static Sensor getSensor(String idSensor){
        BasicDBObject fields = new BasicDBObject();
        fields.put("_id", idSensor);
        DBObject sensorDocument = db.getCollection("sensor").findOne(fields);
        if(sensorDocument != null){
            Sensor sensor = new Sensor(sensorDocument);
            BasicDBList idMeasure = (BasicDBList)sensorDocument.get("mesures");
            for(Object id : idMeasure) {
                Measure measure = getMeasure((String) id);
                if(measure != null){
                    measure.setSensor(sensor);
                    sensor.addMeasure(measure);
                }
            }
            return sensor;
        }
        return null;
    }
    private static Measure getMeasure(String idMeasure){
        BasicDBObject fields = new BasicDBObject();
        fields.put("_id", idMeasure);
        DBObject measureDocument = db.getCollection("measure").findOne(fields);
        if(measureDocument != null){
            Measure measure = new Measure(measureDocument);
            return measure;
        }
        return null;
    }





}
