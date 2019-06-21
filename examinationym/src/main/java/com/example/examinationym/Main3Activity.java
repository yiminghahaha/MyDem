package com.example.examinationym;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private TextView mMain3Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        mMain3Text = (TextView) findViewById(R.id.main3_text);
        int price = getIntent().getIntExtra("work",0);
        mMain3Text.setText("余额为："+price);
    }
}
