package com.example.myregister.verify_presenter;

import com.example.myregister.beans.Verify_bean;

public interface Verify_Callback {
    void  seccuss(Verify_bean verify_bean);
    void  filed(String mes);
}
