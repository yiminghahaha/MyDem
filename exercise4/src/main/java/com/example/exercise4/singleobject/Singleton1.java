package com.example.exercise4.singleobject;

public class Singleton1 {
    private  static  class  Single{
        private  static  final Singleton1 SINGLETON_1 = new Singleton1();
    }

    private  Singleton1 (){}

    public  static  final  Singleton1 getsingleton(){
        return Single.SINGLETON_1;
    }

    public  void  getlong(){
        System.out.println("静态内部类单例模式");
    }
}
