package com.example.exercise4.tousmedol;

import com.example.exercise4.api.Api;
import com.example.exercise4.beans.Tous;
import com.example.exercise4.touspresenter.Tous_Callback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Tous_medolimple implements Tous_medol{
    @Override
    public void getdata(final Tous_Callback tous_callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.url)
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Tous> gettous = api.gettous();
        gettous.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Tous>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Tous tous) {
                            tous_callback.seccuess(tous);
                    }

                    @Override
                    public void onError(Throwable e) {
                            tous_callback.filed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
