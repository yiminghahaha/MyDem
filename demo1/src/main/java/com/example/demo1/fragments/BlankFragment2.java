package com.example.demo1.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo1.Daomas;
import com.example.demo1.R;
import com.example.demo1.adapters.Myadapter2;
import com.example.demo1.beans.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {

    private RecyclerView fra2_re;
    private List<Student> student = new ArrayList<>();
    private Myadapter2 myadapter2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank_fragment2, null);
        initView(inflate);
        return inflate;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            initdata();
        }else {
            student.clear();
        }
    }

    private void initdata() {
        List<Student> students = Daomas.getDaomas().queryAll();
        student.addAll(students);
        myadapter2.notifyDataSetChanged();
    }

    private void initView(View inflate) {
        fra2_re = (RecyclerView) inflate.findViewById(R.id.fra2_re);
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        fra2_re.setLayoutManager(ma);
        myadapter2 = new Myadapter2(getContext(), student);
        fra2_re.setAdapter(myadapter2);

    }
}
