package com.example.exercise4.template;

public class Cricket extends Play{
    @Override
    void initplay() {
        System.out.println("Cricket initplay");
    }

    @Override
    void initstart() {
        System.out.println("Cricket initstart");
    }

    @Override
    void initend() {
        System.out.println("Cricket initend");
    }
}
