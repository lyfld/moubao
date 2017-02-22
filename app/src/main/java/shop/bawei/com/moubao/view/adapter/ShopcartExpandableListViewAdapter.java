package shop.bawei.com.moubao.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;
import java.util.Map;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.CartBean;

public class ShopcartExpandableListViewAdapter extends BaseExpandableListAdapter
{
	private List<CartBean.DatasBean.CartListBean> groups;
	private Map<String, List<CartBean.DatasBean.CartListBean.GoodsBean>> children;
	private Context context;
	//HashMap<Integer, View> groupMap = new HashMap<Integer, View>();
	//HashMap<Integer, View> childrenMap = new HashMap<Integer, View>();
	private CheckInterface checkInterface;
	private ModifyCountInterface modifyCountInterface;
	private LayoutInflater mInflater;

	/**
	 * 构造函数
	 * @param groups
	 *            组元素列表
	 * @param children
	 *            子元素列表
	 * @param context
	 */
	public ShopcartExpandableListViewAdapter(List<CartBean.DatasBean.CartListBean> groups, Map<String, List<CartBean.DatasBean.CartListBean.GoodsBean>> children, Context context)
	{
		super();
		this.groups = groups;
		this.children = children;
		this.context = context;
		mInflater = LayoutInflater.from(context);
	}

	public void setCheckInterface(CheckInterface checkInterface)
	{
		this.checkInterface = checkInterface;
	}

	public void setModifyCountInterface(ModifyCountInterface modifyCountInterface)
	{
		this.modifyCountInterface = modifyCountInterface;
	}

	@Override
	public int getGroupCount()
	{
		return groups.size();
	}

	@Override
	public int getChildrenCount(int groupPosition)
	{
		String groupId = groups.get(groupPosition).getStore_id();
		return children.get(groupId).size();
	}

	@Override
	public Object getGroup(int groupPosition)
	{
		return groups.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition)
	{
		List<CartBean.DatasBean.CartListBean.GoodsBean> childs = children.get(groups.get(groupPosition).getStore_id());

		return childs.get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition)
	{
		return 0;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition)
	{
		return 0;
	}

	@Override
	public boolean hasStableIds()
	{
		return false;
	}

