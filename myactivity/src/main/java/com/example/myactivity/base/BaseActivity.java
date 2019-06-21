package com.example.myactivity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initmvp();
        initview();
        initdata();
        listenner();
    }

    protected void initmvp() {

    }

    protected void listenner() {

    }

    protected void initdata() {

    }

    protected void initview() {

    }

    protected abstract int getLayoutId();


}
