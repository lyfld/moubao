package shop.bawei.com.moubao.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.AddGoodsCarBean;
import shop.bawei.com.moubao.model.beans.DetailsGoodBean;
import shop.bawei.com.moubao.percent.AddGoodsToCarPresenter;
import shop.bawei.com.moubao.percent.DetailsGoodPercent;
import shop.bawei.com.moubao.system.Url;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.utils.SpUtils;
import shop.bawei.com.moubao.view.adapter.DetailsViewPageAdapter;
import shop.bawei.com.moubao.view.adapter.viewholder.DetailsGoodsListAdapter;
import shop.bawei.com.moubao.view.interfaces.DetailsGoodView;
import shop.bawei.com.moubao.view.interfaces.RecyclerViewOnItemClickLitener;
import shop.bawei.com.moubao.view.myview.StickyNavLayout;

/**
 * Created by 刘伊帆 on 2017/1/5.
 */

public class DetailsGoodActivity extends BaseActivity implements DetailsGoodView,View.OnClickListener{
    String url = Url.LINK_MOBILE_GOODS_DETAIL+"&goods_id=";
    //商品名称
    private TextView goodsNameTv;
    //商品品牌
    private TextView goodsJingLeTv;
    //商品价格
    private TextView priceTv;
    //商品评价人数
    private TextView evaluationCountTv;
    //展示图片viewpage
    private ViewPager ImageViewPage;
    //销量
    private TextView goodsSalenumTv;
    //运费有没有货
    private TextView contentstoreTv;
    //送到什么地方
    private TextView areaNameTv;
    //好评率
    private TextView goodEvaluateTv;
    //评价人数
    private TextView getGoodEvaluateNumTv;
    //商品评论
    private RelativeLayout evaluateRl;
    //商品介绍
    private RelativeLayout goodDescRl;
    //商品商城
    private RelativeLayout goodShopRl;
    //商品商城名称
    private TextView storeNameTv;
    //商品评价描述服务 物流
    private TextView textCredit;
    //商品服务
    private TextView serveTv;
    //商品物流
    private TextView logisticsTv;
    //商品列表
    private RecyclerView GoodListRv;
    //返回按钮
    private Button returnBtn;
    //收藏按钮
    private Button collectBtn;
    //分享按钮
    private Button shareBtn;
    //客服
    private TextView kFTv;
    //购物车
    private TextView cateTv;
    //加入购物车
    private TextView addCateTv;
    //立即购买
    private TextView atoncecartTv;
    //标题
    private TextView titleTv;
    //本类p层
    private DetailsGoodPercent dgp;
    //列表商品ID
    private String goods_id1;
    //滑动控件
    private StickyNavLayout stickyNavLayout;
    private LinearLayout rl_goods;
    private String goods_id;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_good_activity);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        goodsNameTv = (TextView) findViewById(R.id.details_good_name_tv);
        goodsJingLeTv = (TextView) findViewById(R.id.details_good_desc_tv);
        priceTv = (TextView) findViewById(R.id.details_good_price_tv);
        priceTv.setTextColor(Color.RED);
        evaluationCountTv = (TextView) findViewById(R.id.details_good_goodevaluatenum_tv);
        ImageViewPage = (ViewPager) findViewById(R.id.details_good_img_vp);
        goodsSalenumTv = (TextView) findViewById(R.id.details_good_salesnum_tv);
        goodsSalenumTv.setTextColor(Color.RED);
        contentstoreTv = (TextView) findViewById(R.id.details_good_goodsnum_price_tv);
        areaNameTv = (TextView) findViewById(R.id.details_good_expressage_address_tv);
        goodEvaluateTv = (TextView) findViewById(R.id.details_good_goodevaluate_tv);
        goodEvaluateTv.setText("好评率：100 %%");
        getGoodEvaluateNumTv = (TextView) findViewById(R.id.details_good_goodevaluatenum_tv);
        storeNameTv = (TextView) findViewById(R.id.details_good_shopname_tv);
        evaluateRl = (RelativeLayout) findViewById(R.id.details_good_evaluate_rl);
        evaluateRl.setOnClickListener(this);
        goodDescRl = (RelativeLayout) findViewById(R.id.details_good_gooddesc_rl);
        goodDescRl.setOnClickListener(this);
        goodShopRl = (RelativeLayout) findViewById(R.id.details_good_shopdesc_rl);
        goodShopRl.setOnClickListener(this);
        textCredit = (TextView) findViewById(R.id.details_good_mark_desc_tv);
        serveTv = (TextView) findViewById(R.id.details_good_mark_serve_tv);
        logisticsTv = (TextView) findViewById(R.id.details_good_mark_logistics_tv);
        GoodListRv = (RecyclerView) findViewById(R.id.details_good_recyclerview);
        returnBtn = (Button) findViewById(R.id.details_good_btn_back);
        returnBtn.setOnClickListener(this);
        collectBtn = (Button) findViewById(R.id.details_good_btn_collect);
        collectBtn.setOnClickListener(this);
        shareBtn = (Button) findViewById(R.id.details_good_share_btn);
        shareBtn.setOnClickListener(this);
        kFTv = (TextView) findViewById(R.id.details_good_kefu_tv);
        kFTv.setOnClickListener(this);
        cateTv = (TextView) findViewById(R.id.details_good_cart_tv);
        cateTv.setOnClickListener(this);
        addCateTv = (TextView) findViewById(R.id.details_good_addcart_tv);
        addCateTv.setOnClickListener(this);
        atoncecartTv = (TextView) findViewById(R.id.details_good_atoncecart_tv);
        atoncecartTv.setOnClickListener(this);
        titleTv = (TextView) findViewById(R.id.details_good_title);
        titleTv.setTextColor(Color.WHITE);
        stickyNavLayout = (StickyNavLayout) findViewById(R.id.details_stikynavlayout);
        rl_goods = (LinearLayout) findViewById(R.id.rl_goods);

    }
    private String userKey ;
    @Override
    public void initDatas() {
        Intent intent = getIntent();
        goods_id = intent.getStringExtra(Url.INTENT_GOODS_ID_DETAILS);
        goods_id1 = goods_id;
        dgp = new DetailsGoodPercent(this);
        dgp.attachView(this);
        dgp.loadDataFromNet(Url.LINK_MOBILE_GOODS_DETAIL+"&goods_id="+ goods_id);
    }
    private DetailsGoodBean beans;
    @Override
    public void success(final DetailsGoodBean bean) {
        beans = bean;
        goodsNameTv.setText(bean.getDatas().getGoods_info().getGoods_name());
        goodsJingLeTv.setText(bean.getDatas().getGoods_info().getGoods_jingle());
        priceTv.setText(bean.getDatas().getGoods_info().getGoods_price());
        evaluationCountTv.setText(bean.getDatas().getGoods_info().getEvaluation_count()+"人评价");
        goodsSalenumTv.setText(bean.getDatas().getGoods_info().getGoods_salenum());
        contentstoreTv.setText(bean.getDatas().getGoods_hair_info().getIf_store_cn()+"  "+bean.getDatas().getGoods_hair_info().getContent());
        areaNameTv.setText(bean.getDatas().getGoods_hair_info().getArea_name());
        getGoodEvaluateNumTv.setText(bean.getDatas().getGoods_evaluate_info().getAll()+"人评价");
        storeNameTv.setText(bean.getDatas().getStore_info().getStore_name());
        textCredit.setText(bean.getDatas().getStore_info().getStore_credit().getStore_desccredit().getText()+":"+bean.getDatas().getStore_info().getStore_credit().getStore_desccredit().getCredit());
        serveTv.setText(bean.getDatas().getStore_info().getStore_credit().getStore_servicecredit().getText()+":"+bean.getDatas().getStore_info().getStore_credit().getStore_desccredit().getCredit());
        logisticsTv.setText(bean.getDatas().getStore_info().getStore_credit().getStore_deliverycredit().getText()+":"+bean.getDatas().getStore_info().getStore_credit().getStore_desccredit().getCredit());
        String[] imgs = bean.getDatas().getGoods_image().split(",");
        Log.e("TAG",imgs[0]);
        DetailsViewPageAdapter viewPageAdapter = new DetailsViewPageAdapter(this,imgs);
        ImageViewPage.setAdapter(viewPageAdapter);
        ImageViewPage.setCurrentItem(0);
        GoodListRv.setLayoutManager(new LinearLayoutManager(this));
        DetailsGoodsListAdapter listAdapter = new DetailsGoodsListAdapter(this);
        listAdapter.setmList(bean.getDatas().getGoods_commend_list());
        GoodListRv.setAdapter(listAdapter);
        listAdapter.setRecyclerViewOnItemClickLitener(new RecyclerViewOnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(DetailsGoodActivity.this,"再次跳转详情",Toast.LENGTH_SHORT).show();
                goods_id1 = bean.getDatas().getGoods_commend_list().get(position).getGoods_id();
                dgp.loadDataFromNet(Url.LINK_MOBILE_GOODS_DETAIL+"&goods_id="+bean.getDatas().getGoods_commend_list().get(position).getGoods_id());
                stickyNavLayout.scrollTo(0,0);
//                Intent intent2 = new Intent(getApplicationContext(),DetailsGoodActivity.class);
//                intent2.putExtra(Url.INTENT_GOODS_ID_DETAILS_DESC,goods_id1);
//                startActivity(intent2);
//                finish();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    @Override
    public void onAddGoodsToCarSuccess(AddGoodsCarBean result) {
        Toast.makeText(this,"加入购物车成功",Toast.LENGTH_SHORT).show();
        popupWindow.dismiss();
    }

    private Button bt_popup_add;
    private Button bt_popup_reduce;
    private Button bt_popup_buynow;
    private Button bt_popup_joincar;
    private EditText et_popup_buynum;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.details_good_btn_back:
                finish();
                break;
            case R.id.details_good_kefu_tv:
                Toast.makeText(this,"转入客服",Toast.LENGTH_SHORT).show();
                break;
            case R.id.details_good_cart_tv:
                Toast.makeText(this,"转入购物车",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,MainActivity.class);
                intent.putExtra("from","detailsGoods");
                startActivity(intent);
                break;
            case R.id.details_good_addcart_tv:
                if(SpUtils.getParam(this,Url.SOAL_TOKEN,"1").equals("")){
                    startActivity(new Intent(this,LoginActivity.class));
                }else {
                    showpubpwindows();
                }
                break;
            case R.id.details_good_atoncecart_tv:
                Toast.makeText(this,"转入立即购买",Toast.LENGTH_SHORT).show();
                break;
            case R.id.details_good_btn_collect:
                Toast.makeText(this,"转入加入收藏",Toast.LENGTH_SHORT).show();
                break;
            case R.id.details_good_share_btn:
                Toast.makeText(this,"转入分享",Toast.LENGTH_SHORT).show();
                break;
            case R.id.details_good_evaluate_rl:
                Toast.makeText(this,"转入商品评价",Toast.LENGTH_SHORT).show();
                break;
            case R.id.details_good_gooddesc_rl:
                Toast.makeText(this,"转入商品介绍",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this,GoodsWebViewActivity.class);
                intent2.putExtra(Url.INTENT_GOODS_ID_DETAILS_DESC,goods_id1);
                startActivity(intent2);
                break;
            case R.id.details_good_shopdesc_rl:
                Toast.makeText(this,"转入商城",Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    private void showpubpwindows() {

        View popupView = getLayoutInflater().inflate(R.layout.goodscar_popupwindow_layout,null);
        //初始化控件
        SimpleDraweeView dv_popup_image = (SimpleDraweeView) popupView.findViewById(R.id.dv_popup_image);
        TextView tv_popup_title = (TextView) popupView.findViewById(R.id.tv_popup_title);
        TextView tv_popup_price = (TextView) popupView.findViewById(R.id.tv_popup_price);
        TextView tv_popup_kucun = (TextView) popupView.findViewById(R.id.tv_popup_kucun);
        bt_popup_add = (Button) popupView.findViewById(R.id.bt_popup_add);
        bt_popup_reduce = (Button) popupView.findViewById(R.id.bt_popup_reduce);
        bt_popup_buynow = (Button) popupView.findViewById(R.id.bt_popup_buynow);
        bt_popup_joincar = (Button) popupView.findViewById(R.id.bt_popup_joincar);
        et_popup_buynum = (EditText) popupView.findViewById(R.id.et_popup_buynum);
        et_popup_buynum.setText(mBuynum+"");
        //按钮监听
        onBtnListen();
        dv_popup_image.setImageURI(beans.getDatas().getGoods_image());
        tv_popup_title.setText(beans.getDatas().getGoods_info().getGoods_name());
        tv_popup_price.setTextColor(Color.RED);
        tv_popup_price.setText("¥"+beans.getDatas().getGoods_info().getGoods_promotion_price());
        popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        setBackgroundAlpha(0.5f);
        popupWindow.showAtLocation(rl_goods, Gravity.BOTTOM,0,0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setBackgroundAlpha(1);
            }
        });
    }

    private int mBuynum = 1;
    private void onBtnListen() {
        bt_popup_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mBuynum > 0){
                    mBuynum--;
                    et_popup_buynum.setText(mBuynum+"");
                }
            }
        });
        bt_popup_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBuynum++;
                et_popup_buynum.setText(mBuynum+"");
            }
        });
//        String userKey =
        bt_popup_joincar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(DetailsGoodActivity.this,"转入加入购物车",Toast.LENGTH_SHORT).show();
                userKey = (String) SpUtils.getParam(DetailsGoodActivity.this,Url.SOAL_TOKEN,"");
                AddGoodsToCarPresenter presenter = new AddGoodsToCarPresenter();
                presenter.attachView(DetailsGoodActivity.this);
                OkHttpUtils.Param param1 = new OkHttpUtils.Param("key",userKey);
                OkHttpUtils.Param param2 = new OkHttpUtils.Param("goods_id",goods_id);
                OkHttpUtils.Param param3 = new OkHttpUtils.Param("quantity",mBuynum+"");
                OkHttpUtils.Param[] params = {param1,param2,param3};
                presenter.loadDataFromNet(Url.LINK_MOBILE_CART_ADD,params);
            }
        });
        et_popup_buynum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailsGoodActivity.this,"立即购买",Toast.LENGTH_SHORT).show();
            }
        });
    }
    //设置添加屏幕的背景透明度
    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = this.getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        this.getWindow().setAttributes(lp);
    }
}
