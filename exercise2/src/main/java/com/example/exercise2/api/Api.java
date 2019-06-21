package com.example.exercise2.api;

import com.example.exercise2.beans.MoneyBean;
import com.example.exercise2.beans.Newbook;
import com.example.exercise2.beans.Shitimer;
import com.example.exercise2.beans.WorkBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String url = "https://api.apiopen.top/";
    @GET("getJoke?page=1&count=2&type=video")
    Observable<Shitimer> gettimer();

    String money = " http://gank.io/api/data/";
    @GET("%E7%A6%8F%E5%88%A9/20/1")
    Observable<MoneyBean> getmongy();

    String newurl = "http://news-at.zhihu.com/api/4/";
    @GET("news/latest")
    Observable<Newbook> getnew();

    @GET("sections")
    Observable<WorkBean> getwork();
}
