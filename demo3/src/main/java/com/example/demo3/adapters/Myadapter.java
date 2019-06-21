package com.example.demo3.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.demo3.R;
import com.example.demo3.Student;
import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private Context context;
    private List<Student> students;
    private  item listenneritem;

    public void setListenneritem(item listenneritem) {
        this.listenneritem = listenneritem;
    }

    public Myadapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    public  interface  item{
        void  itemholder(View view,int position);
    }
    @NonNull
    @Override
    public Myadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_layout, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter.ViewHolder holder, final int position) {
        holder.item1.setText(students.get(position).getText());
        holder.item2.setText(students.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenneritem.itemholder(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView item1;
        private final TextView item2;

        public ViewHolder(View itemView) {
            super(itemView);
            item1 = itemView.findViewById(R.id.item1);
            item2 = itemView.findViewById(R.id.item2);
        }
    }
}
