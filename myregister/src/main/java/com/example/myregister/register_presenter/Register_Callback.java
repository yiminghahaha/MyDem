package com.example.myregister.register_presenter;

import com.example.myregister.beans.Register_bean;

import okhttp3.RequestBody;

public interface Register_Callback {
    void  seccuess(Register_bean register_bean);
    void  field(String mes);
}
