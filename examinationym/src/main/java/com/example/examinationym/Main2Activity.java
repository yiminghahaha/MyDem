package com.example.examinationym;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examinationym.adapters.Myadapter;
import com.example.examinationym.beans.Bean;
import com.example.examinationym.medol.Medolimple;
import com.example.examinationym.presenter.Presenimple;
import com.example.examinationym.view.Mview;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, Mview {
//我是1809A的衣铭  正在参加期末A场考试
    /**
     * 手机号
     */
    private EditText mMain2Et1;
    /**
     * 确认手机号
     */
    private EditText mMain2Et2;
    /**
     * 账户余额：
     */
    private TextView mText;
    private RecyclerView mRecy;
    /**
     * 取消
     */
    private Button mMain2Bt1;
    /**
     * 确认兑换
     */
    private Button mMain2Bt2;
    private List<Bean.DataBean.ListBean> listBeans;
    private Myadapter myadapter;
    private String data1;
    private String s1;
    private String s2;
    private int sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initdata();
        listenner();
    }

    private void initView() {
        mMain2Et1 = (EditText) findViewById(R.id.main2_et1);
        mMain2Et2 = (EditText) findViewById(R.id.main2_et2);
        mText = (TextView) findViewById(R.id.text);
        mRecy = (RecyclerView) findViewById(R.id.recy);
        mMain2Bt1 = (Button) findViewById(R.id.main2_bt1);
        mMain2Bt1.setOnClickListener(this);
        mMain2Bt2 = (Button) findViewById(R.id.main2_bt2);
        mMain2Bt2.setOnClickListener(this);
        //显示输入金额
        data1 = getIntent().getStringExtra("data1");
        mText.setText(""+ data1);


        //设置布局
        LinearLayoutManager ger = new LinearLayoutManager(this);
        mRecy.setLayoutManager(ger);
        //适配器初始化
        listBeans = new ArrayList<>();
        myadapter = new Myadapter(this, listBeans);
        mRecy.setAdapter(myadapter);
    }

    private void initdata() {
       //调用数据
        Presenimple presenimple = new Presenimple(new Medolimple(), this);
        presenimple.getdata();
    }

    @Override
    public void onClick(View v) {
        s1 = mMain2Et1.getText().toString();
        s2 = mMain2Et2.getText().toString();
        switch (v.getId()) {
            default:
                break;
            case R.id.main2_bt1:
                //取消操作
                finish();
                break;
            case R.id.main2_bt2:
                //确认操作
                if (s1.equals(s2)){
                    if (sum!=0){
                        Intent intent = new Intent(this,Main3Activity.class);
                        intent.putExtra("work",sum);
                        startActivity(intent);
                    }
                }else {
                    Toast.makeText(this, "条件不符", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void listenner() {
        myadapter.setListenneritem(new Myadapter.item() {

            private RadioButton group;
            RadioButton rb;
            @Override
            public void holder(int position, View view) {
                String s = mText.getText().toString();
                int price = listBeans.get(position).getPrice();
                if (Integer.valueOf(s)<=price){
                    Toast.makeText(Main2Activity.this, "兑换失败", Toast.LENGTH_SHORT).show();
                }
                    sum = Integer.valueOf(s)-position;
                    if (rb!=null){
                        rb.setChecked(false);
                    }
                    group = view.findViewById(R.id.rd);
                    rb=group;
                    group.setChecked(true);
                }
        });
    }

    @Override
    public void seccuess(Bean bean) {
        if (bean!=null){
            List<Bean.DataBean.ListBean> list = bean.getData().getList();
            listBeans.addAll(list);
            myadapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void filed(String mes) {
        Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
    }
}
