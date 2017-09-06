package com.example.win.newintern3.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * 我的申请数据实体
 * Created by TAO_SX on 2016/7/11/011.
 */
public class MyApplyEntity implements Serializable {

    /**
     * start : 7
     * applylist : [{"applyId":"cdc0878000000972","practiceName":"2016年暑期实习","checkTime":null,"companyName":"基地2","planId":1,"checker":null,"applyTime":"2016-07-10 20:40:33","userId":1,"practiceType":1,"applyStatus":1},{"applyId":"cdc0878000000f72","practiceName":"2016年暑期实习","checkTime":null,"companyName":"11","planId":1,"checker":null,"applyTime":"2016-07-11 10:42:30","userId":1,"practiceType":2,"applyStatus":1},{"applyId":"cdc0878000000e72","practiceName":"2016年暑期实习","checkTime":null,"companyName":"11","planId":1,"checker":null,"applyTime":"2016-07-11 10:42:23","userId":1,"practiceType":2,"applyStatus":1},{"applyId":"cdc0878000000d72","practiceName":"2016年暑期实习","checkTime":null,"companyName":"11","planId":1,"checker":null,"applyTime":"2016-07-11 10:42:12","userId":1,"practiceType":2,"applyStatus":1},{"applyId":"cdc0878000000c72","practiceName":"2016年暑期实习","checkTime":null,"companyName":"dmlasl;","planId":1,"checker":null,"applyTime":"2016-07-10 22:12:11","userId":1,"practiceType":2,"applyStatus":1},{"applyId":"cdc0878000000b72","practiceName":"2016年暑期实习","checkTime":null,"companyName":"北京京胜世纪科技有限公司","planId":1,"checker":null,"applyTime":"2016-07-10 21:57:36","userId":1,"practiceType":2,"applyStatus":1},{"applyId":"cdc0878000000a72","practiceName":"2016年暑期实习","checkTime":null,"companyName":"北京京胜世纪科技有限公司","planId":1,"checker":null,"applyTime":"2016-07-10 21:57:34","userId":1,"practiceType":2,"applyStatus":1}]
     * code : 200
     */

    private int start;
    private String code;
    /**
     * applyId : cdc0878000000972
     * practiceName : 2016年暑期实习
     * checkTime : null
     * companyName : 基地2
     * planId : 1
     * checker : null
     * applyTime : 2016-07-10 20:40:33
     * userId : 1
     * practiceType : 1
     * applyStatus : 1
     */

    private List<ApplylistEntity> applylist;

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

    public List<ApplylistEntity> getApplylist() {
        return applylist;
    }

    public void setApplylist(List<ApplylistEntity> applylist) {
        this.applylist = applylist;
    }

    public static class ApplylistEntity implements Serializable {
        private String applyId;
        private String practiceName;
        private String checkTime;
        private String companyName;
        private int planId;
        private String checker;
        private String applyTime;
        private int userId;
        private int practiceType;
        private int applyStatus;
        private String companyIcon;

        public String getCompanyIcon() {
            return companyIcon;
        }

        public void setCompanyIcon(String companyIcon) {
            this.companyIcon = companyIcon;
        }

        public String getApplyId() {
            return applyId;
        }

        public void setApplyId(String applyId) {
            this.applyId = applyId;
        }

        public String getPracticeName() {
            return practiceName;
        }

        public void setPracticeName(String practiceName) {
            this.practiceName = practiceName;
        }

        public String getCheckTime() {
            return checkTime;
        }

        public void setCheckTime(String checkTime) {
            this.checkTime = checkTime;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public int getPlanId() {
            return planId;
        }

        public void setPlanId(int planId) {
            this.planId = planId;
        }

        public String getChecker() {
            return checker;
        }

        public void setChecker(String checker) {
            this.checker = checker;
        }

        public String getApplyTime() {
            return applyTime;
        }

        public void setApplyTime(String applyTime) {
            this.applyTime = applyTime;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getPracticeType() {
            return practiceType;
        }

        public void setPracticeType(int practiceType) {
            this.practiceType = practiceType;
        }

        public int getApplyStatus() {
            return applyStatus;
        }

        public void setApplyStatus(int applyStatus) {
            this.applyStatus = applyStatus;
        }
    }
}
