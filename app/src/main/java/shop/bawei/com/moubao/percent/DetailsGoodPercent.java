package shop.bawei.com.moubao.percent;

import android.content.Context;

import shop.bawei.com.moubao.model.beans.DetailsGoodBean;
import shop.bawei.com.moubao.view.interfaces.DetailsGoodView;
import shop.bawei.com.moubao.view.interfaces.OkHttpUtilsCallBack;

/**
 * Created by 刘伊帆 on 2017/1/5.
 */

public class DetailsGoodPercent extends BasePercent<DetailsGoodView> {
    private Context context;

    public DetailsGoodPercent(Context context) {
        this.context = context;
    }

    public void loadDataFromNet(String url){
        okHttpUtils.getJson2Bean(url, DetailsGoodBean.class, new OkHttpUtilsCallBack<DetailsGoodBean>() {
            @Override
            public void success(DetailsGoodBean detailsGoodBean) {
                baseView.success(detailsGoodBean);
            }

            @Override
            public void failed() {

            }
        });

    }
}
