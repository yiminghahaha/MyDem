package com.example.exercise2.base;

public abstract class BaseMVPFragment<M extends BaseMedol,V extends BaseView,P extends BasePresenter> extends BaseFragment{

    protected  P initpresenter;

    @Override
    protected void MVP() {
        initpresenter = myinitpresenter();
        if (initpresenter!=null){
            initpresenter.attach(myinitmedol());
            initpresenter.attach(myinitview());
        }
    }

    protected abstract V myinitview();

    protected abstract M myinitmedol();

    protected abstract P myinitpresenter();

}
