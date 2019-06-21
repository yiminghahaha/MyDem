package com.example.myworkone.api;

import com.example.myworkone.beans.Item_bean;
import com.example.myworkone.beans.Login_bean;
import com.example.myworkone.beans.Regist_bean;
import com.example.myworkone.beans.Verify_Bean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    String url = "http://yun918.cn/study/public/index.php/";
    @FormUrlEncoded
    @POST("login")
    Observable<Login_bean> getlogin(@Field("username") String user, @Field("password") String pas);

    @FormUrlEncoded
    @POST("register")
    Observable<Regist_bean> getregist(@Field("username") String user,@Field("password") String pas,@Field("phone") String phone,@Field("verify") String verfit);

    @GET("verify")
    Observable<Verify_Bean> getverify();

    String playurl = " http://www.wanandroid.com/";
    @GET("banner/json")
    Observable<Item_bean> getplay();
}
