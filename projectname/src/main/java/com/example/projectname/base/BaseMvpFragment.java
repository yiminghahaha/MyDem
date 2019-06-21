package com.example.projectname.base;

public abstract class BaseMvpFragment<M extends BaseMedol,V extends BaseView,P extends BasePresenter> extends BaseFragment{
    protected  P initmvppresenter;

    @Override
    protected void initmvp() {
        initmvppresenter = initmypresenter();
        if (initmvppresenter!=null){
            initmvppresenter.initmedol(initmvpmedol());
            initmvppresenter.attachview(initmvpview());
        }
    }

    protected abstract M initmvpmedol();

    protected abstract V initmvpview();

    protected abstract P initmypresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (initmvppresenter!=null){
            initmvppresenter.destroy();
            initmvppresenter=null;
        }
    }
}
