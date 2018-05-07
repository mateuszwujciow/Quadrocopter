package uz.zgora.pl.raspberry.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static uz.zgora.pl.raspberry.util.Objects.isNull;

public class BaseProvider {
    private static final String API_URL = "http://212.109.146.180:16969/";

    private static Retrofit retrofit;

    static Retrofit getRetrofit() {
        if (isNull(retrofit)) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
