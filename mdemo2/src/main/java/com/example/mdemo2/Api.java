package com.example.mdemo2;

import com.example.mdemo2.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String url = " http://www.wanandroid.com/project/list/";
    @GET("1/json?cid=294")
    Observable<Bean> getbean();
}
