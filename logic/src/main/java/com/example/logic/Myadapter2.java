package com.example.logic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Myadapter2 extends RecyclerView.Adapter<Myadapter2.ViewHolder> {

    private Context context;
    private List<Student> strings;
    private  ArrayList<Boolean> booleans = new ArrayList<>();

    public Myadapter2(Context context, List<Student> strings) {
        this.context = context;
        this.strings = strings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item2_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.name.setText(strings.get(position).getName());
        for (int i = 0; i < strings.size(); i++) {
            booleans.add(false);
        }

        holder.checkox.setChecked(booleans.get(position));
        holder.checkox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true){
                    holder.checkox.setChecked(strings.get(position).getaBoolean());
                }else {
                    holder.checkox.setChecked(strings.get(position).getaBoolean());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final CheckBox checkox;


        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            checkox = itemView.findViewById(R.id.checkbox);
        }
    }
}
