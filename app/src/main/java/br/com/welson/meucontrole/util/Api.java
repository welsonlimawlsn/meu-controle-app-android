package br.com.welson.meucontrole.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private static Retrofit retrofit;
    private static final String API;

    static {
        API = "http://192.168.43.252:8085";
        retrofit = new Retrofit.Builder().baseUrl(API).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static Retrofit getInstance() {
        return retrofit;
    }
}
