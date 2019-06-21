package com.example.myworktow.medol;

import com.example.myworktow.api.Api;
import com.example.myworktow.beans.Buer;
import com.example.myworktow.beans.Item_bean;
import com.example.myworktow.presenter.Callback;
import com.example.myworktow.presenter.Callback2;

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
    public void getdata1(final Callback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Item_bean> getitem = api.getitem();
        getitem.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Item_bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Item_bean item_bean) {
                        if (item_bean!=null){
                            callback.seccuss1(item_bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                            callback.filed1(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getdata2(final Callback2 callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.baner)
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Buer> getber = api.getber();
        getber.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Buer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Buer buer) {
                        callback.seccuss1(buer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.filed1(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
