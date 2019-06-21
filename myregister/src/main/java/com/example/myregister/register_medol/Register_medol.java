package com.example.myregister.register_medol;

import com.example.myregister.register_presenter.Register_Callback;

public interface Register_medol {
    void  getregister(String user,String pass,String phone,String verify,Register_Callback register_callback);
}
