package com.example.exercise2.base;

public abstract class BaseMVPActivity<M extends BaseMedol,V extends BaseView,P extends BasePresenter> extends BaseActivity{
    protected  P mypresenter;

    @Override
    protected void MVP() {
       mypresenter =  initpresenter();
       if (mypresenter!=null){
           mypresenter.attach(initmedol());
           mypresenter.attach(initmyview());
       }
    }

    protected abstract V initmyview();

    protected abstract M initmedol();

    protected abstract P initpresenter();
}
