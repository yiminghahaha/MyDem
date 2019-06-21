package com.example.mywork.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.mywork.Daoutils;
import com.example.mywork.DataBean;
import com.example.mywork.R;
import com.example.mywork.adapter.Myadapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

public class BlankFragment2 extends Fragment{
    private RecyclerView rl;
    private Myadapter myadapter;
    private  ArrayList<DataBean>  beans = new ArrayList<>();
    private List<DataBean> bean;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment2, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        rl = (RecyclerView) inflate.findViewById(R.id.rl);
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        rl.setLayoutManager(ma);

        myadapter = new Myadapter(getContext(),beans);
        rl.setAdapter(myadapter);
        listenner();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            initdata();
        }else {
            beans.clear();
        }
    }

    private void initdata(){
        bean = Daoutils.getDaoutils().queryAll();
        beans.addAll(bean);
        myadapter.notifyDataSetChanged();
    }

    private void listenner(){
            myadapter.setListenneritem(new Myadapter.item(){
                @Override
                public void itemholder(View view, int position) {
                    CheckBox checkBox = view.findViewById(R.id.checkbox);
                    if (!checkBox.isChecked()){
                        List<DataBean> beans = myadapter.getDataBeans();
                        DataBean dataBean = beans.get(position);
                        Daoutils.getDaoutils().delete(dataBean);
                        beans.remove(position);
                        myadapter.notifyDataSetChanged();
                    }
                }
            });
    }
}
