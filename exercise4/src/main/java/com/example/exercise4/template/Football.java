package com.example.exercise4.template;

public class Football extends Play{
    @Override
    void initplay() {
        System.out.println("Football initplay");
    }

    @Override
    void initstart() {
        System.out.println("Football initstart");
    }

    @Override
    void initend() {
        System.out.println("Football initend");
    }
}
