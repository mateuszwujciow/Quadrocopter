package uz.zgora.pl.raspberry.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sensor implements Serializable {
    @SerializedName("Kp")
    private float kp;
    @SerializedName("Ki")
    private float ki;
    @SerializedName("Kd")
    private float kd;
    @SerializedName("Tf")
    private float tf;

    public Sensor(final float kp, final float ki, final float kd, final float tf) {
        this.kd = kd;
        this.ki = ki;
        this.kp = kp;
        this.tf = tf;
    }

    public float getKp() {
        return kp;
    }

    public float getKi() {
        return ki;
    }

    public float getKd() {
        return kd;
    }

    public float getTf() {
        return tf;
    }
}
