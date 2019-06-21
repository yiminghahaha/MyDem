package com.example.myfragmentmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView lv;
    private ArrayList<Studen> studens;
    private Myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        lv = (RecyclerView) findViewById(R.id.lv);
        LinearLayoutManager ma = new LinearLayoutManager(this);
        lv.setLayoutManager(ma);
        studens = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Studen studen = new Studen();
            studen.setName("你好"+i);
            studens.add(studen);
        }
        myadapter = new Myadapter(this, studens);
        lv.setAdapter(myadapter);
    }
}
