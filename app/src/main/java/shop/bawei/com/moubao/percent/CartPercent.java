package shop.bawei.com.moubao.percent;

import android.util.Log;

import shop.bawei.com.moubao.model.beans.CartBean;
import shop.bawei.com.moubao.model.beans.UserBean;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.view.interfaces.CartView;
import shop.bawei.com.moubao.view.interfaces.OkHttpUtilsCallBack;

/**
 * Created by 刘伊帆 on 2017/2/9.
 */

public class CartPercent extends BasePercent<CartView> {
    public void loadDataFromNet(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, CartBean.class, new OkHttpUtilsCallBack<CartBean>() {
            @Override
            public void success(CartBean baseBean) {
//                Log.e("TAG",baseBean.getDatas().getSum()+"成功");
                if(baseBean.getCode() == 200){
                    getView().cartsuccess(baseBean);
                }

            }

            @Override
            public void failed() {
                Log.e("TAG","失败");
            }
        },parm);
    }


}
