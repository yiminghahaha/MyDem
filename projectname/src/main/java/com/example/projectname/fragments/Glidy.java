package com.example.projectname.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.projectname.R;
import com.example.projectname.activity.GlidyActivity;
import com.example.projectname.adapters.Glidyadapter;
import com.example.projectname.base.BaseFragment;
import com.example.projectname.bean.GlidyBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Glidy extends BaseFragment{
    private String[] titles = {"all","ANDROID","iOS","休息视频","福利","扩展资源","前端","瞎推荐","App"};
    private  ArrayList<Fragment> fragments;
    private  ArrayList<GlidyBean> glidyBeans;
    private  ArrayList<String> mtab;
    @BindView(R.id.glidy_tab)
    TabLayout glidyTab;
    @BindView(R.id.glidy_image)
    ImageView glidyImage;
    @BindView(R.id.glidy_vp)
    ViewPager glidyVp;
    Unbinder unbinder;
    private Glidyadapter glidyadapter;

    @Override
    protected int getLayoutID() {
        return R.layout.glidy_layout;
    }

    @Override
    protected void initview(View inflate){
        mtab = new ArrayList<>();
        fragments = new ArrayList<>();
        glidyBeans = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            String title = titles[i];
            if (i%2==0){
                glidyBeans.add(new GlidyBean(title,true));
            }else {
                glidyBeans.add(new GlidyBean(title,false));
            }
        }
    }

    @Override
    protected void initdata(){
        for (int i = 0; i < glidyBeans.size(); i++){
            GlidyBean glidyBean = glidyBeans.get(i);
            if (glidyBean.getMselected()){
                fragments.add(new GlidyFragment(glidyBean.getTitle()));
                mtab.add(glidyBean.getTitle());
            }
        }
        glidyadapter = new Glidyadapter(getChildFragmentManager(), fragments, mtab);
        glidyVp.setAdapter(glidyadapter);
        glidyTab.setupWithViewPager(glidyVp);


    }

    @Override
    protected void initlistenner() {
        glidyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GlidyActivity.class);
                intent.putExtra("list",glidyBeans);
                startActivityForResult(intent,100);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100&&resultCode==200){
            glidyBeans = (ArrayList<GlidyBean>) data.getSerializableExtra("list");
            fragments.clear();
            mtab.clear();
            initdata();
        }
    }
}
