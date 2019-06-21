package com.example.mdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        title = (TextView) findViewById(R.id.title);
        int price = getIntent().getIntExtra("price", 0);
        title.setText("余额为："+price);
    }
}
