package com.example.exercise3.api;

import com.example.exercise3.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String url = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/";
    @GET("20/1")
    Observable<Bean> geturl();
}
