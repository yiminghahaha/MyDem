package com.example.demo8;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private Context context;
    private ArrayList<Student> strings;

    public Myadapter(Context context, ArrayList<Student> strings) {
        this.context = context;
        this.strings = strings;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.item.setText(strings.get(position).getName());
                    if (strings.get(position).isAa()){
                holder.bt1.setVisibility(View.INVISIBLE);
            }else{
                holder.bt1.setVisibility(View.VISIBLE);
            }
        holder.bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student set = strings.set(position, strings.get(position));
                set.setBb(true);
            }
        });
        holder.bt1.setChecked(strings.get(position).isBb());
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView item;
        private final RadioButton bt1;

        public ViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.list_item);
            bt1 = itemView.findViewById(R.id.bt);
        }
    }
}
