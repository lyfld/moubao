package shop.bawei.com.moubao.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.BuyBean1;
import shop.bawei.com.moubao.model.beans.CartBean;

/**
 * Created by 刘伊帆 on 2017/2/16.
 */

public class IndentAdapter extends RecyclerView.Adapter<IndentAdapter.ViewHolder> {
    private Context context;
    private List<BuyBean1.DatasBean.StoreCartListBean._$1Bean.GoodsListBean>  list = new ArrayList<>();
    public IndentAdapter(Context context){
        this.context = context;
    }
    public void setData(List<BuyBean1.DatasBean.StoreCartListBean._$1Bean.GoodsListBean> list){
       this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public IndentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.indent_adapter_item,parent,false);
        IndentAdapter.ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(IndentAdapter.ViewHolder holder, int position) {
        BuyBean1.DatasBean.StoreCartListBean._$1Bean.GoodsListBean goodsBean = list.get(position);
        holder.sdv.setImageURI(goodsBean.getGoods_image_url());
        holder.desc.setText(goodsBean.getGoods_num());
        holder.price.setText(goodsBean.getGoods_price());
        holder.sumPrice.setText(goodsBean.getGoods_price());
        holder.num.setText(goodsBean.getGoods_num());
        holder.sum.setText(goodsBean.getGoods_num());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public SimpleDraweeView sdv;
        public TextView desc;
        public TextView price;
        public TextView num;
        public TextView sum;
        public TextView sumPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            sdv = (SimpleDraweeView) itemView.findViewById(R.id.indent_img);
            desc = (TextView) itemView.findViewById(R.id.indent_goodsname);
            price = (TextView) itemView.findViewById(R.id.indent_gprice);
            num = (TextView) itemView.findViewById(R.id.indent_goodsnum);
            sumPrice = (TextView) itemView.findViewById(R.id.indent_goodsprice);
            sum = (TextView) itemView.findViewById(R.id.indent_goodspriceandnum);
        }
    }
}
