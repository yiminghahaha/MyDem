package com.example.projectname.medol;

import com.example.projectname.api.Api;
import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BaseMedol;
import com.example.projectname.bean.NewDay_bean;
import com.example.projectname.net.BaseObserver;
import com.example.projectname.net.Httputils;
import com.example.projectname.net.RxUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ZhiHu_NewDay_Medol extends BaseMedol {

    public void getdata2(final BaseCallback<NewDay_bean> baseCallback) {
        Api instancs = Httputils.getHttputils().getInstancs(Api.url, Api.class);
        Observable<NewDay_bean> observable = instancs.getnewday();
        observable.compose(RxUtils.<NewDay_bean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<NewDay_bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(NewDay_bean newDay_bean) {
                        baseCallback.seccuss(newDay_bean);
                    }
                });
    }
}
