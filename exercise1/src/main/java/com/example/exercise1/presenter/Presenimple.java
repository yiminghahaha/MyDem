package com.example.exercise1.presenter;

import com.example.exercise1.bean.Bean;
import com.example.exercise1.medol.Medol;
import com.example.exercise1.view.Myview;

public class Presenimple implements Presen, Callback {
    private Medol medol;
    private Myview myview;

    public Presenimple(Medol medol, Myview myview) {
        this.medol = medol;
        this.myview = myview;
    }

    @Override
    public void getdata() {
        medol.getdata(this);
    }

    @Override
    public void seccuess(Bean bean) {
        myview.seccuess(bean);
    }

    @Override
    public void filed(String mes) {
        myview.filed(mes);
    }
}
