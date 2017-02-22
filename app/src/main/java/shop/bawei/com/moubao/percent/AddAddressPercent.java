package shop.bawei.com.moubao.percent;

import android.util.Log;

import shop.bawei.com.moubao.model.beans.AddressBean;
import shop.bawei.com.moubao.model.beans.CartBean;
import shop.bawei.com.moubao.model.beans.DelAddressBean;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.view.interfaces.AddAddressView;
import shop.bawei.com.moubao.view.interfaces.OkHttpUtilsCallBack;

/**
 * Created by 刘伊帆 on 2017/2/10.
 */

public class AddAddressPercent extends BasePercent<AddAddressView> {
    public void loadDataFromNet(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, AddressBean.class, new OkHttpUtilsCallBack<AddressBean>() {
            @Override
            public void success(AddressBean baseBean) {
//                Log.e("TAG",baseBean.getDatas().getSum()+"成功");
                if(baseBean.getCode() == 200){
                    getView().addAddressSuccess(baseBean);
                }

            }

            @Override
            public void failed() {
                Log.e("TAG","失败");
            }
        },parm);
    }
    public void getpDataFromNet(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, AddressBean.class, new OkHttpUtilsCallBack<AddressBean>() {
            @Override
            public void success(AddressBean baseBean) {
//                Log.e("TAG",baseBean.getDatas().getSum()+"成功");
                if(baseBean.getCode() == 200){
                    getView().getProvince(baseBean);
                }

            }

            @Override
            public void failed() {
                Log.e("TAG","失败");
            }
        },parm);
    }
    public void getcityFromNet(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, AddressBean.class, new OkHttpUtilsCallBack<AddressBean>() {
            @Override
            public void success(AddressBean baseBean) {
//                Log.e("TAG",baseBean.getDatas().getSum()+"成功");
                if(baseBean.getCode() == 200){
                    getView().getCity(baseBean);
                }

            }

            @Override
            public void failed() {
                Log.e("TAG","失败");
            }
        },parm);
    }
    public void getDistrictFromNet(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, AddressBean.class, new OkHttpUtilsCallBack<AddressBean>() {
            @Override
            public void success(AddressBean baseBean) {
//                Log.e("TAG",baseBean.getDatas().getSum()+"成功");
                if(baseBean.getCode() == 200){
                    getView().getDistrict(baseBean);
                }

            }

            @Override
            public void failed() {
                Log.e("TAG","失败");
            }
        },parm);
    }
    public void upDataFromNet(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, DelAddressBean.class, new OkHttpUtilsCallBack<DelAddressBean>() {
            @Override
            public void success(DelAddressBean baseBean) {
//                Log.e("TAG",baseBean.getDatas().getSum()+"成功");
                if(baseBean.getCode() == 200){
                    getView().upData(baseBean);
                }

            }

            @Override
            public void failed() {
                Log.e("TAG","失败");
            }
        },parm);
    }

}
