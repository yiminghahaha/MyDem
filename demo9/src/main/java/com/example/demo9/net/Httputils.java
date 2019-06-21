package com.example.demo9.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Httputils {
    private  static  Httputils httputils;
    private final Retrofit.Builder builder;

    private Httputils() {
        builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());


    }

    public static Httputils getHttputils() {
        if (httputils==null){
            synchronized (Httputils.class){
                if (httputils==null){
                    httputils = new Httputils();
                }
            }
        }
        return httputils;
    }

    public  <T> T  geturl(String url,Class<T> tClass){
       return  builder.baseUrl(url).build().create(tClass);

    }
}
