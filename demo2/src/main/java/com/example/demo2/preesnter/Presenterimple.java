package com.example.demo2.preesnter;

import com.example.demo2.beans.Bean;
import com.example.demo2.medol.Medol;
import com.example.demo2.view.Mview;

public class Presenterimple implements Presenter{
    private Medol medol;
    private Mview mview;

    public Presenterimple(Medol medol, Mview mview) {
        this.medol = medol;
        this.mview = mview;
    }

    @Override
    public void getdata() {
        medol.getdata(new Callback() {
            @Override
            public void seccuss(Bean bean) {
                mview.seccuss(bean);
            }

            @Override
            public void filed(String mes) {
                mview.filed(mes);
            }
        });
    }
}
