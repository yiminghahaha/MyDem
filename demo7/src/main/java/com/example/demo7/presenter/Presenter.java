package com.example.demo7.presenter;

import com.example.demo7.base.BaseCallback;
import com.example.demo7.base.BasePresenter;
import com.example.demo7.beans.Bean;
import com.example.demo7.medol.Medol;
import com.example.demo7.view.Mview;

public class Presenter extends BasePresenter<Medol,Mview> {
    public void getdata() {
        if (mymedol!=null){
            mymedol.getdata2(new BaseCallback<Bean>() {
                @Override
                public void seccuss(Bean bean) {
                    myview.seccuss(bean);
                }

                @Override
                public void filed(String mes) {
                    myview.filed(mes);
                }
            });
        }
    }
}
