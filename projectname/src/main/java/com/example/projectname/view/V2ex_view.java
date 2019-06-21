package com.example.projectname.view;

import com.example.projectname.base.BaseView;
import com.example.projectname.bean.V2ex_tab;

import java.util.ArrayList;

public interface V2ex_view extends BaseView {
    void seccuss(ArrayList<V2ex_tab> v2ex_tab);

    void filed(String mes);
}
