package com.example.myapp.utils;
import com.example.myapp.Daobean;
import com.example.myapp.dao.DaoMaster;
import com.example.myapp.dao.DaoSession;
import com.example.myapp.dao.DaobeanDao;

import java.util.List;

public class DaoUtils {
    private  static  DaoUtils daoUtils;
    private final DaobeanDao daobeanDao;

    public DaoUtils() {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(App.getApp(), "sccbar.db");
        DaoMaster master = new DaoMaster(openHelper.getWritableDatabase());
        DaoSession session = master.newSession();
        daobeanDao = session.getDaobeanDao();

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

    public  void  insertAll(Daobean bean){
        daobeanDao.insertOrReplaceInTx(bean);
    }

    public List<Daobean> queryAll(){
        return  daobeanDao.queryBuilder().list();
    }
}
