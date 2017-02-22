package shop.bawei.com.moubao.model.beans;

/**
 * Created by 刘伊帆 on 2017/1/11.
 */

public class UserBean extends BaseBean {

    /**
     * code : 200
     * datas : {"username":"aa330011","userid":"3","key":"cdde181e2eb77507925e10af1a425f6d"}
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
         * username : aa330011
         * userid : 3
         * key : cdde181e2eb77507925e10af1a425f6d
         */

        private String username;
        private String userid;
        private String key;
        private String error;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
