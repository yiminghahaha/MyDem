package com.example.myworkone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myworkone.beans.Login_bean;
import com.example.myworkone.login_medol.Login_Medol;
import com.example.myworkone.login_presenter.Login_Preseimple;
import com.example.myworkone.login_view.Login_view;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Login_view {

    private EditText login_user;
    private EditText login_pas;
    private Button login;
    private Button register;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        login_user = (EditText) findViewById(R.id.login_user);
        login_pas = (EditText) findViewById(R.id.login_pas);
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        username = login_user.getText().toString();
        password = login_pas.getText().toString();
        switch (v.getId()) {
            case R.id.login:
                Login_Preseimple preseimple = new Login_Preseimple(new Login_Medol(), this);
                preseimple.getbean(username,password);
                break;
            case R.id.register:
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void submit() {
        // validate
        String user = login_user.getText().toString().trim();
        if (TextUtils.isEmpty(user)) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }

        String pas = login_pas.getText().toString().trim();
        if (TextUtils.isEmpty(pas)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    @Override
    public void seccuss(Login_bean login_bean) {
        int code = login_bean.getCode();
        if (code==200){
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void filed(String login) {
        Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
    }
}
