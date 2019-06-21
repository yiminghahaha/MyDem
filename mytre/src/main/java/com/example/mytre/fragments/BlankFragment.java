package com.example.mytre.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytre.Bean;
import com.example.mytre.R;
import com.example.mytre.Student;
import com.example.mytre.Utils;
import com.example.mytre.adapters.Myadapter;
import com.example.mytre.medol.Medolimple;
import com.example.mytre.presenter.Presenterimple;
import com.example.mytre.view.Myview;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment extends Fragment implements Myview {

    private RecyclerView lv;
    private List<Bean.DataBean> dataBeans;
    private Myadapter myadapter;
    private String TAG;
//    int a=0;
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Long id = Utils.getUtils().queryNameByID(a);
//        for (int i = 0; i < dataBeans.size(); i++) {
//            if (id==i){
//
//            }
//        }
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        lv = (RecyclerView) inflate.findViewById(R.id.lv);
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        lv.setLayoutManager(ma);
        dataBeans = new ArrayList<>();
        myadapter = new Myadapter(getContext(), dataBeans);
        lv.setAdapter(myadapter);
        initdata();
//        myadapter.setItemlistenner(new Myadapter.item() {
//            @Override
//            public void itemholder(Student student, int position) {
//                    a=position;
//            }
//        });
    }

    private void initdata() {
        Presenterimple presenterimple = new Presenterimple(new Medolimple(), this);
        presenterimple.getdata();
    }

    @Override
    public void seccuss(Bean bean) {
        List<Bean.DataBean> data = bean.getData();
        dataBeans.addAll(data);
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void filed(String mes) {
        Log.i(TAG, "filed: "+mes);
    }
}
