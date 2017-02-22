package shop.bawei.com.moubao.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;


import java.util.ArrayList;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.MyBean;

/**
 * Created by 刘伊帆 on 2017/2/16.
 */

public class MyOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<MyBean> mMyOrderBean;

    public MyOrderAdapter(Context context) {
        this.context = context;
    }

    public void getDatas(ArrayList<MyBean> bean) {
        mMyOrderBean = bean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return new MyViewHolder2(LayoutInflater.from(context).inflate(R.layout.rvgoodsitem_layout, parent,
                false));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder2) {
            MyViewHolder2 holder2 = (MyViewHolder2) holder;

            MyBean myBean = mMyOrderBean.get(position);
           // Log.d("TAG","Adapter"+"");
            holder2.img2.setImageURI(myBean.getExtendOrderGoodsBean().getGoods_image_url());
            holder2.tv_name.setText(myBean.getExtendOrderGoodsBean().getGoods_name());
            holder2.tv_price.setText(myBean.getState_desc());
            holder2.tv_price.setTextColor(context.getResources().getColor(R.color.red));
            holder2.tv_comments.setTextColor(context.getResources().getColor(R.color.red));
            holder2.tv_comments.setText("实付款:" + myBean.getGoods_amount());

        }
    }

    @Override
    public int getItemCount() {
        return mMyOrderBean.size();
    }

    //创建ViewHolder商品详情信息
    class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView tv_name, tv_price, tv_comments;
        SimpleDraweeView img2;

        public MyViewHolder2(View itemView) {
            super(itemView);
            img2 = (SimpleDraweeView) itemView.findViewById(R.id.order_goodImg);
            tv_name = (TextView) itemView.findViewById(R.id.order_goodsname);
            tv_price = (TextView) itemView.findViewById(R.id.order_goodsprice);
            tv_comments = (TextView) itemView.findViewById(R.id.order_goodscomments);

        }


    }
}
