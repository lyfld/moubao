package shop.bawei.com.moubao.model.beans;

/**
 * Created by 刘伊帆 on 2017/2/16.
 */

public class IndentBean extends BaseBean {

    /**
     * code : 200
     * datas : {"pay_sn":"850540585983120007","payment_code":"online"}
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * pay_sn : 850540585983120007
         * payment_code : online
         */

        private String pay_sn;
        private String payment_code;

        public String getPay_sn() {
            return pay_sn;
        }

        public void setPay_sn(String pay_sn) {
            this.pay_sn = pay_sn;
        }

        public String getPayment_code() {
            return payment_code;
        }

        public void setPayment_code(String payment_code) {
            this.payment_code = payment_code;
        }
    }
}
