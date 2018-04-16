package uz.zgora.pl.raspberry.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

interface ConfigurationInterface {

    @GET("v1/parameters/all")
    Observable<String> all();
}
