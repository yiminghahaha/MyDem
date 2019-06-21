package com.example.mytre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt1;
    private CircleProgress progress;
    int a = 0;
    //自定义VIEW练习
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bt1 = (Button) findViewById(R.id.bt1);
        progress = (CircleProgress) findViewById(R.id.progress);
        bt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        for (int i = 0; i < 100; i++) {
                            try {
                                Thread.sleep(50);
                                a++;
                                progress.setProgress(a);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start();
                break;
        }
    }
}
