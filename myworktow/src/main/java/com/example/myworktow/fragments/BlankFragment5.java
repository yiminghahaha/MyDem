package com.example.myworktow.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myworktow.R;
import com.example.myworktow.adapters.Myadapter2;
import com.example.myworktow.beans.Fra5_bean;
import com.example.myworktow.tab_medol.Fra5_medolimple;
import com.example.myworktow.tab_presenter.Fra5_presenterimple;
import com.example.myworktow.tab_view.Fra5_view;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class BlankFragment5 extends Fragment implements Fra5_view {

    private String name;
    private RecyclerView fra5_rc;
    private ArrayList<Fra5_bean.DataBean.DatasBean> datasBeans;
    private Myadapter2 myadapter2;

    @SuppressLint("ValidFragment")
    public BlankFragment5(String name) {
        this.name = name;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment5, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        fra5_rc = (RecyclerView) inflate.findViewById(R.id.fra5_rc);
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        fra5_rc.setLayoutManager(ma);
        datasBeans = new ArrayList<>();
        myadapter2 = new Myadapter2(getContext(), datasBeans);
        fra5_rc.setAdapter(myadapter2);
        initdata();
    }

    private void initdata() {
        Fra5_presenterimple presenterimple = new Fra5_presenterimple(new Fra5_medolimple(), this);
        presenterimple.getbean();
    }

    @Override
    public void seccuss(Fra5_bean fra5_bean) {
        List<Fra5_bean.DataBean.DatasBean> datas = fra5_bean.getData().getDatas();
        datasBeans.addAll(datas);
        myadapter2.notifyDataSetChanged();
    }

    @Override
    public void filed(String mes) {
        Toast.makeText(getContext(), mes, Toast.LENGTH_SHORT).show();
    }
}
