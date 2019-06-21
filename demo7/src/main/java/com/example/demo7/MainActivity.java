package com.example.demo7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.demo7.adapter.Myadapter;
import com.example.demo7.base.BaseMVPActivity;
import com.example.demo7.beans.Bean;
import com.example.demo7.medol.Medol;
import com.example.demo7.presenter.Presenter;
import com.example.demo7.view.Mview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMVPActivity<Medol, Mview, Presenter> implements Mview {

    @BindView(R.id.recy)
    RecyclerView recy;
    private List<Bean.DataBean.DatasBean> datasBeans;
    private Myadapter myadapter;

    @Override
    protected int getlayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected Presenter initmvppresenter() {
        return new Presenter();
    }

    @Override
    protected Mview initmvpview() {
        return this;
    }

    @Override
    protected Medol initmvpmedol() {
        return new Medol();
    }

    @Override
    protected void initview() {
        LinearLayoutManager ma = new LinearLayoutManager(this);
        recy.setLayoutManager(ma);
        datasBeans = new ArrayList<>();
        myadapter = new Myadapter(this, datasBeans);
        recy.setAdapter(myadapter);
    }

    @Override
    protected void initdata() {
        initpresenter.getdata();
    }

    @Override
    protected void listenner() {
        myadapter.setListenneritem(new Myadapter.item() {
            @Override
            public void holderitem(View view, int position) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                String link = datasBeans.get(position).getLink();
                intent.putExtra("data",link);
                startActivity(intent);
            }
        });
    }

    @Override
    public void seccuss(Bean bean) {
        List<Bean.DataBean.DatasBean> datas = bean.getData().getDatas();
        datasBeans.addAll(datas);
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void filed(String mes) {
        Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
    }


}
