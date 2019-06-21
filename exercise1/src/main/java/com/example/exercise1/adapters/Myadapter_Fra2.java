package com.example.exercise1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.exercise1.DaoUtils;
import com.example.exercise1.R;
import com.example.exercise1.bean.Student;

import java.util.ArrayList;

public class Myadapter_Fra2 extends RecyclerView.Adapter<Myadapter_Fra2.ViewHolder> {
    private Context context;
    private ArrayList<Student> students;
    private Student student;


    public Myadapter_Fra2(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.adapter2_layout, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        student = students.get(position);
        holder.item.setText(student.getTitle());
        holder.checko.setChecked(student.getABoolean());
        holder.checko.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    DaoUtils.getDaoUtils().delete(student);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView item;
        private final CheckBox checko;

        public ViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
            checko = itemView.findViewById(R.id.boxche);
        }
    }
}
