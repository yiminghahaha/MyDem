package com.example.projectname.presenter;

import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BasePresenter;
import com.example.projectname.bean.NewDay_Hot;
import com.example.projectname.medol.ZhiHu_Hot_Medol;
import com.example.projectname.view.ZhiHu_Hot_View;

public class ZhiHu_Hot_Presenter extends BasePresenter<ZhiHu_Hot_Medol,ZhiHu_Hot_View> {
    public void getdata() {
        if (mymedol!=null){
            mymedol.getdatac(new BaseCallback<NewDay_Hot>() {
                @Override
                public void seccuss(NewDay_Hot newDayHot) {
                    myview.seccuss(newDayHot);
                }

                @Override
                public void filed(String mes) {
                    myview.filed(mes);
                }
            });
        }
    }
}
