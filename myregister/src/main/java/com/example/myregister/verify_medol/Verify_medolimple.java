package com.example.myregister.verify_medol;

import com.example.myregister.api.Api;
import com.example.myregister.beans.Verify_bean;
import com.example.myregister.verify_presenter.Verify_Callback;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Verify_medolimple implements Verify_medol{
    @Override
    public void getdata(final Verify_Callback verify_callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.url)
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Verify_bean> observable = api.getverify();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Verify_bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Verify_bean verify_bean) {
                        verify_callback.seccuss(verify_bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        verify_callback.filed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
