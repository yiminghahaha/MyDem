package com.example.projectname.medol;

import com.example.projectname.api.Api;
import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BaseMedol;
import com.example.projectname.bean.NewDay_colomn;
import com.example.projectname.net.BaseObserver;
import com.example.projectname.net.Httputils;
import com.example.projectname.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ZhiHu_Column_Medol extends BaseMedol {

    public void getMessage(final BaseCallback<NewDay_colomn> baseCallback) {
        Api instancs = Httputils.getHttputils().getInstancs(Api.url, Api.class);
        Observable<NewDay_colomn> getcolomn = instancs.getcolomn();
        getcolomn.compose(RxUtils.<NewDay_colomn>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<NewDay_colomn>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(NewDay_colomn newDay_colomn) {
                        baseCallback.seccuss(newDay_colomn);
                    }
                });
    }
}
