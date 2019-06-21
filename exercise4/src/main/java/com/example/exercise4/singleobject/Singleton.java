package com.example.exercise4.singleobject;

public class Singleton {
    //单例模式  懒汉式线程不安全

    private  static  Singleton singleton = new Singleton();

    public Singleton() {}

    public static Singleton getSingleton() {
        if (singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }

    public  void  getsing(){
        System.out.println("单例模式");
    }

}
