package shop.bawei.com.moubao.model.beans;

import java.io.Serializable;

/**
 * Created by 刘伊帆on 2017/2/13.
 */

public class MyBean implements Serializable{
    private String state_desc;
    private String goods_amount;
    private MyOrderBean.DatasBean.OrderGroupListBean.OrderListBean.ExtendOrderGoodsBean mExtendOrderGoodsBean;



    public String getState_desc() {
        return state_desc;
    }

    public void setState_desc(String state_desc) {
        this.state_desc = state_desc;
    }

    public String getGoods_amount() {
        return goods_amount;
    }

    public void setGoods_amount(String goods_amount) {
        this.goods_amount = goods_amount;
    }

    public MyOrderBean.DatasBean.OrderGroupListBean.OrderListBean.ExtendOrderGoodsBean getExtendOrderGoodsBean() {
        return mExtendOrderGoodsBean;
    }



    public void setExtendOrderGoodsBean(MyOrderBean.DatasBean.OrderGroupListBean.OrderListBean.ExtendOrderGoodsBean extendOrderGoodsBean) {
        mExtendOrderGoodsBean = extendOrderGoodsBean;
    }



}
