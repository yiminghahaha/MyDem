package com.example.myregister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myregister.beans.Register_bean;
import com.example.myregister.beans.Verify_bean;
import com.example.myregister.register_medol.Register_medolimple;
import com.example.myregister.register_presenter.Register_presenterimple;
import com.example.myregister.register_view.Register_view;
import com.example.myregister.verify_medol.Verify_medolimple;
import com.example.myregister.verify_presenter.Verify_Presenterimple;
import com.example.myregister.verify_view.Verify_view;
import com.google.gson.Gson;

import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Verify_view, Register_view {

    private EditText username;
    private EditText pas;
    private EditText password;
    private EditText phone;
    private Button verify;
    private Button register;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        username = (EditText) findViewById(R.id.username);
        pas = (EditText) findViewById(R.id.pas);
        password = (EditText) findViewById(R.id.password);
        phone = (EditText) findViewById(R.id.phone);
        verify = (Button) findViewById(R.id.verify);
        register = (Button) findViewById(R.id.register);

        verify.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.verify:
                Verify_Presenterimple presenterimple = new Verify_Presenterimple(new Verify_medolimple(), this);
                presenterimple.getverify();
                break;
            case R.id.register:
                String name = username.getText().toString();
                String pass = pas.getText().toString();
                String phone = this.phone.getText().toString();
                String verify = this.verify.getText().toString();

                submit(name,pass,phone,verify);
                break;
        }
    }

    private void submit(String name, String pass, String phone, String verify) {
        // validate
        String usernameString = username.getText().toString().trim();
        if (TextUtils.isEmpty(usernameString)) {
            Toast.makeText(this, "用户名", Toast.LENGTH_SHORT).show();
            return;
        }

        String pasString = pas.getText().toString().trim();
        if (TextUtils.isEmpty(pasString)) {
            Toast.makeText(this, "密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String passwordString = password.getText().toString().trim();
        if (TextUtils.isEmpty(passwordString)) {
            Toast.makeText(this, "确认密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String phoneString = this.phone.getText().toString().trim();
        if (TextUtils.isEmpty(phoneString)) {
            Toast.makeText(this, "手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        // TODO validate success, do something

        Register_presenterimple presenterimple = new Register_presenterimple(new Register_medolimple(), this);
        presenterimple.getdata(name,pass,phone,data);
    }

    @Override
    public void seccuss(Verify_bean verify_bean) {
        if (verify_bean!=null){
            data = verify_bean.getData();
            verify.setText(data);
        }
    }

    @Override
    public void filed(String mes) {
        Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void seccuess(Register_bean register_bean) {
        int code = register_bean.getCode();
        if (code==200){
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void field(String mes) {
        Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
    }
}
