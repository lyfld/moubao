package shop.bawei.com.moubao.view.interfaces;

import shop.bawei.com.moubao.model.beans.AddressBean;
import shop.bawei.com.moubao.model.beans.DelAddressBean;

/**
 * Created by 刘伊帆 on 2017/2/10.
 */

public interface AddAddressView extends BaseView{
    void addAddressSuccess(AddressBean addressBean);
    void getProvince(AddressBean addressBean);
    void getCity(AddressBean addressBean);
    void getDistrict(AddressBean addressBean);
    void upData(DelAddressBean addressBean);
}
