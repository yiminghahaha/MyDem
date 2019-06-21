package com.example.demo1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo1.R;
import com.example.demo1.beans.Student;
import java.util.List;

public class Myadapter2 extends RecyclerView.Adapter<Myadapter2.ViewHolder> {
    private Context context;
    private List<Student> students;

    public Myadapter2(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item2_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(students.get(position).getUrl()).into(holder.image);
        holder.te1.setText(students.get(position).getName());
        holder.te2.setText(students.get(position).getUser());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView te1;
        private final TextView te2;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.fra2_image);
            te1 = itemView.findViewById(R.id.fra2_text1);
            te2 = itemView.findViewById(R.id.fra2_text2);
        }
    }
}
