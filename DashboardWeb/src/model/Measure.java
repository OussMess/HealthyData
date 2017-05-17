package model;/* Created by Oussama on 02/05/2017. */

import com.mongodb.DBObject;

import java.net.Socket;
import java.util.List;

public class Measure {
    private Sensor sensor;
    private String id;
    private String type;
    private Double sill;
    private String unit;
    private List<Information> history;
    private List<Information> realTime;

    public String getType() {
        return type;
    }


    public Measure(DBObject document){
        this.id = (String) document.get("_id");
        this.type = (String) document.get("type");
        this.sill = (Double) document.get("threshold");
        this.unit = (String) document.get("unit");
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public String getId() {
        return id;
    }

    public Double getSill() {
        return sill;
    }

    public String getUnit() {
        return unit;
    }
}
