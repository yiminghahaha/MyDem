package com.example.myworktow;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.myworktow.adapters.Vadapter;
import com.example.myworktow.fragments.BlankFragment;
import com.example.myworktow.fragments.BlankFragment2;
import com.example.myworktow.fragments.BlankFragment3;
import com.example.myworktow.fragments.BlankFragment4;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager vder;
    private TabLayout tab;
    private ArrayList<Fragment> fragments;
    private Vadapter vadapter;

    //衣铭  日期 6.9
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        vder = (ViewPager) findViewById(R.id.vder);
        tab = (TabLayout) findViewById(R.id.tab);
        fragments = new ArrayList<>();
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment2());
        fragments.add(new BlankFragment3());
        fragments.add(new BlankFragment4());
        vadapter = new Vadapter(getSupportFragmentManager(), fragments);
        vder.setAdapter(vadapter);
        tab.addTab(tab.newTab().setCustomView(R.layout.tab_one_layout));
        tab.addTab(tab.newTab().setCustomView(R.layout.tab_tow_layout));
        tab.addTab(tab.newTab().setCustomView(R.layout.tab_three_layout));
        tab.addTab(tab.newTab().setCustomView(R.layout.tab_forelayout));
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vder.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vder.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
    }
}
