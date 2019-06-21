package com.example.projectname.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectname.R;
import com.example.projectname.adapters.ZhiHu_hot_adapter;
import com.example.projectname.base.BaseMvpFragment;
import com.example.projectname.bean.NewDay_Hot;
import com.example.projectname.medol.ZhiHu_Hot_Medol;
import com.example.projectname.presenter.ZhiHu_Hot_Presenter;
import com.example.projectname.view.ZhiHu_Hot_View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ZhiHu_Hot extends BaseMvpFragment<ZhiHu_Hot_Medol, ZhiHu_Hot_View, ZhiHu_Hot_Presenter> implements ZhiHu_Hot_View {


    @BindView(R.id.hot_lv)
    RecyclerView hotLv;
    Unbinder unbinder;
    private List<NewDay_Hot.RecentBean> recentBeans;
    private ZhiHu_hot_adapter hot_adapter;

    @Override
    protected int getLayoutID() {
        return R.layout.zhihu_hot_layout;
    }

    @Override
    protected ZhiHu_Hot_Medol initmvpmedol() {
        return new ZhiHu_Hot_Medol();
    }

    @Override
    protected ZhiHu_Hot_View initmvpview() {
        return this;
    }

    @Override
    protected ZhiHu_Hot_Presenter initmypresenter() {
        return new ZhiHu_Hot_Presenter();
    }

    @Override
    protected void initview(View inflate) {
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        hotLv.setLayoutManager(ma);
        recentBeans = new ArrayList<>();
        hot_adapter = new ZhiHu_hot_adapter(getContext(), recentBeans);
        hotLv.setAdapter(hot_adapter);
    }

    @Override
    protected void initdata() {
        initmvppresenter.getdata();
    }


    @Override
    public void seccuss(NewDay_Hot newDayHot) {
        if (newDayHot!=null){
            List<NewDay_Hot.RecentBean> recent = newDayHot.getRecent();
            recentBeans.addAll(recent);
            hot_adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void filed(String mes) {
        Toast.makeText(getContext(), mes, Toast.LENGTH_SHORT).show();
    }
}
