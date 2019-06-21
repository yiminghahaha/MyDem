package com.example.demo7.base;

public abstract class BaseMVPActivity<M extends BaseMedol,V extends BaseView,P extends BasePresenter> extends BaseActivity{
    protected  P initpresenter;
    @Override
    protected void initmvp() {
        initpresenter = initmvppresenter();
        if (initpresenter!=null){
            initpresenter.initmedol(initmvpmedol());
            initpresenter.attachview(initmvpview());
        }
    }

    protected abstract P initmvppresenter();

    protected abstract V initmvpview();

    protected abstract M initmvpmedol();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (initpresenter!=null){
            initpresenter.destroy();
            initpresenter=null;
        }
    }
}
