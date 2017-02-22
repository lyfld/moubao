package shop.bawei.com.moubao.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.DetailsBean;
import shop.bawei.com.moubao.percent.DetailsListPercent;
import shop.bawei.com.moubao.system.Url;
import shop.bawei.com.moubao.view.adapter.DetailsListAdapter;
import shop.bawei.com.moubao.view.interfaces.DetailsListView;
import shop.bawei.com.moubao.view.interfaces.RecyclerViewOnItemClickLitener;
import shop.bawei.com.moubao.view.myview.StickyNavLayout;

/**
 * Created by 刘伊帆 on 2017/1/4.
 */

public class DetailsListActivity extends BaseActivity implements DetailsListView,View.OnClickListener{

    private Button detailsListReturnBtn;
    private String gc_id;
    private DetailsListPercent dp;
    private RecyclerView detailsRecyclerView;
    private TextView noData;
    private DetailsListAdapter adapter;
    private RadioGroup mRg;
    private Button mToUpBtn;
    private StickyNavLayout stickyNavLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_list_activity);
        initViews();
        initDatas();
    }

    @Override
    public void initViews() {
        detailsListReturnBtn = (Button) findViewById(R.id.details_return_btn);
        detailsListReturnBtn.setOnClickListener(this);
        detailsRecyclerView = (RecyclerView) findViewById(R.id.details_recyclerview);
        noData = (TextView) findViewById(R.id.deatils_fruitless_tv);
        mRg = (RadioGroup) findViewById(R.id.details_good_radiogroup);
        mToUpBtn = (Button) findViewById(R.id.details_good_up_btn);
        stickyNavLayout = (StickyNavLayout) findViewById(R.id.details_good_stikynavlayout);
        mToUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailsRecyclerView.scrollToPosition(0);
                stickyNavLayout.scrollTo(0,0);
//                detailsRecyclerView.scrollTo(0,0);
            }
        });
    }

    @Override
    public void initDatas() {
        Intent intent = getIntent();
        gc_id = intent.getStringExtra(Url.INTENT_GC_ID_CATEGORY);
        dp = new DetailsListPercent(this);
        dp.attachView(this);
        dp.loadDataFromNet(Url.LINK_GOOD_CLASS+gc_id);
        adapter = new DetailsListAdapter(this);

    }

    @Override
    public void success(final DetailsBean bean) {
        switch (bean.getPage_total()){
            case 0:
                noData.setVisibility(View.VISIBLE);
                mToUpBtn.setVisibility(View.GONE);
                break;
            case 1:
                Log.d("TAG",bean.getDatas().getGoods_list().get(0).getGoods_name()+"");
                detailsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                adapter.setmList(bean.getDatas().getGoods_list());
                detailsRecyclerView.setAdapter(adapter);
                break;
            default: break;
        }
        adapter.setRecyclerViewOnItemClickLitener(new RecyclerViewOnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(DetailsListActivity.this,"点击了"+position,Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(DetailsListActivity.this,DetailsGoodActivity.class);
                intent1.putExtra(Url.INTENT_GOODS_ID_DETAILS,bean.getDatas().getGoods_list().get(position).getGoods_id());
                startActivity(intent1);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    @Override
    public void haveData(DetailsBean bean) {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.details_return_btn:
                finish();
                break;
            default:
                break;
        }
    }
}
