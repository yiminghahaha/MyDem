package com.example.myactivity.presenter;

import com.example.myactivity.base.BaseCallBack;
import com.example.myactivity.base.BasePresenter;
import com.example.myactivity.beans.Bean;
import com.example.myactivity.medol.Medol;
import com.example.myactivity.view.Mview;

public class Mypresenter extends BasePresenter<Medol,Mview> {

    public void getdata() {
        if (mymedol!=null){
            mymedol.getdata2(new BaseCallBack<Bean>() {
                @Override
                public void seccuss(Bean bean) {
                    myview.seccuess(bean);
                }

                @Override
                public void filed(String mes) {
                    myview.filed(mes);
                }
            });
        }

    }
}
