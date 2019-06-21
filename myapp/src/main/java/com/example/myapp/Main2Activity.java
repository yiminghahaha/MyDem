package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myapp.utils.DaoUtils;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView lv;
    private Myadapter myadapter;
    private List<Daobean> daobeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        listenner();
    }

    private void listenner() {
        myadapter.setListenneritem(new Myadapter.item() {
            @Override
            public void itemholder(Daobean daobean, int position) {
                String image = daobean.getImage();
                String name = daobean.getName();
                String price = daobean.getPrice();
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("bean1",image);
                intent.putExtra("bean2",name);
                intent.putExtra("bean3",price);
                startActivity(intent);
            }
        });
    }


    private void initView() {
        lv = (RecyclerView) findViewById(R.id.lv);
        LinearLayoutManager ma = new LinearLayoutManager(this);
        lv.setLayoutManager(ma);
        daobeans = DaoUtils.getDaoUtils().queryAll();
        myadapter = new Myadapter(this, daobeans);
        lv.setAdapter(myadapter);
    }
}
