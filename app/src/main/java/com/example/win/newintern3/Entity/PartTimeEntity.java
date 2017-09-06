package com.example.win.newintern3.Entity;

import java.util.List;

/**
 * Created by TAO_SX on 2016/8/10/010.
 */
public class PartTimeEntity {

    /**
     * parttimelist : [{"partTimePostTime":"2016-08-08 15:48:23","partTimePostMoney":"10000-14999/月","partTimePostStartTime":"2016年8月","companyName":"北京京胜世纪科技有限公司","partTimePostId":"691fbc35000001c0","companyIcon":"http://114.55.2.134:8080/images/kingvcn.jpg","partTimePostTitle":"软件工程师1","partTimePostEndTime":"2016年9月"},{"partTimePostTime":"2016-08-08 15:48:23","partTimePostMoney":"10000-14999/月","partTimePostStartTime":"2016年8月","companyName":"北京京胜世纪科技有限公司","partTimePostId":"691fbc35000002c0","companyIcon":"http://114.55.2.134:8080/images/kingvcn.jpg","partTimePostTitle":"软件工程师2","partTimePostEndTime":"2016年9月"},{"partTimePostTime":"2016-08-08 15:48:22","partTimePostMoney":"10000-14999/月","partTimePostStartTime":"2016年8月","companyName":"北京京胜世纪科技有限公司","partTimePostId":"691fbc35000000c0","companyIcon":"http://114.55.2.134:8080/images/kingvcn.jpg","partTimePostTitle":"软件工程师0","partTimePostEndTime":"2016年9月"}]
     * start : 3
     * code : 200
     */

    private int start;
    private String code;
    /**
     * partTimePostTime : 2016-08-08 15:48:23
     * partTimePostMoney : 10000-14999/月
     * partTimePostStartTime : 2016年8月
     * companyName : 北京京胜世纪科技有限公司
     * partTimePostId : 691fbc35000001c0
     * companyIcon : http://114.55.2.134:8080/images/kingvcn.jpg
     * partTimePostTitle : 软件工程师1
     * partTimePostEndTime : 2016年9月
     */

    private List<ParttimelistEntity> parttimelist;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ParttimelistEntity> getParttimelist() {
        return parttimelist;
    }

    public void setParttimelist(List<ParttimelistEntity> parttimelist) {
        this.parttimelist = parttimelist;
    }

    public static class ParttimelistEntity {
        private String partTimePostTime;
        private String partTimePostMoney;
        private String partTimePostStartTime;
        private String companyName;
        private String partTimePostId;
        private String companyIcon;
        private String partTimePostTitle;
        private String partTimePostEndTime;

        public String getPartTimePostTime() {
            return partTimePostTime;
        }

        public void setPartTimePostTime(String partTimePostTime) {
            this.partTimePostTime = partTimePostTime;
        }

        public String getPartTimePostMoney() {
            return partTimePostMoney;
        }

        public void setPartTimePostMoney(String partTimePostMoney) {
            this.partTimePostMoney = partTimePostMoney;
        }

        public String getPartTimePostStartTime() {
            return partTimePostStartTime;
        }

        public void setPartTimePostStartTime(String partTimePostStartTime) {
            this.partTimePostStartTime = partTimePostStartTime;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getPartTimePostId() {
            return partTimePostId;
        }

        public void setPartTimePostId(String partTimePostId) {
            this.partTimePostId = partTimePostId;
        }

        public String getCompanyIcon() {
            return companyIcon;
        }

        public void setCompanyIcon(String companyIcon) {
            this.companyIcon = companyIcon;
        }

        public String getPartTimePostTitle() {
            return partTimePostTitle;
        }

        public void setPartTimePostTitle(String partTimePostTitle) {
            this.partTimePostTitle = partTimePostTitle;
        }

        public String getPartTimePostEndTime() {
            return partTimePostEndTime;
        }

        public void setPartTimePostEndTime(String partTimePostEndTime) {
            this.partTimePostEndTime = partTimePostEndTime;
        }
    }
}
