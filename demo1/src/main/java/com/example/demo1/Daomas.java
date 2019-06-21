package com.example.demo1;

import com.example.demo1.beans.Student;
import com.example.demo1.dao.DaoMaster;
import com.example.demo1.dao.DaoSession;
import com.example.demo1.dao.StudentDao;

import java.util.List;

public class Daomas {
    private  static  Daomas daomas;
    private final StudentDao studentDao;

    public Daomas() {
        DaoMaster.DevOpenHelper appna = new DaoMaster.DevOpenHelper(App.getApp(), "appna");
        DaoMaster master = new DaoMaster(appna.getWritableDatabase());
        DaoSession session = master.newSession();
        studentDao = session.getStudentDao();
    }

    public static Daomas getDaomas() {
        if (daomas==null){
            synchronized (Daomas.class){
                if (daomas==null){
                    daomas = new Daomas();
                }
            }
        }
        return daomas;
    }

    public void  insertAll(Student student){
        studentDao.insert(student);
    }

    public List<Student> queryAll(){
        return studentDao.queryBuilder().list();
    }
}
