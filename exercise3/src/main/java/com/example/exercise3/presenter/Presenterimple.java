package com.example.exercise3.presenter;

import com.example.exercise3.Bean;
import com.example.exercise3.medol.Medol;
import com.example.exercise3.view.Mview;

public class Presenterimple implements Preesnter{
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
            public void seccuess(Bean bean) {
                mview.seccuess(bean);
            }

            @Override
            public void filed(String mes) {
                mview.filed(mes);
            }
        });
    }
}
