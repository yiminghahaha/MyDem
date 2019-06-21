package com.example.exercise2.presenter;

import com.example.exercise2.base.BaseCallback;
import com.example.exercise2.base.BasePresenter;
import com.example.exercise2.beans.WorkBean;
import com.example.exercise2.medol.Workmedol;
import com.example.exercise2.utils.Contracte;
import com.example.exercise2.view.Workview;

public class Prework extends BasePresenter<Workmedol,Workview> implements Contracte.workfiled {

    @Override
    public void feild() {
        if (mymedol!=null){
            mymedol.seccuess(new BaseCallback<WorkBean>() {
                @Override
                public void seccuess(WorkBean workBean) {
                    myview.workseccuess(workBean);
                }

                @Override
                public void filed(String mes) {
                    myview.workfiled(mes);
                }
            });
        }
    }
}
