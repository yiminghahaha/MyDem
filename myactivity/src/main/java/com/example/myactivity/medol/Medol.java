package com.example.myactivity.medol;
import com.example.myactivity.api.Api;
import com.example.myactivity.base.BaseCallBack;
import com.example.myactivity.base.BaseMedol;
import com.example.myactivity.beans.Bean;
import com.example.myactivity.net.BaseObserver;
import com.example.myactivity.net.HttpUtils;
import com.example.myactivity.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;

public class Medol extends BaseMedol {
    public void getdata2(final BaseCallBack<Bean> baseCallBack) {
        Api api = HttpUtils.getHttpUtils().geturl(Api.url, Api.class);
        Observable<Bean> geturl = api.geturl();
        geturl.compose(RxUtils.<Bean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Bean bean) {
                        if (bean!=null){
                            baseCallBack.seccuss(bean);
                        }
                    }
                });


    }

}
