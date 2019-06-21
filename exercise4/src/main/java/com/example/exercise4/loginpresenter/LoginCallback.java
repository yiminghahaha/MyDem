package com.example.exercise4.loginpresenter;

import com.example.exercise4.beans.Bean_login;

public interface LoginCallback {
    void  loginseccuss(Bean_login bean_login);
    void  loginfiled(String mes);
}
