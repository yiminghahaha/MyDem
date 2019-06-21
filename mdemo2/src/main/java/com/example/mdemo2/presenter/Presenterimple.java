package com.example.mdemo2.presenter;

import com.example.mdemo2.bean.Bean;
import com.example.mdemo2.medol.Medol;
import com.example.mdemo2.view.Mview;

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
