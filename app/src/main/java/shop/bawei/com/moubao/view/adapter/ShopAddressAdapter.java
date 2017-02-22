package shop.bawei.com.moubao.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.ShopingAddressBean;
import shop.bawei.com.moubao.view.interfaces.RecyclerViewOnItemClickLitener;

/**
 * Created by 刘伊帆 on 2017/2/13.
 */

public class ShopAddressAdapter extends RecyclerView.Adapter<ShopAddressAdapter.ShopAddressViewHolder> {
    private Context context;
    private CheckListener CheckListener;
    private List<ShopingAddressBean.DatasBean.AddressListBean> list = new ArrayList<>();
    private RecyclerViewOnItemClickLitener recyclerViewOnItemClickLitener;
    public ShopAddressAdapter(Context context){
        this.context = context;
    }
    public void setCheckListen(CheckListener CheckListener){
        this.CheckListener = CheckListener;
    }
    public void setData(List<ShopingAddressBean.DatasBean.AddressListBean> lists){
            list.clear();
            list.addAll(lists);
    }
    public void setLitener(RecyclerViewOnItemClickLitener recyclerViewOnItemClickLitener){
        this.recyclerViewOnItemClickLitener = recyclerViewOnItemClickLitener;
    }
    @Override
    public ShopAddressAdapter.ShopAddressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_address_item,parent,false);
        return new ShopAddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ShopAddressAdapter.ShopAddressViewHolder holder, final int position) {
        holder.trueName.setText(list.get(position).getTrue_name());
        holder.phone.setText(list.get(position).getMob_phone());
        holder.address.setText(list.get(position).getArea_info()+"  "+list.get(position).getAddress());
        if(list.get(position).getIs_default().equals("1")){
            holder.defuletCheck.setChecked(true);
        }else {
            holder.defuletCheck.setChecked(false);
        }
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
        holder.defuletCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckListener.onCheckedChang(buttonView,isChecked,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public  static class ShopAddressViewHolder extends RecyclerView.ViewHolder{
        public TextView trueName,phone,address;
        public CheckBox defuletCheck;
        public ShopAddressViewHolder(View itemView) {
            super(itemView);
            trueName = (TextView) itemView.findViewById(R.id.shop_address_item_trueNameTetView);
            phone = (TextView) itemView.findViewById(R.id.shop_address_item_phoneTextView);
            address = (TextView) itemView.findViewById(R.id.shop_address_item_addressTextView);
            defuletCheck = (CheckBox) itemView.findViewById(R.id.shop_address_item_defaultCheckBox);
        }
    }
  public interface CheckListener {
      public void onCheckedChang(CompoundButton buttonView, boolean isChecked,int position);
  }

}
