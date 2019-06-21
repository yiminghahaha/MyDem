package com.example.exercise4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exercise4.beans.Bean_login;
import com.example.exercise4.loginmedol.LoginMedolimple;
import com.example.exercise4.loginpresenter.LoginPresenterimple;
import com.example.exercise4.loginview.Loginview;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Loginview {

    private EditText ed1;
    private EditText ed2;
    private Button bt1;
    private Button bt2;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                username = ed1.getText().toString();
                password = ed2.getText().toString();
                if (!username.isEmpty()&&!password.isEmpty()){
                    LoginPresenterimple presenterimple = new LoginPresenterimple(new LoginMedolimple(), this);
                    presenterimple.getdata(username,password);
                }
                break;
            case R.id.bt2:
                startActivity(new Intent(this,Main2Activity.class));
                break;
        }
    }

    @Override
    public void loginseccuss(Bean_login bean_login) {
        int code = bean_login.getCode();
        if (code==200){
            Intent intent = new Intent(this, Main3Activity.class);
            startActivity(intent);
        }
    }

    @Override
    public void loginfiled(String mes) {
        Toast.makeText(this, "登陆请求失败", Toast.LENGTH_SHORT).show();
    }
}
