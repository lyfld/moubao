package shop.bawei.com.moubao.view.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.MineBean;
import shop.bawei.com.moubao.model.beans.MyBean;
import shop.bawei.com.moubao.model.beans.MyOrderBean;
import shop.bawei.com.moubao.percent.MinePercent;
import shop.bawei.com.moubao.system.Url;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.utils.SpUtils;
import shop.bawei.com.moubao.utils.ToastUtil;
import shop.bawei.com.moubao.view.activity.AddAddressActivity;
import shop.bawei.com.moubao.view.activity.LoginActivity;
import shop.bawei.com.moubao.view.activity.LogoutActivity;
import shop.bawei.com.moubao.view.activity.MyOrderActivity;
import shop.bawei.com.moubao.view.activity.ShopAddressActivity;
import shop.bawei.com.moubao.view.interfaces.MineView;


/**
 * Created by 刘伊帆 on 2016/12/28.
 */

public class MineFragment extends BaseFragment  implements View.OnClickListener,MineView{

    //头像
    private SimpleDraweeView mineHeadImg;
    //包裹头像和文字的布局
    private RelativeLayout mineTitleRl1;
    //登录注册显示
    private TextView mineLoginregisterTv1;
    //商品收藏
    private Button mineGoodscollectBtn;
    //店铺收藏
    private Button mineShopcollectBtn;
    //我的足迹
    private Button mineMytrackBtn;
    //全部订单
    private Button mineAllindentBtn;
    //未支付
    private Button mineNopayBtn;
    //待发货
    private Button mineWaitShipmentsBtn;
    //待收货
    private Button mineWaitDriveBtn;
    //待评价
    private Button mineWaitEvaluateBtn;
    //退款/货
    private Button mineWaitRefundBtn;
    //我的财产
    private Button mineMypropertyBtn;
    //预存款
    private Button mineIndepositBtn;
    //充值卡
    private Button mineCardBtn;
    //代金券
    private Button mineVoucherBtn;
    //红包
    private Button mineRedPacketBtn;
    //积分
    private Button mineIntegralBtn;
    //收获地址
    private Button mineShippingAddressBtn;
    //系统设置
    private Button mineSystemSettingsBtn;
    private MinePercent minePercent;
    private String key;

    @Override
    public View initlayoutinflterView() {
        View v = LayoutInflater.from(context).inflate(R.layout.mine_fragment, null);
        return v;
    }

    @Override
    public void initViews(View v) {
        mineHeadImg = (SimpleDraweeView) v.findViewById(R.id.mine_head_img);
        mineHeadImg.setImageURI("http://4493bz.1985t.com/uploads/allimg/150127/4-15012G52133.jpg");

        mineLoginregisterTv1 = (TextView) v.findViewById(R.id.mine_loginregister_tv);
        mineTitleRl1 = (RelativeLayout) v.findViewById(R.id.mine_title_rl);
        mineGoodscollectBtn = (Button) v.findViewById(R.id.mine_goodscollect_btn);
        mineShopcollectBtn = (Button) v.findViewById(R.id.mine_shopcollect_btn);
        mineMytrackBtn = (Button) v.findViewById(R.id.mine_mytrack_btn);
        mineAllindentBtn = (Button) v.findViewById(R.id.mine_allindent_btn);
        mineNopayBtn = (Button) v.findViewById(R.id.mine_nopay_btn);
        mineWaitShipmentsBtn = (Button) v.findViewById(R.id.mine_wait_shipments_btn);
        mineWaitDriveBtn = (Button) v.findViewById(R.id.mine_wait_drive_btn);
        mineWaitEvaluateBtn = (Button) v.findViewById(R.id.mine_wait_evaluate_btn);
        mineWaitRefundBtn = (Button) v.findViewById(R.id.mine_wait_refund_btn);
        mineMypropertyBtn = (Button) v.findViewById(R.id.mine_myproperty_btn);
        mineIndepositBtn = (Button) v.findViewById(R.id.mine_indeposit_btn);
        mineCardBtn = (Button) v.findViewById(R.id.mine_card_btn);
        mineVoucherBtn = (Button) v.findViewById(R.id.mine_voucher_btn);
        mineRedPacketBtn = (Button) v.findViewById(R.id.mine_red_packet_btn);
        mineIntegralBtn = (Button) v.findViewById(R.id.mine_integral_btn);
        mineShippingAddressBtn = (Button) v.findViewById(R.id.mine_shipping_address_btn);
        mineSystemSettingsBtn = (Button) v.findViewById(R.id.mine_system_settings_btn);

        mineLoginregisterTv1.setTextColor(Color.WHITE);
        mineTitleRl1.setOnClickListener(this);
        mineGoodscollectBtn.setOnClickListener(this);
        mineGoodscollectBtn.setTextColor(Color.WHITE);
        mineShopcollectBtn.setOnClickListener(this);
        mineShopcollectBtn.setTextColor(Color.WHITE);
        mineMytrackBtn.setOnClickListener(this);
        mineMytrackBtn.setTextColor(Color.WHITE);
        mineAllindentBtn.setOnClickListener(this);
        mineNopayBtn.setOnClickListener(this);
        mineWaitShipmentsBtn.setOnClickListener(this);
        mineWaitDriveBtn.setOnClickListener(this);
        mineWaitEvaluateBtn.setOnClickListener(this);
        mineWaitRefundBtn.setOnClickListener(this);
        mineMypropertyBtn.setOnClickListener(this);
        mineIndepositBtn.setOnClickListener(this);
        mineCardBtn.setOnClickListener(this);
        mineVoucherBtn.setOnClickListener(this);
        mineRedPacketBtn.setOnClickListener(this);
        mineIntegralBtn.setOnClickListener(this);
        mineShippingAddressBtn.setOnClickListener(this);
        mineSystemSettingsBtn.setOnClickListener(this);
    }

