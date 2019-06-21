package com.example.exercise2.fragments;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.exercise2.R;
import com.example.exercise2.adapters.Myadapter3;
import com.example.exercise2.base.BaseMVPFragment;
import com.example.exercise2.beans.Newbook;
import com.example.exercise2.medol.NewMedol;
import com.example.exercise2.presenter.PreNew;
import com.example.exercise2.view.NewView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment3 extends BaseMVPFragment<NewMedol, NewView, PreNew> implements NewView {

    @BindView(R.id.newrecy)
    RecyclerView newrecy;
    Unbinder unbinder;
    private List<Newbook.StoriesBean> storiesBeans;
    private Myadapter3 myadapter3;

    @Override
    protected NewView myinitview() {
        return this;
    }

    @Override
    protected NewMedol myinitmedol() {
        return new NewMedol();
    }

    @Override
    protected PreNew myinitpresenter() {
        return new PreNew();
    }

    @Override
    protected int getinflater() {
        return R.layout.fragment_blank;
    }

    @Override
    protected void initview(View inflate) {
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        newrecy.setLayoutManager(ma);
        storiesBeans = new ArrayList<>();
        myadapter3 = new Myadapter3(getContext(), storiesBeans);
        newrecy.setAdapter(myadapter3);
    }

    @Override
    protected void initdata() {
        initpresenter.filed();
    }

    @Override
    public void getseccuess(Newbook newbook) {
        List<Newbook.StoriesBean> stories = newbook.getStories();
        storiesBeans.addAll(stories);
        myadapter3.notifyDataSetChanged();
    }

    @Override
    public void getfiled(String mes) {
        Toast.makeText(getContext(), mes, Toast.LENGTH_SHORT).show();
    }
}
