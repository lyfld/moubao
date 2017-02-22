package shop.bawei.com.moubao.view.interfaces;

import shop.bawei.com.moubao.model.beans.AddGoodsCarBean;
import shop.bawei.com.moubao.model.beans.DetailsGoodBean;

/**
 * Created by 刘伊帆 on 2017/1/5.
 */

public interface DetailsGoodView extends BaseView {
    void success(DetailsGoodBean bean);
    void onAddGoodsToCarSuccess(AddGoodsCarBean result);
}
