package com.example.kaoshi13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.kaoshi13.adapter.Myadapter;
import com.example.kaoshi13.beans.Person;
import com.example.kaoshi13.medol.Medolimple;
import com.example.kaoshi13.presenter.Persenterimple;
import com.example.kaoshi13.view.Mview;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements Mview {

    private RecyclerView lv;
    private List<Person.ResultBean> people;
    private Myadapter myadapter;
    private String TAG;
    private ArrayList<String> strings;

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
        people = new ArrayList<>();
        myadapter = new Myadapter(this, people);
        lv.setAdapter(myadapter);
        strings = new ArrayList<>();

        initdata();
        listenner();
    }

    private void listenner() {
        myadapter.setListenneritem(new Myadapter.item() {
            @Override
            public void itemholder(View view, int position) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                for (int i = 0; i < people.size(); i++) {
                    strings.add(people.get(i).getHeader());
                    intent.putExtra("data",strings);
                }
                startActivity(intent);
            }
        });
    }

    private void initdata() {
        Persenterimple persenterimple = new Persenterimple(new Medolimple(), this);
        persenterimple.getdata();
    }

    @Override
    public void seccusss(Person person) {
        if (person!=null){
            List<Person.ResultBean> result = person.getResult();
            people.addAll(result);
            myadapter.notifyDataSetChanged();
            Log.i(TAG, "seccusss: "+person.toString());
        }
    }

    @Override
    public void filed(String mes) {
        Log.i(TAG, "filed: "+mes);
    }
}
