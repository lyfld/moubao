package shop.bawei.com.moubao.model.beans;

import java.util.List;

/**
 * Created by 刘伊帆 on 2017/2/15.
 */

public class BuyBean extends BaseBean {
    /**
     * code : 200
     * hasmore : false
     * page_total : 1
     * datas : {"order_group_list":[{"order_list":[{"order_id":"5","order_sn":"9000000000000701","pay_sn":"710540496610911005","pay_sn1":null,"store_id":"1","store_name":"好商城V5","buyer_id":"5","buyer_name":"mm123...","buyer_email":"qq123@qq.com","buyer_phone":"15831053739","add_time":"1487152610","payment_code":"online","payment_time":"0","finnshed_time":"0","goods_amount":"146300.00","order_amount":"146300.00","rcb_amount":"0.00","pd_amount":"0.00","shipping_fee":"0.00","evaluation_state":"0","evaluation_again_state":"0","order_state":"10","refund_state":"0","lock_state":"0","delete_state":"0","refund_amount":"0.00","delay_time":"0","order_from":"2","shipping_code":"","order_type":"1","api_pay_time":"0","chain_id":"0","chain_code":"0","rpt_amount":"0.00","trade_no":null,"state_desc":"待付款","payment_name":"在线付款","extend_order_goods":[{"goods_id":"100007","goods_name":"劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593","goods_price":"146300.00","goods_num":"1","goods_type":"1","goods_spec":null,"invite_rates":"0","goods_image_url":"http://169.254.75.6/data/upload/shop/store/goods/1/1_04752627900055146_240.png","refund":false}],"zengpin_list":[],"if_cancel":true,"if_refund_cancel":false,"if_receive":false,"if_lock":false,"if_deliver":false,"if_evaluation":false,"if_evaluation_again":false,"if_delete":false,"ownshop":true}],"pay_amount":146300,"add_time":"1487152610","pay_sn":"710540496610911005"},{"order_list":[{"order_id":"4","order_sn":"9000000000000501","pay_sn":"490540491830963005","pay_sn1":null,"store_id":"1","store_name":"好商城V5","buyer_id":"5","buyer_name":"mm123...","buyer_email":"qq123@qq.com","buyer_phone":"15831053739","add_time":"1487147830","payment_code":"predeposit","payment_time":"1487148693","finnshed_time":"0","goods_amount":"178400.00","order_amount":"178400.00","rcb_amount":"0.00","pd_amount":"178400.00","shipping_fee":"0.00","evaluation_state":"0","evaluation_again_state":"0","order_state":"30","refund_state":"0","lock_state":"0","delete_state":"0","refund_amount":"0.00","delay_time":"1487148854","order_from":"2","shipping_code":"5211314748","order_type":"1","api_pay_time":"0","chain_id":"0","chain_code":"0","rpt_amount":"0.00","trade_no":null,"state_desc":"待收货","payment_name":"站内余额支付","extend_order_goods":[{"goods_id":"100003","goods_name":"劳力士Rolex 日志型系列 自动机械钢带男士表 联保正品 116333","goods_price":"89200.00","goods_num":"2","goods_type":"1","goods_spec":null,"invite_rates":"0","refund":true,"goods_image_url":"http://169.254.75.6/data/upload/shop/store/goods/1/1_04752627769865296_240.jpg"}],"zengpin_list":[],"if_cancel":false,"if_refund_cancel":false,"if_receive":true,"if_lock":false,"if_deliver":true,"if_evaluation":false,"if_evaluation_again":false,"if_delete":false,"ownshop":true}],"add_time":"1487147830","pay_sn":"490540491830963005"},{"order_list":[{"order_id":"3","order_sn":"9000000000000401","pay_sn":"670540491655290005","pay_sn1":null,"store_id":"1","store_name":"好商城V5","buyer_id":"5","buyer_name":"mm123...","buyer_email":"qq123@qq.com","buyer_phone":"15831053739","add_time":"1487147655","payment_code":"online","payment_time":"0","finnshed_time":"0","goods_amount":"195600.00","order_amount":"195600.00","rcb_amount":"0.00","pd_amount":"0.00","shipping_fee":"0.00","evaluation_state":"0","evaluation_again_state":"0","order_state":"10","refund_state":"0","lock_state":"0","delete_state":"0","refund_amount":"0.00","delay_time":"0","order_from":"2","shipping_code":"","order_type":"1","api_pay_time":"0","chain_id":"0","chain_code":"0","rpt_amount":"0.00","trade_no":null,"state_desc":"待付款","payment_name":"在线付款","extend_order_goods":[{"goods_id":"100004","goods_name":"劳力士Rolex 日志型系列 自动机械钢带男表 联保正品 116233","goods_price":"97800.00","goods_num":"2","goods_type":"1","goods_spec":null,"invite_rates":"0","goods_image_url":"http://169.254.75.6/data/upload/shop/store/goods/1/1_04752627799921979_240.jpg","refund":false}],"zengpin_list":[],"if_cancel":true,"if_refund_cancel":false,"if_receive":false,"if_lock":false,"if_deliver":false,"if_evaluation":false,"if_evaluation_again":false,"if_delete":false,"ownshop":true}],"pay_amount":195600,"add_time":"1487147655","pay_sn":"670540491655290005"},{"order_list":[{"order_id":"2","order_sn":"9000000000000201","pay_sn":"210540491547431005","pay_sn1":null,"store_id":"1","store_name":"好商城V5","buyer_id":"5","buyer_name":"mm123...","buyer_email":"qq123@qq.com","buyer_phone":"15831053739","add_time":"1487147547","payment_code":"online","payment_time":"0","finnshed_time":"0","goods_amount":"70000.00","order_amount":"70000.00","rcb_amount":"0.00","pd_amount":"0.00","shipping_fee":"0.00","evaluation_state":"0","evaluation_again_state":"0","order_state":"0","refund_state":"0","lock_state":"0","delete_state":"0","refund_amount":"0.00","delay_time":"0","order_from":"2","shipping_code":"","order_type":"1","api_pay_time":"0","chain_id":"0","chain_code":"0","rpt_amount":"0.00","trade_no":null,"state_desc":"已取消","payment_name":"在线付款","extend_order_goods":[{"goods_id":"100000","goods_name":"劳力士ROLEX-潜航者型 116610-LV-97200自动机械钢带男表联保正品","goods_price":"70000.00","goods_num":"1","goods_type":"1","goods_spec":null,"invite_rates":"0","goods_image_url":"http://169.254.75.6/data/upload/shop/store/goods/1/1_04752627678636481_240.jpg","refund":false}],"zengpin_list":[],"if_cancel":false,"if_refund_cancel":false,"if_receive":false,"if_lock":false,"if_deliver":false,"if_evaluation":false,"if_evaluation_again":false,"if_delete":true,"ownshop":true}],"add_time":"1487147547","pay_sn":"210540491547431005"},{"order_list":[{"order_id":"1","order_sn":"9000000000000101","pay_sn":"960540487650763005","pay_sn1":null,"store_id":"1","store_name":"好商城V5","buyer_id":"5","buyer_name":"mm123...","buyer_email":"qq123@qq.com","buyer_phone":"15831053739","add_time":"1487143650","payment_code":"predeposit","payment_time":"1487148913","finnshed_time":"0","goods_amount":"391200.00","order_amount":"391200.00","rcb_amount":"0.00","pd_amount":"391200.00","shipping_fee":"0.00","evaluation_state":"0","evaluation_again_state":"0","order_state":"20","refund_state":"0","lock_state":"0","delete_state":"0","refund_amount":"0.00","delay_time":"0","order_from":"2","shipping_code":"","order_type":"1","api_pay_time":"0","chain_id":"0","chain_code":"0","rpt_amount":"0.00","trade_no":null,"state_desc":"待发货","payment_name":"站内余额支付","extend_order_goods":[{"goods_id":"100004","goods_name":"劳力士Rolex 日志型系列 自动机械钢带男表 联保正品 116233","goods_price":"97800.00","goods_num":"4","goods_type":"1","goods_spec":null,"invite_rates":"0","goods_image_url":"http://169.254.75.6/data/upload/shop/store/goods/1/1_04752627799921979_240.jpg","refund":false}],"refund":"1","zengpin_list":[],"if_cancel":false,"if_refund_cancel":true,"if_receive":false,"if_lock":false,"if_deliver":false,"if_evaluation":false,"if_evaluation_again":false,"if_delete":false,"ownshop":true}],"add_time":"1487143650","pay_sn":"960540487650763005"}]}
     */

