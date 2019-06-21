package com.example.exercise4.observer;

public class Observer {
    private  String name;

    public void setName(String name) {
        this.name = name;
    }

    public  void  reciveMsg(String mes){
        System.out.println(name+"==="+mes);
    }
}
