package com.example.myworktow.tab_presenter;

import com.example.myworktow.beans.Fra5_bean;
import com.example.myworktow.tab_medol.Fra5_medol;
import com.example.myworktow.tab_view.Fra5_view;

public class Fra5_presenterimple implements Fra5_present{
    private Fra5_medol fra5_medol;
    private Fra5_view fra5_view;

    public Fra5_presenterimple(Fra5_medol fra5_medol, Fra5_view fra5_view) {
        this.fra5_medol = fra5_medol;
        this.fra5_view = fra5_view;
    }

    @Override
    public void getbean() {
        fra5_medol.getdata(new Fra5_Callback() {
            @Override
            public void seccuss(Fra5_bean fra5_bean) {
                fra5_view.seccuss(fra5_bean);
            }

            @Override
            public void filed(String mes) {
                fra5_view.filed(mes);
            }
        });
    }
}
