package shop.bawei.com.moubao.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;




import java.util.ArrayList;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.MyBean;
import shop.bawei.com.moubao.model.beans.MyOrderBean;
import shop.bawei.com.moubao.view.adapter.MyOrderAdapter;


/**
 * 我的订单页面
 * Created by 刘伊帆 on 2017/2/16.
 */

public class MyOrderActivity extends BaseActivity {
    ImageView mOrderBack;
    RecyclerView mMyorderRv;
    private MyOrderBean mMyOrderBean;
    private MyOrderAdapter mMyOrderAdapter;

    private ArrayList<MyBean> mMyBeenList;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                mMyorderRv.setAdapter(mMyOrderAdapter);
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);
        initViews();
        initViews();
    }

    @Override
    public void initViews() {
        mMyorderRv = (RecyclerView) findViewById(R.id.myorder_rv);
        mOrderBack = (ImageView) findViewById(R.id.myorder_back);
        //得到从上个类传来的bean
        // mMyOrderBean = (MyOrderBean)getIntent().getSerializableExtra("orderbean");
        mMyBeenList = (ArrayList<MyBean>)getIntent().getSerializableExtra("mMyBeenList");
        //设置布局，适配数据
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mMyorderRv.setLayoutManager(layoutManager);
        mMyOrderAdapter = new MyOrderAdapter(this);
        mMyOrderAdapter.getDatas(mMyBeenList);

        mHandler.sendEmptyMessageDelayed(0, 5);
    }

    @Override
    public void initDatas() {
/**
 * 在最后的返回
 */
        mOrderBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        mMyorderRv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
