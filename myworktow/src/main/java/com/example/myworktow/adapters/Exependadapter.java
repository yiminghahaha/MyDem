package com.example.myworktow.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.myworktow.R;
import com.example.myworktow.beans.Exependbeans;

import java.util.ArrayList;
import java.util.List;

public class Exependadapter extends BaseExpandableListAdapter {
    private Context context;
    private List<Exependbeans.DataBean> dataBeans;
    private List<Exependbeans.DataBean.ChildrenBean> childrenBeans;

    public Exependadapter(Context context, List<Exependbeans.DataBean> dataBeans, List<Exependbeans.DataBean.ChildrenBean> childrenBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
        this.childrenBeans = childrenBeans;
    }

    @Override
    public int getGroupCount() {
        return dataBeans.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childrenBeans.get(groupPosition).getChildren().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View inflate = View.inflate(context, R.layout.group_layout, null);
        TextView group = inflate.findViewById(R.id.group_tet);
        group.setText(dataBeans.get(groupPosition).getName());
        return inflate;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View inflate = View.inflate(context, R.layout.child_layout, null);
        TextView child = inflate.findViewById(R.id.child_text1);
        child.setText(childrenBeans.get(childPosition).getName());
        return inflate;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
