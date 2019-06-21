package com.example.myone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView lv;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private ArrayList<Person> strings;
    private Myadapter myadapter;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        lv = (RecyclerView) findViewById(R.id.lv);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);

        strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Person person = new Person();
            person.setName("你好"+i);
            strings.add(person);
        }
        LinearLayoutManager ma = new LinearLayoutManager(this);
        lv.setLayoutManager(ma);
        myadapter = new Myadapter(this, strings);
        lv.setAdapter(myadapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                for (int i = 0; i < strings.size(); i++) {
                    strings.get(i).setB(true);
                }
                myadapter.notifyDataSetChanged();
                break;
            case R.id.bt2:
                for (int i = 0; i < strings.size(); i++) {
                    if (strings.get(i).getA()==true){
                        strings.remove(i);
                        i--;
                    }
                }
                myadapter.notifyDataSetChanged();
                break;
            case R.id.bt3:
                for (Person strings1:strings) {
                    Log.i(TAG, "onClick: "+strings1);
                }
                break;
        }
    }
}
