package com.example.projectname.presenter;

import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BasePresenter;
import com.example.projectname.bean.Glidy_item_bean;
import com.example.projectname.medol.Glidy_Medol;
import com.example.projectname.view.Glidy_View;

public class Glidy_Presenter extends BasePresenter<Glidy_Medol,Glidy_View>{

    public void getdata(String title) {
        if (mymedol!=null){
          mymedol.getdata(title, new BaseCallback<Glidy_item_bean>() {
              @Override
              public void seccuss(Glidy_item_bean glidy_item_bean) {
                    myview.glidyseccuss(glidy_item_bean);
              }

              @Override
              public void filed(String mes) {
                    myview.glidyfiled(mes);
              }
          });
        }
    }
}
