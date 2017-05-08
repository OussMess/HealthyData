package model;/* Created by Oussama on 02/05/2017. */

import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private String id;
    private String name;
    private List<Measure> measureList;

    public Sensor(String id) {
        this.id = id;
        this.name = "Sensor" + id;
        setMeasureList();
    }

    public void setMeasureList() {
        this.measureList = new ArrayList<>();
        for(int i = 0; i<50; i++){
            Measure measure = new Measure(this, this.id + "-" + Integer.toString(i));
            this.measureList.add(measure);
        }
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
