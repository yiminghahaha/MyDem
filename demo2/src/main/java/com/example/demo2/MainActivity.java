package com.example.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.demo2.adapter.Myadapter;
import com.example.demo2.beans.Bean;
import com.example.demo2.medol.Medolimple;
import com.example.demo2.preesnter.Presenterimple;
import com.example.demo2.view.Mview;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Mview {
//衣铭  日期6.1
    private RecyclerView rec;
    private List<Bean.ResultsBean> resultsBeans;
    private Myadapter myadapter;
    private String TAG;
    private  ArrayList<String> strings = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rec = (RecyclerView) findViewById(R.id.rec);
        GridLayoutManager gra = new GridLayoutManager(this, 2);
        rec.setLayoutManager(gra);
        resultsBeans = new ArrayList<>();
        myadapter = new Myadapter(this, resultsBeans);
        rec.setAdapter(myadapter);
        initdata();
        listenner();
    }

    private void initdata() {
        Presenterimple presenterimple = new Presenterimple(new Medolimple(), this);
        presenterimple.getdata();
    }

    private void listenner() {
       myadapter.setListenneritem(new Myadapter.item() {
           @Override
           public void itemholder(View view, int position) {
               Intent intent = new Intent(MainActivity.this,Main2Activity.class);
               for (int i = 0; i < resultsBeans.size(); i++) {
                   String url = resultsBeans.get(i).getUrl();
                   strings.add(url);
               }
               intent.putStringArrayListExtra("name",strings);
               startActivity(intent);
           }
       });
    }

    @Override
    public void seccuss(Bean bean) {
        List<Bean.ResultsBean> results = bean.getResults();
        resultsBeans.addAll(results);
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void filed(String mes) {
        Log.i(TAG, "filed: "+mes);
    }
}
