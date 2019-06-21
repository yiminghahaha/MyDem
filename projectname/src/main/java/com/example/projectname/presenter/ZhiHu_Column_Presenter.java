package com.example.projectname.presenter;

import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BasePresenter;
import com.example.projectname.bean.NewDay_colomn;
import com.example.projectname.medol.ZhiHu_Column_Medol;
import com.example.projectname.view.ZhiHu_Column_View;

public class ZhiHu_Column_Presenter extends BasePresenter<ZhiHu_Column_Medol,ZhiHu_Column_View> {

    public void getdata() {
        if (mymedol!=null){
            mymedol.getMessage(new BaseCallback<NewDay_colomn>() {
                @Override
                public void seccuss(NewDay_colomn newDay_colomn) {
                    myview.seccuss(newDay_colomn);
                }

                @Override
                public void filed(String mes) {
                    myview.filed(mes);
                }
            });
        }
    }
}
