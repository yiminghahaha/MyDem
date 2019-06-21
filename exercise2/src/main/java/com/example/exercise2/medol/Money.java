package com.example.exercise2.medol;

import com.example.exercise2.api.Api;
import com.example.exercise2.base.BaseCallback;
import com.example.exercise2.base.BaseMedol;
import com.example.exercise2.beans.MoneyBean;
import com.example.exercise2.utils.Contracte;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Money extends BaseMedol implements Contracte.moneyseccuess {

    @Override
    public void moneyseccuess(final BaseCallback<MoneyBean> moneyBea) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.money)
                .build();
        Api api = retrofit.create(Api.class);
        Observable<MoneyBean> getmongy = api.getmongy();
        getmongy.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MoneyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MoneyBean moneyBean) {
                        moneyBea.seccuess(moneyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        moneyBea.filed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
