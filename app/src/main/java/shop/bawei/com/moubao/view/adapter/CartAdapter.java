package shop.bawei.com.moubao.view.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnLongClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.CartBean;

public class CartAdapter extends BaseExpandableListAdapter {
	
	private CartBean cartBean;
	private LayoutInflater mInflater;
	private Context mContext;
	private String buynum;
	private int num;

	private HashMap<String,Float> map = new HashMap<String,Float>();

	public CartAdapter(Context context, CartBean cartBean) {
		this.mInflater = LayoutInflater.from(context);
		this.cartBean = cartBean;
		this.mContext = context;
	}


	public Object getChild(int groupPosition, int childPosition) {
		return cartBean.getDatas().getCart_list().get(groupPosition).getGoods().get(childPosition);
	}

	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	public int getChildrenCount(int groupPosition) {
		return cartBean.getDatas().getCart_list().get(groupPosition).getGoods().size();
	}

	public View getChildView(final int groupPosition, final int childPosition,
							 boolean isLastChild, View convertView, ViewGroup parent) {
		ViewHolder vHolder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.cart_child_goods, null);
			vHolder = new ViewHolder();
			vHolder.goodsAdd = (Button) convertView.findViewById(R.id.cart_child_add);
			vHolder.goodsDel = (Button) convertView.findViewById(R.id.cart_child_delt);
			vHolder.goodsDesc = (TextView) convertView.findViewById(R.id.cart_child_goodsname);
			vHolder.goodsImg = (SimpleDraweeView) convertView.findViewById(R.id.cart_child_img);
			vHolder.goodsNum = (TextView) convertView.findViewById(R.id.cart_child_goodsnum);
			vHolder.goodsNumEt = (EditText) convertView.findViewById(R.id.cart_child_buynum_et);
			vHolder.goodsPrice = (TextView) convertView.findViewById(R.id.cart_child_goodspriceandnum);
			vHolder.goodsReul = (Button) convertView.findViewById(R.id.cart_child_remove);
			vHolder.goodsSele = (CheckBox) convertView.findViewById(R.id.cart_child_chexbox);
			vHolder.goodsSumP = (TextView) convertView.findViewById(R.id.cart_child_goodsprice);
			convertView.setTag(vHolder);
		}else {
			vHolder = (ViewHolder) convertView.getTag();
		}

		final CartBean.DatasBean.CartListBean.GoodsBean goodsBean= cartBean.getDatas().getCart_list().get(groupPosition).getGoods().get(childPosition);
	    final float price = Float.parseFloat(goodsBean.getGoods_price());
		buynum = goodsBean.getGoods_num();
		num = Integer.parseInt(buynum);
		Log.e("TAGG",buynum+"PPPPPPPPPP");
		vHolder.goodsDesc.setText(goodsBean.getGoods_name());
		vHolder.goodsImg.setImageURI(goodsBean.getGoods_image_url());
        vHolder.goodsPrice.setText(num+"");
		vHolder.goodsNumEt.setText(buynum);
		vHolder.goodsNum.setText(num+"");
		vHolder.goodsSumP.setText(price*num+"");
//		vHolder.goodsSele.setChecked(goodsBean.isChildFlag());
		final ViewHolder finalVHolder1 = vHolder;
		vHolder.goodsAdd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(num <=20){
					num++;
					finalVHolder1.goodsNum.setText(num+"");
					finalVHolder1.goodsNumEt.setText(num+"");
					finalVHolder1.goodsSumP.setText(num*price+"");
					finalVHolder1.goodsPrice.setText(num+"");
				}
			}
		});

		final ViewHolder finalVHolder = vHolder;
		vHolder.goodsReul.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				if(num >1){
					num--;
					finalVHolder1.goodsNum.setText(num +"");
					finalVHolder1.goodsNumEt.setText(num+"");
					finalVHolder1.goodsSumP.setText(num*price+"");
					finalVHolder1.goodsPrice.setText(num+"");
				}
			}
		});

		vHolder.goodsDel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

			}
		});

		vHolder.goodsSele.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

				if(b){
					map.put(goodsBean.getGoods_id(),price);

				}else{
					map.remove(goodsBean.getGoods_id());
				}
				cartBean.getDatas().getCart_list().get(groupPosition).getGoods().get(childPosition).setChildFlag(b);

			}
		});
		vHolder.goodsSele.setChecked(goodsBean.isChildFlag());

		return convertView;
	}
	
	class ViewHolder{
		public TextView goodsPrice;
		public SimpleDraweeView goodsImg;
		public TextView goodsDesc;
		public TextView goodsNum;
		public TextView goodsSumP;
		public Button goodsDel;
		public Button goodsAdd;
		public Button goodsReul;
		public EditText goodsNumEt;
		public CheckBox goodsSele;
	}

	public Object getGroup(int groupPosition) {
		return cartBean.getDatas().getCart_list().get(groupPosition);
	}

	public int getGroupCount() {
		return cartBean.getDatas().getCart_list().size();
	}

	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	/**
	 * create group view and bind data to view
	 */
	public View getGroupView(final int groupPosition, boolean isExpanded,
							 View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.cart_group_sc, null);
		}
		TextView groupGoodsName = (TextView) convertView.findViewById(R.id.cart_group_text);
		groupGoodsName.setText(cartBean.getDatas().getCart_list().get(groupPosition).getStore_name());
		final CheckBox groupCheck = (CheckBox) convertView.findViewById(R.id.cart_group_checkbox);
//		groupCheck.setChecked(cartBean.getDatas().getCart_list().get(groupPosition).isGroupFlag());
		groupCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

				cartBean.getDatas().getCart_list().get(groupPosition).setGroupFlag(b);

			}
		});
		groupCheck.setChecked(cartBean.getDatas().getCart_list().get(groupPosition).isGroupFlag());

		return convertView;
	}

	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	public boolean hasStableIds() {
		return true;
	}
	public HashMap<String,Float> getMap(){
		return map;
	}
}
