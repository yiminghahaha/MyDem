package com.example.work1;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String url = "http://www.qubaobei.com/";
    @GET("ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
    Observable<Bean> geturl();
}
