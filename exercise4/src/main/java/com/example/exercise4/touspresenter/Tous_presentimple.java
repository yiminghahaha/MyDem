package com.example.exercise4.touspresenter;

import com.example.exercise4.beans.Tous;
import com.example.exercise4.tousmedol.Tous_medol;
import com.example.exercise4.tousview.Tous_view;

public class Tous_presentimple implements Tous_present{
    private Tous_medol tous_medol;
    private Tous_view tous_view;

    public Tous_presentimple(Tous_medol tous_medol, Tous_view tous_view) {
        this.tous_medol = tous_medol;
        this.tous_view = tous_view;
    }

    @Override
    public void getdata() {
        tous_medol.getdata(new Tous_Callback() {
            @Override
            public void seccuess(Tous tous) {
                tous_view.seccuess(tous);
            }

            @Override
            public void filed(String mes) {
                tous_view.filed(mes);
            }
        });
    }
}
