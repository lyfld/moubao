package shop.bawei.com.moubao.percent;


import android.content.Context;
import android.util.Log;

import java.util.List;

import shop.bawei.com.moubao.model.beans.AddGoodsCarBean;
import shop.bawei.com.moubao.model.beans.CategoryBean;
import shop.bawei.com.moubao.model.beans.UserBean;
import shop.bawei.com.moubao.system.Url;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.utils.SpUtils;
import shop.bawei.com.moubao.view.interfaces.DetailsGoodView;
import shop.bawei.com.moubao.view.interfaces.OkHttpUtilsCallBack;

/**
 * Created by 曹建树 on 2017/1/16.
 */

public class AddGoodsToCarPresenter extends BasePercent<DetailsGoodView> {

    public void loadDataFromNet(String url, OkHttpUtils.Param... parm){
//        OkHttpUtil instance = OkHttpUtil.getInstance();
//        instance.requestJson2Bean(url, AddGoodsCarBean.class, new OkHttpUtil.RequestJson2BeanCallBack<AddGoodsCarBean>() {
//            @Override
//            public void success(AddGoodsCarBean result) {
//                getView().onAddGoodsToCarSuccess(result);
//            }
//
//            @Override
//            public void error() {
//
//            }
//        },param);


            okHttpUtils.requestJson2Bean(url, AddGoodsCarBean.class, new OkHttpUtilsCallBack<AddGoodsCarBean>() {
                @Override
                public void success(AddGoodsCarBean baseBean) {
                    Log.e("TAG",baseBean.getCode()+"成功");
//                    getView().success(baseBean);
                    getView().onAddGoodsToCarSuccess(baseBean);

                }

                @Override
                public void failed() {
                    Log.e("TAG","失败");
                }
            },parm);

    }
    public void deleteGoodsToNet(String cart_id, Context context) {
        OkHttpUtils.Param param1 = new OkHttpUtils.Param("key", (String) SpUtils.getParam(context, Url.SOAL_TOKEN,""));
        OkHttpUtils.Param param2 = new OkHttpUtils.Param("cart_id", cart_id);
        OkHttpUtils.Param[] params = {param1, param2};
        okHttpUtils.requestJson2Bean(Url.LINK_MOBILE_CART_DEL, AddGoodsCarBean.class, new OkHttpUtilsCallBack<AddGoodsCarBean>() {
            @Override
            public void success(AddGoodsCarBean addGoodsCarBean) {
                getView().onAddGoodsToCarSuccess(addGoodsCarBean);
            }

            @Override
            public void failed() {

            }
        }, params);
    }

}
