package com.example.abdazizs.go_loundry.Rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alhamdulillah on 10/23/16.
 */
public class ApiClient {
    public static final String BASE_URL = "http://192.168.43.88/rest_server_golaundry/index.php/";
    public static final String BASE_upload = "http://192.168.43.88/rest_server_golaundry/application/";
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}