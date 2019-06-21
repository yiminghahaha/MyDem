package com.example.myregister.verify_presenter;

import com.example.myregister.beans.Verify_bean;
import com.example.myregister.verify_medol.Verify_medol;
import com.example.myregister.verify_view.Verify_view;

public class Verify_Presenterimple implements Verify_presenter{
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
            public void seccuss(Verify_bean verify_bean) {
                verify_view.seccuss(verify_bean);
            }

            @Override
            public void filed(String mes) {
                verify_view.filed(mes);
            }
        });
    }
}
