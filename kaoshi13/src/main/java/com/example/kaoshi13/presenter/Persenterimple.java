package com.example.kaoshi13.presenter;

import com.example.kaoshi13.beans.Person;
import com.example.kaoshi13.medol.Medol;
import com.example.kaoshi13.view.Mview;

public class Persenterimple implements Persenter{
    private Medol medol;
    private Mview mview;

    public Persenterimple(Medol medol, Mview mview) {
        this.medol = medol;
        this.mview = mview;
    }

    @Override
    public void getdata() {
        medol.getbean(new MyCallback() {
            @Override
            public void seccusss(Person person) {
                mview.seccusss(person);
            }

            @Override
            public void filed(String mes) {
                mview.filed(mes);
            }
        });
    }
}
