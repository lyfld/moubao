package shop.bawei.com.moubao.view.interfaces;

import shop.bawei.com.moubao.model.beans.BuyBean1;
import shop.bawei.com.moubao.model.beans.CartBean;
import shop.bawei.com.moubao.model.beans.IndentBean;
import shop.bawei.com.moubao.model.beans.ShopingAddressBean;

/**
 * Created by 刘伊帆 on 2017/2/15.
 */

public interface BuyView extends BaseView {
    void success(CartBean cartBean);
    void addressSuccess(ShopingAddressBean shopingAddressBean);
    void indentSuccess(IndentBean indentBean);
    void buyBean(BuyBean1 buyBean1);
}
