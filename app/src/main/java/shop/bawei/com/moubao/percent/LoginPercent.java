package shop.bawei.com.moubao.percent;

import android.content.Context;
import android.util.Log;

import shop.bawei.com.moubao.model.beans.BaseBean;
import shop.bawei.com.moubao.model.beans.UserBean;
import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.view.interfaces.LoginView;
import shop.bawei.com.moubao.view.interfaces.OkHttpUtilsCallBack;

/**
 * Created by 刘伊帆 on 2017/1/10.
 */

public class LoginPercent extends BasePercent<LoginView> {
    private Context context;

    public LoginPercent(Context context) {
        this.context = context;
    }

    public void loadDataFromNet(String url, OkHttpUtils.Param... parm){

        okHttpUtils.requestJson2Bean(url, UserBean.class, new OkHttpUtilsCallBack<UserBean>() {
            @Override
            public void success(UserBean baseBean) {
                Log.e("TAG",baseBean.getCode()+"成功");
                getView().success(baseBean);
            }

            @Override
            public void failed() {
                Log.e("TAG","失败");
            }
        },parm);
    }
}
