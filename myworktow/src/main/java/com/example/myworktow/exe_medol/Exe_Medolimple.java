package com.example.myworktow.exe_medol;

import com.example.myworktow.api.Api;
import com.example.myworktow.beans.Exependbeans;
import com.example.myworktow.exe_prese.MCallback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Exe_Medolimple implements Exe_medol{
    @Override
    public void getdata(final MCallback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.expend)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Exependbeans> getexpend = api.getexpend();
        getexpend.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Exependbeans>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Exependbeans exependbeans) {
                            callback.seccuss(exependbeans);
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
