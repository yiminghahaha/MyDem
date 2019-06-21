package com.example.myworkone.register_presenter;

import com.example.myworkone.beans.Regist_bean;

public interface Register_Callback {
    void  seccuss(Regist_bean regist_bean);
    void  filed(String mes);
}
