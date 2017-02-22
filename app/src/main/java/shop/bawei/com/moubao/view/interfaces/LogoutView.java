package shop.bawei.com.moubao.view.interfaces;

import shop.bawei.com.moubao.model.beans.MineBean;

/**
 * Created by 刘伊帆 on 2017/1/13.
 */

public interface LogoutView extends BaseView {
    void success(MineBean mb);
    void logout();
}
