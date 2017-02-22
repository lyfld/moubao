package shop.bawei.com.moubao.percent;

import android.content.Context;

import shop.bawei.com.moubao.model.beans.DetailsBean;
import shop.bawei.com.moubao.view.interfaces.DetailsListView;
import shop.bawei.com.moubao.view.interfaces.OkHttpUtilsCallBack;

/**
 * Created by 刘伊帆 on 2017/1/4.
 */

public class DetailsListPercent extends BasePercent<DetailsListView> {
    private Context context;

    public DetailsListPercent(Context context) {
        this.context = context;
    }

    public void loadDataFromNet(String url){
        okHttpUtils.getJson2Bean(url, DetailsBean.class, new OkHttpUtilsCallBack<DetailsBean>() {
            @Override
            public void success(DetailsBean detailsBean) {
                baseView.success(detailsBean);
            }

            @Override
            public void failed() {

            }
        });
    }

    public void haveData(){}

}
