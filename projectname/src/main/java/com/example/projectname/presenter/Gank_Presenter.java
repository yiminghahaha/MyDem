package com.example.projectname.presenter;

import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BasePresenter;
import com.example.projectname.bean.Gank_bean;
import com.example.projectname.medol.Gank_Medol;
import com.example.projectname.view.Gank_View;

public class Gank_Presenter extends BasePresenter<Gank_Medol,Gank_View> {

    public void getdata(String string, int num, int page) {
        if (mymedol!=null){
            mymedol.getdata(string,num,page, new BaseCallback<Gank_bean>() {
                @Override
                public void seccuss(Gank_bean gank_bean) {
                        if (gank_bean!=null){
                            myview.gankseccuss(gank_bean);
                        }
                }

                @Override
                public void filed(String mes) {
                        myview.gankfiled(mes);
                }
            });
        }
    }
}
