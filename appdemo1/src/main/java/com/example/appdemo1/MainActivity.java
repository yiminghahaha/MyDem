package com.example.appdemo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import qdx.stickyheaderdecoration.NormalDecoration;

public class MainActivity extends AppCompatActivity {

    private RecyclerView lv;
    private ArrayList<Car> cars;
    private Myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        lv = (RecyclerView) findViewById(R.id.lv);
        LinearLayoutManager ma = new LinearLayoutManager(this);
        lv.setLayoutManager(ma);
        cars = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            cars.add(new Car("花花"+i,"15"+i));
        }
        myadapter = new Myadapter(this, cars);
        NormalDecoration decoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int i) {
                return cars.get(i).getSex();
            }
        };
        lv.addItemDecoration(decoration);
        decoration.setOnHeaderClickListener(new NormalDecoration.OnHeaderClickListener() {
            @Override
            public void headerClick(int i) {
                Toast.makeText(MainActivity.this, cars.get(i).getSex(), Toast.LENGTH_SHORT).show();
            }
        });
        lv.setAdapter(myadapter);
    }
}