    @Override
    public void initDatas() {
        minePercent = new MinePercent(context);
        minePercent.attachView(this);


    }

    @Override
    public void onResume() {
        super.onResume();
//        "6fe496de0c203ab9840377a79b44699b"

        key = (String) SpUtils.getParam(context, Url.SOAL_TOKEN,"");
        Log.e("TAG","000000000000"+key);
        minePercent.loadDataFromNet(Url.LINK_MOBILE_USER,new OkHttpUtils.Param("key", key));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_head_img:
                break;
            case R.id.mine_title_rl:
//                Log.e("TAG","88888888888"+key);
                if(key.length()>0){
                    startActivity(new Intent(context, LogoutActivity.class));
                 }else{
                    startActivity(new Intent(context, LoginActivity.class));
                }

                break;
            case R.id.mine_goodscollect_btn:
                break;
            case R.id.mine_shopcollect_btn:
                break;
            case R.id.mine_mytrack_btn:
                break;
            case R.id.mine_allindent_btn:
                Log.e("TAG","asdasd7777777777777777777");
                minePercent.postDataFromNet(Url.LINK_MOBILE_ORDER,new OkHttpUtils.Param("key", (String) SpUtils.getParam(context,Url.SOAL_TOKEN,"")));
                break;
            case R.id.mine_nopay_btn:
                break;
            case R.id.mine_wait_shipments_btn:
                break;
            case R.id.mine_wait_drive_btn:
                break;
            case R.id.mine_wait_evaluate_btn:
                break;
            case R.id.mine_wait_refund_btn:
                break;
            case R.id.mine_myproperty_btn:
                break;
            case R.id.mine_indeposit_btn:
                break;
            case R.id.mine_card_btn:
                break;
            case R.id.mine_voucher_btn:
                break;
            case R.id.mine_red_packet_btn:
                break;
            case R.id.mine_integral_btn:
                break;
            case R.id.mine_shipping_address_btn:
                if(key.length()>0){
                    startActivity(new Intent(context, ShopAddressActivity.class));
                }else{
                    ToastUtil.show(getActivity(),"请先登录");
                }
                break;
            case R.id.mine_system_settings_btn:
                break;
            default:
                break;
        }
    }

    @Override
    public void success(MineBean mb) {
        if(mb.getCode() == 200){
            mineHeadImg.setImageURI(mb.getDatas().getMember_info().getAvatar());
            mineLoginregisterTv1.setText(mb.getDatas().getMember_info().getUser_name());

        }else if(mb.getCode() == 400){
            Toast.makeText(context,mb.getDatas().getError(),Toast.LENGTH_SHORT).show();
            mineLoginregisterTv1.setText("登录/注册");
        }
    }

    @Override
    public void successorde(MyOrderBean orderBean) {

        Intent orderIntent = new Intent(context, MyOrderActivity.class);
        orderIntent.putExtra("mMyBeenList",getmyOrderList(orderBean));
        startActivity(orderIntent);
    }
    /**
     * 得到集合中的数据
     *
     * @param orderBean
     */
    public ArrayList<MyBean> getmyOrderList(MyOrderBean orderBean) {
        ArrayList<MyBean> mMyBeenList = null;

        if (orderBean.getCode() == 200) {
            if (orderBean.getDatas().getOrder_group_list() != null && orderBean.getDatas().getOrder_group_list().size() > 0) {
                List<MyOrderBean.DatasBean.OrderGroupListBean> mOrder_group_list = orderBean.getDatas().getOrder_group_list();
                // List<List<MyOrderBean.DatasBean.OrderGroupListBean.OrderListBean>>  order_list = new ArrayList<>();
                mMyBeenList = new ArrayList<>();
                for (MyOrderBean.DatasBean.OrderGroupListBean orderGroupListBean : mOrder_group_list) {
                    // order_list.add(orderGroupListBean.getOrder_list());
                    for (MyOrderBean.DatasBean.OrderGroupListBean.OrderListBean orderListBean : orderGroupListBean.getOrder_list()) {

                        for (MyOrderBean.DatasBean.OrderGroupListBean.OrderListBean.ExtendOrderGoodsBean extendOrderGoodsBean : orderListBean.getExtend_order_goods()) {

                            MyBean myBean = new MyBean();
                            myBean.setState_desc(orderListBean.getState_desc());
                            myBean.setGoods_amount(orderListBean.getGoods_amount());
                            myBean.setExtendOrderGoodsBean(extendOrderGoodsBean);
                            mMyBeenList.add(myBean);
                        }

                    }
                }
            }
        }
        return mMyBeenList;
    }
}
