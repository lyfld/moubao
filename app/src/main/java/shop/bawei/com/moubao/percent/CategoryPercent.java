package shop.bawei.com.moubao.percent;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shop.bawei.com.moubao.model.beans.CategoryBean;
import shop.bawei.com.moubao.view.interfaces.CategoryView;
import shop.bawei.com.moubao.view.interfaces.OkHttpUtilsCallBack;


/**
 * Created by 刘伊帆 on 2016/12/30.
 */

public class CategoryPercent extends BasePercent<CategoryView> {
    private Context context;

    public CategoryPercent(Context context) {
        this.context = context;
    }


    //请求分类信息的方法
    public void requestLeft(String classUrl){
        okHttpUtils.getJson2Bean(classUrl, CategoryBean.class, new OkHttpUtilsCallBack<CategoryBean>() {
            @Override
            public void success(CategoryBean result) {
                //得到数据集合,回调Fragment
                List<CategoryBean.DatasBean.ClassListBean> list = result.getDatas().getClass_list();
                baseView.leftCategory(list);
            }

            @Override
            public void failed() {

            }
        });
    };

    public void requestRight(String GoodsUrl) {
        okHttpUtils.getJson2Bean(GoodsUrl, CategoryBean.class, new OkHttpUtilsCallBack<CategoryBean>() {
            @Override
            public void success(CategoryBean result) {
                //回调
                List<CategoryBean.DatasBean.ClassListBean> list = result.getDatas().getClass_list();
                baseView.rightCateGory(list);
            }

            @Override
            public void failed() {

            }
        });
    }

    public void requestChildItemData(final String childItemUrl) {

        okHttpUtils.getJson2Bean(childItemUrl, CategoryBean.class, new OkHttpUtilsCallBack<CategoryBean>() {
            @Override
            public void success(CategoryBean result) {
                //回调
                List<CategoryBean.DatasBean.ClassListBean> list = result.getDatas().getClass_list();
                //因为响应顺序不一样返回当前请求数据
                baseView.childCategory(list,childItemUrl);
            }

            @Override
            public void failed() {

            }
        });
    }

}
