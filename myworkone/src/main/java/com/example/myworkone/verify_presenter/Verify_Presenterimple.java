package com.example.myworkone.verify_presenter;

import com.example.myworkone.beans.Verify_Bean;
import com.example.myworkone.verify_medol.Verify_medol;
import com.example.myworkone.verify_view.Verify_view;

public class Verify_Presenterimple implements Verify_Presenter{
    private Verify_medol verify_medol;
    private Verify_view verify_view;

    public Verify_Presenterimple(Verify_medol verify_medol, Verify_view verify_view) {
        this.verify_medol = verify_medol;
        this.verify_view = verify_view;
    }

    @Override
    public void getverify() {
        verify_medol.getdata(new Verify_Callback() {
            @Override
            public void seccuss(Verify_Bean verify_bean) {
                verify_view.seccuss(verify_bean);
            }

            @Override
            public void filed(String mes) {
                verify_view.filed(mes);
            }
        });
    }
}
