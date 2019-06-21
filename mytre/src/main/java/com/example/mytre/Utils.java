package com.example.mytre;

import com.example.mytre.dao.DaoMaster;
import com.example.mytre.dao.DaoSession;
import com.example.mytre.dao.StudentDao;

import java.util.List;

public class Utils {
    private  static Utils utils;
    private final StudentDao studentDao;

    public Utils() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(App.getApp(), "nameapp");
        DaoMaster master = new DaoMaster(helper.getWritableDatabase());
        DaoSession session = master.newSession();
        studentDao = session.getStudentDao();
    }

    public static Utils getUtils() {
        if (utils==null){
            synchronized (Utils.class){
                if (utils==null){
                    utils = new Utils();
                }
            }
        }
        return utils;
    }

    public  void  insertAll(Student student){
        studentDao.insert(student);
    }

    public List<Student> queryAll(){
        return studentDao.queryBuilder().list();
    }

    public  void  delete(Student student){
        studentDao.delete(student);

    }

    public  Boolean queryboolean(String name){
        List<Student> list = studentDao.queryBuilder().where(StudentDao.Properties.Name.eq(name)).list();
        if (list.size()>0){
            return true;
        }
        return false;
    }
    public  Long queryNameByID(long ID) {
        List<Student> stus = studentDao.queryRaw("where ID=?", String.valueOf(ID));
        Student student = stus.get(0);
        Long name = student.getId();
        return name;
    }
}
