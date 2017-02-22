package shop.bawei.com.moubao.model.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 刘伊帆 on 2017/2/16.
 */

public class BuyBean1 extends BaseBean {


    /**
     * code : 200
     * datas : {"address_api":{"allow_offpay":"0","allow_offpay_batch":{"1":false,"2":false,"4":false},"content":{"1":"0.00"},"no_send_tpl_ids":[],"offpay_hash":"RZE-Q3SrYnUQpXMAjYrerfRaetjot3NyhghOPjA","offpay_hash_batch":"QOQt3P0K3Jg1h9YqdT086A600bG-sUPaGKVAkXx3qNR5ldyFnQcnsA0FFAy5I6gRTGRMHP7","state":"success"},"address_info":{"address":"就看了空间","address_id":"4","area_id":"37","area_info":"北京 北京市 东城区","city_id":"36","dlyp_id":"0","is_default":"1","member_id":"7","mob_phone":"456456","true_name":"456456546"},"freight_hash":"ez0HzWuZcCYUfjO94sXOa5IZEYtKgSQ2mIf9l3-8Zbn7ryT32n93I0So4ycdoIQumHh6ITc85xA90g7nE9sBnRgoztVCYKXkF9sr1iM2c6lz40WpZ8z6Ww72H3SxZ_pz5ruC1jM_pwhsYxAsqQJv0KJ25gVAai98TI3ikYg","ifshow_offpay":true,"inv_info":{"content":"不需要发票"},"order_amount":"70000.00","rpt_info":[],"rpt_list":[],"store_cart_list":{"1":{"freight":"1","goods_list":[{"bl_id":"0","book_down_payment":"0.00","book_down_time":"0","book_final_payment":"0.00","buyer_id":"7","cart_id":"22","contractlist":[],"gc_id":"587","goods_commonid":"100000","goods_freight":"0.00","goods_id":"100000","goods_image":"1_04752627678636481.jpg","goods_image_url":"http://192.168.163.1/data/upload/shop/store/goods/1/1_04752627678636481_240.jpg","goods_name":"劳力士ROLEX-潜航者型 116610-LV-97200自动机械钢带男表联保正品","goods_num":"1","goods_price":"70000.00","goods_storage":"98","goods_storage_alarm":"0","goods_total":"70000.00","goods_vat":"0","have_gift":"0","is_book":"0","is_chain":"0","is_fcode":"0","sole_info":[],"state":true,"storage_state":true,"store_id":"1","store_name":"好商城V5","transport_id":"0"}],"store_goods_total":"70000.00","store_name":"好商城V5","store_voucher_info":[],"store_voucher_list":[]}},"store_final_total_list":{"1":"70000.00"},"vat_hash":"CdG__RE0-oDY_4WcFQE5i8eLivTpmOIJOp3","zk_list":[]}
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
         * address_api : {"allow_offpay":"0","allow_offpay_batch":{"1":false,"2":false,"4":false},"content":{"1":"0.00"},"no_send_tpl_ids":[],"offpay_hash":"RZE-Q3SrYnUQpXMAjYrerfRaetjot3NyhghOPjA","offpay_hash_batch":"QOQt3P0K3Jg1h9YqdT086A600bG-sUPaGKVAkXx3qNR5ldyFnQcnsA0FFAy5I6gRTGRMHP7","state":"success"}
         * address_info : {"address":"就看了空间","address_id":"4","area_id":"37","area_info":"北京 北京市 东城区","city_id":"36","dlyp_id":"0","is_default":"1","member_id":"7","mob_phone":"456456","true_name":"456456546"}
         * freight_hash : ez0HzWuZcCYUfjO94sXOa5IZEYtKgSQ2mIf9l3-8Zbn7ryT32n93I0So4ycdoIQumHh6ITc85xA90g7nE9sBnRgoztVCYKXkF9sr1iM2c6lz40WpZ8z6Ww72H3SxZ_pz5ruC1jM_pwhsYxAsqQJv0KJ25gVAai98TI3ikYg
         * ifshow_offpay : true
         * inv_info : {"content":"不需要发票"}
         * order_amount : 70000.00
         * rpt_info : []
         * rpt_list : []
         * store_cart_list : {"1":{"freight":"1","goods_list":[{"bl_id":"0","book_down_payment":"0.00","book_down_time":"0","book_final_payment":"0.00","buyer_id":"7","cart_id":"22","contractlist":[],"gc_id":"587","goods_commonid":"100000","goods_freight":"0.00","goods_id":"100000","goods_image":"1_04752627678636481.jpg","goods_image_url":"http://192.168.163.1/data/upload/shop/store/goods/1/1_04752627678636481_240.jpg","goods_name":"劳力士ROLEX-潜航者型 116610-LV-97200自动机械钢带男表联保正品","goods_num":"1","goods_price":"70000.00","goods_storage":"98","goods_storage_alarm":"0","goods_total":"70000.00","goods_vat":"0","have_gift":"0","is_book":"0","is_chain":"0","is_fcode":"0","sole_info":[],"state":true,"storage_state":true,"store_id":"1","store_name":"好商城V5","transport_id":"0"}],"store_goods_total":"70000.00","store_name":"好商城V5","store_voucher_info":[],"store_voucher_list":[]}}
         * store_final_total_list : {"1":"70000.00"}
         * vat_hash : CdG__RE0-oDY_4WcFQE5i8eLivTpmOIJOp3
         * zk_list : []
         */

