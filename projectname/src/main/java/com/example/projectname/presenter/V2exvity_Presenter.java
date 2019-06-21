package com.example.projectname.presenter;
import com.example.projectname.base.BaseCallback;
import com.example.projectname.base.BasePresenter;
import com.example.projectname.bean.NodeNaviBean;
import com.example.projectname.medol.V2exvity_Medol;
import com.example.projectname.view.V2exvity_View;

public class V2exvity_Presenter extends BasePresenter<V2exvity_Medol,V2exvity_View>{
    public void getdata(){
        if (mymedol!=null){
            mymedol.getdata(new BaseCallback<NodeNaviBean>(){
                @Override
                public void seccuss(NodeNaviBean nodeNaviBean){
                    if (nodeNaviBean!=null){
                        myview.seccuss(nodeNaviBean);
                    }
                }

                @Override
                public void filed(String mes) {
                    myview.filed(mes);
                }
            });
        }

    }
}
