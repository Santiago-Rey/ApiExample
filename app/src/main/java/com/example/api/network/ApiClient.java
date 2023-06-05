package com.example.api.network;

import android.os.SharedMemory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    //Conexion con la api
    private static Retrofit retrofit;

    public static Retrofit getclient(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.10.7:80/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
