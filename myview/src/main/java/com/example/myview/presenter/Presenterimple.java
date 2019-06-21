package com.example.myview.presenter;

import com.example.myview.Bean;
import com.example.myview.medol.Medol;
import com.example.myview.view.Myview;

public class Presenterimple implements Presenter{
    private Medol medol;
    private Myview myview;

    public Presenterimple(Medol medol, Myview myview) {
        this.medol = medol;
        this.myview = myview;
    }

    @Override
    public void getbea() {
        medol.getdata(new MCallBack() {
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
