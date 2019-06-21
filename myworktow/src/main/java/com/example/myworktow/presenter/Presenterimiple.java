package com.example.myworktow.presenter;

import com.example.myworktow.beans.Buer;
import com.example.myworktow.beans.Item_bean;
import com.example.myworktow.medol.Medol;
import com.example.myworktow.view.Mview;

public class Presenterimiple implements Presen{
    private Medol medol;
    private Mview mview;

    public Presenterimiple(Medol medol, Mview mview) {
        this.medol = medol;
        this.mview = mview;
    }


    @Override
    public void getitem() {
        medol.getdata1(new Callback() {
            @Override
            public void seccuss1(Item_bean item_bean) {
                if (item_bean!=null){
                    mview.seccuss1(item_bean);
                }
            }

            @Override
            public void filed1(String mes) {
                mview.filed1(mes);
            }
        });
    }

    @Override
    public void getbean() {
        medol.getdata2(new Callback2() {
            @Override
            public void seccuss1(Buer buer) {
                mview.seccuss2(buer);
            }

            @Override
            public void filed1(String mes) {
                mview.filed2(mes);
            }
        });
    }
}
