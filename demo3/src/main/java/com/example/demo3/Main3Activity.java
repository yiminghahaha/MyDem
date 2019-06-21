package com.example.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView name;
    private TextView text;
    private Button bt1;
    private TextView view;
    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        name = (TextView) findViewById(R.id.name);
        text = (TextView) findViewById(R.id.text);
        bt1 = (Button) findViewById(R.id.bt1);
        view = (TextView) findViewById(R.id.view);

        bt1.setOnClickListener(this);
        view.setOnClickListener(this);
        key = getIntent().getStringExtra("key");
        if (key.equals("1")){
            view.setText("添加");
        }else if (key.equals("2")){
            view.setText("修改");
        }

    }

    @Override
    public void onClick(View v) {
        String name = this.name.getText().toString();
        String text = this.text.getText().toString();

        switch (v.getId()) {
            case R.id.bt1:
                if (key.equals("1")){
                    Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("text", text);
                    setResult(200, intent);
                    finish();
                }else if (key.equals("2")){
                    Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                    intent.putExtra("name2",name);
                    intent.putExtra("text2",text);
                    setResult(300,intent);
                    finish();
                }

                break;
        }
    }
}
