package com.example.mdemo2;

import android.app.NotificationManager;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.mdemo2.adapter.Vadapter;
import com.example.mdemo2.fragments.BlankFragment;
import com.example.mdemo2.fragments.BlankFragment2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> fragments;
    private Vadapter vadapter;
    private Brocas brocas;
    private IntentFilter aaa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
        fragments = new ArrayList<>();
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment2());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("首页");
        strings.add("我的");
        vadapter = new Vadapter(getSupportFragmentManager(), fragments, strings);
        vp.setAdapter(vadapter);
        tab.setupWithViewPager(vp);

    }
    @Override
    public void onResume() {
        super.onResume();
        brocas = new Brocas();
        aaa = new IntentFilter("aaa");
       registerReceiver(brocas, aaa);

    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(brocas);
    }
}
