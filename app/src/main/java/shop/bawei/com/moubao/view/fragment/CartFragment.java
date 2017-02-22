package shop.bawei.com.moubao.view.fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.AddGoodsCarBean;
import shop.bawei.com.moubao.model.beans.CartBean;
import shop.bawei.com.moubao.model.beans.DetailsGoodBean;
import shop.bawei.com.moubao.percent.AddGoodsToCarPresenter;
import shop.bawei.com.moubao.percent.CartPercent;
import shop.bawei.com.moubao.system.Url;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.utils.SpUtils;
import shop.bawei.com.moubao.view.activity.BuyActivity;
import shop.bawei.com.moubao.view.activity.DetailsGoodActivity;
import shop.bawei.com.moubao.view.adapter.CartAdapter;
import shop.bawei.com.moubao.view.adapter.ShopcartExpandableListViewAdapter;
import shop.bawei.com.moubao.view.interfaces.CartView;
import shop.bawei.com.moubao.view.interfaces.DetailsGoodView;
import shop.bawei.com.moubao.view.myview.xlistview.XExpandableListView;

/**
 * Created by 刘伊帆 on 2016/12/28.
 */

public class CartFragment extends BaseFragment implements CartView,DetailsGoodView,ShopcartExpandableListViewAdapter.CheckInterface,ShopcartExpandableListViewAdapter.ModifyCountInterface, View.OnClickListener{


    private XExpandableListView xExpandableListView;
    private List<CartBean.DatasBean.CartListBean> mCart_list;
    private CheckBox cartCheck;
    private TextView sumPrice;
    private Button gotojs;
    private SimpleDraweeView simpleDraweeView;
    private CartPercent cartPercent;
    private double totalPrice = 0.00;// 购买的商品总价
    private int totalCount = 0;// 购买的商品总数量
    private List<CartBean.DatasBean.CartListBean> groups = new ArrayList<CartBean.DatasBean.CartListBean>();// 组元素数据列表
    private Map<String, List<CartBean.DatasBean.CartListBean.GoodsBean>> children = new HashMap<String, List<CartBean.DatasBean.CartListBean.GoodsBean>>();// 子元素数据列表


    private ShopcartExpandableListViewAdapter selva;
    private AddGoodsToCarPresenter addGoodsToCarPresenter;
    private String storeId;

    @Override
    public View initlayoutinflterView() {
        View v =  LayoutInflater.from(context).inflate(R.layout.cart_fragment, null);
        return v;
    }

    @Override
    public void initViews(View v) {
        xExpandableListView = (XExpandableListView) v.findViewById(R.id.cart_xlistview);
        cartCheck = (CheckBox) v.findViewById(R.id.cart_chexbox);
        cartCheck.setOnClickListener(this);
        simpleDraweeView =  (SimpleDraweeView) v.findViewById(R.id.simview);
        sumPrice = (TextView) v.findViewById(R.id.cart_goodsnum_goodsmoney);
        gotojs = (Button) v.findViewById(R.id.cart_gotojs);
        gotojs.setOnClickListener(this);
    }

