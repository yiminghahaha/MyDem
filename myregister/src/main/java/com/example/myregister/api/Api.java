package com.example.myregister.api;
import com.example.myregister.beans.Register_bean;
import com.example.myregister.beans.Verify_bean;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    String url = "http://yun918.cn/study/public/index.php/";
    @FormUrlEncoded
    @POST("register")
    Observable<Register_bean> getrigister(@Field("username") String user, @Field("password") String pas, @Field("phone") String phone, @Field("verify") String verfiy);

    @GET("verify")
    Observable<Verify_bean> getverify();
}
