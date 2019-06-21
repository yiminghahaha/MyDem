package com.example.myworkone;

import com.example.myworkone.beans.Dao_bean;
import com.example.myworkone.dao.DaoMaster;
import com.example.myworkone.dao.DaoSession;
import com.example.myworkone.dao.Dao_beanDao;

import java.util.List;

public class DaoUtils {
    private  static  DaoUtils daoUtils;
    private final Dao_beanDao dao_beanDao;

    public DaoUtils() {
        DaoMaster.DevOpenHelper daoname = new DaoMaster.DevOpenHelper(App.getApp(), "daoname");
        DaoMaster daoMaster = new DaoMaster(daoname.getWritableDatabase());
        DaoSession session = daoMaster.newSession();
        dao_beanDao = session.getDao_beanDao();

    }

    public static DaoUtils getDaoUtils() {
        if (daoUtils==null){
            synchronized (DaoUtils.class){
                if (daoUtils==null){
                    daoUtils = new DaoUtils();
                }
            }
        }
        return daoUtils;
    }

    public  void  insertAll(Dao_bean dao_bean){
        dao_beanDao.insertOrReplace(dao_bean);
    }

    public List<Dao_bean> queryAll(){
        return  dao_beanDao.queryBuilder().list();
    }
}
