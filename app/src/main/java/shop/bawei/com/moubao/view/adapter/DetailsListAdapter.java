package shop.bawei.com.moubao.view.adapter;

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
import shop.bawei.com.moubao.view.interfaces.RecyclerViewOnItemClickLitener;

/**
 * Created by 刘伊帆 on 2017/1/4.
 */

public class DetailsListAdapter extends RecyclerView.Adapter<DetailsListAdapter.DetailsListViewHolder> {
    private Context context;
    private List<DetailsBean.DatasBean.GoodsListBean> mList;
    private RecyclerViewOnItemClickLitener recyclerViewOnItemClickLitener;

    public void setRecyclerViewOnItemClickLitener(RecyclerViewOnItemClickLitener recyclerViewOnItemClickLitener) {
        this.recyclerViewOnItemClickLitener = recyclerViewOnItemClickLitener;
    }

    public DetailsListAdapter(Context context) {
        this.context = context;
    }

    public void setmList(List<DetailsBean.DatasBean.GoodsListBean> mList) {
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
        holder.evaluateTv.setText("评价"+mList.get(position).getEvaluation_good_star()+"星");
        holder.priceTv.setTextColor(Color.RED);
        holder.priceTv.setText("¥"+mList.get(position).getGoods_price());
        holder.salenumTv.setText("已售"+mList.get(position).getGoods_salenum());
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
        public final TextView evaluateTv;
        public final TextView priceTv;
        public final TextView salenumTv;

        public DetailsListViewHolder(View itemView) {
            super(itemView);
            sdv = (SimpleDraweeView) itemView.findViewById(R.id.details_list_view);
            titleTv =  (TextView) itemView.findViewById(R.id.details_list_title_tv);
            evaluateTv =  (TextView) itemView.findViewById(R.id.details_list_evaluate_tv);
            priceTv =  (TextView) itemView.findViewById(R.id.details_list_price_tv);
            salenumTv =  (TextView) itemView.findViewById(R.id.details_list_salenum_tv);

        }
    }
}
