package com.example.demo7.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
//衣铭  周一晚作业  日期6.3
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayoutID());
        ButterKnife.bind(this);
        initmvp();
        initview();
        initdata();
        listenner();
    }

    protected void listenner() {

    }

    protected void initdata() {

    }

    protected void initview() {

    }

    protected void initmvp() {

    }

    protected abstract int getlayoutID();

}
