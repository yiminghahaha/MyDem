package com.example.mywork;

import com.example.mywork.dao.DaoMaster;
import com.example.mywork.dao.DaoSession;
import com.example.mywork.dao.DataBeanDao;

import java.util.List;

public class Daoutils {
    private static  Daoutils daoutils;
    private final DataBeanDao dataBeanDao;

    public Daoutils() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(App.getApp(), "worknam");
        DaoMaster master = new DaoMaster(helper.getWritableDatabase());
        DaoSession session = master.newSession();
        dataBeanDao = session.getDataBeanDao();
    }

    public static Daoutils getDaoutils() {
        if (daoutils==null){
            synchronized (Daoutils.class){
                if (daoutils==null){
                    daoutils = new Daoutils();
                }
            }
        }
        return daoutils;
    }

    public  void  insertAll(DataBean dataBean){
        dataBeanDao.insertOrReplace(dataBean);
    }

    public List<DataBean> queryAll(){
        return  dataBeanDao.queryBuilder().list();
    }

    public  void  delete(DataBean dataBean){
        dataBeanDao.delete(dataBean);
    }

    public  DataBean queryOne(DataBean dataBean){
        DataBean unique = dataBeanDao.queryBuilder().where(DataBeanDao.Properties.Title.eq(dataBean.getTitle())).build().unique();
        return unique;
    }

}
