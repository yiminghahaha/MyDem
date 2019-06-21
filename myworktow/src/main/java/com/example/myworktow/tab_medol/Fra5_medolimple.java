package com.example.myworktow.tab_medol;

import com.example.myworktow.api.Api;
import com.example.myworktow.beans.Fra5_bean;
import com.example.myworktow.tab_presenter.Fra5_Callback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fra5_medolimple implements Fra5_medol{
    @Override
    public void getdata(final Fra5_Callback fra5_callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.fra5)
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Fra5_bean> getfra5 = api.getfra5();
        getfra5.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Fra5_bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Fra5_bean fra5_bean) {
                        fra5_callback.seccuss(fra5_bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        fra5_callback.filed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
