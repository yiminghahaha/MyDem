package com.example.demo9.base;

public abstract class BaseMvpActivity<M extends BaseMedol,V extends BaseView,P extends BasePresenter> extends BaseActivity{

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (initmvpresenter!=null){
            initmvpresenter.destroy();
            initmvpresenter=null;
        }
    }
}
