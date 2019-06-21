package com.example.myworktow.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myworktow.R;
import com.example.myworktow.adapters.Myadapter;
import com.example.myworktow.beans.Buer;
import com.example.myworktow.beans.Item_bean;
import com.example.myworktow.medol.Medolimple;
import com.example.myworktow.presenter.Presenterimiple;
import com.example.myworktow.view.Mview;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements Mview {

    private RecyclerView lv_one;
    private List<Item_bean.DataBean.DatasBean> datasBeans;
    private List<Buer.DataBean> beans;
    private Myadapter myadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        lv_one = (RecyclerView) inflate.findViewById(R.id.lv_one);
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        lv_one.setLayoutManager(ma);
        datasBeans = new ArrayList<>();
        beans = new ArrayList<>();
        myadapter = new Myadapter(getContext(), datasBeans, beans);
        lv_one.setAdapter(myadapter);
        initdata();
    }

    private void initdata() {
        Presenterimiple presenterimiple = new Presenterimiple(new Medolimple(), this);
        presenterimiple.getitem();
        presenterimiple.getbean();

    }

    @Override
    public void seccuss1(Item_bean item_bean) {
        if (item_bean!=null){
            List<Item_bean.DataBean.DatasBean> datas = item_bean.getData().getDatas();
            datasBeans.addAll(datas);
            myadapter.notifyDataSetChanged();
        }
    }

    @Override
    public void filed1(String mes) {
        Toast.makeText(getContext(), mes, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void seccuss2(Buer item_bean) {
        if (item_bean!=null){
            List<Buer.DataBean> data = item_bean.getData();
            beans.addAll(data);
            myadapter.notifyDataSetChanged();
        }
    }

    @Override
    public void filed2(String mes) {
        Toast.makeText(getContext(), mes, Toast.LENGTH_SHORT).show();
    }
}
