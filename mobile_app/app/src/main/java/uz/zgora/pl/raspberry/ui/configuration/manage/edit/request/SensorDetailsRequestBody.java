package uz.zgora.pl.raspberry.ui.configuration.manage.edit.request;

import com.google.gson.annotations.SerializedName;

import uz.zgora.pl.raspberry.model.Sensor;
import uz.zgora.pl.raspberry.model.SensorDetails;

public class SensorDetailsRequestBody {

    @SerializedName("values")
    Sensor sensor;

    public SensorDetailsRequestBody(final SensorDetails sensorDetails) {
        sensor = sensorDetails.getSensor();
    }
}
