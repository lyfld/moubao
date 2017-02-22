package shop.bawei.com.moubao.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import java.util.List;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.DelAddressBean;
import shop.bawei.com.moubao.model.beans.ShopingAddressBean;
import shop.bawei.com.moubao.percent.ShopAddressPercent;
import shop.bawei.com.moubao.system.Url;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.utils.SpUtils;
import shop.bawei.com.moubao.utils.ToastUtil;
import shop.bawei.com.moubao.view.adapter.ShopAddressAdapter;
import shop.bawei.com.moubao.view.interfaces.RecyclerViewOnItemClickLitener;
import shop.bawei.com.moubao.view.interfaces.ShopAddressView;

/**
 * Created by 刘伊帆 on 2017/2/13.
 */

public class ShopAddressActivity extends BaseActivity implements ShopAddressView,View.OnClickListener,RecyclerViewOnItemClickLitener,ShopAddressAdapter.CheckListener {

    private ShopAddressPercent shopAddressPercent;
    private ShopAddressAdapter shopAddressAdapter;
    private RecyclerView recyclerView;
    private Button backBtn,addBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_address_activity);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.shop_address_list);
        backBtn = (Button) findViewById(R.id.shop_address_btn_back);
        addBtn = (Button) findViewById(R.id.shop_address_ok_btn);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        backBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        shopAddressPercent.loadDataFromNet(Url.LINK_MOBILE_ADDRESS,new OkHttpUtils.Param("key", (String) SpUtils.getParam(this,Url.SOAL_TOKEN,"")));
    }

    @Override
    public void initDatas() {
        shopAddressPercent = new ShopAddressPercent();
        shopAddressPercent.attachView(this);
        shopAddressAdapter = new ShopAddressAdapter(this);
        shopAddressAdapter.setLitener(this);
        shopAddressAdapter.setCheckListen(this);

    }

    private List<ShopingAddressBean.DatasBean.AddressListBean> address_list;
    @Override
    public void success(ShopingAddressBean sab) {
        address_list = sab.getDatas().getAddress_list();
        shopAddressAdapter.setData(address_list);
        recyclerView.setAdapter(shopAddressAdapter);

    }

    @Override
    public void delSuccess(DelAddressBean delAddressBean) {
        ToastUtil.show(this,"删除成功!");
    }

    @Override
    public void upDataSuccess(DelAddressBean delAddressBean) {
        shopAddressPercent.loadDataFromNet(Url.LINK_MOBILE_ADDRESS,new OkHttpUtils.Param("key", (String) SpUtils.getParam(this,Url.SOAL_TOKEN,"")));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shop_address_btn_back:
                finish();
                break;
            case R.id.shop_address_ok_btn:
                startActivity(new Intent(this, AddAddressActivity.class));
                break;
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this,AddAddressActivity.class);
        intent.putExtra("from","AddAddressActivity");
        intent.putExtra("address",address_list.get(position));
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(View view, final int position) {
        AlertDialog alert1;
        alert1 = new AlertDialog.Builder(this).create();
        alert1.setTitle("操作提示");
        alert1.setMessage("您确定要删除这个地址吗？");
        alert1.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        alert1.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                shopAddressPercent.delDataFromNet(Url.LINK_MOBILE_ADDRESS_DEL,new OkHttpUtils.Param("key",
                        (String) SpUtils.getParam(ShopAddressActivity.this,Url.SOAL_TOKEN,"")),
                        new OkHttpUtils.Param("address_id",address_list.get(position).getAddress_id()));
                address_list.remove(position);
                shopAddressAdapter.setData(address_list);
                shopAddressAdapter.notifyDataSetChanged();
            }
        });
        alert1.show();
    }

    @Override
    public void onCheckedChang(CompoundButton buttonView, boolean isChecked,int position) {
        Log.e("TAG",""+isChecked+"999"+position);
        shopAddressPercent.UpDateData(Url.LINK_MOBILE_ADDRESS_EDIT,new OkHttpUtils.Param("key",(String) SpUtils.getParam(ShopAddressActivity.this,Url.SOAL_TOKEN,"")),
                new OkHttpUtils.Param("address_id",address_list.get(position).getAddress_id()),
                new OkHttpUtils.Param("true_name",address_list.get(position).getTrue_name()),
                new OkHttpUtils.Param("mob_phone",address_list.get(position).getMob_phone()),
                new OkHttpUtils.Param("city_id",address_list.get(position).getCity_id()),
                new OkHttpUtils.Param("area_id",address_list.get(position).getArea_id()),
                new OkHttpUtils.Param("address",address_list.get(position).getAddress()),
                new OkHttpUtils.Param("area_info",address_list.get(position).getArea_info()),
                new OkHttpUtils.Param("is_default",isChecked?"1":"0")
        );
    }
}
