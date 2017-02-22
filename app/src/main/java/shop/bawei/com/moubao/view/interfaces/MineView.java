package shop.bawei.com.moubao.view.interfaces;

import shop.bawei.com.moubao.model.beans.MineBean;
import shop.bawei.com.moubao.model.beans.MyOrderBean;

/**
 * Created by 刘伊帆 on 2017/1/11.
 */

public interface MineView extends BaseView {
    void success(MineBean mb);
    void successorde(MyOrderBean orderBean);
}
