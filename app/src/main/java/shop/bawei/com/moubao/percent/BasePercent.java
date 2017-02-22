package shop.bawei.com.moubao.percent;

import shop.bawei.com.moubao.utils.OkHttpUtils;
import shop.bawei.com.moubao.view.interfaces.BaseView;

/**
 * Created by 刘伊帆 on 2016/12/28.
 */

public class BasePercent <T extends BaseView>{
    public T baseView;
    public void attachView(T baseView){
        this.baseView = baseView;
    }

    public T getView(){
        return baseView;
    }
    public OkHttpUtils okHttpUtils;
    {okHttpUtils= OkHttpUtils.getInstance();}

}
