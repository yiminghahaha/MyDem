package com.example.myworkone.register_medol;

import com.example.myworkone.register_presenter.Register_Callback;

public interface Register_medol {
    void  getdata(String username, String password, String phone, String verify, Register_Callback register_callback);
}
