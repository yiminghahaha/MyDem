package com.example.myworkone.register_medol;

import com.example.myworkone.api.Api;
import com.example.myworkone.beans.Regist_bean;
import com.example.myworkone.register_presenter.Register_Callback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register_Medolimple implements Register_medol{
    @Override
    public void getdata(String username, String password, String phone, String verify, final Register_Callback register_callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Regist_bean> observable = api.getregist(username, password, phone, verify);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Regist_bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Regist_bean regist_bean) {
                        register_callback.seccuss(regist_bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        register_callback.filed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