    @Override
    public void initDatas() {
        cartPercent = new CartPercent();
        cartPercent.attachView(this);
        addGoodsToCarPresenter = new AddGoodsToCarPresenter();
        addGoodsToCarPresenter.attachView(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        String token = (String) SpUtils.getParam(context,Url.SOAL_TOKEN,"");
        cartPercent.loadDataFromNet(Url.LINK_MOBILE_CART,new OkHttpUtils.Param("key",token));

    }

    @Override
    public void cartsuccess(final CartBean cartBean) {
        if(cartBean.getDatas().getCart_list().size()>0){
            xExpandableListView.setVisibility(View.VISIBLE);
            simpleDraweeView.setVisibility(View.GONE);
            initEvents(cartBean);
        }else{
            simpleDraweeView.setImageURI("http://img1.imgtn.bdimg.com/it/u=1432768490,212778581&fm=21&gp=0.jpg");
            xExpandableListView.setVisibility(View.GONE);
            simpleDraweeView.setVisibility(View.VISIBLE);
        }

//        CartAdapter ca = new CartAdapter(context,cartBean);
//        Map<String, List<CartBean.DatasBean.CartListBean.GoodsBean>> children = new HashMap<String, List<CartBean.DatasBean.CartListBean.GoodsBean>>();
//        for (CartBean.DatasBean.CartListBean ctb:cartBean.getDatas().getCart_list()){
//            children.put(ctb.getStore_id(),ctb.getGoods());
//        }
//        ShopcartExpandableListViewAdapter ca = new ShopcartExpandableListViewAdapter(cartBean.getDatas().getCart_list(),children,context);
//        xExpandableListView.setGroupIndicator(null);
//        xExpandableListView.setPullLoadEnable(false);// ��ֹ�������ظ���
//        xExpandableListView.setXListViewListener(new XExpandableListView.IXListViewListener() {
//
//            @Override
//            public void onRefresh() {
//
////                mxListView.setAdapter(mAdapter);
//                String token = (String) SpUtils.getParam(context,Url.SOAL_TOKEN,"");
//                cartPercent.loadDataFromNet(Url.LINK_MOBILE_CART,new OkHttpUtils.Param("key",token));
//                xExpandableListView.stopRefresh();
//                xExpandableListView.setRefreshTime(System.currentTimeMillis());
//            }
//
//            @Override
//            public void onLoadMore() {
//            }
//        });

//        xExpandableListView.setAdapter(ca);
//        for(int i = 0; i < ca.getGroupCount(); i++){
//
//            xExpandableListView.expandGroup(i);
//
//        }
//        sumPrice.setText("共"+cartBean.getDatas().getCart_count()+"件商品，共"+cartBean.getDatas().getSum()+"元");
//        calculate();
//        selva.notifyDataSetChanged();
    }
    private void initEvents(CartBean bean) {
        mCart_list = bean.getDatas().getCart_list();
        children.put(mCart_list.get(0).getStore_id(), mCart_list.get(0).getGoods());
        groups = mCart_list;
        selva = new ShopcartExpandableListViewAdapter(mCart_list, children, context);
        selva.setCheckInterface(this);// 关键步骤1,设置复选框接口
        selva.setModifyCountInterface(this);// 关键步骤2,设置数量增减接口
        xExpandableListView.setGroupIndicator(null);
        xExpandableListView.setPullLoadEnable(true);// ��ֹ�������ظ���
        xExpandableListView.setXListViewListener(new XExpandableListView.IXListViewListener() {

            @Override
            public void onRefresh() {

//                mxListView.setAdapter(mAdapter);
                String token = (String) SpUtils.getParam(context,Url.SOAL_TOKEN,"");
                cartPercent.loadDataFromNet(Url.LINK_MOBILE_CART,new OkHttpUtils.Param("key",token));
                Log.e("TAG","刷新可见");
                xExpandableListView.stopRefresh();
                xExpandableListView.setRefreshTime(System.currentTimeMillis());
            }

            @Override
            public void onLoadMore() {
            }
        });
        xExpandableListView.setAdapter(selva);

        for (int i = 0; i < selva.getGroupCount(); i++) {
            xExpandableListView.expandGroup(i);// 关键步骤3,初始化时，将ExpandableListView以展开的方式呈现
        }
    }

    @Override
    public void success(DetailsGoodBean bean) {
        String token = (String) SpUtils.getParam(context,Url.SOAL_TOKEN,"");
        cartPercent.loadDataFromNet(Url.LINK_MOBILE_CART,new OkHttpUtils.Param("key",token));
    }

    @Override
    public void onAddGoodsToCarSuccess(AddGoodsCarBean result) {
        String token = (String) SpUtils.getParam(context,Url.SOAL_TOKEN,"");
        Log.e("TAGGGG",result.getDatas()+"qqqqqqqqqqqqqqqqaaaaaaaaaaaaaaaa");
        cartPercent.loadDataFromNet(Url.LINK_MOBILE_CART,new OkHttpUtils.Param("key",token));
    }

    @Override
    public void onClick(View view) {
        AlertDialog alert;
        switch (view.getId()) {
            case R.id.cart_chexbox:

                doCheckAll();
                break;
            case R.id.cart_gotojs:


                if (totalCount == 0) {
                    Toast.makeText(context, "请选择要支付的商品", Toast.LENGTH_LONG).show();
                    return;
                }
                String cart_id = "";
                String store_id = "";
                for (int i = 0; i < children.get(groups.get(0).getStore_id()).size(); i++) {
                    String temp = children.get(groups.get(0).getStore_id()).get(i).getCart_id()+ "|" + children.get(groups.get(0).getStore_id()).get(i).getGoods_num() + ",";
                    cart_id += temp;
                    temp = children.get(groups.get(0).getStore_id()).get(0).getStore_id() + "|";
                    store_id += temp;
                }

                final String storeId =  store_id.substring(0, store_id.lastIndexOf("|"));
                final String cartId = cart_id.substring(0, cart_id.lastIndexOf(","));

                alert = new AlertDialog.Builder(context).create();
                alert.setTitle("操作提示");
                alert.setMessage("总计:\n" + totalCount + "种商品\n" + totalPrice + "元");
                alert.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alert.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //跳转到订单页面

                        Intent intent = new Intent(context, BuyActivity.class);
                        intent.putExtra("cart_id",cartId);
                        intent.putExtra("stord_id",storeId);
                        context.startActivity(intent);
                    }
                });
                alert.show();
                break;
//            case R.id.tv_delete:
//
//                if (totalCount == 0) {
//                    Toast.makeText(context, "请选择要移除的商品", Toast.LENGTH_LONG).show();
//                    return;
//                }
//
//                alert = new AlertDialog.Builder(context).create();
//                alert.setTitle("操作提示");
//                alert.setMessage("您确定要将这些商品从购物车中移除吗？");
//                alert.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        return;
//                    }
//                });
//                alert.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        doDelete();
//                    }
//                });
//                alert.show();
//                break;
        }

    }


    /**
     * 删除操作<br>
     * 1.不要边遍历边删除，容易出现数组越界的情况<br>
     * 2.现将要删除的对象放进相应的列表容器中，待遍历完后，以removeAll的方式进行删除
     */
    protected void doDelete() {
        List<CartBean.DatasBean.CartListBean> toBeDeleteGroups = new ArrayList<>();// 待删除的组元素列表
        for (int i = 0; i < groups.size(); i++) {
            CartBean.DatasBean.CartListBean group = groups.get(i);
            if (group.isGroupFlag()) {

                toBeDeleteGroups.add(group);
            }

            List<CartBean.DatasBean.CartListBean.GoodsBean> toBeDeleteProducts = new ArrayList<>();// 待删除的子元素列表
            List<CartBean.DatasBean.CartListBean.GoodsBean> childs = children.get(group.getStore_id());

            for (int j = 0; j < childs.size(); j++) {
                if (childs.get(j).isChildFlag()) {
                    toBeDeleteProducts.add(childs.get(j));

                }
            }
            for (int n = 0; n < toBeDeleteProducts.size(); n++) {
//                deleteGoodsToNet(toBeDeleteProducts.get(n).getCart_id());
                addGoodsToCarPresenter.deleteGoodsToNet(toBeDeleteProducts.get(n).getCart_id(),context);
            }
            childs.removeAll(toBeDeleteProducts);

        }

        groups.removeAll(toBeDeleteGroups);


    }
    @Override
    public void doIncrease(int groupPosition, int childPosition, View showCountView,View showViewEt, boolean isChecked,int num,Float price,View showTextView,View showViewP,String goods_id) {

//        CartBean.DatasBean.CartListBean.GoodsBean product = (CartBean.DatasBean.CartListBean.GoodsBean) selva.getChild(groupPosition, childPosition);
//
//
//        // product.setCount(currentCount);
//        String userKey = (String) SpUtils.getParam(context,Url.SOAL_TOKEN,"");
//        OkHttpUtils.Param param1 = new OkHttpUtils.Param("key",userKey);
//        OkHttpUtils.Param param2 = new OkHttpUtils.Param("goods_id",goods_id);
//        OkHttpUtils.Param param3 = new OkHttpUtils.Param("quantity",1+"");
//        OkHttpUtils.Param[] params = {param1,param2,param3};
//        addGoodsToCarPresenter.loadDataFromNet(Url.LINK_MOBILE_CART_ADD,params);
//        Log.e("TAGG","BBBBBBBBBBBBBBB"+num);
//        ((TextView) showCountView).setText(num + "");
//        ((EditText)showViewEt).setText(num+"");
//        ((TextView) showViewP).setText(num + "");
//        ((TextView) showTextView).setText(num*price+"");
//        selva.notifyDataSetChanged();
//        calculate();
    }

    @Override
    public void doDecrease(int groupPosition, int childPosition, View showCountView, boolean isChecked) {

//        CartBean.DatasBean.CartListBean.GoodsBean product = (CartBean.DatasBean.CartListBean.GoodsBean) selva.getChild(groupPosition, childPosition);
//        int currentCount = Integer.parseInt(product.getGoods_num());
//        if (currentCount == 1)
//            return;
//        currentCount--;
//
//        //  product.setCount(currentCount);
//        ((TextView) showCountView).setText(currentCount + "");
//
//        selva.notifyDataSetChanged();
//        calculate();
    }

    @Override
    public void del(int groupPosition, int childPosition, final String str) {
        AlertDialog alert1;
        alert1 = new AlertDialog.Builder(context).create();
                alert1.setTitle("操作提示");
                alert1.setMessage("您确定要将这些商品从购物车中移除吗？");
                alert1.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alert1.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("TAG","WITCH"+str);
                        addGoodsToCarPresenter.deleteGoodsToNet(str,context);
                    }
                });
                alert1.show();


    }

    @Override
    public void checkGroup(int groupPosition, boolean isChecked) {
        CartBean.DatasBean.CartListBean group = groups.get(groupPosition);
        List<CartBean.DatasBean.CartListBean.GoodsBean> childs = children.get(group.getStore_id());
        for (int i = 0; i < childs.size(); i++) {
            childs.get(i).setChildFlag(isChecked);
        }
        if (isAllCheck())
            cartCheck.setChecked(true);
        else
            cartCheck.setChecked(false);
        selva.notifyDataSetChanged();
        calculate();
    }

    @Override
    public void checkChild(int groupPosition, int childPosiTion, boolean isChecked) {
        boolean allChildSameState = true;// 判断改组下面的所有子元素是否是同一种状态
        CartBean.DatasBean.CartListBean group = groups.get(groupPosition);
        List<CartBean.DatasBean.CartListBean.GoodsBean> childs = children.get(group.getStore_id());
        for (int i = 0; i < childs.size(); i++) {
            if (childs.get(i).isChildFlag() != isChecked) {
                allChildSameState = false;
                break;
            }
        }
        if (allChildSameState) {
            group.setGroupFlag(isChecked);// 如果所有子元素状态相同，那么对应的组元素被设为这种统一状态
        } else {
            group.setGroupFlag(false);// 否则，组元素一律设置为未选中状态
        }

        if (isAllCheck())
            cartCheck.setChecked(true);
        else
            cartCheck.setChecked(false);
        selva.notifyDataSetChanged();
        calculate();
    }

    private boolean isAllCheck() {

        for (CartBean.DatasBean.CartListBean group : groups) {
            if (!group.isGroupFlag())
                return false;

        }

        return true;
    }

    /**
     * 全选与反选
     */
    private void doCheckAll() {
        for (int i = 0; i < groups.size(); i++) {
            groups.get(i).setGroupFlag(cartCheck.isChecked());
            CartBean.DatasBean.CartListBean group = groups.get(i);
            List<CartBean.DatasBean.CartListBean.GoodsBean> childs = children.get(group.getStore_id());
            for (int j = 0; j < childs.size(); j++) {
                childs.get(j).setChildFlag(cartCheck.isChecked());
            }
        }
        calculate();
        selva.notifyDataSetChanged();
    }

    /**
     * 统计操作<br>
     * 1.先清空全局计数器<br>
     * 2.遍历所有子元素，只要是被选中状态的，就进行相关的计算操作<br>
     * 3.给底部的textView进行数据填充
     */
    private void calculate() {
        totalCount = 0;
        totalPrice = 0.00;
        for (int i = 0; i < groups.size(); i++) {
            CartBean.DatasBean.CartListBean group = groups.get(i);
            List<CartBean.DatasBean.CartListBean.GoodsBean> childs = children.get(group.getStore_id());
            for (int j = 0; j < childs.size(); j++) {
                CartBean.DatasBean.CartListBean.GoodsBean product = childs.get(j);
                if (product.isChildFlag()) {
                    totalCount++;
                    totalPrice += Float.parseFloat(product.getGoods_price()) * Float.parseFloat(product.getGoods_num());
                }
            }
        }
//        tv_total_price.setText("￥" + totalPrice);
//        tv_go_to_pay.setText("去支付(" + totalCount + ")");
        sumPrice.setText("共"+totalCount+"件商品，共"+totalPrice+"元");
    }
}
