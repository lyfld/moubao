package shop.bawei.com.moubao.percent;

import android.util.Log;

import shop.bawei.com.moubao.model.beans.BuyBean1;
import shop.bawei.com.moubao.model.beans.CartBean;
import shop.bawei.com.moubao.model.beans.DelAddressBean;
import shop.bawei.com.moubao.model.beans.IndentBean;
import shop.bawei.com.moubao.model.beans.ShopingAddressBean;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.view.interfaces.BuyView;
import shop.bawei.com.moubao.view.interfaces.OkHttpUtilsCallBack;

/**
 * Created by 刘伊帆 on 2017/2/15.
 */

public class BuyPercent extends BasePercent<BuyView> {

    public void upDataFromNet(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, CartBean.class, new OkHttpUtilsCallBack<CartBean>() {
            @Override
            public void success(CartBean baseBean) {
//                Log.e("TAG",baseBean.getDatas().getSum()+"成功");
                if(baseBean.getCode() == 200){
                    getView().success(baseBean);
                }

            }

            @Override
            public void failed() {
                Log.e("TAG","失败");
            }
        },parm);
    }
    public void dataFromNet(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, ShopingAddressBean.class, new OkHttpUtilsCallBack<ShopingAddressBean>() {
            @Override
            public void success(ShopingAddressBean baseBean) {
//                Log.e("TAG",baseBean.getDatas().getSum()+"成功");
                if(baseBean.getCode() == 200){
                    getView().addressSuccess(baseBean);
                }

            }

            @Override
            public void failed() {
                Log.e("TAG","失败");
            }
        },parm);
    }
    public void indentDataFromNet(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, IndentBean.class, new OkHttpUtilsCallBack<IndentBean>() {
            @Override
            public void success(IndentBean baseBean) {
//                Log.e("TAG",baseBean.getDatas().getSum()+"成功");
                if(baseBean.getCode() == 200){
                    getView().indentSuccess(baseBean);
                }

            }

            @Override
            public void failed() {
                Log.e("TAG","失败");
            }
        },parm);
    }

    public void buyDataFromNet(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, BuyBean1.class, new OkHttpUtilsCallBack<BuyBean1>() {
            @Override
            public void success(BuyBean1 baseBean) {
//                Log.e("TAG",baseBean.getDatas().getSum()+"成功");
                if(baseBean.getCode() == 200){
                    getView().buyBean(baseBean);
                }

            }

            @Override
            public void failed() {
                Log.e("TAG","失败");
            }
        },parm);
    }
}
