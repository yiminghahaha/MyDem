package com.example.projectname.presenter;

import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BasePresenter;
import com.example.projectname.bean.NewDay_bean;
import com.example.projectname.medol.ZhiHu_NewDay_Medol;
import com.example.projectname.view.ZhiHu_NewDay_View;

public class ZhiHu_NewDay_Presenter extends BasePresenter<ZhiHu_NewDay_Medol,ZhiHu_NewDay_View> {

    public void getdata1() {
        if (mymedol!=null){
            mymedol.getdata2(new BaseCallback<NewDay_bean>() {
                @Override
                public void seccuss(NewDay_bean newDay_bean) {
                    myview.seccuess(newDay_bean);
                }

                @Override
                public void filed(String mes) {
                    myview.filed(mes);
                }
            });
        }
    }
}
