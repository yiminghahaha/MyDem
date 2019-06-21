package com.example.myactivity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.myactivity.adapter.Myadapter;
import com.example.myactivity.base.BaseActivity;
import com.example.myactivity.base.BaseMVPActivity;
import com.example.myactivity.beans.Bean;
import com.example.myactivity.medol.Medol;
import com.example.myactivity.presenter.Mypresenter;
import com.example.myactivity.view.Mview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMVPActivity<Medol, Mview, Mypresenter> implements Mview {

    @BindView(R.id.recy)
    RecyclerView recy;
    private List<Bean.ResultsBean> resultsBeans;
    private String TAG;
    private Myadapter myadapter;

    @Override
    protected Mview initMVPview() {
        return this;
    }

    @Override
    protected Medol initMVPmedol() {
        return new Medol();
    }

    @Override
    protected Mypresenter initpresenter() {
        return new Mypresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initview() {
        GridLayoutManager grad = new GridLayoutManager(this, 2);
        recy.setLayoutManager(grad);
        resultsBeans = new ArrayList<>();
        myadapter = new Myadapter(this, resultsBeans);
        recy.setAdapter(myadapter);
    }

    @Override
    protected void initdata() {
        initMVPpresenter.getdata();
    }


    @Override
    public void seccuess(Bean bean) {
        List<Bean.ResultsBean> results = bean.getResults();
        resultsBeans.addAll(results);
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void filed(String mes) {
        Log.i(TAG, "filed: "+mes);
    }
}
