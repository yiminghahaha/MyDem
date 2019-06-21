package com.example.mywork.presenter;

import com.example.mywork.Bean;
import com.example.mywork.DataBean;

import java.util.ArrayList;
import java.util.List;

public interface MCallback {
    void  seccuss(List<DataBean> dataBeans);
    void  filed(String mes);
}
