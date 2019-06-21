package com.example.exercise3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;

import com.example.exercise3.adapter.Myadapter;
import com.example.exercise3.adapter.Vpager_adapter;
import com.example.exercise3.medol.Medolimple;
import com.example.exercise3.presenter.Presenterimple;
import com.example.exercise3.view.Mview;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Mview {

    private RecyclerView lv;
    private ArrayList<Bean.ResultsBean> resultsBeans;
    private Myadapter myadapter;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        lv = (RecyclerView) findViewById(R.id.lv);
        GridLayoutManager gr = new GridLayoutManager(this, 2);
        lv.setLayoutManager(gr);
        resultsBeans = new ArrayList<>();
        myadapter = new Myadapter(this, resultsBeans);
        lv.setAdapter(myadapter);
        initdata();
        listenner();
    }

    private void listenner() {
        myadapter.setListenneritem(new Myadapter.item(){
            @Override
            public void itemholder(View view, int position){
                View inflate = View.inflate(MainActivity.this, R.layout.popu_layout, null);
                ViewPager vpager = inflate.findViewById(R.id.vpager);
                PopupWindow popupWindow = new PopupWindow(inflate,500,500);
                popupWindow.showAsDropDown(inflate);
                Vpager_adapter adapter = new Vpager_adapter(MainActivity.this, resultsBeans);
                vpager.setAdapter(adapter);
            }
        });
    }

    private void initdata() {
        Presenterimple presenterimple = new Presenterimple(new Medolimple(), this);
        presenterimple.getdata();
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
