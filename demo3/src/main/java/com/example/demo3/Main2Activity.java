package com.example.demo3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.demo3.adapters.Myadapter;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView lv;
    private Myadapter myadapter;
    private List<Student> students;
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        lv = (RecyclerView) findViewById(R.id.lv);
        LinearLayoutManager ma = new LinearLayoutManager(this);
        lv.setLayoutManager(ma);
        students = Daoma.getDaoma().queryAll();
        myadapter = new Myadapter(this, students);
        lv.setAdapter(myadapter);
        listenner();
    }

    private void listenner() {
        myadapter.setListenneritem(new Myadapter.item() {
            @Override
            public void itemholder(View view, final int position) {
                a=position;
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this)
                        .setTitle("提示")
                        .setMessage("请选择操作按钮")
                        .setNegativeButton("添加", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                                intent.putExtra("key","1");
                                startActivityForResult(intent,100);
                            }
                        }).setPositiveButton("修改", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                                intent.putExtra("key","2");
                                startActivityForResult(intent,100);
                            }
                        }).setNeutralButton("删除", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                students.remove(position);
                                myadapter.notifyDataSetChanged();
                            }
                        });
                builder .show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100&&resultCode==200){
            //添加
            String name = data.getStringExtra("name");
            String text = data.getStringExtra("text");
            Student student = new Student();
            student.setName(name);
            student.setText(text);
            students.add(student);
            //数据库操作
            Daoma.getDaoma().insert(student);

            myadapter.notifyDataSetChanged();


        }else if (requestCode==100&&resultCode==300){
            //修改
            String name = data.getStringExtra("name2");
            String text = data.getStringExtra("text2");

            Student student = new Student();
            student.setName(name);
            student.setText(text);
            student.setId(Long.valueOf(a));
            students.set(a,student);

            //数据库操作
            Daoma.getDaoma().update(student);

            myadapter.notifyDataSetChanged();

        }
    }
}
