package com.example.mdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed1;
    private Button bt1;
    private String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ed1 = (EditText) findViewById(R.id.ed1);
        bt1 = (Button) findViewById(R.id.bt1);

        bt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                price = ed1.getText().toString();
                submit(price);
                break;
        }
    }

    private void submit(String price) {
        // validate
        String ed1String = ed1.getText().toString().trim();
        if (TextUtils.isEmpty(ed1String)) {
            Toast.makeText(this, "请输入余额", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("data",price);
        startActivity(intent);
    }
}
