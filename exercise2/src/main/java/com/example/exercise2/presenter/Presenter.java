package com.example.exercise2.presenter;

import com.example.exercise2.base.BaseCallback;
import com.example.exercise2.base.BasePresenter;
import com.example.exercise2.beans.Shitimer;
import com.example.exercise2.medol.MedTimer;
import com.example.exercise2.utils.Contracte;
import com.example.exercise2.view.Mview;

public class Presenter extends BasePresenter<MedTimer,Mview> implements Contracte.timerfiled {

    @Override
    public void filed() {
        if (mymedol!=null){
            mymedol.seccuess(new BaseCallback<Shitimer>() {
                @Override
                public void seccuess(Shitimer shitimer) {
                    myview.seccuess(shitimer);
                }

                @Override
                public void filed(String mes) {
                    myview.filedm(mes);
                }
            });
        }
    }
}
