package com.example.mdemo2.fragments;


import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mdemo2.Brocas;
import com.example.mdemo2.Main2Activity;
import com.example.mdemo2.R;
import com.example.mdemo2.adapter.Myadapter;
import com.example.mdemo2.bean.Bean;
import com.example.mdemo2.medol.Medolimple;
import com.example.mdemo2.presenter.Presenterimple;
import com.example.mdemo2.view.Mview;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements Mview {

    private RecyclerView lv;
    private List<Bean.DataBean.DatasBean> datasBeans;
    private Myadapter myadapter;
    private Brocas brocas;
    private IntentFilter aaa;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank, null);
        initView(inflate);
        return inflate;
    }

    public void listenner() {
        myadapter.setListenner(new Myadapter.itemview() {
            @Override
            public void holderitem(View view, int position) {
                Intent intent = new Intent("aaa");
                String title = datasBeans.get(position).getTitle();
                String envelopePic = datasBeans.get(position).getEnvelopePic();
                intent.putExtra("title",title);
                intent.putExtra("url",envelopePic);
                getActivity().sendBroadcast(intent);
            }
        });
    }

    private void initView(View inflate) {
        lv = (RecyclerView) inflate.findViewById(R.id.lv);
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        lv.setLayoutManager(ma);
        datasBeans = new ArrayList<>();
        myadapter = new Myadapter(getContext(), datasBeans);
        lv.setAdapter(myadapter);
        initdata();
        listenner();
    }

    private void initdata() {
        Presenterimple presenterimple = new Presenterimple(new Medolimple(), this);
        presenterimple.getdata();
    }

    @Override
    public void seccuss(Bean bean) {
        List<Bean.DataBean.DatasBean> datas = bean.getData().getDatas();
        datasBeans.addAll(datas);
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void filed(String mes) {
        Toast.makeText(getContext(), mes, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        brocas = new Brocas();
        aaa = new IntentFilter("aaa");
        getActivity().registerReceiver(brocas, aaa);

    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(brocas);
    }
}
