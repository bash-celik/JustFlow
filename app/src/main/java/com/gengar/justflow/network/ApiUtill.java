package com.gengar.justflow.network;

public class ApiUtill {

    public static String BASE_URL = "https://api.deezer.com/";

    public static Api getApi(){
        return RemoteClient.getRetrofit(BASE_URL).create(Api.class);

    }

}
