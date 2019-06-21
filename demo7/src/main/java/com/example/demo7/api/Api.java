package com.example.demo7.api;

import com.example.demo7.beans.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String url = "http://www.wanandroid.com/article/list/";
    @GET("0/json")
    Observable<Bean> geturl();
}
