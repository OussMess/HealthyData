package model;/* Created by Oussama on 02/05/2017. */

import com.mongodb.DBObject;

import java.util.List;

public class Measure {
    private Sensor sensor;
    private String id;
    private String type;
    private Double sill;
    private List<Information> history;
    private List<Information> realTime;

    public String getType() {
        return type;
    }


    public Measure(DBObject document){
        this.type = (String) document.get("type");
        this.sill = (Double) document.get("sill");
        this.id = (String) document.get("_id");

    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
