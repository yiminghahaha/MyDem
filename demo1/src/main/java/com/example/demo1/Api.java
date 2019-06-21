package com.example.demo1;

import com.example.demo1.beans.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String url = "http://news-at.zhihu.com/api/4/";
    @GET("news/hot")
    Observable<Bean> geturl();
}
