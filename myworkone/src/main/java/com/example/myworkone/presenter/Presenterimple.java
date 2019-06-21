package com.example.myworkone.presenter;

import com.example.myworkone.beans.Item_bean;
import com.example.myworkone.medol.Medol;
import com.example.myworkone.view.Mview;

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
            public void seccuss(Item_bean item_bean) {
                mview.seccuss(item_bean);
            }

            @Override
            public void filed(String mes) {
                mview.filed(mes);
            }
        });
    }
}
