package com.example.win.newintern3.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * 实习基地
 * Created by TAO_SX on 2016/7/4/004.
 */
public class BaseEntity implements Serializable{

    /**
     * baselist : [{"basePlanNum":"4","isApply":1,"practiceName":"京胜世纪实习计划","baseIcon":null,"companyName":"北京才聚汇智科技有限公司","basePlanEndTime":"2016-09-10","basePlanStartTime":"2016-06-08","planId":1,"baseId":2,"companyIcon":"http://114.55.2.134:8080/images/cj.jpg","basePlanId":2},{"basePlanNum":"3","isApply":1,"practiceName":"京胜世纪实习计划","baseIcon":null,"companyName":"北京京胜世纪科技有限公司","basePlanEndTime":"2016-09-10","basePlanStartTime":"2016-06-10","planId":1,"baseId":1,"companyIcon":"http://114.55.2.134:8080/images/kingvcn.jpg","basePlanId":1}]
     * start : 2
     * code : 200
     */

    private int start;
    private String code;
    private List<BaselistEntity> baselist;

    public void setStart(int start) {
        this.start = start;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setBaselist(List<BaselistEntity> baselist) {
        this.baselist = baselist;
    }

    public int getStart() {
        return start;
    }

    public String getCode() {
        return code;
    }

    public List<BaselistEntity> getBaselist() {
        return baselist;
    }

    public static class BaselistEntity implements Serializable {
        /**
         * basePlanNum : 4
         * isApply : 1
         * practiceName : 京胜世纪实习计划
         * baseIcon : null
         * companyName : 北京才聚汇智科技有限公司
         * basePlanEndTime : 2016-09-10
         * basePlanStartTime : 2016-06-08
         * planId : 1
         * baseId : 2
         * companyIcon : http://114.55.2.134:8080/images/cj.jpg
         * basePlanId : 2
         */

        private String basePlanNum;
        private int isApply;
        private String practiceName;
        private String baseIcon;
        private String companyName;
        private String basePlanEndTime;
        private String basePlanStartTime;
        private int planId;
        private int baseId;
        private String companyIcon;
        private int basePlanId;

        public void setBasePlanNum(String basePlanNum) {
            this.basePlanNum = basePlanNum;
        }

        public void setIsApply(int isApply) {
            this.isApply = isApply;
        }

        public void setPracticeName(String practiceName) {
            this.practiceName = practiceName;
        }

        public void setBaseIcon(String baseIcon) {
            this.baseIcon = baseIcon;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public void setBasePlanEndTime(String basePlanEndTime) {
            this.basePlanEndTime = basePlanEndTime;
        }

        public void setBasePlanStartTime(String basePlanStartTime) {
            this.basePlanStartTime = basePlanStartTime;
        }

        public void setPlanId(int planId) {
            this.planId = planId;
        }

        public void setBaseId(int baseId) {
            this.baseId = baseId;
        }

        public void setCompanyIcon(String companyIcon) {
            this.companyIcon = companyIcon;
        }

        public void setBasePlanId(int basePlanId) {
            this.basePlanId = basePlanId;
        }

        public String getBasePlanNum() {
            return basePlanNum;
        }

        public int getIsApply() {
            return isApply;
        }

        public String getPracticeName() {
            return practiceName;
        }

        public String getBaseIcon() {
            return baseIcon;
        }

        public String getCompanyName() {
            return companyName;
        }

        public String getBasePlanEndTime() {
            return basePlanEndTime;
        }

        public String getBasePlanStartTime() {
            return basePlanStartTime;
        }

        public int getPlanId() {
            return planId;
        }

        public int getBaseId() {
            return baseId;
        }

        public String getCompanyIcon() {
            return companyIcon;
        }

        public int getBasePlanId() {
            return basePlanId;
        }
    }
}
