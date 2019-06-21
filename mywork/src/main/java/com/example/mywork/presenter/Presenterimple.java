package com.example.mywork.presenter;

import com.example.mywork.DataBean;
import com.example.mywork.medol.Medol;
import com.example.mywork.view.Myview;
import java.util.List;

public class Presenterimple implements Presenter{
    private Medol medol;
    private Myview myview;

    public Presenterimple(Medol medol, Myview myview) {
        this.medol = medol;
        this.myview = myview;
    }

    @Override
    public void getdata() {
        medol.getdata(new MCallback() {
            @Override
            public void seccuss(List<DataBean> dataBeans) {
                myview.seccuss(dataBeans);
            }

            @Override
            public void filed(String mes) {
                myview.filed(mes);
            }
        });
    }
}
