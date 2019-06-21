package com.example.projectname.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import com.example.projectname.R;
import com.example.projectname.adapters.Gankvity_adapter;
import com.example.projectname.base.BaseActivity;
import com.example.projectname.bean.GlidyBean;
import com.example.projectname.callback.SimpleItemTouchHelperCallBack;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GlidyActivity extends BaseActivity {

    @BindView(R.id.update)
    Button update;
    @BindView(R.id.gankActivity_lv)
    RecyclerView gankActivityLv;
    private ArrayList<GlidyBean> list;
    private  Gankvity_adapter adapter;
    private SimpleItemTouchHelperCallBack callBack;
    private ItemTouchHelper helper;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_glidy;
    }

    @Override
    protected void initview(){
        list = (ArrayList<GlidyBean>) getIntent().getSerializableExtra("list");
        LinearLayoutManager ma = new LinearLayoutManager(this);
        gankActivityLv.setLayoutManager(ma);
        adapter = new Gankvity_adapter(this, list);
        gankActivityLv.setAdapter(adapter);
        //关联
        callBack = new SimpleItemTouchHelperCallBack(adapter);
        helper = new ItemTouchHelper(callBack);
        helper.attachToRecyclerView(gankActivityLv);
    }

    @Override
    protected void initlistenner() {
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("list",list);
                setResult(200,intent);
                finish();
            }
        });

    }
}
