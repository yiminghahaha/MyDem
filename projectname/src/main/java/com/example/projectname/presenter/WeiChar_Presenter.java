package com.example.projectname.presenter;

import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BasePresenter;
import com.example.projectname.bean.WeiChar_Bean;
import com.example.projectname.medol.WeiChar_Medol;
import com.example.projectname.view.WeiChar_View;

public class WeiChar_Presenter extends BasePresenter<WeiChar_Medol,WeiChar_View> {

    public void getdata() {
        if (mymedol!=null){
            mymedol.getbean(new BaseCallback<WeiChar_Bean>() {
                @Override
                public void seccuss(WeiChar_Bean weiChar_bean) {
                    myview.seccuss(weiChar_bean);
                }

                @Override
                public void filed(String mes) {
                    myview.filed(mes);
                }
            });
        }
    }
}
