package com.example.exercise2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import cn.jzvd.JZVideoPlayerStandard;

public class Main2Activity extends AppCompatActivity {

    private JZVideoPlayerStandard mMedioplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mMedioplayer = (JZVideoPlayerStandard) findViewById(R.id.medioplayer);
        mMedioplayer.setUp("https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/classfile/0/从技术走向管理/001" +
                        ".从技术到管理_第1节_从技术到管理的内外部因素.mp4",
                JZVideoPlayerStandard.SCROLL_AXIS_NONE,getString(R.string.str));
        Glide.with(this).load("https://ww1.sinaimg.cn/large/0065oQSqly1g2hekfwnd7j30sg0x4djy.jpg")
                .into(mMedioplayer.thumbImageView);//给默认显示的图片赋值
        mMedioplayer.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }
    @Override
    public void onBackPressed() {
        if (mMedioplayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mMedioplayer.releaseAllVideos();
    }
}
