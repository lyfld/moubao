package shop.bawei.com.moubao.percent;

import android.content.Context;

import shop.bawei.com.moubao.model.beans.MineBean;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.view.interfaces.LogoutView;
import shop.bawei.com.moubao.view.interfaces.OkHttpUtilsCallBack;

/**
 * Created by 刘伊帆 on 2017/1/14.
 */

public class LogoutPercent extends BasePercent<LogoutView> {


    private Context context;

    public LogoutPercent(Context context) {
        this.context = context;
    }

    public void loadDataFromNet(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, MineBean.class, new OkHttpUtilsCallBack<MineBean>() {
            @Override
            public void success(MineBean mb) {
                if(mb.getCode() == 200){
                    getView().success(mb);
                }

            }

            @Override
            public void failed() {

            }
        },parm);
    }

    public void logoutUser(String url, OkHttpUtils.Param... parm){
        okHttpUtils.requestJson2Bean(url, MineBean.class, new OkHttpUtilsCallBack<MineBean>() {
            @Override
            public void success(MineBean mb) {

//                if(mb.getCode() == 200){
                    getView().logout();
//                }
            }

            @Override
            public void failed() {

            }
        },parm);

    }
}
