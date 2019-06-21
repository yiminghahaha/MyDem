package com.example.projectname.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projectname.R;
import com.example.projectname.bean.Glidy_item_bean;
import java.util.List;

public class Glidy_adapter extends RecyclerView.Adapter<Glidy_adapter.ViewHolder> {
    private Context context;
    private List<Glidy_item_bean.ResultsBean> resultsBeans;

    public Glidy_adapter(Context context, List<Glidy_item_bean.ResultsBean> resultsBeans) {
        this.context = context;
        this.resultsBeans = resultsBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.glidy_item_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text.setText(resultsBeans.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return resultsBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.glidy_item);
        }
    }
}
