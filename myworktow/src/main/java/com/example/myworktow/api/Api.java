package com.example.myworktow.api;

import com.example.myworktow.beans.Buer;
import com.example.myworktow.beans.Exependbeans;
import com.example.myworktow.beans.Fra5_bean;
import com.example.myworktow.beans.Item_bean;
import com.example.myworktow.beans.Tab_beas;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String url = " http://www.wanandroid.com/article/";
    @GET("list/0/json")
    Observable<Item_bean> getitem();

    String baner = "http://www.wanandroid.com/";
    @GET("banner/json")
    Observable<Buer> getber();

    String taburl = " http://www.wanandroid.com/project/";
    @GET("tree/json")
    Observable<Tab_beas> gettab();

    String fra5 = "https://www.wanandroid.com/project/list/";
    @GET("1/json?cid=294")
    Observable<Fra5_bean> getfra5();

    String expend = "https://www.wanandroid.com/";
    @GET("tree/json")
    Observable<Exependbeans> getexpend();
}
