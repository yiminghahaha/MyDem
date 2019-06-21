package com.example.myregister.register_medol;

import com.example.myregister.api.Api;
import com.example.myregister.beans.Register_bean;
import com.example.myregister.register_presenter.Register_Callback;
import java.io.IOException;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register_medolimple implements Register_medol{
    @Override
    public void getregister(String user, String pass, String phone, String verify, final Register_Callback register_callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Register_bean> observable = api.getrigister(user,pass,phone,verify);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Register_bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Register_bean register_bean) {
                      register_callback.seccuess(register_bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            register_callback.field(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
