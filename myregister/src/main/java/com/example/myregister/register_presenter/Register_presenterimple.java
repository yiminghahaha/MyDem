package com.example.myregister.register_presenter;

import com.example.myregister.beans.Register_bean;
import com.example.myregister.register_medol.Register_medol;
import com.example.myregister.register_view.Register_view;

public class Register_presenterimple implements Register_presenter, Register_Callback {
    private Register_medol register_medol;
    private Register_view register_view;

    public Register_presenterimple(Register_medol register_medol, Register_view register_view) {
        this.register_medol = register_medol;
        this.register_view = register_view;
    }

    @Override
    public void getdata(String user, String pass, String phone, String verify) {
        register_medol.getregister(user,pass,phone,verify,this);
    }

    @Override
    public void seccuess(Register_bean register_bean) {
        register_view.seccuess(register_bean);
    }

    @Override
    public void field(String mes) {
        register_view.field(mes);
    }
}
