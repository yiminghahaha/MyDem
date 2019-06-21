package com.example.mdemo.api;

import com.example.mdemo.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String url = "http://106.13.63.54:8080/sys/xin195yk/";
    @GET("jiekou.json")
    Observable<Bean> geturl();
}
