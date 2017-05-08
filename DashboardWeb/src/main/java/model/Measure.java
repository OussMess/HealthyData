package model;/* Created by Oussama on 02/05/2017. */

import java.util.List;

public class Measure {
    private Sensor sensor;
    private String type;
    private Float sill;
    private List<Information> history;
    private List<Information> realTime;

    public String getType() {
        return type;
    }

    public Measure(Sensor sensor, String type) {
        this.sensor = sensor;

        this.type =type;
    }
}
