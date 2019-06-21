package com.example.demo9.base;

public abstract class BaseMvpFragment<M extends BaseMedol,V extends BaseView,P extends BasePresenter> extends BaseFragment{

    protected   P initmvpresenter;

    @Override
    protected void initmvp() {
        initmvpresenter =  initmvpresenter();
        if (initmvpresenter!=null){
            initmvpresenter.attachview(initmvpview());
            initmvpresenter.initmedol(initmvpmedol());
        }
    }

    protected abstract M initmvpmedol();

    protected abstract V initmvpview();

    protected abstract P initmvpresenter();
}
