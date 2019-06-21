package com.example.myworkone.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myworkone.DaoUtils;
import com.example.myworkone.R;
import com.example.myworkone.adapters.Myadapter;
import com.example.myworkone.beans.Dao_bean;
import com.example.myworkone.beans.Item_bean;
import com.example.myworkone.medol.Medolimple;
import com.example.myworkone.presenter.Presenterimple;
import com.example.myworkone.view.Mview;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements Mview {

    private RecyclerView lv;
    private List<Item_bean.DataBean> dataBeans;
    private String TAG;
    private Myadapter myadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank, null);
        initView(inflate);
        initdata();
        return inflate;
    }

    private void initdata() {
        Presenterimple presenterimple = new Presenterimple(new Medolimple(), this);
        presenterimple.getdata();
    }

    private void initView(View inflate) {
        lv = (RecyclerView) inflate.findViewById(R.id.lv);
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        lv.setLayoutManager(ma);
        dataBeans = new ArrayList<>();
        myadapter = new Myadapter(getContext(), dataBeans);
        lv.setAdapter(myadapter);
        myadapter.setListenneritem(new Myadapter.item() {
            @Override
            public void itemholder(View view, int positon) {
                Dao_bean dao_bean = new Dao_bean();
                dao_bean.setId(Long.valueOf(positon));
                dao_bean.setTitle(dataBeans.get(positon).getTitle());
                dao_bean.setUrl(dataBeans.get(positon).getImagePath());
                DaoUtils.getDaoUtils().insertAll(dao_bean);
                Toast.makeText(getContext(), "收藏成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void seccuss(Item_bean item_bean) {
        List<Item_bean.DataBean> data = item_bean.getData();
        dataBeans.addAll(data);
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void filed(String mes) {
        Log.i(TAG, "filed: "+mes);
    }
}
