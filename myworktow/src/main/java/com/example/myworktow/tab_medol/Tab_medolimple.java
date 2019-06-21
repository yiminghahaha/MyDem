package com.example.myworktow.tab_medol;

import com.example.myworktow.api.Api;
import com.example.myworktow.beans.Tab_beas;
import com.example.myworktow.medol.Medol;
import com.example.myworktow.tab_presenter.Tab_Callback;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Tab_medolimple implements Tab_medol {
    @Override
    public void getdata(final Tab_Callback tab_callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.taburl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Tab_beas> gettab = api.gettab();
        gettab.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Tab_beas>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Tab_beas tab_beas) {
                        if (tab_beas!=null){

                            tab_callback.seccuss(tab_beas);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                            tab_callback.filed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
