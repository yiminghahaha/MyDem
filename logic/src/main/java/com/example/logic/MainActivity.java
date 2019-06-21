package com.example.logic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView lv;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private List<Student> students;
    private Myadapter1 myadapter1;
    private Myadapter2 myadapter2;

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
        students = new ArrayList<>();
        LinearLayoutManager ma = new LinearLayoutManager(this);
        lv.setLayoutManager(ma);
        for (int i = 0; i < 20; i++) {
            Student student = new Student(true, "你好" + i);
            students.add(student);
        }
        myadapter1 = new Myadapter1(this, students);
        lv.setAdapter(myadapter1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                myadapter2 = new Myadapter2(this, students);
                lv.setAdapter(myadapter2);
                myadapter2.notifyDataSetChanged();
                break;
            case R.id.bt2:
                for (int i = 0; i < students.size(); i++) {
                    Student student = students.get(i);
                    if (student.getaBoolean()==true){
                        students.remove(i);
                    }
                }
                myadapter2.notifyDataSetChanged();
                break;
            case R.id.bt3:
                List<Student> objects = new ArrayList<>();
                objects.addAll(students);
                Myadapter1 myadapter1 = new Myadapter1(this, objects);
                lv.setAdapter(myadapter1);
//                students.clear();
//                initView();
                break;
        }
    }
}
