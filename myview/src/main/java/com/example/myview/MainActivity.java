package com.example.myview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myview.medol.Medolimple;
import com.example.myview.presenter.Presenterimple;
import com.example.myview.view.Myview;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Myview {

    private RecyclerView lv;
    private List<Bean.DataBean.DatasBean> students;
    private Myadapter myadapter;
    private Button bt1;
    private Button bt2;
    private Button bt3;
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
        bt1.setOnClickListener(this);
        bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(this);
        bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(this);

        LinearLayoutManager ma = new LinearLayoutManager(this);
        lv.setLayoutManager(ma);
        students = new ArrayList<>();

        myadapter = new Myadapter(this, students);
        lv.setAdapter(myadapter);
        Presenterimple presenterimple = new Presenterimple(new Medolimple(), this);
        presenterimple.getbea();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).isFresh()==false){
                        Bean.DataBean.DatasBean set = students.set(i, students.get(i));
                        set.setFresh(true);
                    }else {
                        Bean.DataBean.DatasBean set = students.set(i, students.get(i));
                        set.setFresh(false);
                    }
                }
                myadapter.notifyDataSetChanged();
                break;
            case R.id.bt2:

                break;
            case R.id.bt3:

                break;
        }
    }

    @Override
    public void seccuss(Bean bean) {
        List<Bean.DataBean.DatasBean> datas = bean.getData().getDatas();
        students.addAll(datas);
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void filed(String mes) {
        Log.i(TAG, "filed: "+mes);
    }
}
