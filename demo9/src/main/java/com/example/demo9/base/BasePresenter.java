package com.example.demo9.base;

import java.util.ArrayList;

public abstract class BasePresenter<M extends BaseMedol,V extends BaseView> {

    private ArrayList<BaseMedol> baseMedols = new ArrayList<>();

    protected  M mymedol;
    protected  V myview;

    public  void  initmedol(M mymedol){
        this.mymedol = mymedol;
        baseMedols.add(mymedol);
    }

    public  void  attachview(V myview){
        this.myview = myview;
    }

    public void destroy() {
        if (baseMedols.size()>0&&baseMedols!=null){
            for (BaseMedol baseMedol: baseMedols) {
                baseMedol.clear();
            }
        }
        if (myview!=null){
            myview=null;
        }
        if (mymedol!=null){
            mymedol=null;
        }
    }
}
