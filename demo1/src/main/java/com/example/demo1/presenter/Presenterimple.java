package com.example.demo1.presenter;

import com.example.demo1.beans.Bean;
import com.example.demo1.medol.Medol;
import com.example.demo1.view.Myview;

public class Presenterimple implements Preesnter{
    private Medol medol;
    private Myview myview;

    public Presenterimple(Medol medol, Myview myview) {
        this.medol = medol;
        this.myview = myview;
    }

    @Override
    public void getdata() {
        medol.getdata(new Callback() {
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
