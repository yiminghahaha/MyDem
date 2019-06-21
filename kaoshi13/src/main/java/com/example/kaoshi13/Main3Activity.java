package com.example.kaoshi13;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.kaoshi13.adapter.Vpager;

import java.io.Serializable;
import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    private ViewPager vpager;
    private Vpager vpager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();

    }

    private void initView() {
        vpager = (ViewPager) findViewById(R.id.vpager);
        ArrayList<String> data = (ArrayList<String>) getIntent().getSerializableExtra("data");
        vpager1 = new Vpager(this, data);
        vpager.setAdapter(vpager1);
    }
}
