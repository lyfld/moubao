package shop.bawei.com.moubao.model.beans;

import java.util.List;

/**
 * Created by 刘伊帆 on 2017/2/10.
 */

public class AddressBean {

    /**
     * code : 200
     * datas : {"area_list":[{"area_id":"1","area_name":"北京"},{"area_id":"2","area_name":"天津"},{"area_id":"3","area_name":"河北"},{"area_id":"4","area_name":"山西"},{"area_id":"5","area_name":"内蒙古"},{"area_id":"6","area_name":"辽宁"},{"area_id":"7","area_name":"吉林"},{"area_id":"8","area_name":"黑龙江"},{"area_id":"9","area_name":"上海"},{"area_id":"10","area_name":"江苏"},{"area_id":"11","area_name":"浙江"},{"area_id":"12","area_name":"安徽"},{"area_id":"13","area_name":"福建"},{"area_id":"14","area_name":"江西"},{"area_id":"15","area_name":"山东"},{"area_id":"16","area_name":"河南"},{"area_id":"17","area_name":"湖北"},{"area_id":"18","area_name":"湖南"},{"area_id":"19","area_name":"广东"},{"area_id":"20","area_name":"广西"},{"area_id":"21","area_name":"海南"},{"area_id":"22","area_name":"重庆"},{"area_id":"23","area_name":"四川"},{"area_id":"24","area_name":"贵州"},{"area_id":"25","area_name":"云南"},{"area_id":"26","area_name":"西藏"},{"area_id":"27","area_name":"陕西"},{"area_id":"28","area_name":"甘肃"},{"area_id":"29","area_name":"青海"},{"area_id":"30","area_name":"宁夏"},{"area_id":"31","area_name":"新疆"},{"area_id":"32","area_name":"台湾"},{"area_id":"33","area_name":"香港"},{"area_id":"34","area_name":"澳门"},{"area_id":"35","area_name":"海外"}]}
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
        private List<AreaListBean> area_list;

        private int address_id;

        public int getAddress_id() {
            return address_id;
        }

        public void setAddress_id(int address_id) {
            this.address_id = address_id;
        }
        public List<AreaListBean> getArea_list() {
            return area_list;
        }

        public void setArea_list(List<AreaListBean> area_list) {
            this.area_list = area_list;
        }

        public static class AreaListBean {
            /**
             * area_id : 1
             * area_name : 北京
             */

            private String area_id;
            private String area_name;

            public String getArea_id() {
                return area_id;
            }

            public void setArea_id(String area_id) {
                this.area_id = area_id;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }
        }
    }
}
