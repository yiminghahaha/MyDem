package com.example.exercise4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exercise4.api.Api;
import com.example.exercise4.beans.Bean_regist;
import com.example.exercise4.beans.Tous;
import com.example.exercise4.tousmedol.Tous_medolimple;
import com.example.exercise4.touspresenter.Tous_presentimple;
import com.example.exercise4.tousview.Tous_view;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, Tous_view {

    private EditText regist_ed1;
    private EditText regist_ed2;
    private EditText regist_ed3;
    private EditText regist_ed4;
    private Button regist_bt1;
    private Button regist_bt2;
    private String TAG;
    private String data;
    private String username;
    private String password;
    private String okpassword;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        regist_ed1 = (EditText) findViewById(R.id.regist_ed1);
        regist_ed2 = (EditText) findViewById(R.id.regist_ed2);
        regist_ed3 = (EditText) findViewById(R.id.regist_ed3);
        regist_ed4 = (EditText) findViewById(R.id.regist_ed4);
        regist_bt1 = (Button) findViewById(R.id.regist_bt1);
        regist_bt2 = (Button) findViewById(R.id.regist_bt2);

        regist_bt1.setOnClickListener(this);
        regist_bt2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regist_bt1:
                Tous_presentimple presentimple = new Tous_presentimple(new Tous_medolimple(), this);
                presentimple.getdata();
                break;
            case R.id.regist_bt2:
                username = regist_ed1.getText().toString();
                password = regist_ed2.getText().toString();
                okpassword = regist_ed3.getText().toString();
                phone = regist_ed4.getText().toString();
                if (password.equals(okpassword)){
                    initdata();
                 // startActivity(new Intent(Main2Activity.this,MainActivity.class));
                }else {
                    Toast.makeText(this, "密码不相同", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void initdata() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Observable<Bean_regist> observable = api.getregist(username,password,phone,data);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean_regist>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(Bean_regist bean_regist) {
                        int code = bean_regist.getCode();
                        Log.i("111", "onNext: "+code);
                        if (code==200){
                            Toast.makeText(Main2Activity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Main2Activity.this, "注册失败", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void submit() {
        // validate
        String ed1 = regist_ed1.getText().toString().trim();
        if (TextUtils.isEmpty(ed1)) {
            Toast.makeText(this, "用户名", Toast.LENGTH_SHORT).show();
            return;
        }

        String ed2 = regist_ed2.getText().toString().trim();
        if (TextUtils.isEmpty(ed2)) {
            Toast.makeText(this, "密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String ed3 = regist_ed3.getText().toString().trim();
        if (TextUtils.isEmpty(ed3)) {
            Toast.makeText(this, "确认密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String ed4 = regist_ed4.getText().toString().trim();
        if (TextUtils.isEmpty(ed4)) {
            Toast.makeText(this, "手机号", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    public void seccuess(Tous tous) {
        data = tous.getData();
        regist_bt1.setText(data);
    }

    @Override
    public void filed(String mes) {
        Toast.makeText(this, "验证码请求失败", Toast.LENGTH_SHORT).show();
    }

}
