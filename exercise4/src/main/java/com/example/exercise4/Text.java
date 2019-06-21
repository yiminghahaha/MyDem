package com.example.exercise4;

import com.example.exercise4.build.Animal;
import com.example.exercise4.factory.Computer;
import com.example.exercise4.factory.Factory;
import com.example.exercise4.observer.Observable;
import com.example.exercise4.observer.Observer;
import com.example.exercise4.singleobject.Singleton;
import com.example.exercise4.singleobject.Singleton1;
import com.example.exercise4.template.Cricket;
import com.example.exercise4.template.Football;

public class Text {
    public static void main(String[] args) {
        //单例模式
        single();
        //模板模式
        templa();
        //观察者模式
        observ();
        //建造模式
        build();
        //工厂模式
        factory();
    }

    private static void factory() {
        Factory factory = new Factory();
        Computer rectangle = factory.setshape("Rectangle");
        rectangle.play();
        Computer square = factory.setshape("Square");
        square.play();
        Computer circle = factory.setshape("circle");
        circle.play();
    }

    private static void build() {
        Animal animal = new Animal.builder()
                .setage(2)
                .setname("张三")
                .setsex("男")
                .build();
        System.out.println(animal);

    }

    private static void observ() {
        Observable observable = new Observable();
        Observer observer1 = new Observer();
        observer1.setName("张三");
        Observer observer2 = new Observer();
        observer2.setName("李四");
        Observer observer3 = new Observer();
        observer3.setName("王五");
        observable.subices(observer1);
        observable.subices(observer2);
        observable.subices(observer3);
        observable.notifymes("收到了");
    }

    private static void templa() {
        Football football = new Football();
        football.game();
        Cricket cricket = new Cricket();
        cricket.game();
    }

    private static void single() {
        Singleton singleton = Singleton.getSingleton();
        singleton.getsing();
        Singleton1 getsingleton = Singleton1.getsingleton();
        getsingleton.getlong();
    }
}
