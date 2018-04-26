package com.gengar.justflow.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteClient {


    private static Retrofit retrofit;

    public  static Retrofit getRetrofit(String baseUrl){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseUrl)
                    .build();
        }

        return retrofit;
    }

}
