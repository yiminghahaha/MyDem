package com.example.demo1.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.demo1.Daomas;
import com.example.demo1.R;
import com.example.demo1.adapters.Myadapter1;
import com.example.demo1.beans.Bean;
import com.example.demo1.beans.Student;
import com.example.demo1.medol.Medolimple;
import com.example.demo1.presenter.Presenterimple;
import com.example.demo1.view.Myview;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements Myview {

    private RecyclerView fra1_rec;
    private List<Bean.RecentBean> recentBeans;
    private Myadapter1 myadapter1;
    private String TAG;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        fra1_rec = (RecyclerView) inflate.findViewById(R.id.fra1_rec);
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        fra1_rec.setLayoutManager(ma);
        recentBeans = new ArrayList<>();
        myadapter1 = new Myadapter1(getContext(), recentBeans);
        fra1_rec.setAdapter(myadapter1);
        initdata();
        listenner();
    }

    private void listenner() {
        myadapter1.setListenneritem(new Myadapter1.item() {
            @Override
            public void holderitem(View view, final int position) {
                new AlertDialog.Builder(getContext())
                        .setMessage("是否插入数据库")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Student student = new Student();
                                student.setId(Long.valueOf(position));
                                student.setName(recentBeans.get(position).getNews_id()+"");
                                student.setUrl(recentBeans.get(position).getThumbnail());
                                student.setUser(recentBeans.get(position).getUrl());
                                Daomas.getDaomas().insertAll(student);
                                Toast.makeText(getContext(), "插入成功", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("取消",null)
                        .show();
            }
        });
    }

    private void initdata() {
        Presenterimple presenterimple = new Presenterimple(new Medolimple(), this);
        presenterimple.getdata();
    }

    @Override
    public void seccuss(Bean bean) {
        List<Bean.RecentBean> recent = bean.getRecent();
        recentBeans.addAll(recent);
        myadapter1.notifyDataSetChanged();
    }

    @Override
    public void filed(String mes) {
        Log.i(TAG, "filed: "+mes);
    }
}
