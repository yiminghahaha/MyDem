package com.example.myactivity.base;

public abstract class BaseMVPFragment<M extends BaseMedol,V extends BaseView,P extends BasePresenter> extends BaseFragment{
    protected  P initMVPpresenter;

    @Override
    protected void initMVP() {
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
    public void onDestroy() {
        super.onDestroy();
        if (initMVPpresenter!=null){
            initMVPpresenter.destroy();
            initMVPpresenter=null;
        }

    }
}
