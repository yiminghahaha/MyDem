package com.example.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

//衣铭  日期：6.2
public class MainActivity extends AppCompatActivity {
Handler handler  =  new Handler(){
    @Override
    public void handleMessage(Message msg) {
        if (msg.what==0){
            if (count>=0){
                show.setText(""+count--);
            }else {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                timer.cancel();
                //进出动画方法
                overridePendingTransition(R.anim.anim1,R.anim.anim2);
            }
        }
    }
};
    private TextView show;
    private Timer timer;
    private Student student1;
    int count = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        for (int i = 0; i < 20; i++) {
            student1 = new Student();
            student1.setId(Long.valueOf(i));
            student1.setName("张三"+i);
            student1.setText("高级开发师"+i);
            Daoma.getDaoma().insertAll(student1);
        }
    }

    private void initView() {
        show = (TextView) findViewById(R.id.timer);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },1000,1000);
    }
}
