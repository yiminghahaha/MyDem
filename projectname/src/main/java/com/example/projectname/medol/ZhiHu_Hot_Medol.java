package com.example.projectname.medol;

import com.example.projectname.api.Api;
import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BaseMedol;
import com.example.projectname.bean.NewDay_Hot;
import com.example.projectname.net.BaseObserver;
import com.example.projectname.net.Httputils;
import com.example.projectname.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ZhiHu_Hot_Medol extends BaseMedol {

    public void getdatac(final BaseCallback<NewDay_Hot> baseCallback) {
        Api instancs = Httputils.getHttputils().getInstancs(Api.url, Api.class);
        Observable<NewDay_Hot> gethot = instancs.gethot();
        gethot.compose(RxUtils.<NewDay_Hot>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<NewDay_Hot>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(NewDay_Hot newDayHot) {
                        baseCallback.seccuss(newDayHot);
                    }
                });
    }
}
