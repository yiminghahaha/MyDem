package com.example.exercise2.fragments;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.exercise2.R;
import com.example.exercise2.adapters.Myadapter2;
import com.example.exercise2.base.BaseMVPFragment;
import com.example.exercise2.beans.MoneyBean;
import com.example.exercise2.medol.Money;
import com.example.exercise2.presenter.PreMoney;
import com.example.exercise2.view.Moneyview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends BaseMVPFragment<Money, Moneyview, PreMoney> implements Moneyview {

    @BindView(R.id.money_rec)
    RecyclerView moneyRec;
    Unbinder unbinder;
    private ArrayList<MoneyBean.ResultsBean> resultsBeans;
    private Myadapter2 myadapter2;

    @Override
    protected Moneyview myinitview() {
        return this;
    }

    @Override
    protected Money myinitmedol() {
        return new Money();
    }

    @Override
    protected PreMoney myinitpresenter() {
        return new PreMoney();
    }

    @Override
    protected int getinflater() {
        return R.layout.fragment_blank_fragment2;
    }

    @Override
    protected void initview(View inflate) {
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        //LinearLayoutManager ma = new LinearLayoutManager(getContext());
        moneyRec.setLayoutManager(manager);
        resultsBeans = new ArrayList<>();
        myadapter2 = new Myadapter2(getContext(), resultsBeans);
        moneyRec.setAdapter(myadapter2);
    }

    @Override
    protected void initdata() {
        initpresenter.moneyfiled();
    }

    @Override
    public void seccuess(MoneyBean moneyBean) {
        List<MoneyBean.ResultsBean> results = moneyBean.getResults();
        resultsBeans.addAll(results);
        myadapter2.notifyDataSetChanged();
    }

    @Override
    public void filed(String mes) {
        Toast.makeText(getContext(), mes, Toast.LENGTH_SHORT).show();
    }

}
