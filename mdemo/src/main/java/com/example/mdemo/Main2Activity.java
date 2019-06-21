package com.example.mdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mdemo.medol.Medolimple;
import com.example.mdemo.presenter.Presenterimple;
import com.example.mdemo.view.Mview;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, Mview {

    private EditText phone1;
    private EditText phone2;
    private RecyclerView lv;
    private Button back;
    private Button ok;
    private List<Bean.DataBean.ListBean> listBeans;
    private Myadapter myadapter;
    private String data;
    private TextView show;
    private int price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initdata();
        listenner();
    }

    private void listenner() {
        myadapter.setListenneritem(new Myadapter.item() {
            private RadioButton radioButton;
            @Override
            public void itemholder(View view, int position) {
                price = listBeans.get(position).getPrice();
                if (radioButton!=null){
                    radioButton.setChecked(false);
                }
                RadioButton checkbox = view.findViewById(R.id.checkbox);
                radioButton = checkbox;
                checkbox.setChecked(true);
            }
        });
    }

    private void initdata() {
        Presenterimple presenterimple = new Presenterimple(new Medolimple(), this);
        presenterimple.getdata();
    }

    private void initView() {
        show = (TextView) findViewById(R.id.show);
        phone1 = (EditText) findViewById(R.id.phone1);
        phone2 = (EditText) findViewById(R.id.phone2);
        lv = (RecyclerView) findViewById(R.id.lv);
        back = (Button) findViewById(R.id.back);
        ok = (Button) findViewById(R.id.ok);

        back.setOnClickListener(this);
        ok.setOnClickListener(this);

        data = getIntent().getStringExtra("data");
        show.setText(data);
        LinearLayoutManager ma = new LinearLayoutManager(this);
        lv.setLayoutManager(ma);
        listBeans = new ArrayList<>();
        myadapter = new Myadapter(this, listBeans);
        lv.setAdapter(myadapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.ok:
                String phone1 = this.phone1.getText().toString();
                String phone2 = this.phone2.getText().toString();
                submit(phone1, phone2);
                break;
        }
    }

    private void submit(String phone1, String phone2) {
        // validate
        String phone1String = this.phone1.getText().toString().trim();
        if (TextUtils.isEmpty(phone1String)) {
            Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
            return;
        }

        String phone2String = this.phone2.getText().toString().trim();
        if (TextUtils.isEmpty(phone2String)) {
            Toast.makeText(this, "请确认手机号码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        if (phone1.equalsIgnoreCase(phone2)) {
            Integer value = Integer.valueOf(data);
            if (value>price){
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                int pric = value- price;
                intent.putExtra("price",pric);
                startActivity(intent);
            }else {
                Toast.makeText(Main2Activity.this, "兑换失败", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void getseccuss(Bean bean) {
        List<Bean.DataBean.ListBean> list = bean.getData().getList();
        listBeans.addAll(list);
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void getfiled(String mes) {
        Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
    }
}
