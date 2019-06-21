package com.example.projectname.base;

import java.util.ArrayList;

public abstract class BasePresenter<M extends BaseMedol,V extends BaseView> {
    private ArrayList<BaseMedol> medols = new ArrayList<>();

    protected  M mymedol;

    protected  V myview;

    public  void  initmedol(M mymedol){
        this.mymedol = mymedol;
        medols.add(mymedol);
    }

    public  void attachview(V myview){
        this.myview = myview;
    }

    public void destroy() {
        if (medols.size()>0&&medols!=null){
            for (BaseMedol baseMedol:medols) {
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
