package shop.bawei.com.moubao.view.interfaces;


import java.util.ArrayList;
import java.util.List;

import shop.bawei.com.moubao.model.beans.CategoryBean;


/**
 * Created by 刘伊帆 on 2016/12/30.
 */

public interface CategoryView extends BaseView{
    public void leftCategory(List<CategoryBean.DatasBean.ClassListBean> list);
    public void rightCateGory(List<CategoryBean.DatasBean.ClassListBean> list);
    public void childCategory(List<CategoryBean.DatasBean.ClassListBean> list,String url);
}
