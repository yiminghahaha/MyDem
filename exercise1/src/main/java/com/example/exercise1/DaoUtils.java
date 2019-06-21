package com.example.exercise1;

import com.example.exercise1.bean.Student;
import com.example.exercise1.dao.DaoMaster;
import com.example.exercise1.dao.DaoSession;
import com.example.exercise1.dao.StudentDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class DaoUtils {
    private  static  DaoUtils daoUtils;
    private final StudentDao studentDao;

    public DaoUtils() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(App.getApp(), "ming");
        DaoMaster master = new DaoMaster(helper.getWritableDatabase());
        DaoSession session = master.newSession();
        studentDao = session.getStudentDao();
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

    public  void  insertAll(Student student){
        studentDao.insertOrReplace(student);
    }

    public  boolean queryWhere(String name){
        QueryBuilder<Student> where = studentDao.queryBuilder().where(StudentDao.Properties.Title.eq(name));
        if (where!=null){
            return true;
        }
        return false;
    }
    public void  delete(Student name){
         studentDao.delete(name);
    }

    public List<Student> queryAll(){
        List<Student> list = studentDao.queryBuilder().list();
        return list;
    }
}
