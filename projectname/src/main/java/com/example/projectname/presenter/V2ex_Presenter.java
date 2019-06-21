package com.example.projectname.presenter;

import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BasePresenter;
import com.example.projectname.bean.V2ex_tab;
import com.example.projectname.medol.V2ex_Medol;
import com.example.projectname.view.V2ex_view;

import java.util.ArrayList;

public class V2ex_Presenter extends BasePresenter<V2ex_Medol,V2ex_view> {

    public void getdata() {
        if (mymedol!=null){
            mymedol.getdata(new BaseCallback<ArrayList<V2ex_tab>>() {
                @Override
                public void seccuss(ArrayList<V2ex_tab> v2ex_tabs) {
                    myview.seccuss(v2ex_tabs);
                }

                @Override
                public void filed(String mes) {
                    myview.filed(mes);
                }
            });
        }
    }
}
