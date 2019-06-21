package com.example.myfragmentmanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHodler> {
    private Context context;
    private ArrayList<Studen> studens;

    public Myadapter(Context context, ArrayList<Studen> studens) {
        this.context = context;
        this.studens = studens;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_layout, null);
        ViewHodler hodler = new ViewHodler(inflate);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {
        holder.tet.setText(studens.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return studens.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {

        private final TextView tet;
        private final RadioButton radio;

        public ViewHodler(View itemView) {
            super(itemView);
            tet = itemView.findViewById(R.id.list_item);
            radio = itemView.findViewById(R.id.radio);
        }
    }
}
