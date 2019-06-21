package com.example.exercise4.loginmedol;

import com.example.exercise4.api.Api;
import com.example.exercise4.beans.Bean_login;
import com.example.exercise4.loginpresenter.LoginCallback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginMedolimple implements LoginMedol{
    @Override
    public void getdata(String username,String password,final LoginCallback loginCallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.url)
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Bean_login> getlogin = api.getlogin(username,password);
        getlogin.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean_login>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean_login bean_login) {
                            loginCallback.loginseccuss(bean_login);
                    }

                    @Override
                    public void onError(Throwable e) {
                            loginCallback.loginfiled(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
