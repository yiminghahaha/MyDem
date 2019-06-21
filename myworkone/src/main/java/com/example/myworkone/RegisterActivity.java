package com.example.myworkone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myworkone.beans.Regist_bean;
import com.example.myworkone.beans.Verify_Bean;
import com.example.myworkone.register_medol.Register_Medolimple;
import com.example.myworkone.register_presenter.Register_presenterimple;
import com.example.myworkone.register_view.Register_view;
import com.example.myworkone.verify_medol.Verify_Medolimple;
import com.example.myworkone.verify_presenter.Verify_Presenterimple;
import com.example.myworkone.verify_view.Verify_view;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, Verify_view, Register_view {

    private EditText username;
    private EditText password;
    private EditText phone;
    private EditText verify;
    private Button show;
    private Button zc;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        phone = (EditText) findViewById(R.id.phone);
        verify = (EditText) findViewById(R.id.verify);
        show = (Button) findViewById(R.id.show);
        zc = (Button) findViewById(R.id.zc);

        show.setOnClickListener(this);
        zc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show:
                Verify_Presenterimple presenterimple = new Verify_Presenterimple(new Verify_Medolimple(), this);
                presenterimple.getverify();
                break;
            case R.id.zc:
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String phone = this.phone.getText().toString();
                String verify = this.verify.getText().toString();
                Register_presenterimple presenterimple1 = new Register_presenterimple(new Register_Medolimple(), this);
                presenterimple1.getregis(user,pass,phone,verify);
                break;
        }
    }

    private void submit() {
        // validate
        String usernameString = username.getText().toString().trim();
        if (TextUtils.isEmpty(usernameString)) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }

        String passwordString = password.getText().toString().trim();
        if (TextUtils.isEmpty(passwordString)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String phoneString = phone.getText().toString().trim();
        if (TextUtils.isEmpty(phoneString)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String verifyString = verify.getText().toString().trim();
        if (TextUtils.isEmpty(verifyString)) {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    public void seccuss(Verify_Bean verify_bean) {
        data = verify_bean.getData();
        if (data !=null){
            show.setText(data);
        }else {
            Toast.makeText(this, "获取验证失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void seccuss2(Regist_bean regist_bean) {
        int code = regist_bean.getCode();
        if (code==200){
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void filed(String mes) {
        Toast.makeText(this, "获取验证失败", Toast.LENGTH_SHORT).show();
    }
}
