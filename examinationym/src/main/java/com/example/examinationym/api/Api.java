package com.example.examinationym.api;

import com.example.examinationym.beans.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String url = "http://106.13.63.54:8080/sys/";
    @GET("xin195yk/jiekou.json")
    Observable<Bean> geturl();
}
