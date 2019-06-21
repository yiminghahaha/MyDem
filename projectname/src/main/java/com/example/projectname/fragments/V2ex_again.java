package com.example.projectname.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectname.R;
import com.example.projectname.adapters.V2ex_adapter_item;
import com.example.projectname.base.BaseMvpFragment;
import com.example.projectname.bean.V2ex_again_bean;
import com.example.projectname.medol.V2ex_again_Medol;
import com.example.projectname.presenter.V2ex_again_Presenter;
import com.example.projectname.view.V2ex_again_View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class V2ex_again extends BaseMvpFragment<V2ex_again_Medol, V2ex_again_View, V2ex_again_Presenter> implements V2ex_again_View {
    @BindView(R.id.v2ex_lv)
    RecyclerView v2exLv;
    Unbinder unbinder;
    private String url;
    private List<V2ex_again_bean> beans;
    private V2ex_adapter_item adapterItem;

    @SuppressLint("ValidFragment")
    public V2ex_again(String url) {
        this.url = url;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.v2ex_agein_layout;
    }

    @Override
    protected V2ex_again_Medol initmvpmedol() {
        return new V2ex_again_Medol();
    }

    @Override
    protected V2ex_again_View initmvpview() {
        return this;
    }

    @Override
    protected V2ex_again_Presenter initmypresenter() {
        return new V2ex_again_Presenter();
    }

    @Override
    protected void initview(View inflate) {
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        v2exLv.setLayoutManager(ma);
        beans = new ArrayList<>();
        adapterItem = new V2ex_adapter_item(getContext(), beans);
        v2exLv.setAdapter(adapterItem);

    }

    @Override
    protected void initdata(){
        initmvppresenter.getdata(url);
    }

    @Override
    public void seccuss(final ArrayList<V2ex_again_bean> v2ex_again_bean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                beans.addAll(v2ex_again_bean);
                adapterItem.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void filed(final String mes) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getActivity(), mes, Toast.LENGTH_SHORT).show();
                }
            });
    }

}
