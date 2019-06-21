package com.example.exercise2.fragments;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.exercise2.R;
import com.example.exercise2.adapters.Myadapter1;
import com.example.exercise2.base.BaseMVPFragment;
import com.example.exercise2.beans.Shitimer;
import com.example.exercise2.medol.MedTimer;
import com.example.exercise2.presenter.Presenter;
import com.example.exercise2.view.Mview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends BaseMVPFragment<MedTimer,Mview,Presenter> implements Mview {

    @BindView(R.id.recy)
    RecyclerView recy;
    private List<Shitimer.ResultBean> resultBeans;
    private Myadapter1 myadapter1;

    @Override
    protected Mview myinitview() {
        return this;
    }

    @Override
    protected MedTimer myinitmedol() {
        return new MedTimer();
    }

    @Override
    protected Presenter myinitpresenter() {
        return new Presenter();
    }

    @Override
    protected int getinflater() {
        return R.layout.fragment_blank_fragment1;
    }

    @Override
    protected void initview(View inflate) {
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        recy.setLayoutManager(ma);
        resultBeans = new ArrayList<>();
        myadapter1 = new Myadapter1(getContext(), resultBeans);
        recy.setAdapter(myadapter1);
    }

    @Override
    protected void initdata() {
        initpresenter.filed();
    }

    @Override
    public void seccuess(Shitimer shitimer) {
        List<Shitimer.ResultBean> result = shitimer.getResult();
        resultBeans.addAll(result);
        myadapter1.notifyDataSetChanged();
    }

    @Override
    public void filedm(String mes) {
        Log.e("aaa",mes);
    }
}
