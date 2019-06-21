package com.example.myworkone.login_medol;

import com.example.myworkone.beans.Login_bean;
import com.example.myworkone.api.Api;
import com.example.myworkone.login_presenter.MyCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login_Medol implements Medol{

    @Override
    public void getdata(String username, String password, final MyCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Login_bean> observable = api.getlogin(username, password);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Login_bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Login_bean login_bean) {
                        callBack.seccuss(login_bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.filed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
