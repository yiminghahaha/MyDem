package com.example.projectname.medol;

import com.example.projectname.api.Api;
import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BaseMedol;
import com.example.projectname.bean.NodeNaviBean;
import com.example.projectname.net.BaseObserver;
import com.example.projectname.net.Httputils;
import com.example.projectname.net.RxUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class V2exvity_Medol extends BaseMedol{

    public void getdata(final BaseCallback<NodeNaviBean> baseCallback) {
        Api instancs = Httputils.getHttputils().getInstancs(Api.playurl, Api.class);
        Observable<NodeNaviBean> navi = instancs.getNodeNavi();
        navi.compose(RxUtils.<NodeNaviBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<NodeNaviBean>(){
                    @Override
                    public void onSubscribe(Disposable d){
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(NodeNaviBean nodeNaviBean){
                        if (nodeNaviBean!=null){
                            baseCallback.seccuss(nodeNaviBean);
                        }
                    }
                });

    }
}
