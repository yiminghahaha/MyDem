package com.example.exercise2.medol;

import com.example.exercise2.api.Api;
import com.example.exercise2.base.BaseCallback;
import com.example.exercise2.base.BaseMedol;
import com.example.exercise2.beans.Newbook;
import com.example.exercise2.utils.Contracte;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewMedol extends BaseMedol implements Contracte.newseccuess {

    @Override
    public void seccuess(final BaseCallback<Newbook> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.newurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Newbook> getnew = api.getnew();
        getnew.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Newbook>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Newbook newbook) {
                            callback.seccuess(newbook);
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