    private int code;
    private boolean hasmore;
    private int page_total;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isHasmore() {
        return hasmore;
    }

    public void setHasmore(boolean hasmore) {
        this.hasmore = hasmore;
    }

    public int getPage_total() {
        return page_total;
    }

    public void setPage_total(int page_total) {
        this.page_total = page_total;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        private List<OrderGroupListBean> order_group_list;

        public List<OrderGroupListBean> getOrder_group_list() {
            return order_group_list;
        }

        public void setOrder_group_list(List<OrderGroupListBean> order_group_list) {
            this.order_group_list = order_group_list;
        }

        public static class OrderGroupListBean {
            /**
             * order_list : [{"order_id":"5","order_sn":"9000000000000701","pay_sn":"710540496610911005","pay_sn1":null,"store_id":"1","store_name":"好商城V5","buyer_id":"5","buyer_name":"mm123...","buyer_email":"qq123@qq.com","buyer_phone":"15831053739","add_time":"1487152610","payment_code":"online","payment_time":"0","finnshed_time":"0","goods_amount":"146300.00","order_amount":"146300.00","rcb_amount":"0.00","pd_amount":"0.00","shipping_fee":"0.00","evaluation_state":"0","evaluation_again_state":"0","order_state":"10","refund_state":"0","lock_state":"0","delete_state":"0","refund_amount":"0.00","delay_time":"0","order_from":"2","shipping_code":"","order_type":"1","api_pay_time":"0","chain_id":"0","chain_code":"0","rpt_amount":"0.00","trade_no":null,"state_desc":"待付款","payment_name":"在线付款","extend_order_goods":[{"goods_id":"100007","goods_name":"劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593","goods_price":"146300.00","goods_num":"1","goods_type":"1","goods_spec":null,"invite_rates":"0","goods_image_url":"http://169.254.75.6/data/upload/shop/store/goods/1/1_04752627900055146_240.png","refund":false}],"zengpin_list":[],"if_cancel":true,"if_refund_cancel":false,"if_receive":false,"if_lock":false,"if_deliver":false,"if_evaluation":false,"if_evaluation_again":false,"if_delete":false,"ownshop":true}]
             * pay_amount : 146300
             * add_time : 1487152610
             * pay_sn : 710540496610911005
             */

            private int pay_amount;
            private String add_time;
            private String pay_sn;
            private List<OrderListBean> order_list;

            public int getPay_amount() {
                return pay_amount;
            }

            public void setPay_amount(int pay_amount) {
                this.pay_amount = pay_amount;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getPay_sn() {
                return pay_sn;
            }

            public void setPay_sn(String pay_sn) {
                this.pay_sn = pay_sn;
            }

            public List<OrderListBean> getOrder_list() {
                return order_list;
            }

            public void setOrder_list(List<OrderListBean> order_list) {
                this.order_list = order_list;
            }

            public static class OrderListBean {
                /**
                 * order_id : 5
                 * order_sn : 9000000000000701
                 * pay_sn : 710540496610911005
                 * pay_sn1 : null
                 * store_id : 1
                 * store_name : 好商城V5
                 * buyer_id : 5
                 * buyer_name : mm123...
                 * buyer_email : qq123@qq.com
                 * buyer_phone : 15831053739
                 * add_time : 1487152610
                 * payment_code : online
                 * payment_time : 0
                 * finnshed_time : 0
                 * goods_amount : 146300.00
                 * order_amount : 146300.00
                 * rcb_amount : 0.00
                 * pd_amount : 0.00
                 * shipping_fee : 0.00
                 * evaluation_state : 0
                 * evaluation_again_state : 0
                 * order_state : 10
                 * refund_state : 0
                 * lock_state : 0
                 * delete_state : 0
                 * refund_amount : 0.00
                 * delay_time : 0
                 * order_from : 2
                 * shipping_code :
                 * order_type : 1
                 * api_pay_time : 0
                 * chain_id : 0
                 * chain_code : 0
                 * rpt_amount : 0.00
                 * trade_no : null
                 * state_desc : 待付款
                 * payment_name : 在线付款
                 * extend_order_goods : [{"goods_id":"100007","goods_name":"劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593","goods_price":"146300.00","goods_num":"1","goods_type":"1","goods_spec":null,"invite_rates":"0","goods_image_url":"http://169.254.75.6/data/upload/shop/store/goods/1/1_04752627900055146_240.png","refund":false}]
                 * zengpin_list : []
                 * if_cancel : true
                 * if_refund_cancel : false
                 * if_receive : false
                 * if_lock : false
                 * if_deliver : false
                 * if_evaluation : false
                 * if_evaluation_again : false
                 * if_delete : false
                 * ownshop : true
                 */

                private String order_id;
                private String order_sn;
                private String pay_sn;
                private Object pay_sn1;
                private String store_id;
                private String store_name;
                private String buyer_id;
                private String buyer_name;
                private String buyer_email;
                private String buyer_phone;
                private String add_time;
                private String payment_code;
                private String payment_time;
                private String finnshed_time;
                private String goods_amount;
                private String order_amount;
                private String rcb_amount;
                private String pd_amount;
                private String shipping_fee;
                private String evaluation_state;
                private String evaluation_again_state;
                private String order_state;
                private String refund_state;
                private String lock_state;
                private String delete_state;
                private String refund_amount;
                private String delay_time;
                private String order_from;
                private String shipping_code;
                private String order_type;
                private String api_pay_time;
                private String chain_id;
                private String chain_code;
                private String rpt_amount;
                private Object trade_no;
                private String state_desc;
                private String payment_name;
                private boolean if_cancel;
                private boolean if_refund_cancel;
                private boolean if_receive;
                private boolean if_lock;
                private boolean if_deliver;
                private boolean if_evaluation;
                private boolean if_evaluation_again;
                private boolean if_delete;
                private boolean ownshop;
                private List<ExtendOrderGoodsBean> extend_order_goods;
                private List<?> zengpin_list;

                public String getOrder_id() {
                    return order_id;
                }

                public void setOrder_id(String order_id) {
                    this.order_id = order_id;
                }

                public String getOrder_sn() {
                    return order_sn;
                }

                public void setOrder_sn(String order_sn) {
                    this.order_sn = order_sn;
                }

                public String getPay_sn() {
                    return pay_sn;
                }

                public void setPay_sn(String pay_sn) {
                    this.pay_sn = pay_sn;
                }

                public Object getPay_sn1() {
                    return pay_sn1;
                }

                public void setPay_sn1(Object pay_sn1) {
                    this.pay_sn1 = pay_sn1;
                }

                public String getStore_id() {
                    return store_id;
                }

                public void setStore_id(String store_id) {
                    this.store_id = store_id;
                }

                public String getStore_name() {
                    return store_name;
                }

                public void setStore_name(String store_name) {
                    this.store_name = store_name;
                }

                public String getBuyer_id() {
                    return buyer_id;
                }

                public void setBuyer_id(String buyer_id) {
                    this.buyer_id = buyer_id;
                }

                public String getBuyer_name() {
                    return buyer_name;
                }

                public void setBuyer_name(String buyer_name) {
                    this.buyer_name = buyer_name;
                }

                public String getBuyer_email() {
                    return buyer_email;
                }

                public void setBuyer_email(String buyer_email) {
                    this.buyer_email = buyer_email;
                }

                public String getBuyer_phone() {
                    return buyer_phone;
                }

                public void setBuyer_phone(String buyer_phone) {
                    this.buyer_phone = buyer_phone;
                }

                public String getAdd_time() {
                    return add_time;
                }

                public void setAdd_time(String add_time) {
                    this.add_time = add_time;
                }

                public String getPayment_code() {
                    return payment_code;
                }

                public void setPayment_code(String payment_code) {
                    this.payment_code = payment_code;
                }

                public String getPayment_time() {
                    return payment_time;
                }

                public void setPayment_time(String payment_time) {
                    this.payment_time = payment_time;
                }

                public String getFinnshed_time() {
                    return finnshed_time;
                }

                public void setFinnshed_time(String finnshed_time) {
                    this.finnshed_time = finnshed_time;
                }

                public String getGoods_amount() {
                    return goods_amount;
                }

                public void setGoods_amount(String goods_amount) {
                    this.goods_amount = goods_amount;
                }

                public String getOrder_amount() {
                    return order_amount;
                }

                public void setOrder_amount(String order_amount) {
                    this.order_amount = order_amount;
                }

                public String getRcb_amount() {
                    return rcb_amount;
                }

                public void setRcb_amount(String rcb_amount) {
                    this.rcb_amount = rcb_amount;
                }

                public String getPd_amount() {
                    return pd_amount;
                }

                public void setPd_amount(String pd_amount) {
                    this.pd_amount = pd_amount;
                }

                public String getShipping_fee() {
                    return shipping_fee;
                }

                public void setShipping_fee(String shipping_fee) {
                    this.shipping_fee = shipping_fee;
                }

                public String getEvaluation_state() {
                    return evaluation_state;
                }

                public void setEvaluation_state(String evaluation_state) {
                    this.evaluation_state = evaluation_state;
                }

                public String getEvaluation_again_state() {
                    return evaluation_again_state;
                }

                public void setEvaluation_again_state(String evaluation_again_state) {
                    this.evaluation_again_state = evaluation_again_state;
                }

                public String getOrder_state() {
                    return order_state;
                }

                public void setOrder_state(String order_state) {
                    this.order_state = order_state;
                }

                public String getRefund_state() {
                    return refund_state;
                }

                public void setRefund_state(String refund_state) {
                    this.refund_state = refund_state;
                }

                public String getLock_state() {
                    return lock_state;
                }

                public void setLock_state(String lock_state) {
                    this.lock_state = lock_state;
                }

                public String getDelete_state() {
                    return delete_state;
                }

                public void setDelete_state(String delete_state) {
                    this.delete_state = delete_state;
                }

                public String getRefund_amount() {
                    return refund_amount;
                }

                public void setRefund_amount(String refund_amount) {
                    this.refund_amount = refund_amount;
                }

                public String getDelay_time() {
                    return delay_time;
                }

                public void setDelay_time(String delay_time) {
                    this.delay_time = delay_time;
                }

                public String getOrder_from() {
                    return order_from;
                }

                public void setOrder_from(String order_from) {
                    this.order_from = order_from;
                }

                public String getShipping_code() {
                    return shipping_code;
                }

                public void setShipping_code(String shipping_code) {
                    this.shipping_code = shipping_code;
                }

                public String getOrder_type() {
                    return order_type;
                }

                public void setOrder_type(String order_type) {
                    this.order_type = order_type;
                }

                public String getApi_pay_time() {
                    return api_pay_time;
                }

                public void setApi_pay_time(String api_pay_time) {
                    this.api_pay_time = api_pay_time;
                }

                public String getChain_id() {
                    return chain_id;
                }

                public void setChain_id(String chain_id) {
                    this.chain_id = chain_id;
                }

                public String getChain_code() {
                    return chain_code;
                }

                public void setChain_code(String chain_code) {
                    this.chain_code = chain_code;
                }

                public String getRpt_amount() {
                    return rpt_amount;
                }

                public void setRpt_amount(String rpt_amount) {
                    this.rpt_amount = rpt_amount;
                }

                public Object getTrade_no() {
                    return trade_no;
                }

                public void setTrade_no(Object trade_no) {
                    this.trade_no = trade_no;
                }

                public String getState_desc() {
                    return state_desc;
                }

                public void setState_desc(String state_desc) {
                    this.state_desc = state_desc;
                }

                public String getPayment_name() {
                    return payment_name;
                }

                public void setPayment_name(String payment_name) {
                    this.payment_name = payment_name;
                }

                public boolean isIf_cancel() {
                    return if_cancel;
                }

                public void setIf_cancel(boolean if_cancel) {
                    this.if_cancel = if_cancel;
                }

                public boolean isIf_refund_cancel() {
                    return if_refund_cancel;
                }

                public void setIf_refund_cancel(boolean if_refund_cancel) {
                    this.if_refund_cancel = if_refund_cancel;
                }

                public boolean isIf_receive() {
                    return if_receive;
                }

                public void setIf_receive(boolean if_receive) {
                    this.if_receive = if_receive;
                }

                public boolean isIf_lock() {
                    return if_lock;
                }

                public void setIf_lock(boolean if_lock) {
                    this.if_lock = if_lock;
                }

                public boolean isIf_deliver() {
                    return if_deliver;
                }

                public void setIf_deliver(boolean if_deliver) {
                    this.if_deliver = if_deliver;
                }

                public boolean isIf_evaluation() {
                    return if_evaluation;
                }

                public void setIf_evaluation(boolean if_evaluation) {
                    this.if_evaluation = if_evaluation;
                }

                public boolean isIf_evaluation_again() {
                    return if_evaluation_again;
                }

                public void setIf_evaluation_again(boolean if_evaluation_again) {
                    this.if_evaluation_again = if_evaluation_again;
                }

                public boolean isIf_delete() {
                    return if_delete;
                }

                public void setIf_delete(boolean if_delete) {
                    this.if_delete = if_delete;
                }

                public boolean isOwnshop() {
                    return ownshop;
                }

                public void setOwnshop(boolean ownshop) {
                    this.ownshop = ownshop;
                }

                public List<ExtendOrderGoodsBean> getExtend_order_goods() {
                    return extend_order_goods;
                }

                public void setExtend_order_goods(List<ExtendOrderGoodsBean> extend_order_goods) {
                    this.extend_order_goods = extend_order_goods;
                }

                public List<?> getZengpin_list() {
                    return zengpin_list;
                }

                public void setZengpin_list(List<?> zengpin_list) {
                    this.zengpin_list = zengpin_list;
                }

                public static class ExtendOrderGoodsBean {
                    /**
                     * goods_id : 100007
                     * goods_name : 劳力士Rolex 蚝式恒动系列自动机械钢带男表正品116523-8DI-78593
                     * goods_price : 146300.00
                     * goods_num : 1
                     * goods_type : 1
                     * goods_spec : null
                     * invite_rates : 0
                     * goods_image_url : http://169.254.75.6/data/upload/shop/store/goods/1/1_04752627900055146_240.png
                     * refund : false
                     */

                    private String goods_id;
                    private String goods_name;
                    private String goods_price;
                    private String goods_num;
                    private String goods_type;
                    private Object goods_spec;
                    private String invite_rates;
                    private String goods_image_url;
                    private boolean refund;

                    public String getGoods_id() {
                        return goods_id;
                    }

                    public void setGoods_id(String goods_id) {
                        this.goods_id = goods_id;
                    }

                    public String getGoods_name() {
                        return goods_name;
                    }

                    public void setGoods_name(String goods_name) {
                        this.goods_name = goods_name;
                    }

                    public String getGoods_price() {
                        return goods_price;
                    }

                    public void setGoods_price(String goods_price) {
                        this.goods_price = goods_price;
                    }

                    public String getGoods_num() {
                        return goods_num;
                    }

                    public void setGoods_num(String goods_num) {
                        this.goods_num = goods_num;
                    }

                    public String getGoods_type() {
                        return goods_type;
                    }

                    public void setGoods_type(String goods_type) {
                        this.goods_type = goods_type;
                    }

                    public Object getGoods_spec() {
                        return goods_spec;
                    }

                    public void setGoods_spec(Object goods_spec) {
                        this.goods_spec = goods_spec;
                    }

                    public String getInvite_rates() {
                        return invite_rates;
                    }

                    public void setInvite_rates(String invite_rates) {
                        this.invite_rates = invite_rates;
                    }

                    public String getGoods_image_url() {
                        return goods_image_url;
                    }

                    public void setGoods_image_url(String goods_image_url) {
                        this.goods_image_url = goods_image_url;
                    }

                    public boolean isRefund() {
                        return refund;
                    }

                    public void setRefund(boolean refund) {
                        this.refund = refund;
                    }
                }
            }
        }
    }
}
