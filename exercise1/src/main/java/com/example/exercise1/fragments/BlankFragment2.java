package com.example.exercise1.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.exercise1.DaoUtils;
import com.example.exercise1.R;
import com.example.exercise1.adapters.Myadapter_Fra2;
import com.example.exercise1.bean.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {


    private View view;
    private RecyclerView mRecy;
    private ArrayList<Student> students = new ArrayList<>();
    private Myadapter_Fra2 myadapter_fra2;

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
        List<Student> student = DaoUtils.getDaoUtils().queryAll();
        students.addAll(student);
        myadapter_fra2.notifyDataSetChanged();
    }

    private void initView(View inflate) {
        mRecy = (RecyclerView) inflate.findViewById(R.id.recy);
        LinearLayoutManager ma = new LinearLayoutManager(getContext());
        mRecy.setLayoutManager(ma);
        myadapter_fra2 = new Myadapter_Fra2(getContext(), students);
        mRecy.setAdapter(myadapter_fra2);

    }
}
