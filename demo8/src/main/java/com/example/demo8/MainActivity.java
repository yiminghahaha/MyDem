package com.example.demo8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView lv;
    private ArrayList<Student> strings;
    private Myadapter myadapter;
    private Button bo1;
    private Button bo2;
    private Button bo3;
    private RadioGroup by;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getData();
    }

    private void initView() {
        lv = (RecyclerView) findViewById(R.id.lv);
        LinearLayoutManager ma = new LinearLayoutManager(this);
        lv.setLayoutManager(ma);
        strings = new ArrayList<>();

        myadapter = new Myadapter(this, strings);
        lv.setAdapter(myadapter);

        bo1 = (Button) findViewById(R.id.bo1);
        bo1.setOnClickListener(this);
        bo2 = (Button) findViewById(R.id.bo2);
        bo2.setOnClickListener(this);
        bo3 = (Button) findViewById(R.id.bo3);
        bo3.setOnClickListener(this);

    }

    private void getData() {

        for (int i = 0; i < 20; i++) {
            strings.add(new Student("XIAP"+i));
        }
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bo1:
                for (int i = 0; i < strings.size(); i++) {
                    Student student = strings.get(i);
                    student.setAa(false);
                }
                myadapter.notifyDataSetChanged();
                break;
            case R.id.bo2:
                for (int i = 0; i < strings.size(); i++) {
                    Student student = strings.get(i);
                    if (student.isBb()==true){
                        strings.remove(i);
                        i--;
                    }
                }
                myadapter.notifyDataSetChanged();
                break;
            case R.id.bo3:
                strings.clear();
            getData();

                break;
        }
    }
}
