package com.example.work1.medol;

import com.example.work1.Api;
import com.example.work1.Bean;
import com.example.work1.presenter.CallBack2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Medolimple implements Medol{
    @Override
    public void getdata(final CallBack2 callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Bean> observable = api.geturl();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                            callback.seccuess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            callback.filed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
