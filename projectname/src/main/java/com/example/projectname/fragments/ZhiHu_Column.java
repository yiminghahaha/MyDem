package com.example.projectname.fragments;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectname.R;
import com.example.projectname.adapters.ZhiHu_column_adapter;
import com.example.projectname.base.BaseMedol;
import com.example.projectname.base.BaseMvpFragment;
import com.example.projectname.base.BasePresenter;
import com.example.projectname.base.BaseView;
import com.example.projectname.bean.NewDay_colomn;
import com.example.projectname.medol.ZhiHu_Column_Medol;
import com.example.projectname.presenter.ZhiHu_Column_Presenter;
import com.example.projectname.view.ZhiHu_Column_View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ZhiHu_Column extends BaseMvpFragment<ZhiHu_Column_Medol,ZhiHu_Column_View,ZhiHu_Column_Presenter> implements ZhiHu_Column_View {

    @BindView(R.id.column_lv)
    RecyclerView columnLv;
    Unbinder unbinder;
    private List<NewDay_colomn.DataBean> dataBeans;
    private ZhiHu_column_adapter columnAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.zhihu_column_layout;
    }

    @Override
    protected void initview(View inflate) {
        GridLayoutManager ma = new GridLayoutManager(getContext(), 2);
        columnLv.setLayoutManager(ma);
        dataBeans = new ArrayList<>();
        columnAdapter = new ZhiHu_column_adapter(getContext(), dataBeans);
        columnLv.setAdapter(columnAdapter);
    }

    @Override
    protected void initdata() {
        initmvppresenter.getdata();
    }

    @Override
    protected ZhiHu_Column_Medol initmvpmedol() {
        return new ZhiHu_Column_Medol();
    }

    @Override
    protected ZhiHu_Column_View initmvpview() {
        return this;
    }

    @Override
    protected ZhiHu_Column_Presenter initmypresenter() {
        return new ZhiHu_Column_Presenter();
    }

    @Override
    public void seccuss(NewDay_colomn newDay_colomn) {
        List<NewDay_colomn.DataBean> data = newDay_colomn.getData();
        dataBeans.addAll(data);
        columnAdapter.notifyDataSetChanged();
    }

    @Override
    public void filed(String mes) {
        Log.i("column", "filed: "+mes);
    }
}
