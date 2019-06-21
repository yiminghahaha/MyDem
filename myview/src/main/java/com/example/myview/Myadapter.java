package com.example.myview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHodler> {
    private Context context;
    private List<Bean.DataBean.DatasBean> strings;
    private ArrayList<Boolean> booleans = new ArrayList<>();

    public Myadapter(Context context, List<Bean.DataBean.DatasBean> strings) {
        this.context = context;
        this.strings = strings;
    }

    @NonNull
    @Override
    public Myadapter.ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_layout, null);
        ViewHodler viewHodler = new ViewHodler(inflate);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter.ViewHodler holder, int position) {
        holder.title.setText(strings.get(position).getTitle());
        for (int i = 0; i < strings.size(); i++) {
            booleans.add(false);
        }
        holder.chenk.setChecked(booleans.get(position));
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(position).isFresh()==true){
                holder.chenk.setChecked(true);
            }else if (strings.get(position).isCollect()==false){
                holder.chenk.setChecked(false);
            }
        }

    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {

        private  CheckBox chenk;
        private  TextView title;


        public ViewHodler(View itemView) {
            super(itemView);
            chenk = itemView.findViewById(R.id.checkbox);
            title = itemView.findViewById(R.id.title);

        }
    }
}
