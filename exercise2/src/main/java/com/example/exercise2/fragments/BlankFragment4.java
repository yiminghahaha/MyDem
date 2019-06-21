package com.example.exercise2.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.exercise2.R;
import com.example.exercise2.adapters.Myadapter4;
import com.example.exercise2.base.BaseMVPFragment;
import com.example.exercise2.beans.WorkBean;
import com.example.exercise2.medol.Workmedol;
import com.example.exercise2.presenter.Prework;
import com.example.exercise2.view.Workview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment4 extends BaseMVPFragment<Workmedol, Workview, Prework> implements Workview {

    @BindView(R.id.work_recy)
    RecyclerView workRecy;
    Unbinder unbinder;
    private ArrayList<WorkBean.DataBean> dataBeans;
    private Myadapter4 myadapter4;

    @Override
    protected Workview myinitview() {
        return this;
    }

    @Override
    protected Workmedol myinitmedol() {
        return new Workmedol();
    }

    @Override
    protected Prework myinitpresenter() {
        return new Prework();
    }

    @Override
    protected int getinflater() {
        return R.layout.fragment_blank_fragment4;
    }

    @Override
    protected void initview(View inflate) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        workRecy.setLayoutManager(manager);
        dataBeans = new ArrayList<>();
        myadapter4 = new Myadapter4(getContext(), dataBeans);
        workRecy.setAdapter(myadapter4);
    }

    @Override
    protected void initdata() {
        initpresenter.feild();
    }

    @Override
    public void workseccuess(WorkBean workBean) {
        List<WorkBean.DataBean> data = workBean.getData();
        dataBeans.addAll(data);
        myadapter4.notifyDataSetChanged();
    }

    @Override
    public void workfiled(String mes) {
        Toast.makeText(getContext(), mes, Toast.LENGTH_SHORT).show();
    }
}
