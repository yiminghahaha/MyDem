package com.example.examinationym.presenter;

import com.example.examinationym.beans.Bean;
import com.example.examinationym.medol.Medol;
import com.example.examinationym.view.Mview;

public class Presenimple implements Presen, Callback {
    private Medol medol;
    private Mview mview;

    public Presenimple(Medol medol, Mview mview) {
        this.medol = medol;
        this.mview = mview;
    }

    @Override
    public void getdata() {
        medol.getdata(this);
    }

    @Override
    public void seccuess(Bean bean) {
        mview.seccuess(bean);
    }

    @Override
    public void filed(String mes) {
        mview.filed(mes);
    }
}
