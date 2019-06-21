package com.example.projectname.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectname.R;
import com.example.projectname.adapters.WeiChar_adapter;
import com.example.projectname.base.BaseMvpFragment;
import com.example.projectname.bean.WeiChar_Bean;
import com.example.projectname.medol.WeiChar_Medol;
import com.example.projectname.presenter.WeiChar_Presenter;
import com.example.projectname.view.WeiChar_View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class WeiChar extends BaseMvpFragment<WeiChar_Medol, WeiChar_View, WeiChar_Presenter> implements WeiChar_View {

    @BindView(R.id.weichar_lv)
    RecyclerView weicharLv;
    Unbinder unbinder;
    private List<WeiChar_Bean.NewslistBean> beans;
    private WeiChar_adapter adapter;

    @Override
    protected int getLayoutID() {
        return R.layout.weichar_layout;
    }

    @Override
    protected WeiChar_Medol initmvpmedol() {
        return new WeiChar_Medol();
    }

    @Override
    protected WeiChar_View initmvpview() {
        return this;
    }

    @Override
    protected WeiChar_Presenter initmypresenter() {
        return new WeiChar_Presenter();
    }

    @Override
    protected void initview(View inflate) {
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        weicharLv.setLayoutManager(ma);
        beans = new ArrayList<>();
        adapter = new WeiChar_adapter(getContext(), beans);
        weicharLv.setAdapter(adapter);
    }

    @Override
    protected void initdata() {
        initmvppresenter.getdata();
    }

    @Override
    public void seccuss(WeiChar_Bean weiChar_bean) {
        List<WeiChar_Bean.NewslistBean> newslist = weiChar_bean.getNewslist();
        beans.addAll(newslist);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void filed(String url) {
        Toast.makeText(getContext(), url, Toast.LENGTH_SHORT).show();
    }
}
