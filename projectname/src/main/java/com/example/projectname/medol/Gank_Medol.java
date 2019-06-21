package com.example.projectname.medol;

import com.example.projectname.api.Api;
import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BaseMedol;
import com.example.projectname.bean.Gank_bean;
import com.example.projectname.net.BaseObserver;
import com.example.projectname.net.Httputils;
import com.example.projectname.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class Gank_Medol extends BaseMedol {


    public void getdata(String string, int num, int page, final BaseCallback<Gank_bean> baseCallback) {
        Api instancs = Httputils.getHttputils().getInstancs(Api.sBaseUrl, Api.class);
        Observable<Gank_bean> gankData = instancs.getGankData(string, num, page);
        gankData.compose(RxUtils.<Gank_bean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Gank_bean>(){
                    @Override
                    public void onSubscribe(Disposable d){
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Gank_bean gank_bean){
                        if (gank_bean!=null){
                            baseCallback.seccuss(gank_bean);
                        }
                    }
                });
    }
}
