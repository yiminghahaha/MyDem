package com.example.work1.presenter;

import com.example.work1.Bean;
import com.example.work1.medol.Medol;
import com.example.work1.view.View;

public class Presenterimple implements Presen{
    private Medol medol;
    private View view;

    public Presenterimple(Medol medol, View view) {
        this.medol = medol;
        this.view = view;
    }

    @Override
    public void getdata() {
        medol.getdata(new CallBack2() {
            @Override
            public void seccuess(Bean bean) {
                view.seccuess(bean);
            }

            @Override
            public void filed(String str) {
                view.filed(str);
            }
        });
    }
}
