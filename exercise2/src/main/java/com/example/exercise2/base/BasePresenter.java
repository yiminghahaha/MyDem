package com.example.exercise2.base;

public abstract class BasePresenter<M extends BaseMedol,V extends BaseView> {
      protected  M mymedol;
      protected  V myview;

      public void  attach(M mymedol){
          this.mymedol = mymedol;
      }

      public  void  attach(V myview){
          this.myview = myview;
      }
}
