package com.example.kaoshi13.api;

import com.example.kaoshi13.beans.Person;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String url = "http://api.apiopen.top/";
    @GET("getJoke")
    Observable<Person> getperson();
}