	@Override
	public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
	{

		GroupHolder gholder;
		if (convertView == null)
		{
			gholder = new GroupHolder();
			convertView = View.inflate(context, R.layout.cart_group_sc, null);
			gholder.cb_check = (CheckBox) convertView.findViewById(R.id.cart_group_checkbox);
			gholder.tv_group_name = (TextView) convertView.findViewById(R.id.cart_group_text);
			//groupMap.put(groupPosition, convertView);
			 convertView.setTag(gholder);
		} else
		{
			// convertView = groupMap.get(groupPosition);
			gholder = (GroupHolder) convertView.getTag();
		}
		final CartBean.DatasBean.CartListBean group = (CartBean.DatasBean.CartListBean) getGroup(groupPosition);
		if (group != null)
		{
			gholder.tv_group_name.setText(group.getStore_name());
			gholder.cb_check.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)

				{
					group.setGroupFlag(((CheckBox) v).isChecked());
					checkInterface.checkGroup(groupPosition, ((CheckBox) v).isChecked());// 暴露组选接口
				}
			});
			gholder.cb_check.setChecked(group.isGroupFlag());
		}
		return convertView;
	}

	@Override
	public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, final ViewGroup parent)
	{

		final ViewHolderChild vHolder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.cart_child_goods, null);
			vHolder = new ViewHolderChild();
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
			vHolder.gPrice = (TextView) convertView.findViewById(R.id.cart_child_gprice);
			convertView.setTag(vHolder);
		}else {
			vHolder = (ViewHolderChild) convertView.getTag();
		}
		final CartBean.DatasBean.CartListBean.GoodsBean product = (CartBean.DatasBean.CartListBean.GoodsBean) getChild(groupPosition, childPosition);

		if (product != null)
		{
			vHolder.goodsDesc.setText(product.getGoods_name());
			vHolder.goodsImg.setImageURI(product.getGoods_image_url());
//			vHolder.goodsPrice.setText(num+"");
//			vHolder.goodsNumEt.setText(buynum);
			vHolder.goodsSumP.setText(product.getGoods_price() );
			vHolder.gPrice.setText("￥" + product.getGoods_price() + "");
			vHolder.goodsNum.setText(product.getGoods_num() + "");
			vHolder.goodsSele.setChecked(product.isChildFlag());
			vHolder.goodsDel.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View view) {
					modifyCountInterface.del(groupPosition, childPosition,product.getCart_id());
				}
			});
			vHolder.goodsSele.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					product.setChildFlag(((CheckBox) v).isChecked());
					vHolder.goodsSele.setChecked(((CheckBox) v).isChecked());
					checkInterface.checkChild(groupPosition, childPosition, ((CheckBox) v).isChecked());// 暴露子选接口
				}
			});
			vHolder.goodsAdd.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Log.e("TAGG","AAAAAAAAAAAA");
					modifyCountInterface.doIncrease(groupPosition, childPosition,vHolder.goodsNum,vHolder.goodsNumEt,vHolder.goodsSele.isChecked(),Integer.parseInt(product.getGoods_num()),Float.parseFloat(product.getGoods_price()),vHolder.goodsSumP,vHolder.goodsPrice,product.getGoods_id());// 暴露增加接口
				}
			});
			vHolder.goodsReul.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					modifyCountInterface.doDecrease(groupPosition, childPosition, vHolder.goodsNum, vHolder.goodsSele.isChecked());// 暴露删减接口
				}
			});
		}
		return convertView;
	}
	class ViewHolderChild{
		public TextView goodsPrice,gPrice;
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

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition)
	{
		return false;
	}

	/**
	 * 组元素绑定器
	 * 
	 * 
	 */
	private class GroupHolder
	{
		CheckBox cb_check;
		TextView tv_group_name;
	}

	/**
	 * 子元素绑定器
	 * 
	 * 
	 */
	private class ChildHolder
	{
		CheckBox cb_check;
		SimpleDraweeView mSimpleDraweeView;
		TextView tv_product_name;
		TextView tv_product_desc;
		TextView tv_price;
		TextView iv_increase;
		TextView tv_count;
		TextView iv_decrease;
	}

	/**
	 * 复选框接口
	 * 
	 * 
	 */
	public interface CheckInterface
	{
		/**
		 * 组选框状态改变触发的事件
		 * 
		 * @param groupPosition
		 *            组元素位置
		 * @param isChecked
		 *            组元素选中与否
		 */
		public void checkGroup(int groupPosition, boolean isChecked);

		/**
		 * 子选框状态改变时触发的事件
		 * 
		 * @param groupPosition
		 *            组元素位置
		 * @param childPosition
		 *            子元素位置
		 * @param isChecked
		 *            子元素选中与否
		 */
		public void checkChild(int groupPosition, int childPosition, boolean isChecked);
	}

	/**
	 * 改变数量的接口
	 * 
	 * 
	 */
	public interface ModifyCountInterface
	{
		/**
		 * 增加操作
		 * 
		 * @param groupPosition
		 *            组元素位置
		 * @param childPosition
		 *            子元素位置
		 * @param showCountView
		 *            用于展示变化后数量的View
		 * @param isChecked
		 *            子元素选中与否
		 */
		public void doIncrease(int groupPosition, int childPosition, View showCountView,View showViewEt, boolean isChecked,int num,Float price,View showTextView,View showViewP,String goods_id);

		/**
		 * 删减操作
		 * 
		 * @param groupPosition
		 *            组元素位置
		 * @param childPosition
		 *            子元素位置
		 * @param showCountView
		 *            用于展示变化后数量的View
		 * @param isChecked
		 *            子元素选中与否
		 */
		public void doDecrease(int groupPosition, int childPosition, View showCountView, boolean isChecked);



		public void del(int groupPosition, int childPosition,String str);
	}

}
