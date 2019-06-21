package com.example.myworkone.verify_medol;

import com.example.myworkone.api.Api;
import com.example.myworkone.beans.Verify_Bean;
import com.example.myworkone.verify_presenter.Verify_Callback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Verify_Medolimple implements Verify_medol{
    @Override
    public void getdata(final Verify_Callback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.url)
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Verify_Bean> getverify = api.getverify();
        getverify.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Verify_Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Verify_Bean verify_bean) {
                        callback.seccuss(verify_bean);
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
