package com.example.exercise1.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.exercise1.R;
import com.example.exercise1.adapters.Myadapter_Fra1;
import com.example.exercise1.bean.Bean;
import com.example.exercise1.medol.Medolimple;
import com.example.exercise1.presenter.Presenimple;
import com.example.exercise1.view.Myview;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements Myview {

    private View view;
    private RecyclerView mRecy;
    private List<Bean.DataBean> dataBeans;
    private Myadapter_Fra1 myadapter_fra1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank, null);
        initView(inflate);
        initdata();
        return inflate;
    }

    private void initdata() {
        Presenimple presenimple = new Presenimple(new Medolimple(), this);
        presenimple.getdata();
    }

    private void initView(View inflate) {
        mRecy = (RecyclerView) inflate.findViewById(R.id.recy);
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        mRecy.setLayoutManager(ma);
        dataBeans = new ArrayList<>();
        myadapter_fra1 = new Myadapter_Fra1(getContext(), dataBeans);
        mRecy.setAdapter(myadapter_fra1);
    }

    @Override
    public void seccuess(Bean bean) {
        if (bean!=null){
            List<Bean.DataBean> data = bean.getData();
            dataBeans.addAll(data);
            myadapter_fra1.notifyDataSetChanged();
        }
    }

    @Override
    public void filed(String mes) {
        Toast.makeText(getContext(), mes, Toast.LENGTH_SHORT).show();
    }
}
