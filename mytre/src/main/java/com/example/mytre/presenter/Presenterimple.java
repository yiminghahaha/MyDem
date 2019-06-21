package com.example.mytre.presenter;

import com.example.mytre.Bean;
import com.example.mytre.medol.Medol;
import com.example.mytre.view.Myview;

public class Presenterimple implements Presenter{
    private Medol medol;
    private Myview myview;

    public Presenterimple(Medol medol, Myview myview) {
        this.medol = medol;
        this.myview = myview;
    }

    @Override
    public void getdata() {
        medol.getdata(new MyCallback() {
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
