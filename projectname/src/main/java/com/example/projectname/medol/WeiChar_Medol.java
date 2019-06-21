package com.example.projectname.medol;

import com.example.projectname.api.Api;
import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BaseMedol;
import com.example.projectname.bean.WeiChar_Bean;
import com.example.projectname.net.BaseObserver;
import com.example.projectname.net.Httputils;
import com.example.projectname.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class WeiChar_Medol extends BaseMedol {

    public void getbean(final BaseCallback<WeiChar_Bean> baseCallback) {
        Api instancs = Httputils.getHttputils().getInstancs(Api.weichar_url, Api.class);
        Observable<WeiChar_Bean> observable = instancs.getwichar();
        observable.compose(RxUtils.<WeiChar_Bean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<WeiChar_Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(WeiChar_Bean weiChar_bean) {
                        baseCallback.seccuss(weiChar_bean);
                    }
                });
    }
}
