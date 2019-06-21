package com.example.projectname.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectname.R;
import com.example.projectname.bean.NodeNaviBean;
import com.example.projectname.layout.FlowLayout;
import java.util.List;

public class V2exvity_adapter extends RecyclerView.Adapter<V2exvity_adapter.ViewHolder>{
    private Context context;
    private List<NodeNaviBean.DataBean> dataBeans;

    public V2exvity_adapter(Context context, List<NodeNaviBean.DataBean> dataBeans){
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View inflate = View.inflate(context,R.layout.v2exvity_item_layout,null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position){
        final NodeNaviBean.DataBean bean = dataBeans.get(position);
        List<NodeNaviBean.DataBean.ArticlesBean> articles = bean.getArticles();
        if (articles!=null){
            for (int i = 0; i < articles.size(); i++){
                TextView textView = (TextView) View.inflate(context, R.layout.v2ex_liu_layout, null);
                textView.setText(articles.get(i).getTitle());
                final int finalI = i;
                textView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, dataBeans.get(position).getArticles().get(finalI).getTitle(), Toast.LENGTH_SHORT).show();
                    }
                });
                holder.flowt.addView(textView);
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  FlowLayout flowt;

        public ViewHolder(View itemView) {
            super(itemView);
            flowt = itemView.findViewById(R.id.flayout);
        }
    }
}
