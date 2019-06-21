package com.example.exercise4.template;

public abstract class Play {
    abstract  void  initplay();
    abstract void  initstart();
    abstract  void  initend();
    public  final void  game(){
        initplay();
        initstart();
        initend();
    }
}
