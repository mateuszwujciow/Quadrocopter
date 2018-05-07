package uz.zgora.pl.raspberry.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import uz.zgora.pl.raspberry.model.Configuration;
import uz.zgora.pl.raspberry.model.ConfigurationDetails;

interface ConfigurationInterface {

    @GET("configuration-list/all")
    Observable<List<Configuration>> all();

    @POST("configuration-list")
    Observable<CommonResponse> add(@Body ConfigurationDetails configurationDetails);

    @PUT("configuration-list/{id}")
    Observable<CommonResponse> update(@Path("id") long configurationId, @Body ConfigurationDetails configurationDetails);

    @DELETE("configuration-list/{id}")
    Observable<CommonResponse> remove(@Path("id") long configurationId);
}
