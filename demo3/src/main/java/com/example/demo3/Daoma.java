package com.example.demo3;

import com.example.demo3.dao.DaoMaster;
import com.example.demo3.dao.DaoSession;
import com.example.demo3.dao.StudentDao;
import java.util.List;

public class Daoma {
    private  static  Daoma daoma;
    private final StudentDao dao;

    public Daoma() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(App.getApp(), "dao3");
        DaoMaster master = new DaoMaster(helper.getWritableDatabase());
        DaoSession session = master.newSession();
        dao = session.getStudentDao();
    }

    public static Daoma getDaoma() {
        if (daoma==null){
            synchronized (Daoma.class){
                if (daoma==null){
                    daoma = new Daoma();
                }
            }
        }
        return daoma;
    }

    public  boolean  inserbooler(Student id){
        List<Student> where = dao.queryBuilder().where(StudentDao.Properties.Id.eq(id)).list();
        if (where.size()>0){
            return true;
        }
        return  false;
    }

    public void  insertAll(Student student){
            dao.insertOrReplace(student);

    }

    public List<Student> queryAll(){

        List<Student> list = dao.queryBuilder().list();
        return list;
    }

    public void  update(Student student){
        dao.update(student);
    }

    public  void  insert(Student student){
        dao.insert(student);
    }

}
