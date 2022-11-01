package com.e.mademvvm.mvvmnews;

import com.e.mademvvm.mvvmnews.bean.NewBean;

import java.util.List;

/***
 * 多baseurl测试
 */
public  class BaseResponse {

    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"uniquekey":"6c4caa0c3ba6e05e2a272892af43c00e","title":"杨幂的发际线再也回不去了么？网友吐槽像半秃","date":"2017-01-05 11:03","category":"yule","author_name":"腾讯娱乐","url":"http://mini.eastday.com/mobile/170105110355287.html?qid=juheshuju","thumbnail_pic_s":"","thumbnail_pic_s02":" ","thumbnail_pic_s03":" "}]}
     */

//    private String reason;
//    private ResultBean result;
//    private int error_code;
//
//    public int getError_code() {
//        return error_code;
//    }
//
//    public void setError_code(int error_code) {
//        this.error_code = error_code;
//    }
//
//    public String getReason() {
//        return reason;
//    }
//
//    public void setReason(String reason) {
//        this.reason = reason;
//    }
//
//    public ResultBean getResult() {
//        return result;
//    }
//
//    public void setResult(ResultBean result) {
//        this.result = result;
//    }

//    public static class ResultBean {
        /**
         * stat : 1
         * data : [{"uniquekey":"6c4caa0c3ba6e05e2a272892af43c00e","title":"杨幂的发际线再也回不去了么？网友吐槽像半秃","date":"2017-01-05 11:03","category":"yule","author_name":"腾讯娱乐","url":"http://mini.eastday.com/mobile/170105110355287.html?qid=juheshuju","thumbnail_pic_s":"","thumbnail_pic_s02":" ","thumbnail_pic_s03":" "}]
         */

        private String stat;
        private List<Bean> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<Bean> getData() {
            return data;
        }

        public void setData(List<Bean> data) {
            this.data = data;
        }

        public static class Bean {
            /**
             * uniquekey : 6c4caa0c3ba6e05e2a272892af43c00e
             * title : 杨幂的发际线再也回不去了么？网友吐槽像半秃
             * date : 2017-01-05 11:03
             * category : yule
             * author_name : 腾讯娱乐
             * url : http://mini.eastday.com/mobile/170105110355287.html?qid=juheshuju
             * thumbnail_pic_s :
             * thumbnail_pic_s02 :
             * thumbnail_pic_s03 :
             */

            private String date;


            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

        }
//    }
}
