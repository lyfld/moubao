package shop.bawei.com.moubao.model.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 刘伊帆 on 2017/1/11.
 */

public class MineBean extends BaseBean {

    /**
     * code : 200
     * datas : {"member_info":{"user_name":"a330011","avatar":"http://192.168.163.1/data/upload/shop/common/default_user_portrait.gif","level_name":"V0","favorites_store":0,"favorites_goods":1,"order_nopay_count":"0","order_noreceipt_count":"0","order_notakes_count":"0","order_noeval_count":"0","return":"0"}}
     */

    private int code;
    private String login;
    private DatasBean datas;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

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
         * member_info : {"user_name":"a330011","avatar":"http://192.168.163.1/data/upload/shop/common/default_user_portrait.gif","level_name":"V0","favorites_store":0,"favorites_goods":1,"order_nopay_count":"0","order_noreceipt_count":"0","order_notakes_count":"0","order_noeval_count":"0","return":"0"}
         */
        private String error;
        private MemberInfoBean member_info;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public MemberInfoBean getMember_info() {
            return member_info;
        }

        public void setMember_info(MemberInfoBean member_info) {
            this.member_info = member_info;
        }

        public static class MemberInfoBean {
            /**
             * user_name : a330011
             * avatar : http://192.168.163.1/data/upload/shop/common/default_user_portrait.gif
             * level_name : V0
             * favorites_store : 0
             * favorites_goods : 1
             * order_nopay_count : 0
             * order_noreceipt_count : 0
             * order_notakes_count : 0
             * order_noeval_count : 0
             * return : 0
             */

            private String user_name;
            private String avatar;
            private String level_name;
            private int favorites_store;
            private int favorites_goods;
            private String order_nopay_count;
            private String order_noreceipt_count;
            private String order_notakes_count;
            private String order_noeval_count;
            @SerializedName("return")
            private String returnX;

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getLevel_name() {
                return level_name;
            }

            public void setLevel_name(String level_name) {
                this.level_name = level_name;
            }

            public int getFavorites_store() {
                return favorites_store;
            }

            public void setFavorites_store(int favorites_store) {
                this.favorites_store = favorites_store;
            }

            public int getFavorites_goods() {
                return favorites_goods;
            }

            public void setFavorites_goods(int favorites_goods) {
                this.favorites_goods = favorites_goods;
            }

            public String getOrder_nopay_count() {
                return order_nopay_count;
            }

            public void setOrder_nopay_count(String order_nopay_count) {
                this.order_nopay_count = order_nopay_count;
            }

            public String getOrder_noreceipt_count() {
                return order_noreceipt_count;
            }

            public void setOrder_noreceipt_count(String order_noreceipt_count) {
                this.order_noreceipt_count = order_noreceipt_count;
            }

            public String getOrder_notakes_count() {
                return order_notakes_count;
            }

            public void setOrder_notakes_count(String order_notakes_count) {
                this.order_notakes_count = order_notakes_count;
            }

            public String getOrder_noeval_count() {
                return order_noeval_count;
            }

            public void setOrder_noeval_count(String order_noeval_count) {
                this.order_noeval_count = order_noeval_count;
            }

            public String getReturnX() {
                return returnX;
            }

            public void setReturnX(String returnX) {
                this.returnX = returnX;
            }
        }
    }
}
