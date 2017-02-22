package shop.bawei.com.moubao.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.CategoryBean;


/**
 * Created by 姜鹏 on 2016/12/30.
 */

public class GoodsContentAdapter extends RecyclerView.Adapter<GoodsContentAdapter.MyViewHolder> {

    private final Context context;
    private List<CategoryBean.DatasBean.ClassListBean> list;
    private OnItemClickLisenter lisenter;

    public GoodsContentAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(View.inflate(context, R.layout.category_right_recyler_ietm_item,null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        //设置图片及文字
        String newName;
        holder.goodsImage.setImageResource(R.drawable.category_right_item_img);
        String name = list.get(position).getGc_name();
        if(name.length() > 4){
            newName = name.substring(4);
        }else{
            newName = name;
        }
        holder.contentName.setText(newName);
        if(lisenter != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //监听回调
                    lisenter.onItemClick(holder.itemView,holder.getLayoutPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView goodsImage;
        public TextView contentName;

        public MyViewHolder(View itemView) {
            super(itemView);
            goodsImage = (ImageView) itemView.findViewById(R.id.category_recyler_right_img);
            contentName = (TextView) itemView.findViewById(R.id.category_recyler_right_item_tv);
        }
    }
    public void setData(List<CategoryBean.DatasBean.ClassListBean> list){
        this.list = list;
    }
    //自定义回调监听
    public void setOnItemClickLisenter(OnItemClickLisenter lisenter){
        this.lisenter = lisenter;
    }
    public interface OnItemClickLisenter{
        void onItemClick(View view, int position);
    }
}
