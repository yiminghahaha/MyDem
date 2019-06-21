package com.example.myapp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    private ViewPager vpager;
    private ArrayList<Bean> beans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initView();
        EventBus.getDefault().register(this);
    }

    private void initView() {
        vpager = (ViewPager) findViewById(R.id.vpager);
        beans = new ArrayList<>();
    }

    @Subscribe(threadMode = ThreadMode.ASYNC,sticky = true)
    public  void  initdata(Bean bean){
        if (bean!=null){
            beans.add(bean);
            Vpager vpager1 = new Vpager(this, beans);
            vpager.setAdapter(vpager1);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
