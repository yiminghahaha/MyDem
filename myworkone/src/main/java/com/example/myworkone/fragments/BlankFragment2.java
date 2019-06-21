package com.example.myworkone.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myworkone.DaoUtils;
import com.example.myworkone.R;
import com.example.myworkone.adapters.Shou_adapter;
import com.example.myworkone.beans.Dao_bean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {

    private RecyclerView rec;
    private List<Dao_bean> dao_beans;
    private Shou_adapter shou_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment2, null);
        initView(inflate);
        initdata();
        return inflate;
    }

    private void initdata() {
        List<Dao_bean> beans = DaoUtils.getDaoUtils().queryAll();
        dao_beans.addAll(beans);
        shou_adapter.notifyDataSetChanged();
    }

    private void initView(View inflate) {
        rec = (RecyclerView) inflate.findViewById(R.id.rec);
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        rec.setLayoutManager(ma);
        dao_beans = new ArrayList<>();
        shou_adapter = new Shou_adapter(getContext(), dao_beans);
        rec.setAdapter(shou_adapter);
    }
}
