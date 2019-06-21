package com.example.mywork.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.mywork.Bean;
import com.example.mywork.Daoutils;
import com.example.mywork.DataBean;
import com.example.mywork.R;
import com.example.mywork.adapter.Myadapter;
import com.example.mywork.medol.Medolimple;
import com.example.mywork.presenter.Presenterimple;
import com.example.mywork.view.Myview;

import org.greenrobot.greendao.DbUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment implements Myview {

    private RecyclerView lv;
    private List<DataBean> dataBeans;
    private Myadapter myadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment1, null);
        initView(inflate);
        return inflate;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&myadapter!=null){
            myadapter.notifyDataSetChanged();
        }
    }

    private void initView(View inflate) {
        lv = (RecyclerView) inflate.findViewById(R.id.lv);
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        lv.setLayoutManager(ma);
        dataBeans = new ArrayList<>();
        myadapter = new Myadapter(getContext(),dataBeans);
        lv.setAdapter(myadapter);
        initdata();
        listenner();
    }

    private void listenner(){
       myadapter.setListenneritem(new Myadapter.item() {
           @Override
           public void itemholder(View view, int position) {
               CheckBox chec = view.findViewById(R.id.checkbox);
               List<DataBean> beans = myadapter.getDataBeans();
               DataBean dataBean = beans.get(position);
               if (chec.isChecked()){
                   Daoutils.getDaoutils().insertAll(dataBean);
               }else {
                   Daoutils.getDaoutils().delete(dataBean);
               }
           }
       });
    }

    private void initdata() {
        Presenterimple presenterimple = new Presenterimple(new Medolimple(), this);
        presenterimple.getdata();
    }

    @Override
    public void seccuss(List<DataBean> data) {
        dataBeans.addAll(data);
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void filed(String mes) {
        Log.i("FRAGMENT", "filed: "+mes);
    }

}
