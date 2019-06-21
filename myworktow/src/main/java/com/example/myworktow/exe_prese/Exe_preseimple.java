package com.example.myworktow.exe_prese;

import com.example.myworktow.beans.Exependbeans;
import com.example.myworktow.exe_medol.Exe_medol;
import com.example.myworktow.exe_view.Mview;

public class Exe_preseimple implements Exe_presenter{
    private Exe_medol exe_medol;
    private Mview mview;

    public Exe_preseimple(Exe_medol exe_medol, Mview mview) {
        this.exe_medol = exe_medol;
        this.mview = mview;
    }

    @Override
    public void getdata() {
        exe_medol.getdata(new MCallback() {
            @Override
            public void seccuss(Exependbeans exependbeans) {
                mview.seccuss(exependbeans);
            }

            @Override
            public void filed(String mes) {
                mview.filed(mes);
            }
        });
    }
}
