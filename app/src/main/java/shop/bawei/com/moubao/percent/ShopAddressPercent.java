package shop.bawei.com.moubao.percent;

import android.util.Log;

import shop.bawei.com.moubao.model.beans.DelAddressBean;
import shop.bawei.com.moubao.model.beans.ShopingAddressBean;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.view.interfaces.OkHttpUtilsCallBack;
import shop.bawei.com.moubao.view.interfaces.ShopAddressView;

/**
 * Created by 刘伊帆 on 2017/2/13.
 */

public class ShopAddressPercent extends BasePercent<ShopAddressView> {


    public void loadDataFromNet(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, ShopingAddressBean.class, new OkHttpUtilsCallBack<ShopingAddressBean>() {
            @Override
            public void success(ShopingAddressBean baseBean) {
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

    public void delDataFromNet(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, DelAddressBean.class, new OkHttpUtilsCallBack<DelAddressBean>() {
            @Override
            public void success(DelAddressBean baseBean) {
//                Log.e("TAG",baseBean.getDatas().getSum()+"成功");
                if(baseBean.getCode() == 200){
                    getView().delSuccess(baseBean);
                }

            }

            @Override
            public void failed() {
                Log.e("TAG","失败");
            }
        },parm);
    }

    public void UpDateData(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, DelAddressBean.class, new OkHttpUtilsCallBack<DelAddressBean>() {
            @Override
            public void success(DelAddressBean baseBean) {
//                Log.e("TAG",baseBean.getDatas().getSum()+"成功");
                if(baseBean.getCode() == 200){
                    getView().upDataSuccess(baseBean);
                }

            }

            @Override
            public void failed() {
                Log.e("TAG","失败");
            }
        },parm);
    }


}