        private AddressApiBean address_api;
        private AddressInfoBean address_info;
        private String freight_hash;
        private boolean ifshow_offpay;
        private InvInfoBean inv_info;
        private String order_amount;
        private StoreCartListBean store_cart_list;
        private StoreFinalTotalListBean store_final_total_list;
        private String vat_hash;
        private List<?> rpt_info;
        private List<?> rpt_list;
        private List<?> zk_list;

        public AddressApiBean getAddress_api() {
            return address_api;
        }

        public void setAddress_api(AddressApiBean address_api) {
            this.address_api = address_api;
        }

        public AddressInfoBean getAddress_info() {
            return address_info;
        }

        public void setAddress_info(AddressInfoBean address_info) {
            this.address_info = address_info;
        }

        public String getFreight_hash() {
            return freight_hash;
        }

        public void setFreight_hash(String freight_hash) {
            this.freight_hash = freight_hash;
        }

        public boolean isIfshow_offpay() {
            return ifshow_offpay;
        }

        public void setIfshow_offpay(boolean ifshow_offpay) {
            this.ifshow_offpay = ifshow_offpay;
        }

        public InvInfoBean getInv_info() {
            return inv_info;
        }

        public void setInv_info(InvInfoBean inv_info) {
            this.inv_info = inv_info;
        }

        public String getOrder_amount() {
            return order_amount;
        }

        public void setOrder_amount(String order_amount) {
            this.order_amount = order_amount;
        }

        public StoreCartListBean getStore_cart_list() {
            return store_cart_list;
        }

        public void setStore_cart_list(StoreCartListBean store_cart_list) {
            this.store_cart_list = store_cart_list;
        }

        public StoreFinalTotalListBean getStore_final_total_list() {
            return store_final_total_list;
        }

        public void setStore_final_total_list(StoreFinalTotalListBean store_final_total_list) {
            this.store_final_total_list = store_final_total_list;
        }

        public String getVat_hash() {
            return vat_hash;
        }

        public void setVat_hash(String vat_hash) {
            this.vat_hash = vat_hash;
        }

        public List<?> getRpt_info() {
            return rpt_info;
        }

        public void setRpt_info(List<?> rpt_info) {
            this.rpt_info = rpt_info;
        }

        public List<?> getRpt_list() {
            return rpt_list;
        }

        public void setRpt_list(List<?> rpt_list) {
            this.rpt_list = rpt_list;
        }

        public List<?> getZk_list() {
            return zk_list;
        }

