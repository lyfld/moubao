package shop.bawei.com.moubao.view.adapter.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.DetailsBean;
import shop.bawei.com.moubao.model.beans.DetailsGoodBean;
import shop.bawei.com.moubao.view.interfaces.RecyclerViewOnItemClickLitener;

/**
 * Created by 刘伊帆 on 2017/1/4.
 */

public class DetailsGoodsListAdapter extends RecyclerView.Adapter<DetailsGoodsListAdapter.DetailsListViewHolder> {
    private Context context;
    private List<DetailsGoodBean.DatasBean.GoodsCommendListBean> mList;
    private RecyclerViewOnItemClickLitener recyclerViewOnItemClickLitener;

    public void setRecyclerViewOnItemClickLitener(RecyclerViewOnItemClickLitener recyclerViewOnItemClickLitener) {
        this.recyclerViewOnItemClickLitener = recyclerViewOnItemClickLitener;
    }

    public DetailsGoodsListAdapter(Context context) {
        this.context = context;
    }

    public void setmList(List<DetailsGoodBean.DatasBean.GoodsCommendListBean> mList) {
        this.mList = mList;
    }

    @Override
    public DetailsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.details_list_layout,parent,false);

        return new DetailsListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final DetailsListViewHolder holder, final int position) {
        holder.titleTv.setText(mList.get(position).getGoods_name());
        holder.priceTv.setTextColor(Color.RED);
        holder.priceTv.setText("¥"+mList.get(position).getGoods_promotion_price());
        holder.sdv.setImageURI(mList.get(position).getGoods_image_url());
        if(recyclerViewOnItemClickLitener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerViewOnItemClickLitener.onItemClick(holder.itemView,position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    recyclerViewOnItemClickLitener.onItemLongClick(holder.itemView,position);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public class DetailsListViewHolder extends RecyclerView.ViewHolder{

        public final SimpleDraweeView sdv;
        public final TextView titleTv;
        public final TextView priceTv;
        public DetailsListViewHolder(View itemView) {
            super(itemView);
            sdv = (SimpleDraweeView) itemView.findViewById(R.id.details_list_view);
            titleTv =  (TextView) itemView.findViewById(R.id.details_list_title_tv);
            priceTv =  (TextView) itemView.findViewById(R.id.details_list_price_tv);

        }
    }
}
