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
import com.example.mytre.R;
import com.example.mytre.Student;
import com.example.mytre.Utils;

import java.util.ArrayList;
import java.util.List;

public class Myadaoter extends RecyclerView.Adapter<Myadaoter.ViewHolder> {
    private Context context;
    private List<Student> students;
    private Student student;

    public Myadaoter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public Myadaoter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View inflate = View.inflate(context, R.layout.item2_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myadaoter.ViewHolder holder, final int position){
        student = students.get(position);
        holder.chec.setChecked(student.getABoolean());
        holder.txt.setText(students.get(position).getName());
        Glide.with(context).load(students.get(position).getImage()).into(holder.image);
        holder.chec.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean checked = buttonView.isChecked();
                    if (checked==false){
                        Utils.getUtils().delete(student);
                        students.remove(position);
                        notifyDataSetChanged();

                    }
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox chec;
        private final ImageView image;
        private final TextView txt;

        public ViewHolder(View itemView) {
            super(itemView);
            chec = itemView.findViewById(R.id.item2_checkbox);
            image = itemView.findViewById(R.id.item2_image);
            txt = itemView.findViewById(R.id.item2_txt);
        }
    }
}
