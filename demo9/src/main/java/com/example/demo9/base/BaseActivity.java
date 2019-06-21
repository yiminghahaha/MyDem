package com.example.demo9.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        ButterKnife.bind(this);
        initmvp();
        initview();
        initdata();
        initlistenner();
    }

    protected void initlistenner() {

    }

    protected void initdata() {

    }

    protected void initview() {

    }

    protected void initmvp() {

    }

    protected abstract int getLayoutID();
}
