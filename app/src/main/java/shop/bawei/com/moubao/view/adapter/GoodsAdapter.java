package shop.bawei.com.moubao.view.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.HashMap;
import java.util.List;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.CategoryBean;

/**
 * Created by 姜鹏 on 2016/12/30.
 */

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.MyViewHolder> {

    private final Context context;
    private List<CategoryBean.DatasBean.ClassListBean> list;

    public GoodsAdapter(Context context){
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.category_rigt_recycler_item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //设置商品类名
        holder.goodsName.setText(list.get(position).getGc_name());
        //类名下的详细信息
        //设置GridlayoutManager
        holder.rlContent.setLayoutManager(new GridLayoutManager(context,3));
//        holder.rlContent.setAdapter(mAdapterList.get(position));
        holder.rlContent.setAdapter(hashMap.get("http://169.254.125.170/mobile/index.php?act=goods_class&gc_id="+list.get(position).getGc_id()));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView goodsName;
        public RecyclerView rlContent;

        public MyViewHolder(View itemView) {
            super(itemView);
            goodsName = (TextView) itemView.findViewById(R.id.category_recyler_right_tv);
            rlContent = (RecyclerView) itemView.findViewById(R.id.category_category_right_recyclerview);
        }
    }
    public void setData(List<CategoryBean.DatasBean.ClassListBean> list){
           this.list = list;
    }
    //因为请求数据响应数据顺序不一样所以使用map集合存储
    private HashMap<String,GoodsContentAdapter> hashMap;

    public void setHashMap(HashMap<String, GoodsContentAdapter> hashMap) {
        this.hashMap = hashMap;
    }
}
