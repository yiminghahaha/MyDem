package com.example.mytre.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytre.R;
import com.example.mytre.Student;
import com.example.mytre.Utils;
import com.example.mytre.adapters.Myadaoter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {

    private RecyclerView pv;
    private List<Student> students = new ArrayList<>();
    private Myadaoter myadaoter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment2, null);
        initView(inflate);
        return inflate;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            initdata();
        }else {
            students.clear();
        }
    }

    private void initdata() {
        List<Student> studentList = Utils.getUtils().queryAll();
        students.addAll(studentList);
        myadaoter.notifyDataSetChanged();
    }

    private void initView(View inflate) {
        pv = (RecyclerView) inflate.findViewById(R.id.pv);
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        pv.setLayoutManager(ma);
        myadaoter = new Myadaoter(getContext(), students);
        pv.setAdapter(myadaoter);

    }


}
