package com.example.exercise4.loginpresenter;

import com.example.exercise4.beans.Bean_login;
import com.example.exercise4.loginmedol.LoginMedol;
import com.example.exercise4.loginview.Loginview;

public class LoginPresenterimple implements LoginPresen, LoginCallback {
    private LoginMedol loginMedol;
    private Loginview loginview;

    public LoginPresenterimple(LoginMedol loginMedol, Loginview loginview) {
        this.loginMedol = loginMedol;
        this.loginview = loginview;
    }

    @Override
    public void getdata(String username, String password) {
        loginMedol.getdata(username,password,this);
    }

    @Override
    public void loginseccuss(Bean_login bean_login) {
        loginview.loginseccuss(bean_login);
    }

    @Override
    public void loginfiled(String mes) {
        loginview.loginfiled(mes);
    }
}
