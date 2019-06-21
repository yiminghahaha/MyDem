package com.example.projectname.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.projectname.R;
import com.example.projectname.adapters.ZhiHu_NewDay_adapter;
import com.example.projectname.base.BaseMvpFragment;
import com.example.projectname.bean.NewDay_bean;
import com.example.projectname.medol.ZhiHu_NewDay_Medol;
import com.example.projectname.presenter.ZhiHu_NewDay_Presenter;
import com.example.projectname.view.ZhiHu_NewDay_View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

public class ZhiHu_NewDay extends BaseMvpFragment<ZhiHu_NewDay_Medol, ZhiHu_NewDay_View, ZhiHu_NewDay_Presenter> implements ZhiHu_NewDay_View {

    @BindView(R.id.zhihu_lv)
    RecyclerView zhihuLv;
    Unbinder unbinder;
    private List<NewDay_bean.StoriesBean> storiesBeans;
    private List<NewDay_bean.TopStoriesBean> topStoriesBeans;
    private String TAG;
    private ZhiHu_NewDay_adapter adapter;

    @Override
    protected int getLayoutID() {
        return R.layout.zhihu_newday_layout;
    }

    @Override
    protected void initview(View inflate) {
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        zhihuLv.setLayoutManager(ma);
        storiesBeans = new ArrayList<>();
        topStoriesBeans = new ArrayList<>();
        adapter = new ZhiHu_NewDay_adapter(getContext(), storiesBeans, topStoriesBeans);
        zhihuLv.setAdapter(adapter);
    }

    @Override
    protected void initdata() {
        initmvppresenter.getdata1();
    }

    @Override
    protected ZhiHu_NewDay_Medol initmvpmedol() {
        return new ZhiHu_NewDay_Medol();
    }

    @Override
    protected ZhiHu_NewDay_View initmvpview() {
        return this;
    }

    @Override
    protected ZhiHu_NewDay_Presenter initmypresenter() {
        return new ZhiHu_NewDay_Presenter();
    }

    @Override
    public void seccuess(NewDay_bean newDay_bean) {
        List<NewDay_bean.TopStoriesBean> top_stories = newDay_bean.getTop_stories();
        List<NewDay_bean.StoriesBean> stories = newDay_bean.getStories();
        storiesBeans.addAll(stories);
        topStoriesBeans.addAll(top_stories);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void filed(String mes) {
        Log.i(TAG, "filed: " + mes);
    }




}
