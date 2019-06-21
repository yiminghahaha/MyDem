package com.example.myworkone.verify_presenter;

import com.example.myworkone.beans.Verify_Bean;

public interface Verify_Callback {
    void  seccuss(Verify_Bean verify_bean);
    void  filed(String mes);
}
