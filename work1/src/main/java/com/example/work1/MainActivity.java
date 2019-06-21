package com.example.work1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.work1.medol.Medolimple;
import com.example.work1.presenter.Presenterimple;
import com.example.work1.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View {
    private RecyclerView mRec;
    private TextView mShow;
    private List<Bean.DataBean> arrayList;
    private Myadapter myadapter;

    private String TAG;
    int sum = 0;
    //衣铭  日期 5.28
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        listenner();
    }

    private void listenner() {
        myadapter.setListenneritem(new Myadapter.item() {
            @Override
            public void holderitem(boolean view, int position) {
                if (view){
                    int num = arrayList.get(position).getNum();
                    sum+=num;
                }else if (!view){
                        sum -= arrayList.get(position).getNum();
                    }
                mShow.setText("金额为："+sum);
            }
        });
    }

    private void initView() {
        mRec = (RecyclerView) findViewById(R.id.rec);
        mShow = (TextView) findViewById(R.id.show);
        LinearLayoutManager ma = new LinearLayoutManager(this);
        mRec.setLayoutManager(ma);
        arrayList = new ArrayList<>();
        myadapter = new Myadapter(this, arrayList);
        mRec.setAdapter(myadapter);
        initdata();
    }

    private void initdata() {
        Presenterimple presenterimple = new Presenterimple(new Medolimple(), this);
        presenterimple.getdata();
    }

    @Override
    public void seccuess(Bean bean) {
        if (bean!=null){
            List<Bean.DataBean> list = bean.getData();
            arrayList.addAll(list);
            myadapter.notifyDataSetChanged();
        }
    }

    @Override
    public void filed(String str) {
        Log.i(TAG, "filed: "+str);
    }
}
