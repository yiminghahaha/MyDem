package com.example.demo2;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.demo2.adapter.Vpager;

import java.io.Serializable;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ViewPager vpager;
    private Vpager vpager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        vpager = (ViewPager) findViewById(R.id.vpager);
        ArrayList<String> name = (ArrayList<String>) getIntent().getSerializableExtra("name");
        vpager1 = new Vpager(this, name);
        vpager.setAdapter(vpager1);
    }
}
