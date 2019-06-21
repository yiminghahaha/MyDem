package com.example.myone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private Context context;
    private ArrayList<Person> strings;


    public Myadapter(Context context, ArrayList<Person> strings) {
        this.context = context;
        this.strings = strings;
    }


    @NonNull
    @Override
    public Myadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Myadapter.ViewHolder holder, final int position){
        holder.name.setText(strings.get(position).getName());
        if (strings.get(position).getB()==true){
            holder.radio.setVisibility(View.VISIBLE);
        }else {
            holder.radio.setVisibility(View.GONE);
        }
        holder.radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //修改类中的字段属性值
                Person set = strings.set(position, strings.get(position));
                set.setA(true);
            }
        });

    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView name;
        private  RadioButton radio;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            radio = itemView.findViewById(R.id.radio);
        }
    }
}