        public void setZk_list(List<?> zk_list) {
            this.zk_list = zk_list;
        }

        public static class AddressApiBean {
            /**
             * allow_offpay : 0
             * allow_offpay_batch : {"1":false,"2":false,"4":false}
             * content : {"1":"0.00"}
             * no_send_tpl_ids : []
             * offpay_hash : RZE-Q3SrYnUQpXMAjYrerfRaetjot3NyhghOPjA
             * offpay_hash_batch : QOQt3P0K3Jg1h9YqdT086A600bG-sUPaGKVAkXx3qNR5ldyFnQcnsA0FFAy5I6gRTGRMHP7
             * state : success
             */

            private String allow_offpay;
            private AllowOffpayBatchBean allow_offpay_batch;
            private ContentBean content;
            private String offpay_hash;
            private String offpay_hash_batch;
            private String state;
            private List<?> no_send_tpl_ids;

            public String getAllow_offpay() {
                return allow_offpay;
            }

            public void setAllow_offpay(String allow_offpay) {
                this.allow_offpay = allow_offpay;
            }

            public AllowOffpayBatchBean getAllow_offpay_batch() {
                return allow_offpay_batch;
            }

            public void setAllow_offpay_batch(AllowOffpayBatchBean allow_offpay_batch) {
                this.allow_offpay_batch = allow_offpay_batch;
            }

            public ContentBean getContent() {
                return content;
            }

            public void setContent(ContentBean content) {
                this.content = content;
            }

            public String getOffpay_hash() {
                return offpay_hash;
            }

            public void setOffpay_hash(String offpay_hash) {
                this.offpay_hash = offpay_hash;
            }

            public String getOffpay_hash_batch() {
                return offpay_hash_batch;
            }

            public void setOffpay_hash_batch(String offpay_hash_batch) {
                this.offpay_hash_batch = offpay_hash_batch;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public List<?> getNo_send_tpl_ids() {
                return no_send_tpl_ids;
            }

            public void setNo_send_tpl_ids(List<?> no_send_tpl_ids) {
                this.no_send_tpl_ids = no_send_tpl_ids;
            }

            public static class AllowOffpayBatchBean {
                /**
                 * 1 : false
                 * 2 : false
                 * 4 : false
                 */

                @SerializedName("1")
                private boolean _$1;
                @SerializedName("2")
                private boolean _$2;
                @SerializedName("4")
                private boolean _$4;

                public boolean is_$1() {
                    return _$1;
                }

                public void set_$1(boolean _$1) {
                    this._$1 = _$1;
                }

                public boolean is_$2() {
                    return _$2;
                }

                public void set_$2(boolean _$2) {
                    this._$2 = _$2;
                }

                public boolean is_$4() {
                    return _$4;
                }

                public void set_$4(boolean _$4) {
                    this._$4 = _$4;
                }
            }

            public static class ContentBean {
                /**
                 * 1 : 0.00
                 */

                @SerializedName("1")
                private String _$1;

                public String get_$1() {
                    return _$1;
                }

                public void set_$1(String _$1) {
                    this._$1 = _$1;
                }
            }
        }

        public static class AddressInfoBean {
            /**
             * address : 就看了空间
             * address_id : 4
             * area_id : 37
             * area_info : 北京 北京市 东城区
             * city_id : 36
             * dlyp_id : 0
             * is_default : 1
             * member_id : 7
             * mob_phone : 456456
             * true_name : 456456546
             */

            private String address;
            private String address_id;
            private String area_id;
            private String area_info;
            private String city_id;
            private String dlyp_id;
            private String is_default;
            private String member_id;
            private String mob_phone;
            private String true_name;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getAddress_id() {
                return address_id;
            }

            public void setAddress_id(String address_id) {
                this.address_id = address_id;
            }

            public String getArea_id() {
                return area_id;
            }

            public void setArea_id(String area_id) {
                this.area_id = area_id;
            }

