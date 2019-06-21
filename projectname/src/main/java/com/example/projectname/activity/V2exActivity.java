package com.example.projectname.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.projectname.R;
import com.example.projectname.adapters.V2exvity_adapter;
import com.example.projectname.bean.NodeNaviBean;
import com.example.projectname.base.BaseMvpActivity;
import com.example.projectname.medol.V2exvity_Medol;
import com.example.projectname.presenter.V2exvity_Presenter;
import com.example.projectname.view.V2exvity_View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import qdx.stickyheaderdecoration.NormalDecoration;

public class V2exActivity extends BaseMvpActivity<V2exvity_Medol,V2exvity_View,V2exvity_Presenter> implements V2exvity_View {

    @BindView(R.id.v2exvity_lv)
    RecyclerView v2exvityLv;
    private List<NodeNaviBean.DataBean> dataBeans;
    private V2exvity_adapter adapter;
    private String TAG;
    private NormalDecoration decoration;

    @Override
    protected V2exvity_Medol initmvpmedol() {
        return new V2exvity_Medol();
    }

    @Override
    protected V2exvity_View initmvpview(){
        return this;
    }

    @Override
    protected V2exvity_Presenter initmypresenter(){
        return new V2exvity_Presenter();
    }

    @Override
    protected int getLayoutID(){
        return R.layout.activity_v2ex;
    }

    @Override
    protected void initview() {
        LinearLayoutManager ma = new LinearLayoutManager(this);
        v2exvityLv.setLayoutManager(ma);
        dataBeans = new ArrayList<>();
        adapter = new V2exvity_adapter(this, dataBeans);
        v2exvityLv.setAdapter(adapter);
    }

    @Override
    protected void initdata(){
        initmvppresenter.getdata();
    }



    @Override
    public void seccuss(NodeNaviBean nodeNaviBean) {
        if (nodeNaviBean!=null){
            final List<NodeNaviBean.DataBean> data = nodeNaviBean.getData();
            decoration = new NormalDecoration() {
                @Override
                public String getHeaderName(int i){
                    return data.get(i).getName();
                }
            };
            decoration.setOnHeaderClickListener(new NormalDecoration.OnHeaderClickListener() {
                @Override
                public void headerClick(int i) {
                    Toast.makeText(V2exActivity.this, dataBeans.get(i).getName(), Toast.LENGTH_SHORT).show();
                }
            });
            v2exvityLv.addItemDecoration(decoration);
            dataBeans.addAll(data);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void filed(String mes) {
        Log.i(TAG, "filed: "+mes);
    }
}
