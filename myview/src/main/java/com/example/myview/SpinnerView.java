package com.example.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class SpinnerView extends RelativeLayout {

    private ArrayList<String> strings;
    private EditText et;
    private ImageView iv;
    private PopupWindow popupWindow;

    public SpinnerView(Context context) {
        super(context);
    }

    public SpinnerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SpinnerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //需要将写的布局添加到这个自定义view中
        LayoutInflater.from(getContext()).inflate(R.layout.view_spinner, this);
        initView();
        initData();
    }

    private void initView() {
        et = findViewById(R.id.et);
        iv = findViewById(R.id.iv);
        iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
    }

    private void show() {
        ListView listView = new ListView(getContext());
        listView.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item,strings));
        popupWindow = new PopupWindow(et.getWidth(), 50);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = strings.get(position);
                et.setText(s);
                et.setSelection(s.length());
            }
        });
        popupWindow.setContentView(listView);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(et);
    }

    private void initData() {
        strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add("数据"+i);
        }
    }

}
