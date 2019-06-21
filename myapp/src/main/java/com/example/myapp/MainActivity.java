package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.myapp.utils.DaoUtils;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
                if (count>=0){
                    animtion.setText(count--+"TEXTVIEW");
                }else {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fromanima,R.anim.toanima);
                    timer.cancel();
                }
            }
        }
    };

    private TextView animtion;
    private Timer timer;
    private int count = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        for (int i = 0; i < 10; i++) {
            Daobean bean = new Daobean(Long.valueOf(i),"https://ws1.sinaimg.cn/large/0065oQSqgy1fxno2dvxusj30sf10nqcm.jpg", "奔驰", "3000");
            DaoUtils.getDaoUtils().insertAll(bean);
        }
        for (int i = 11; i < 20; i++) {
            Daobean bean = new Daobean(Long.valueOf(i),"https://ws1.sinaimg.cn/large/0065oQSqly1fw8wzdua6rj30sg0yc7gp.jpg", "宝马", "2000");
            DaoUtils.getDaoUtils().insertAll(bean);
        }
    }

    private void initView() {
        animtion = (TextView) findViewById(R.id.animtion);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.texanim);
        animtion.setAnimation(animation);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000,1000);
    }
}
