package com.example.myactivity.base;

public abstract class BaseMVPActivity<M extends BaseMedol,V extends BaseView,P extends BasePresenter> extends BaseActivity{
    protected  P initMVPpresenter;

    @Override
    protected void initmvp() {
        initMVPpresenter = initpresenter();
        if (initMVPpresenter!=null){
            initMVPpresenter.initmedol(initMVPmedol());
            initMVPpresenter.attach(initMVPview());
        }
    }

    protected abstract V initMVPview();

    protected abstract M initMVPmedol();

    protected abstract P initpresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (initMVPpresenter!=null){
            initMVPpresenter.destroy();
            initMVPpresenter=null;
        }

    }
}
