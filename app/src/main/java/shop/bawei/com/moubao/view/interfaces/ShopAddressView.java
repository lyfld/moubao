package shop.bawei.com.moubao.view.interfaces;

import shop.bawei.com.moubao.model.beans.DelAddressBean;
import shop.bawei.com.moubao.model.beans.ShopingAddressBean;

/**
 * Created by 刘伊帆 on 2017/2/13.
 */

public interface ShopAddressView extends BaseView {
    void success(ShopingAddressBean sab);
    void delSuccess(DelAddressBean delAddressBean);
    void upDataSuccess(DelAddressBean delAddressBean);
}
