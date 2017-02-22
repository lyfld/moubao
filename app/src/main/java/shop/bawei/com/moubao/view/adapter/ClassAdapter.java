package shop.bawei.com.moubao.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.CategoryBean;

/**
 * Created by 姜鹏 on 2016/12/29.
 */

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.MyViewHolder> {

    private final Context context;
    private List<CategoryBean.DatasBean.ClassListBean> list;
    private OnItemClickListener onClickLisenter;
    private int layoutposiotn = 0;

    public ClassAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder
                (View.inflate(context, R.layout.category_recycler_item,null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.className.setText(list.get(position).getGc_name());
        if(position == 0){
            list.get(position).setClick(true);
        }
        //设置监听
        if(onClickLisenter != null){
            holder.className.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    layoutposiotn =  holder.getLayoutPosition();
                    list.get(position).setClick(true);
                    notifyDataSetChanged();
                    //回调监听
                    onClickLisenter.onItemClick(holder.itemView,holder.getLayoutPosition());
                }
            });
        }
        if(position == layoutposiotn){
            for(CategoryBean.DatasBean.ClassListBean bean : list){
                if(bean.isClick()){
                    holder.className.setTextColor(Color.RED);
                    holder.className.setBackgroundResource(R.drawable.category_item_backgroud_checked);
                }
            }
        }else{
            holder.className.setTextColor(Color.BLACK);
            holder.className.setBackgroundResource(R.drawable.category_item_backgroud);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView className;

        public MyViewHolder(View itemView) {
            super(itemView);
            className = (TextView) itemView.findViewById(R.id.category_recyler_item_tv);
        }
    }
    public void setData(List<CategoryBean.DatasBean.ClassListBean> list){
        this.list = list;
    }

    //自定义设置Item的点击监听
    public interface OnItemClickListener{
         void onItemClick(View view, int position);
    }
    //暴露设置监听的方法
    public void setOnItemClickLisenter(OnItemClickListener onClickLisenter){
         this.onClickLisenter = onClickLisenter;
    }

}
