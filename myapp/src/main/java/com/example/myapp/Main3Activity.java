package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import org.greenrobot.eventbus.EventBus;
import java.util.Timer;
import java.util.TimerTask;

public class Main3Activity extends AppCompatActivity {

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){
                if (max<100){
                    max+=10;
                    progress.setProgress(max);
                    if (max==100){
                        image_tu.setVisibility(View.VISIBLE);
                        name1.setVisibility(View.VISIBLE);
                        price1.setVisibility(View.VISIBLE);
                        progress.setVisibility(View.GONE);
                    }
                }
            }
        }
    };

    private ProgressBar progress;
    private ImageView image_tu;
    private TextView name1;
    private TextView price1;
    private Timer timer;
    private String bean1;
    private String bean2;
    private String bean3;
    private int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        progress = (ProgressBar) findViewById(R.id.progress);
        image_tu = (ImageView) findViewById(R.id.image);
        name1 = (TextView) findViewById(R.id.name);
        price1 = (TextView) findViewById(R.id.price);
        max = progress.getProgress();

        bean1 = getIntent().getStringExtra("bean1");
        bean2 = getIntent().getStringExtra("bean2");
        bean3 = getIntent().getStringExtra("bean3");
        Glide.with(Main3Activity.this).load(bean1).into(image_tu);
        name1.setText(bean2);
        price1.setText(bean3);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);
            }
        },500,1000);
        image_tu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                Bean bean = new Bean();
                bean.setImage(bean1);
                bean.setName(bean2);
                EventBus.getDefault().postSticky(bean);
                startActivity(intent);
            }
        });

    }
}
