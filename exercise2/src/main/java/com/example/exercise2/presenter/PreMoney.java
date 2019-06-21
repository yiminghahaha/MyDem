package com.example.exercise2.presenter;

import com.example.exercise2.base.BaseCallback;
import com.example.exercise2.base.BasePresenter;
import com.example.exercise2.beans.MoneyBean;
import com.example.exercise2.medol.Money;
import com.example.exercise2.utils.Contracte;
import com.example.exercise2.view.Moneyview;

public class PreMoney extends BasePresenter<Money,Moneyview> implements Contracte.moneyfiled {

    @Override
    public void moneyfiled() {
        mymedol.moneyseccuess(new BaseCallback<MoneyBean>() {
            @Override
            public void seccuess(MoneyBean moneyBean) {
                myview.seccuess(moneyBean);
            }

            @Override
            public void filed(String mes) {
                myview.filed(mes);
            }
        });
    }
}
