package com.example.exercise4.api;
import com.example.exercise4.beans.Bean_login;
import com.example.exercise4.beans.Bean_regist;
import com.example.exercise4.beans.Tous;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    String url = "http://yun918.cn/study/public/index.php/";
    @POST("login")
    @FormUrlEncoded
    Observable<Bean_login> getlogin(@Field("username") String username,@Field("password") String password);

    @POST("register")
    @FormUrlEncoded
//    Observable<Bean_regist> getregist(@Body RequestBody body);
    Observable<Bean_regist> getregist(@Field("username") String username,@Field("password")
            String password,@Field("phone") String phone,@Field("verify") String verify);

    @GET("verify")
    Observable<Tous> gettous();
}
