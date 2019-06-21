package com.example.exercise1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.exercise1.adapters.Vpager_Adapter;
import com.example.exercise1.fragments.BlankFragment;
import com.example.exercise1.fragments.BlankFragment2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabMode;
    private ViewPager mVpager;
    private ArrayList<Fragment> fragments;
    private Vpager_Adapter vpager_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mTabMode = (TabLayout) findViewById(R.id.tabMode);
        mVpager = (ViewPager) findViewById(R.id.vpager);
        fragments = new ArrayList<>();
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment2());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        vpager_adapter = new Vpager_Adapter(getSupportFragmentManager(), fragments, strings);
        mVpager.setAdapter(vpager_adapter);
        mTabMode.setupWithViewPager(mVpager);
    }
}
