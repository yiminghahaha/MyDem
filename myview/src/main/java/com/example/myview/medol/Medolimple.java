package com.example.myview.medol;

import com.example.myview.Api;
import com.example.myview.Bean;
import com.example.myview.presenter.MCallBack;

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
    public void getdata(final MCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Bean> observable = api.getda();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        callBack.seccuss(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.filed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
