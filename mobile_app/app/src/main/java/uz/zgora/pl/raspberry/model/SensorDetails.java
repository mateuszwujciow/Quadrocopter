package uz.zgora.pl.raspberry.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SensorDetails implements Serializable {
    @SerializedName("configuration_id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("values")
    private Sensor sensor;

    public SensorDetails(final String name) {
        this(0, name, new Sensor(0f, 0f, 0f, 0f));
    }

    public SensorDetails(final String name, final Sensor sensor) {
        this(0, name, sensor);
    }

    public SensorDetails(final int id, final String name, final Sensor sensor) {
        this.id = id;
        this.name = name;
        this.sensor = sensor;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Sensor getSensor() {
        return sensor;
    }
}
