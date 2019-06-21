package com.example.mywork.api;

import com.example.mywork.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String url = "http://www.wanandroid.com/";
    @GET("banner/json")
    Observable<Bean> getbean();
}
