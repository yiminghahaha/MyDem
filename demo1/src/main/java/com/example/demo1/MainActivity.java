package com.example.demo1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.demo1.adapters.Vpager;
import com.example.demo1.fragments.BlankFragment;
import com.example.demo1.fragments.BlankFragment2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager vpager;
    private TabLayout tabMode;
    private ArrayList<Fragment> fragments;
    private Vpager vpager1;

    //衣铭   日期5.31
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        vpager = (ViewPager) findViewById(R.id.vpager);
        tabMode = (TabLayout) findViewById(R.id.tabMode);
        fragments = new ArrayList<>();
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment2());
        ArrayList<String> list = new ArrayList<>();
        list.add("我的");
        list.add("收藏");
        vpager1 = new Vpager(getSupportFragmentManager(), fragments, list);
        vpager.setAdapter(vpager1);
        tabMode.setupWithViewPager(vpager);
    }
}
