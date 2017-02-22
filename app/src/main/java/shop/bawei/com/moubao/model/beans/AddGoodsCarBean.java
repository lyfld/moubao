package shop.bawei.com.moubao.model.beans;

/**
 * Created by 曹建树 on 2017/1/16.
 */

public class AddGoodsCarBean {
    /**
     * code : 200
     * datas : 1
     */

    private int code;
    private String datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "AddShopCarBean{" +
                "code=" + code +
                ", datas='" + datas + '\'' +
                '}';
    }
}
