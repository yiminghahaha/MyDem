package com.example.exercise1.api;

import com.example.exercise1.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String url = " http://www.wanandroid.com/project/";
    @GET("tree/json")
    Observable<Bean> getbean();
}
