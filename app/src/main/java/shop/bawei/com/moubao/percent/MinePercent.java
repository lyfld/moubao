package shop.bawei.com.moubao.percent;

import android.content.Context;

import shop.bawei.com.moubao.model.beans.MineBean;
import shop.bawei.com.moubao.model.beans.MyOrderBean;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.view.interfaces.MineView;
import shop.bawei.com.moubao.view.interfaces.OkHttpUtilsCallBack;

/**
 * Created by 刘伊帆 on 2017/2/16.
 */

public class MinePercent extends BasePercent<MineView>{
    private Context context;

    public MinePercent(Context context) {
        this.context = context;
    }

    public void loadDataFromNet(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, MineBean.class, new OkHttpUtilsCallBack<MineBean>() {
            @Override
            public void success(MineBean mb) {
                getView().success(mb);
            }

            @Override
            public void failed() {

            }

        },parm);
    }
    public void postDataFromNet(String url, OkHttpUtils.Param... parmas) {
        okHttpUtils.requestJson2Bean(url, MyOrderBean.class, new OkHttpUtilsCallBack<MyOrderBean>() {
            @Override
            public void success(MyOrderBean mb) {
                getView().successorde(mb);
            }

            @Override
            public void failed() {

            }
        }, parmas);
    }
}
