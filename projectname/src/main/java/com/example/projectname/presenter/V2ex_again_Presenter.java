package com.example.projectname.presenter;

import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BasePresenter;
import com.example.projectname.bean.V2ex_again_bean;
import com.example.projectname.medol.V2ex_again_Medol;
import com.example.projectname.view.V2ex_again_View;

import java.util.ArrayList;

public class V2ex_again_Presenter extends BasePresenter<V2ex_again_Medol,V2ex_again_View> {

    public void getdata(String url) {
        if (mymedol!=null){
            mymedol.getbean(url, new BaseCallback<ArrayList<V2ex_again_bean>>() {
                @Override
                public void seccuss(ArrayList<V2ex_again_bean> v2ex_again_beans) {
                    if (v2ex_again_beans!=null){
                        myview.seccuss(v2ex_again_beans);
                    }
                }

                @Override
                public void filed(String mes) {
                    myview.filed(mes);
                }
            });
        }
    }
}
