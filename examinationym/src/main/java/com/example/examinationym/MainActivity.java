package com.example.examinationym;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToobar;
    private EditText mEt1;
    /**
     * 进入兑换页面
     */
    private Button mBt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        mToobar = (Toolbar) findViewById(R.id.toobar);
        mEt1 = (EditText) findViewById(R.id.et1);
        mBt1 = (Button) findViewById(R.id.bt1);
        mBt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String s = mEt1.getText().toString();

        switch (v.getId()) {
            default:
                break;
            case R.id.bt1:
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("data1",s);
                startActivity(intent);
                break;
        }
    }
}
