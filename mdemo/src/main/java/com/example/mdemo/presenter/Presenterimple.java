package com.example.mdemo.presenter;

import com.example.mdemo.Bean;
import com.example.mdemo.medol.Medol;
import com.example.mdemo.view.Mview;

public class Presenterimple implements Presenter{
    private Medol medol;
    private Mview mview;

    public Presenterimple(Medol medol, Mview mview) {
        this.medol = medol;
        this.mview = mview;
    }

    @Override
    public void getdata() {
        medol.getdata(new Mcallback() {
            @Override
            public void getseccuss(Bean bean) {
                mview.getseccuss(bean);
            }

            @Override
            public void getfiled(String mes) {
                mview.getfiled(mes);
            }
        });
    }
}
