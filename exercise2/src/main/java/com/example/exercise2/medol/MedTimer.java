package com.example.exercise2.medol;

import com.example.exercise2.api.Api;
import com.example.exercise2.base.BaseCallback;
import com.example.exercise2.base.BaseMedol;
import com.example.exercise2.beans.Shitimer;
import com.example.exercise2.utils.Contracte;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MedTimer extends BaseMedol implements Contracte.timerseccuess {

    @Override
    public void seccuess(final BaseCallback<Shitimer> shitimer) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Shitimer> observable = api.gettimer();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Shitimer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Shitimer timer) {
                        if (timer.getCode()==200){
                            shitimer.seccuess(timer);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        shitimer.filed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
