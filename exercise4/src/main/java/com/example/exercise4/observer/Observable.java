package com.example.exercise4.observer;

import java.util.ArrayList;

public class Observable {
    private ArrayList<Observer> observers = new ArrayList<>();

    public  void  subices(Observer observer){
            observers.add(observer);
    }

    public  void  notifymes(String mes){
        for (Observer observer: observers) {
            observer.reciveMsg(mes);
        }
    }
}
