package com.example.exercise2.medol;

import com.example.exercise2.api.Api;
import com.example.exercise2.base.BaseCallback;
import com.example.exercise2.base.BaseMedol;
import com.example.exercise2.beans.WorkBean;
import com.example.exercise2.utils.Contracte;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Workmedol extends BaseMedol implements Contracte.workseccuess {

    @Override
    public void seccuess(final BaseCallback<WorkBean> workBea) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.newurl)
                .build();
        Api api = retrofit.create(Api.class);
        Observable<WorkBean> getwork = api.getwork();
        getwork.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WorkBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WorkBean workBean) {
                        workBea.seccuess(workBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        workBea.filed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
