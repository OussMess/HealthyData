package model;/* Created by Oussama on 02/05/2017. */

import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sensor {
    private String id;
    private String name;
    private List<Measure> measureList;


    public Sensor(DBObject document){
        this.id = (String)document.get("_id");
        this.name = (String)document.get("name");
        this.measureList = new ArrayList<>();

    }

    public void addMeasure(Measure measure){
        this.measureList.add(measure);
    }

    public List<Measure> getMeasureList() {
        return measureList;
    }

    public String getName() {

        return name;
    }

    public String getId() {

        return id;
    }
}
