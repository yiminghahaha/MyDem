package com.example.myfragmentmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.myfragmentmanager.view.DeleteTextView;

public class Main3Activity extends AppCompatActivity {

    private DeleteTextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        tv = (DeleteTextView) findViewById(R.id.tv);
        tv.setdeleteline();
        tv.setundataline();
    }
}
