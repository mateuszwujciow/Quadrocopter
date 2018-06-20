package uz.zgora.pl.raspberry.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import uz.zgora.pl.raspberry.model.Configuration;
import uz.zgora.pl.raspberry.model.SensorDetails;
import uz.zgora.pl.raspberry.ui.configuration.manage.add.AddConfigurationRequestBody;
import uz.zgora.pl.raspberry.ui.configuration.manage.edit.request.SensorDetailsRequestBody;

interface ConfigurationInterface {

    @GET("configuration-list/all")
    Observable<List<Configuration>> getConfigurations();

    @GET("configuration-list/sensors/{id}")
    Observable<List<SensorDetails>> getSensors(@Path("id") int configurationId);

    @GET("configuration-list/sensors/current")
    Observable<List<SensorDetails>> getCurrentSensors();

    @POST("configuration-list/new")
    Observable<Integer> add(@Body AddConfigurationRequestBody configurationName);

    @PATCH("configuration-list/sensors/{id}/{sensorName}")
    Observable<String> update(@Path("id") long configurationId, @Path("sensorName") String sensorName, @Body SensorDetailsRequestBody sensorDetails);

    @DELETE("configuration-list/delete/{id}")
    Observable<String> remove(@Path("id") long configurationId);

    @POST("configuration-list/sensors/current/{id}")
    Observable<String> uploadToQuadrocopter(@Path("id") long configurationId);
}
