package com.example.myworktow.tab_presenter;
import com.example.myworktow.beans.Tab_beas;
import com.example.myworktow.tab_medol.Tab_medol;
import com.example.myworktow.tab_view.Tab_view;

public class Tab_Presenterimple implements Tab_presenter {
    private Tab_medol tab_medol;
    private Tab_view tab_view;

    public Tab_Presenterimple(Tab_medol tab_medol, Tab_view tab_view) {
        this.tab_medol = tab_medol;
        this.tab_view = tab_view;
    }

    @Override
    public void getbean() {
        tab_medol.getdata(new Tab_Callback() {
            @Override
            public void seccuss(Tab_beas tab_beas) {
                tab_view.seccuss(tab_beas);
            }

            @Override
            public void filed(String mes) {
                tab_view.filed(mes);
            }
        });
    }
}
