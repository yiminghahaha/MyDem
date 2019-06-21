package com.example.myworktow.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.myworktow.R;
import com.example.myworktow.adapters.Exependadapter;
import com.example.myworktow.beans.Exependbeans;
import com.example.myworktow.exe_medol.Exe_Medolimple;
import com.example.myworktow.exe_prese.Exe_preseimple;
import com.example.myworktow.exe_view.Mview;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment implements Mview {

    private ExpandableListView listview;
    private List<Exependbeans.DataBean> dataBeans;
    private List<Exependbeans.DataBean.ChildrenBean> childrenBeans;
    private Exependadapter exependadapter;
    private String TAG;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment2, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        listview = (ExpandableListView) inflate.findViewById(R.id.listview);
        dataBeans = new ArrayList<>();
        childrenBeans = new ArrayList<>();
        exependadapter = new Exependadapter(getContext(), dataBeans, childrenBeans);
        listview.setAdapter(exependadapter);
        initdata();
    }

    private void initdata() {
        Exe_preseimple exe_preseimple = new Exe_preseimple(new Exe_Medolimple(), this);
        exe_preseimple.getdata();
    }

    @Override
    public void seccuss(Exependbeans exependbeans) {
        List<Exependbeans.DataBean> data = exependbeans.getData();
        dataBeans.addAll(data);
        for (int i = 0; i < data.size(); i++) {
            List<Exependbeans.DataBean.ChildrenBean> children = data.get(i).getChildren();
            childrenBeans.addAll(children);
        }
        exependadapter.notifyDataSetChanged();
    }

    @Override
    public void filed(String mes) {
        Log.i(TAG, "filed: "+mes);
    }
}
