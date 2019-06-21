package com.example.myview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private DeleteTextView tv;
    private Button bt;
    private CircleProgress progress_circular;
    private int mProgress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        //tv = (DeleteTextView) findViewById(R.id.tv);
        //只能选一个否则没有效果
        //tv.setdeleteline();
        // tv.setundataline();
        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(this);
        progress_circular = (CircleProgress) findViewById(R.id.progress_circular);
        progress_circular.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                initdata();
                break;
        }
    }

    private void initdata() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(50);
                        mProgress++;

                        progress_circular.setProgress(mProgress);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
