package com.example.exercise2.utils;

import com.example.exercise2.base.BaseCallback;
import com.example.exercise2.beans.MoneyBean;
import com.example.exercise2.beans.Newbook;
import com.example.exercise2.beans.Shitimer;
import com.example.exercise2.beans.WorkBean;

public interface Contracte {
    public  interface  timerseccuess{
        void  seccuess(BaseCallback<Shitimer> shitimer);
    }

    public  interface  timerfiled{
        void  filed();
    }

    public  interface  moneyseccuess{
        void  moneyseccuess(BaseCallback<MoneyBean> moneyBean);
    };

    public  interface  moneyfiled{
        void  moneyfiled();
    }

    public  interface  newseccuess{
        void  seccuess(BaseCallback<Newbook> callback);
    };

    public  interface  newfiled{
        void  filed();
    }

    public  interface workseccuess{
        void  seccuess(BaseCallback<WorkBean> workBean);
    }

    public  interface  workfiled{
        void  feild();
    }
}
