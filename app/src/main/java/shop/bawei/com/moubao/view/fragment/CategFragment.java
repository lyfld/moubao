package shop.bawei.com.moubao.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import shop.bawei.com.moubao.R;
import shop.bawei.com.moubao.model.beans.CategoryBean;
import shop.bawei.com.moubao.percent.CategoryPercent;
import shop.bawei.com.moubao.system.Url;
import shop.bawei.com.moubao.view.activity.DetailsListActivity;
import shop.bawei.com.moubao.view.adapter.ClassAdapter;
import shop.bawei.com.moubao.view.adapter.GoodsAdapter;
import shop.bawei.com.moubao.view.adapter.GoodsContentAdapter;
import shop.bawei.com.moubao.view.interfaces.CategoryView;
import shop.bawei.com.moubao.view.interfaces.RecyclerViewOnItemClickLitener;
import shop.bawei.com.moubao.view.myview.ItemDecoration;

/**
 * Created by 刘伊帆 on 2016/12/28.
 */

public class CategFragment extends BaseFragment implements CategoryView{

    private RecyclerView recyclerViewLeft;
    private RecyclerView recyclerViewRight;
    private CategoryPercent cp;
    /**
     * 商品分类的RecyclerView
     */
    private RecyclerView mRlClass;
    /**
     * 商品内容的RecyclerView
     */
    private RecyclerView mRlShop;

    /**
     * 分类列表的Adapter
     */
    private ClassAdapter mClassAdapter;

    /**
     * 商品内容的Adapter
     */
    private GoodsAdapter mGoodsAdapter;

    /**
     * 商品内容的Adapter
     */
    private GoodsContentAdapter mContentAdapter;

    /**
     * 记录是否是第一次请求数据
     */
    private boolean isFirst = true;

    /**
     * 记录上一次点击的position
     */
    int lastPosition = 0;

    /**
     * 当前点击的position
     */
    int currentPosition = 0;

    /**
     * 记录子商品的数量
     */
    int goodsNum = 0;

    /**
     * 记录回调的次数
     */
    int callBackNum = 0;

    /**
     * 记录Adapter的map集合
     */
    private HashMap<String,GoodsContentAdapter> hashMap = new HashMap<String,GoodsContentAdapter>();

    @Override
    public void initDatas() {
        cp.attachView(this);
        //请求分类数据
        cp.requestLeft(Url.LINK_MOBILE_CLASS);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cp = new CategoryPercent(context);

    }

    @Override
    public View initlayoutinflterView() {
        View v = View.inflate(context,R.layout.category_fragment,null);
        return v;
    }

    @Override
    public void initViews(View view) {
        mRlClass = (RecyclerView) view.findViewById(R.id.category_category_recyclerview);
        mRlShop = (RecyclerView) view.findViewById(R.id.category_data_recyclerview);

    }


    @Override
    public void leftCategory(final List<CategoryBean.DatasBean.ClassListBean> list) {
        mClassAdapter = new ClassAdapter(context);
        mClassAdapter.setData(list);
        //设置布局管理器
        mRlClass.setLayoutManager(new LinearLayoutManager(context));
        //添加分割线
        mRlClass.addItemDecoration(new ItemDecoration(context,LinearLayoutManager.VERTICAL));
        mRlClass.setAdapter(mClassAdapter);
        //设置点击监听
        mClassAdapter.setOnItemClickLisenter(new ClassAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //记录点击的position
                currentPosition = position;
                //请求商品数据
                int gc_id = Integer.parseInt(list.get(position).getGc_id());
                cp.requestRight(Url.LINK_MOBILE_CLASS+"&gc_id="+gc_id);
            }
        });
        //请求默认数据
        if(isFirst){
            //请求商品数据
            int gc_id = Integer.parseInt(list.get(0).getGc_id());
            cp.requestRight(Url.LINK_MOBILE_CLASS+"&gc_id="+gc_id);
        }
    }

    @Override
    public void rightCateGory(List<CategoryBean.DatasBean.ClassListBean> list) {
        //记录子商品的数量
        goodsNum = list.size();
        if(isFirst){
            mGoodsAdapter = new GoodsAdapter(context);
            //设置数据集合
            mGoodsAdapter.setData(list);
        }else{
            //设置数据集合
            mGoodsAdapter.setData(list);
        }
        if(isFirst){


            for(CategoryBean.DatasBean.ClassListBean bean : list){
                //得到每一个子条目商品的ID
                int gc_id = Integer.parseInt(bean.getGc_id());
                //请求数据
                cp.requestChildItemData(Url.LINK_MOBILE_CLASS+"&gc_id="+gc_id);
            }

            isFirst = !isFirst;
        }
        //判断点击的是否是同一个分类
        if(currentPosition != lastPosition){
            //释放掉Adapter的引用
            if(hashMap!=null || hashMap.size() >0){
                hashMap.clear();
            }
            //隐藏掉RecylerView
            mRlShop.setVisibility(View.INVISIBLE);

            for(CategoryBean.DatasBean.ClassListBean bean : list){
                //得到每一个子条目商品的ID
                int gc_id = Integer.parseInt(bean.getGc_id());
                //请求数据
                cp.requestChildItemData(Url.LINK_MOBILE_CLASS+"&gc_id="+gc_id);
            }
            lastPosition = currentPosition;
        }

    }


    @Override
    public void childCategory(final List<CategoryBean.DatasBean.ClassListBean> list, final String url) {

        //记录回调的次数
        callBackNum++;

            //创建Adapter
            mContentAdapter = new GoodsContentAdapter(context);
            //设置数据源
            mContentAdapter.setData(list);
            //添加到Adapter的集合
            hashMap.put(url,mContentAdapter);

        if(callBackNum == goodsNum){
            //显示RecylerView
            mRlShop.setVisibility(View.VISIBLE);
//            mGoodsAdapter.setAdapterList(mAdapterList);
            mGoodsAdapter.setHashMap(hashMap);

            mRlShop.setLayoutManager(new LinearLayoutManager(context));
            mRlShop.setAdapter(mGoodsAdapter);
            //归零
            callBackNum = 0;
            goodsNum = 0;
        }
        //设置监听
        mContentAdapter.setOnItemClickLisenter(new GoodsContentAdapter.OnItemClickLisenter() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context,"position:"+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailsListActivity.class);
                intent.putExtra(Url.INTENT_GC_ID_CATEGORY,list.get(position).getGc_id());
                startActivity(intent);
                Log.d("TAG", url);
            }
        });
    }
}


