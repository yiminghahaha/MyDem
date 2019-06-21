package com.example.mytre.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mytre.Bean;
import com.example.mytre.R;
import com.example.mytre.Student;
import com.example.mytre.Utils;

import java.util.ArrayList;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private Context context;
    private List<Bean.DataBean> beans;
    private ArrayList<Boolean> booleans = new ArrayList<>();
//    private  item itemlistenner;
//
//    public void setItemlistenner(item itemlistenner) {
//        this.itemlistenner = itemlistenner;
//    }

    public Myadapter(Context context, List<Bean.DataBean> beans) {
        this.context = context;
        this.beans = beans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_layout, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

//    public  interface  item{
//        void  itemholder(Student student,int position);
//    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position){
        for (int i = 0; i < beans.size(); i++){
            booleans.add(false);
        }
        holder.checkox.setChecked(booleans.get(position));
        Glide.with(context).load(beans.get(position).getImagePath()).into(holder.image);
        holder.txt.setText(beans.get(position).getTitle());
        holder.checkox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            private Student student;
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    student = new Student();
                    student.setId(Long.valueOf(position));
                    student.setABoolean(isChecked);
                    student.setName(beans.get(position).getTitle());
                    student.setImage(beans.get(position).getImagePath());
                    Utils.getUtils().insertAll(student);
                    Toast.makeText(context, "插入成功", Toast.LENGTH_SHORT).show();
                }
//                itemlistenner.itemholder(student,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView txt;
        private  CheckBox checkox;
        private  ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            checkox = itemView.findViewById(R.id.checkbox);
            image = itemView.findViewById(R.id.image);
            txt = itemView.findViewById(R.id.txt);
        }
    }
}
