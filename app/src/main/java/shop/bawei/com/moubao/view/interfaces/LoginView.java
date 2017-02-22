package shop.bawei.com.moubao.view.interfaces;

import shop.bawei.com.moubao.model.beans.UserBean;

/**
 * Created by 刘伊帆 on 2017/1/10.
 */

public interface LoginView extends BaseView {
    void success(UserBean baseBean);
}
