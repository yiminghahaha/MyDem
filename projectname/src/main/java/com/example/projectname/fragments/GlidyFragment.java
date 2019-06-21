package com.example.projectname.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectname.R;
import com.example.projectname.adapters.Glidy_adapter;
import com.example.projectname.base.BaseMedol;
import com.example.projectname.base.BaseMvpFragment;
import com.example.projectname.base.BasePresenter;
import com.example.projectname.base.BaseView;
import com.example.projectname.bean.Glidy_item_bean;
import com.example.projectname.medol.Glidy_Medol;
import com.example.projectname.presenter.Glidy_Presenter;
import com.example.projectname.view.Glidy_View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class GlidyFragment extends BaseMvpFragment<Glidy_Medol,Glidy_View,Glidy_Presenter> implements Glidy_View {
    @BindView(R.id.glidy_lv)
    RecyclerView glidyLv;
    Unbinder unbinder;
    private String title;
    private String TAG;
    private List<Glidy_item_bean.ResultsBean> resultsBeans;
    private Glidy_adapter glidy_adapter;

    @SuppressLint("ValidFragment")
    public GlidyFragment(String title) {
        this.title = title;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_glidy;
    }

    @Override
    protected Glidy_Medol initmvpmedol() {
        return new Glidy_Medol();
    }

    @Override
    protected Glidy_View initmvpview() {
        return this;
    }

    @Override
    protected Glidy_Presenter initmypresenter() {
        return new Glidy_Presenter();
    }

    @Override
    protected void initview(View inflate) {
        LinearLayoutManager ma = new LinearLayoutManager(getActivity());
        glidyLv.setLayoutManager(ma);
        resultsBeans = new ArrayList<>();
        glidy_adapter = new Glidy_adapter(getContext(), resultsBeans);
        glidyLv.setAdapter(glidy_adapter);
    }

    @Override
    protected void initdata(){
        initmvppresenter.getdata(title);
    }

    @Override
    public void glidyseccuss(Glidy_item_bean glidy_item_bean){
        List<Glidy_item_bean.ResultsBean> results = glidy_item_bean.getResults();
        resultsBeans.addAll(results);
        glidy_adapter.notifyDataSetChanged();
    }

    @Override
    public void glidyfiled(String mes) {
        Log.i(TAG, "glidyfiled: "+mes);
    }
}