            public String getArea_info() {
                return area_info;
            }

            public void setArea_info(String area_info) {
                this.area_info = area_info;
            }

            public String getCity_id() {
                return city_id;
            }

            public void setCity_id(String city_id) {
                this.city_id = city_id;
            }

            public String getDlyp_id() {
                return dlyp_id;
            }

            public void setDlyp_id(String dlyp_id) {
                this.dlyp_id = dlyp_id;
            }

            public String getIs_default() {
                return is_default;
            }

            public void setIs_default(String is_default) {
                this.is_default = is_default;
            }

            public String getMember_id() {
                return member_id;
            }

            public void setMember_id(String member_id) {
                this.member_id = member_id;
            }

            public String getMob_phone() {
                return mob_phone;
            }

            public void setMob_phone(String mob_phone) {
                this.mob_phone = mob_phone;
            }

            public String getTrue_name() {
                return true_name;
            }

            public void setTrue_name(String true_name) {
                this.true_name = true_name;
            }
        }

        public static class InvInfoBean {
            /**
             * content : 不需要发票
             */

            private String content;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        public static class StoreCartListBean {
            /**
             * 1 : {"freight":"1","goods_list":[{"bl_id":"0","book_down_payment":"0.00","book_down_time":"0","book_final_payment":"0.00","buyer_id":"7","cart_id":"22","contractlist":[],"gc_id":"587","goods_commonid":"100000","goods_freight":"0.00","goods_id":"100000","goods_image":"1_04752627678636481.jpg","goods_image_url":"http://192.168.163.1/data/upload/shop/store/goods/1/1_04752627678636481_240.jpg","goods_name":"劳力士ROLEX-潜航者型 116610-LV-97200自动机械钢带男表联保正品","goods_num":"1","goods_price":"70000.00","goods_storage":"98","goods_storage_alarm":"0","goods_total":"70000.00","goods_vat":"0","have_gift":"0","is_book":"0","is_chain":"0","is_fcode":"0","sole_info":[],"state":true,"storage_state":true,"store_id":"1","store_name":"好商城V5","transport_id":"0"}],"store_goods_total":"70000.00","store_name":"好商城V5","store_voucher_info":[],"store_voucher_list":[]}
             */

            @SerializedName("1")
            private _$1Bean _$1;

            public _$1Bean get_$1() {
                return _$1;
            }

            public void set_$1(_$1Bean _$1) {
                this._$1 = _$1;
            }

            public static class _$1Bean {
                /**
                 * freight : 1
                 * goods_list : [{"bl_id":"0","book_down_payment":"0.00","book_down_time":"0","book_final_payment":"0.00","buyer_id":"7","cart_id":"22","contractlist":[],"gc_id":"587","goods_commonid":"100000","goods_freight":"0.00","goods_id":"100000","goods_image":"1_04752627678636481.jpg","goods_image_url":"http://192.168.163.1/data/upload/shop/store/goods/1/1_04752627678636481_240.jpg","goods_name":"劳力士ROLEX-潜航者型 116610-LV-97200自动机械钢带男表联保正品","goods_num":"1","goods_price":"70000.00","goods_storage":"98","goods_storage_alarm":"0","goods_total":"70000.00","goods_vat":"0","have_gift":"0","is_book":"0","is_chain":"0","is_fcode":"0","sole_info":[],"state":true,"storage_state":true,"store_id":"1","store_name":"好商城V5","transport_id":"0"}]
                 * store_goods_total : 70000.00
                 * store_name : 好商城V5
                 * store_voucher_info : []
                 * store_voucher_list : []
                 */

                private String freight;
                private String store_goods_total;
                private String store_name;
                private List<GoodsListBean> goods_list;
                private List<?> store_voucher_info;
                private List<?> store_voucher_list;

                public String getFreight() {
                    return freight;
                }

                public void setFreight(String freight) {
                    this.freight = freight;
                }

                public String getStore_goods_total() {
                    return store_goods_total;
                }

                public void setStore_goods_total(String store_goods_total) {
                    this.store_goods_total = store_goods_total;
                }

                public String getStore_name() {
                    return store_name;
                }

                public void setStore_name(String store_name) {
                    this.store_name = store_name;
                }

                public List<GoodsListBean> getGoods_list() {
                    return goods_list;
                }

                public void setGoods_list(List<GoodsListBean> goods_list) {
                    this.goods_list = goods_list;
                }

                public List<?> getStore_voucher_info() {
                    return store_voucher_info;
                }

                public void setStore_voucher_info(List<?> store_voucher_info) {
                    this.store_voucher_info = store_voucher_info;
                }

                public List<?> getStore_voucher_list() {
                    return store_voucher_list;
                }

                public void setStore_voucher_list(List<?> store_voucher_list) {
                    this.store_voucher_list = store_voucher_list;
                }

                public static class GoodsListBean {
                    /**
                     * bl_id : 0
                     * book_down_payment : 0.00
                     * book_down_time : 0
                     * book_final_payment : 0.00
                     * buyer_id : 7
                     * cart_id : 22
                     * contractlist : []
                     * gc_id : 587
                     * goods_commonid : 100000
                     * goods_freight : 0.00
                     * goods_id : 100000
                     * goods_image : 1_04752627678636481.jpg
                     * goods_image_url : http://192.168.163.1/data/upload/shop/store/goods/1/1_04752627678636481_240.jpg
                     * goods_name : 劳力士ROLEX-潜航者型 116610-LV-97200自动机械钢带男表联保正品
                     * goods_num : 1
                     * goods_price : 70000.00
                     * goods_storage : 98
                     * goods_storage_alarm : 0
                     * goods_total : 70000.00
                     * goods_vat : 0
                     * have_gift : 0
                     * is_book : 0
                     * is_chain : 0
                     * is_fcode : 0
                     * sole_info : []
                     * state : true
                     * storage_state : true
                     * store_id : 1
                     * store_name : 好商城V5
                     * transport_id : 0
                     */

                    private String bl_id;
                    private String book_down_payment;
                    private String book_down_time;
                    private String book_final_payment;
                    private String buyer_id;
                    private String cart_id;
                    private String gc_id;
                    private String goods_commonid;
                    private String goods_freight;
                    private String goods_id;
                    private String goods_image;
                    private String goods_image_url;
                    private String goods_name;
                    private String goods_num;
                    private String goods_price;
                    private String goods_storage;
                    private String goods_storage_alarm;
                    private String goods_total;
                    private String goods_vat;
                    private String have_gift;
                    private String is_book;
                    private String is_chain;
                    private String is_fcode;
                    private boolean state;
                    private boolean storage_state;
                    private String store_id;
                    private String store_name;
                    private String transport_id;
                    private List<?> contractlist;
                    private List<?> sole_info;

                    public String getBl_id() {
                        return bl_id;
                    }

                    public void setBl_id(String bl_id) {
                        this.bl_id = bl_id;
                    }

                    public String getBook_down_payment() {
                        return book_down_payment;
                    }

                    public void setBook_down_payment(String book_down_payment) {
                        this.book_down_payment = book_down_payment;
                    }

                    public String getBook_down_time() {
                        return book_down_time;
                    }

                    public void setBook_down_time(String book_down_time) {
                        this.book_down_time = book_down_time;
                    }

                    public String getBook_final_payment() {
                        return book_final_payment;
                    }

                    public void setBook_final_payment(String book_final_payment) {
                        this.book_final_payment = book_final_payment;
                    }

                    public String getBuyer_id() {
                        return buyer_id;
                    }

                    public void setBuyer_id(String buyer_id) {
                        this.buyer_id = buyer_id;
                    }

                    public String getCart_id() {
                        return cart_id;
                    }

                    public void setCart_id(String cart_id) {
                        this.cart_id = cart_id;
                    }

                    public String getGc_id() {
                        return gc_id;
                    }

                    public void setGc_id(String gc_id) {
                        this.gc_id = gc_id;
                    }

                    public String getGoods_commonid() {
                        return goods_commonid;
                    }

                    public void setGoods_commonid(String goods_commonid) {
                        this.goods_commonid = goods_commonid;
                    }

                    public String getGoods_freight() {
                        return goods_freight;
                    }

                    public void setGoods_freight(String goods_freight) {
                        this.goods_freight = goods_freight;
                    }

                    public String getGoods_id() {
                        return goods_id;
                    }

                    public void setGoods_id(String goods_id) {
                        this.goods_id = goods_id;
                    }

                    public String getGoods_image() {
                        return goods_image;
                    }

                    public void setGoods_image(String goods_image) {
                        this.goods_image = goods_image;
                    }

                    public String getGoods_image_url() {
                        return goods_image_url;
                    }

                    public void setGoods_image_url(String goods_image_url) {
                        this.goods_image_url = goods_image_url;
                    }

                    public String getGoods_name() {
                        return goods_name;
                    }

                    public void setGoods_name(String goods_name) {
                        this.goods_name = goods_name;
                    }

                    public String getGoods_num() {
                        return goods_num;
                    }

                    public void setGoods_num(String goods_num) {
                        this.goods_num = goods_num;
                    }

                    public String getGoods_price() {
                        return goods_price;
                    }

                    public void setGoods_price(String goods_price) {
                        this.goods_price = goods_price;
                    }

                    public String getGoods_storage() {
                        return goods_storage;
                    }

                    public void setGoods_storage(String goods_storage) {
                        this.goods_storage = goods_storage;
                    }

                    public String getGoods_storage_alarm() {
                        return goods_storage_alarm;
                    }

                    public void setGoods_storage_alarm(String goods_storage_alarm) {
                        this.goods_storage_alarm = goods_storage_alarm;
                    }

                    public String getGoods_total() {
                        return goods_total;
                    }

                    public void setGoods_total(String goods_total) {
                        this.goods_total = goods_total;
                    }

                    public String getGoods_vat() {
                        return goods_vat;
                    }

                    public void setGoods_vat(String goods_vat) {
                        this.goods_vat = goods_vat;
                    }

                    public String getHave_gift() {
                        return have_gift;
                    }

                    public void setHave_gift(String have_gift) {
                        this.have_gift = have_gift;
                    }

                    public String getIs_book() {
                        return is_book;
                    }

                    public void setIs_book(String is_book) {
                        this.is_book = is_book;
                    }

                    public String getIs_chain() {
                        return is_chain;
                    }

                    public void setIs_chain(String is_chain) {
                        this.is_chain = is_chain;
                    }

                    public String getIs_fcode() {
                        return is_fcode;
                    }

                    public void setIs_fcode(String is_fcode) {
                        this.is_fcode = is_fcode;
                    }

                    public boolean isState() {
                        return state;
                    }

                    public void setState(boolean state) {
                        this.state = state;
                    }

                    public boolean isStorage_state() {
                        return storage_state;
                    }

                    public void setStorage_state(boolean storage_state) {
                        this.storage_state = storage_state;
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

                    public String getTransport_id() {
                        return transport_id;
                    }

                    public void setTransport_id(String transport_id) {
                        this.transport_id = transport_id;
                    }

                    public List<?> getContractlist() {
                        return contractlist;
                    }

                    public void setContractlist(List<?> contractlist) {
                        this.contractlist = contractlist;
                    }

                    public List<?> getSole_info() {
                        return sole_info;
                    }

                    public void setSole_info(List<?> sole_info) {
                        this.sole_info = sole_info;
                    }
                }
            }
        }

        public static class StoreFinalTotalListBean {
            /**
             * 1 : 70000.00
             */

            @SerializedName("1")
            private String _$1;

            public String get_$1() {
                return _$1;
            }

            public void set_$1(String _$1) {
                this._$1 = _$1;
            }
        }
    }
}
