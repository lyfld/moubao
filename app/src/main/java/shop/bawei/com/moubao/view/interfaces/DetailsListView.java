package shop.bawei.com.moubao.view.interfaces;


import shop.bawei.com.moubao.model.beans.DetailsBean;

/**
 * Created by 刘伊帆 on 2017/1/4.
 */

public interface DetailsListView extends BaseView {
    void success(DetailsBean bean);
    void haveData(DetailsBean bean);

}
