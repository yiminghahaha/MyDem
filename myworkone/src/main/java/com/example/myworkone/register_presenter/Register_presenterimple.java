package com.example.myworkone.register_presenter;

import com.example.myworkone.beans.Regist_bean;
import com.example.myworkone.register_medol.Register_medol;
import com.example.myworkone.register_view.Register_view;

public class Register_presenterimple implements Register_presenter, Register_Callback {
    private Register_medol register_medol;
    private Register_view register_view;

    public Register_presenterimple(Register_medol register_medol, Register_view register_view) {
        this.register_medol = register_medol;
        this.register_view = register_view;
    }

    @Override
    public void getregis(String user, String pas, String phone, String verify) {
        register_medol.getdata(user,pas,phone,verify,this);
    }

    @Override
    public void seccuss(Regist_bean regist_bean) {
        register_view.seccuss2(regist_bean);
    }

    @Override
    public void filed(String mes) {
        register_view.filed(mes);
    }
}
