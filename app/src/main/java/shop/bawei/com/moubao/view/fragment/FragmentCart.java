//package shop.bawei.com.moubao.view.fragment;
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.support.annotation.Nullable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CheckBox;
//import android.widget.ExpandableListView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.gs.fqx.R;
//import com.gs.fqx.model.HttpUtils;
//import com.gs.fqx.model.bean.AddCartBean;
//import com.gs.fqx.model.bean.CartListsBean;
//import com.gs.fqx.utils.API;
//import com.gs.fqx.utils.ToastUtil;
//import com.gs.fqx.views.activity.AddressActivity;
//import com.gs.fqx.views.activity.MainActivity;
//import com.gs.fqx.views.adapter.CartLinearAdapter;
//import com.gs.fqx.views.adapter.ShopcartExpandableListViewAdapter;
//import com.gs.fqx.views.interfaces.MyListener;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
///**
// * Created by 樊、先生 on 2016/12/27.
// */
//
//public class FragmentCart extends BaseFragment implements ShopcartExpandableListViewAdapter.CheckInterface, ShopcartExpandableListViewAdapter.ModifyCountInterface, View.OnClickListener {
//
//    @BindView(R.id.cart_txt)
//    TextView mCartTxt;
//    @BindView(R.id.cart_llayout)
//    LinearLayout mCartLlayout;
//    private MainActivity mMainActivity;
//    private ExpandableListView exListView;
//    private CheckBox cb_check_all;
//    private TextView tv_total_price;
//    private TextView tv_delete;
//    private TextView tv_go_to_pay;
//
//
//    private Context context;
//
//    private double totalPrice = 0.00;// 购买的商品总价
//    private int totalCount = 0;// 购买的商品总数量
//
//    private ShopcartExpandableListViewAdapter selva;
//    private List<CartListsBean.DatasBean.CartListBean> groups = new ArrayList<CartListsBean.DatasBean.CartListBean>();// 组元素数据列表
//    private Map<String, List<CartListsBean.DatasBean.CartListBean.GoodsBean>> children = new HashMap<String, List<CartListsBean.DatasBean.CartListBean.GoodsBean>>();// 子元素数据列表
//
//    private Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            if (msg.what == 0) {
//                if (mCart_list.size() > 0) {
//
//                    initEvents();
//                }
//            }
//        }
//    };
//    private CartLinearAdapter mCartLinearAdapter;
//    private List<CartListsBean.DatasBean.CartListBean> mCart_list;
//
//    @Override
//    protected int getContentViewLayoutID() {
//        return R.layout.cart_fragment;
//    }
//
//    @Override
//    protected void initViewsAndEvents(View view) {
//        context = getContext();
//        exListView = (ExpandableListView) view.findViewById(R.id.exListView);
//        cb_check_all = (CheckBox) view.findViewById(R.id.all_chekbox);
//        tv_total_price = (TextView) view.findViewById(R.id.tv_total_price);
//        tv_delete = (TextView) view.findViewById(R.id.tv_delete);
//        tv_go_to_pay = (TextView) view.findViewById(R.id.tv_go_to_pay);
//
//        cb_check_all.setOnClickListener(this);
//        tv_delete.setOnClickListener(this);
//        tv_go_to_pay.setOnClickListener(this);
//    }
//
//    private void initEvents() {
//        children.put(mCart_list.get(0).getStore_id(), mCart_list.get(0).getGoods());
//        groups = mCart_list;
//        selva = new ShopcartExpandableListViewAdapter(mCart_list, children, mActivity);
//        selva.setCheckInterface(this);// 关键步骤1,设置复选框接口
//        selva.setModifyCountInterface(this);// 关键步骤2,设置数量增减接口
//        exListView.setAdapter(selva);
//
//        for (int i = 0; i < selva.getGroupCount(); i++) {
//            exListView.expandGroup(i);// 关键步骤3,初始化时，将ExpandableListView以展开的方式呈现
//        }
//    }
//
//    @Override
//    public void onClick(View v) {
//        AlertDialog alert;
//        switch (v.getId()) {
//            case R.id.all_chekbox:
//
//                doCheckAll();
//                break;
//            case R.id.tv_go_to_pay:
//
//                if (totalCount == 0) {
//                    Toast.makeText(context, "请选择要支付的商品", Toast.LENGTH_LONG).show();
//                    return;
//                }
//
//                alert = new AlertDialog.Builder(context).create();
//                alert.setTitle("操作提示");
//                alert.setMessage("总计:\n" + totalCount + "种商品\n" + totalPrice + "元");
//                alert.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        return;
//                    }
//                });
//                alert.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //跳转到订单页面
//                        Intent intent = new Intent(mActivity, AddressActivity.class);
//                        mActivity.startActivity(intent);
//                    }
//                });
//                alert.show();
//                break;
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
//        }
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        //登录状态
//        Boolean flag = mSharedPreferences.getBoolean("FLAG", false);
//        if (flag) {
//            mCartTxt.setVisibility(View.GONE);
//
//            mCartLlayout.setVisibility(View.VISIBLE);
//            //网络请获取购物车详情
//            getGoodsNumforNet();
//
//        } else {
//             mCartTxt.setVisibility(View.VISIBLE);
//
//          mCartLlayout.setVisibility(View.GONE);
//            ToastUtil.show(mActivity, "还未登录哦！");
//        }
//    }
//
//    /**
//     * 等到购物车信息
//     */
//    public void getGoodsNumforNet() {
//        HttpUtils.Param param1 = new HttpUtils.Param("key", mSharedPreferences.getString("KEY", ""));
//        HttpUtils.Param[] params = {param1};
//        HttpUtils.instance().requestJson2Bean(API.LINK_MOBILE_CART, CartListsBean.class, new MyListener<CartListsBean>() {
//            @Override
//            public void onSuccess(CartListsBean requestBean) {
//                if (requestBean.getCode() == 200) {
//
//                    String sum = requestBean.getDatas().getSum();
//                    mCart_list = requestBean.getDatas().getCart_list();
//
//                    mHandler.sendEmptyMessageDelayed(0, 5);
//                }
//            }
//
//            @Override
//            public void onFail() {
//
//            }
//        }, params);
//    }
//
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        mMainActivity = (MainActivity) activity;
//    }
//
//    /**
//     * 删除操作<br>
//     * 1.不要边遍历边删除，容易出现数组越界的情况<br>
//     * 2.现将要删除的对象放进相应的列表容器中，待遍历完后，以removeAll的方式进行删除
//     */
//    protected void doDelete() {
//        List<CartListsBean.DatasBean.CartListBean> toBeDeleteGroups = new ArrayList<>();// 待删除的组元素列表
//        for (int i = 0; i < groups.size(); i++) {
//            CartListsBean.DatasBean.CartListBean group = groups.get(i);
//            if (group.isChoosed()) {
//
//                toBeDeleteGroups.add(group);
//            }
//
//            List<CartListsBean.DatasBean.CartListBean.GoodsBean> toBeDeleteProducts = new ArrayList<>();// 待删除的子元素列表
//            List<CartListsBean.DatasBean.CartListBean.GoodsBean> childs = children.get(group.getStore_id());
//
//            for (int j = 0; j < childs.size(); j++) {
//                if (childs.get(j).isChoosed()) {
//                    toBeDeleteProducts.add(childs.get(j));
//
//                }
//            }
//            for (int n = 0; n < toBeDeleteProducts.size(); n++) {
//                deleteGoodsToNet(toBeDeleteProducts.get(n).getCart_id());
//            }
//            childs.removeAll(toBeDeleteProducts);
//
//        }
//
//        groups.removeAll(toBeDeleteGroups);
//
//
//    }
//
//    private void deleteGoodsToNet(String cart_id) {
//        HttpUtils.Param param1 = new HttpUtils.Param("key", mSharedPreferences.getString("KEY", ""));
//        HttpUtils.Param param2 = new HttpUtils.Param("cart_id", cart_id);
//        HttpUtils.Param[] params = {param1, param2};
//        HttpUtils.instance().requestJson2Bean(API.LINK_MOBILE_CART_DEL, AddCartBean.class, new MyListener<AddCartBean>() {
//            @Override
//            public void onSuccess(AddCartBean requestBean) {
//                if (requestBean.getCode() == 200) {
//
//                    //删除成功，刷新页面，重新统计钱数
//
//                    getGoodsNumforNet();
//                    calculate();
//                    selva.notifyDataSetChanged();
//                }
//
//            }
//
//            @Override
//            public void onFail() {
//
//            }
//        }, params);
//    }
//
//    @Override
//    public void doIncrease(int groupPosition, int childPosition, View showCountView, boolean isChecked) {
//
//        CartListsBean.DatasBean.CartListBean.GoodsBean product = (CartListsBean.DatasBean.CartListBean.GoodsBean) selva.getChild(groupPosition, childPosition);
//        int currentCount = Integer.parseInt(product.getGoods_num());
//        currentCount++;
//        // product.setCount(currentCount);
//        ((TextView) showCountView).setText(currentCount + "");
//
//        selva.notifyDataSetChanged();
//        calculate();
//    }
//
//    @Override
//    public void doDecrease(int groupPosition, int childPosition, View showCountView, boolean isChecked) {
//
//        CartListsBean.DatasBean.CartListBean.GoodsBean product = (CartListsBean.DatasBean.CartListBean.GoodsBean) selva.getChild(groupPosition, childPosition);
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
//    }
//
//    @Override
//    public void checkGroup(int groupPosition, boolean isChecked) {
//        CartListsBean.DatasBean.CartListBean group = groups.get(groupPosition);
//        List<CartListsBean.DatasBean.CartListBean.GoodsBean> childs = children.get(group.getStore_id());
//        for (int i = 0; i < childs.size(); i++) {
//            childs.get(i).setChoosed(isChecked);
//        }
//        if (isAllCheck())
//            cb_check_all.setChecked(true);
//        else
//            cb_check_all.setChecked(false);
//        selva.notifyDataSetChanged();
//        calculate();
//    }
//
//    @Override
//    public void checkChild(int groupPosition, int childPosiTion, boolean isChecked) {
//        boolean allChildSameState = true;// 判断改组下面的所有子元素是否是同一种状态
//        CartListsBean.DatasBean.CartListBean group = groups.get(groupPosition);
//        List<CartListsBean.DatasBean.CartListBean.GoodsBean> childs = children.get(group.getStore_id());
//        for (int i = 0; i < childs.size(); i++) {
//            if (childs.get(i).isChoosed() != isChecked) {
//                allChildSameState = false;
//                break;
//            }
//        }
//        if (allChildSameState) {
//            group.setChoosed(isChecked);// 如果所有子元素状态相同，那么对应的组元素被设为这种统一状态
//        } else {
//            group.setChoosed(false);// 否则，组元素一律设置为未选中状态
//        }
//
//        if (isAllCheck())
//            cb_check_all.setChecked(true);
//        else
//            cb_check_all.setChecked(false);
//        selva.notifyDataSetChanged();
//        calculate();
//    }
//
//    private boolean isAllCheck() {
//
//        for (CartListsBean.DatasBean.CartListBean group : groups) {
//            if (!group.isChoosed())
//                return false;
//
//        }
//
//        return true;
//    }
//
//    /**
//     * 全选与反选
//     */
//    private void doCheckAll() {
//        for (int i = 0; i < groups.size(); i++) {
//            groups.get(i).setChoosed(cb_check_all.isChecked());
//            CartListsBean.DatasBean.CartListBean group = groups.get(i);
//            List<CartListsBean.DatasBean.CartListBean.GoodsBean> childs = children.get(group.getStore_id());
//            for (int j = 0; j < childs.size(); j++) {
//                childs.get(j).setChoosed(cb_check_all.isChecked());
//            }
//        }
//        calculate();
//        selva.notifyDataSetChanged();
//    }
//
//    /**
//     * 统计操作<br>
//     * 1.先清空全局计数器<br>
//     * 2.遍历所有子元素，只要是被选中状态的，就进行相关的计算操作<br>
//     * 3.给底部的textView进行数据填充
//     */
//    private void calculate() {
//        totalCount = 0;
//        totalPrice = 0.00;
//        for (int i = 0; i < groups.size(); i++) {
//            CartListsBean.DatasBean.CartListBean group = groups.get(i);
//            List<CartListsBean.DatasBean.CartListBean.GoodsBean> childs = children.get(group.getStore_id());
//            for (int j = 0; j < childs.size(); j++) {
//                CartListsBean.DatasBean.CartListBean.GoodsBean product = childs.get(j);
//                if (product.isChoosed()) {
//                    totalCount++;
//                    totalPrice += Float.parseFloat(product.getGoods_price()) * Float.parseFloat(product.getGoods_num());
//                }
//            }
//        }
//        tv_total_price.setText("￥" + totalPrice);
//        tv_go_to_pay.setText("去支付(" + totalCount + ")");
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // TODO: inflate a fragment view
//        View rootView = super.onCreateView(inflater, container, savedInstanceState);
//        ButterKnife.bind(this, rootView);
//        return rootView;
//    }
//}
