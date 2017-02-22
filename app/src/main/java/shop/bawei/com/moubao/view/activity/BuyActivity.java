package shop.bawei.com.moubao.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.BuyBean1;
import shop.bawei.com.moubao.model.beans.CartBean;
import shop.bawei.com.moubao.model.beans.IndentBean;
import shop.bawei.com.moubao.model.beans.ShopingAddressBean;
import shop.bawei.com.moubao.percent.BuyPercent;
import shop.bawei.com.moubao.system.Url;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.utils.SpUtils;
import shop.bawei.com.moubao.utils.ToastUtil;
import shop.bawei.com.moubao.view.adapter.IndentAdapter;
import shop.bawei.com.moubao.view.interfaces.BuyView;

/**
 * Created by 刘伊帆 on 2017/2/15.
 */

public class BuyActivity extends BaseActivity implements BuyView,View.OnClickListener{

    private RecyclerView recyclerView;
    private BuyPercent buyPercent;
    private IndentAdapter adapter;
    private String key;
    private TextView name,address,phone,onlinePay,pay,havefa,nofa;
    private Button okBtn;
    private ShopingAddressBean.DatasBean.AddressListBean addressBean;
    private CartBean cartBeans;
    private String vat_hash, offpay_hash, password="";
    private String invoice_id = "0", voucher="", pd_pay="0", fcode="";
    private String offpay_hash_batch, pay_name="online", rcb_pay="0";
    private BuyBean1 buyBean11;
    private String cardId;
    private String storeId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settle);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.settle_recyview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new IndentAdapter(this);
        name = (TextView) findViewById(R.id.head_indent_nameTetView);
        phone = (TextView) findViewById(R.id.head_indent_phoneTextView);
        address = (TextView) findViewById(R.id.head_indent_contentTextView);
        okBtn = (Button) findViewById(R.id.tijiao_btn);
        okBtn.setOnClickListener(this);
        onlinePay = (TextView) findViewById(R.id.head_indent_payOnlineTextView);
        pay = (TextView) findViewById(R.id.head_indent_payOfflineTextView);
        havefa = (TextView) findViewById(R.id.head_indent_invoiceYesTextView);
        nofa = (TextView) findViewById(R.id.head_indent_invoiceNoTextView);
        onlinePay.setOnClickListener(this);
        pay.setOnClickListener(this);
        havefa.setOnClickListener(this);
        nofa.setOnClickListener(this);
    }

    @Override
    public void initDatas() {
        buyPercent = new BuyPercent();
        buyPercent.attachView(this);
        key = (String) SpUtils.getParam(this, Url.SOAL_TOKEN,"");
        Intent intent = getIntent();
        cardId = intent.getStringExtra("cart_id");
        storeId = intent.getStringExtra("stord_id");
        buyPercent.buyDataFromNet(Url.LINK_MOBILE_BUY_SETUP1,new OkHttpUtils.Param("key",key),
                new OkHttpUtils.Param("cart_id", cardId),
                new OkHttpUtils.Param("ifcart","1"));
//        buyPercent.upDataFromNet(Url.LINK_MOBILE_CART,new OkHttpUtils.Param("key",key));
//        buyPercent.dataFromNet(Url.LINK_MOBILE_ADDRESS,new OkHttpUtils.Param("key",key));
        Log.e("TAG","执行了222");
    }

    @Override
    public void success(CartBean cartBean) {
//        CartAdapter adapter = new CartAdapter(this,cartBean);
//        cartBeans = cartBean;
//        adapter.setData(cartBean.getDatas().getCart_list().get(0).getGoods());

    }

    @Override
    public void addressSuccess(ShopingAddressBean shopingAddressBean) {
//        List<ShopingAddressBean.DatasBean.AddressListBean> lists =  shopingAddressBean.getDatas().getAddress_list();
//        Log.e("TAG","执行了");
//        for (ShopingAddressBean.DatasBean.AddressListBean list : lists) {
//            if("1".equals(list.getIs_default())){
//                Log.e("TAG","执行了111111");
//                addressBean = list;
//                name.setText(list.getTrue_name());
//                phone.setText(list.getMob_phone());
//                address.setText(list.getArea_info()+list.getAddress());
//            }
//        }
    }

    @Override
    public void indentSuccess(IndentBean indentBean) {
        ToastUtil.show(this,"下单成功");
        finish();
    }

    @Override
    public void buyBean(BuyBean1 buyBean1) {
        buyBean11 = buyBean1;
        BuyBean1.DatasBean.AddressInfoBean addressInfoBean = buyBean1.getDatas().getAddress_info();
        name.setText(addressInfoBean.getTrue_name());
        phone.setText(addressInfoBean.getMob_phone());
        address.setText(addressInfoBean.getArea_info()+addressInfoBean.getAddress());
        adapter.setData(buyBean1.getDatas().getStore_cart_list().get_$1().getGoods_list());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tijiao_btn:
                qingqiu();

                break;
            case R.id.head_indent_invoiceYesTextView:
                havefa.setBackgroundResource(R.color.colorAccent);
                nofa.setBackgroundResource(R.color.white);
                break;
            case R.id.head_indent_invoiceNoTextView:
                nofa.setBackgroundResource(R.color.colorAccent);
                havefa.setBackgroundResource(R.color.white);
                break;
            case R.id.head_indent_payOnlineTextView:
                pay_name = "online";
                onlinePay.setBackgroundResource(R.color.colorAccent);
                pay.setBackgroundResource(R.color.white);
                break;
            case R.id.head_indent_payOfflineTextView:
                pay_name = "offline";
                pay.setBackgroundResource(R.color.colorAccent);
                onlinePay.setBackgroundResource(R.color.white);
                break;
            default:
                break;
        }
    }


    /**
     *ajaxParams.put("key", Constant.userKeyString);
     ajaxParams.put("ifcart", ifcart);
     ajaxParams.put("cart_id", cart_id);
     ajaxParams.put("address_id", address_id);
     ajaxParams.put("vat_hash", vat_hash);
     ajaxParams.put("offpay_hash", offpay_hash);
     ajaxParams.put("offpay_hash_batch", offpay_hash_batch);
     ajaxParams.put("pay_name", pay_name);
     ajaxParams.put("invoice_id", invoice_id);
     ajaxParams.put("voucher", voucher);
     ajaxParams.put("pd_pay", pd_pay);
     ajaxParams.put("password", password);
     ajaxParams.put("fcode", fcode);
     ajaxParams.put("rcb_pay", rcb_pay);
     ajaxParams.put("rpt", "");
     ajaxParams.put("pay_message", message);
     * @param
     */
    private void qingqiu() {
//        vat_hash =
        buyPercent.indentDataFromNet(Url.LINK_MOBILE_BUY_SETUP2,new OkHttpUtils.Param("key", (String) SpUtils.getParam(this,Url.SOAL_TOKEN,"")),
                new OkHttpUtils.Param("ifcart","1"),
                new OkHttpUtils.Param("cart_id",cardId),
                new OkHttpUtils.Param("address_id",buyBean11.getDatas().getAddress_info().getAddress_id()),
                new OkHttpUtils.Param("vat_hash",buyBean11.getDatas().getVat_hash()),
                new OkHttpUtils.Param("offpay_hash",buyBean11.getDatas().getAddress_api().getOffpay_hash()),
                new OkHttpUtils.Param("offpay_hash_batch",buyBean11.getDatas().getAddress_api().getOffpay_hash_batch()),
                new OkHttpUtils.Param("pay_name",pay_name),
                new OkHttpUtils.Param("invoice_id",invoice_id),
                new OkHttpUtils.Param("voucher",voucher),
                new OkHttpUtils.Param("pd_pay",pd_pay),
                new OkHttpUtils.Param("password",password),
                new OkHttpUtils.Param("fcode",fcode),
                new OkHttpUtils.Param("rcb_pay",rcb_pay),
                new OkHttpUtils.Param("rpt",""),
                new OkHttpUtils.Param("pay_message",storeId)
  );
    }
}
