package com.example.exercise1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exercise1.DaoUtils;
import com.example.exercise1.R;
import com.example.exercise1.bean.Bean;
import com.example.exercise1.bean.Student;

import java.util.List;

public class Myadapter_Fra1 extends RecyclerView.Adapter<Myadapter_Fra1.ViewHolder> {
    private Context context;
    private List<Bean.DataBean> dataBeans;

    public Myadapter_Fra1(Context context, List<Bean.DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.adapter_layout, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.title.setText(dataBeans.get(position).getName()+"我多想能多陪你一场，把前半生的风景对你讲");
        holder.cheked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Student student = new Student();
                    student.setId(Long.valueOf(position));
                    student.setABoolean(true);
                    student.setTitle(dataBeans.get(position).getName());
                    DaoUtils.getDaoUtils().insertAll(student);
                    Toast.makeText(context, "插入成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final CheckBox cheked;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.show_title);
            cheked = itemView.findViewById(R.id.checkbox);
        }
    }
}
