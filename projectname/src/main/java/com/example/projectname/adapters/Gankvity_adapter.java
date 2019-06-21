package com.example.projectname.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import com.example.projectname.R;
import com.example.projectname.bean.GlidyBean;
import com.example.projectname.callback.TouchCallBack;

import java.util.Collections;
import java.util.List;

public class Gankvity_adapter extends RecyclerView.Adapter<Gankvity_adapter.ViewHolder> implements TouchCallBack {
    private Context context;
    private List<GlidyBean> gank_beans;

    public Gankvity_adapter(Context context, List<GlidyBean> gank_beans){
        this.context = context;
        this.gank_beans = gank_beans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.gankactivity_item_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final GlidyBean bean = gank_beans.get(position);
        holder.name.setText(bean.getTitle());
         holder.sc.setChecked(bean.getMselected());
        holder.sc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                bean.setMselected(isChecked);
            }
        });
    }

    @Override
    public int getItemCount(){
        return gank_beans.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(gank_beans,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDelete(int position) {
        gank_beans.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView name;
        private  Switch sc;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.gankvity_name);
            sc = itemView.findViewById(R.id.gankvity_switch);
        }
    }
}
