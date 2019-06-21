package com.example.myworkone.login_presenter;

import com.example.myworkone.beans.Login_bean;
import com.example.myworkone.login_medol.Medol;
import com.example.myworkone.login_view.Login_view;

public class Login_Preseimple implements Presenter, MyCallBack {
    private Medol medol;
    private Login_view login_view;

    public Login_Preseimple(Medol medol, Login_view login_view) {
        this.medol = medol;
        this.login_view = login_view;
    }

    @Override
    public void getbean(String user, String pass) {
        medol.getdata(user,pass,this);
    }

    @Override
    public void seccuss(Login_bean login_bean) {
        login_view.seccuss(login_bean);
    }

    @Override
    public void filed(String login) {
        login_view.filed(login);
    }
}
