package com.example.myfragmentmanager.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class DeleteTextView extends TextView {
    public DeleteTextView(Context context) {
        super(context);
    }

    public DeleteTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DeleteTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //自定义删除线
    public  void  setdeleteline(){
        getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
    }
    //自定义下划线
    public  void setundataline(){
        getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
    }


}
