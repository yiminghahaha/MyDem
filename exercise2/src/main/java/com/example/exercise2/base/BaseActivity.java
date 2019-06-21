package com.example.exercise2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayout());
        ButterKnife.bind(this);
        MVP();
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

    protected void MVP() {

    }

    protected abstract int getlayout();

}
