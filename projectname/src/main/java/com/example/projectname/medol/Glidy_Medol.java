package com.example.projectname.medol;

import com.example.projectname.api.Api;
import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BaseMedol;
import com.example.projectname.bean.Glidy_item_bean;
import com.example.projectname.net.BaseObserver;
import com.example.projectname.net.Httputils;
import com.example.projectname.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class Glidy_Medol extends BaseMedol{

    public void getdata(String title, final BaseCallback<Glidy_item_bean> baseCallback) {
        Api instancs = Httputils.getHttputils().getInstancs(Api.glidy_url, Api.class);
        Observable<Glidy_item_bean> observable = instancs.getglidy(title);
        observable.compose(RxUtils.<Glidy_item_bean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Glidy_item_bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Glidy_item_bean glidy_item_bean) {
                        if (glidy_item_bean!=null){
                            baseCallback.seccuss(glidy_item_bean);
                        }
                    }
                });
    }
}
