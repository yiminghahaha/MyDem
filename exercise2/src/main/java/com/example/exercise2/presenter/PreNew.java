package com.example.exercise2.presenter;

import com.example.exercise2.base.BaseCallback;
import com.example.exercise2.base.BasePresenter;
import com.example.exercise2.beans.Newbook;
import com.example.exercise2.medol.NewMedol;
import com.example.exercise2.utils.Contracte;
import com.example.exercise2.view.NewView;

public class PreNew extends BasePresenter<NewMedol,NewView> implements Contracte.newfiled {

    @Override
    public void filed() {
        mymedol.seccuess(new BaseCallback<Newbook>() {
            @Override
            public void seccuess(Newbook newbook) {
                myview.getseccuess(newbook);
            }

            @Override
            public void filed(String mes) {
                myview.getfiled(mes);
            }
        });
    }
}
