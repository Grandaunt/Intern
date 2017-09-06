package com.example.win.newintern3.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by TAO_SX on 2016/7/6/006.
 */
public class BaseMenuPlanEntity implements Serializable
{
    /**
     * code : 200
     * practiceplanlist : [{"creator":"王明","practiceName":"2016年毕业实习","planStartTime":"2016-12-1","createTime":"2016-07-05","departmentId":1,"planId":2,"planEndTime":"2017-06-1","userId":1},{"creator":"王明","practiceName":"2016年暑期实习","planStartTime":"2016-06-01","createTime":"2016-05-21","departmentId":1,"planId":1,"planEndTime":"2016-09-30","userId":1}]
     */

    private String code;
    /**
     * creator : 王明
     * practiceName : 2016年毕业实习
     * planStartTime : 2016-12-1
     * createTime : 2016-07-05
     * departmentId : 1
     * planId : 2
     * planEndTime : 2017-06-1
     * userId : 1
     */

    private List<PracticeplanlistEntity> practiceplanlist;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<PracticeplanlistEntity> getPracticeplanlist() {
        return practiceplanlist;
    }

    public void setPracticeplanlist(List<PracticeplanlistEntity> practiceplanlist) {
        this.practiceplanlist = practiceplanlist;
    }

    public static class PracticeplanlistEntity implements Serializable {
        private String creator;
        private String practiceName;
        private String planStartTime;
        private String createTime;
        private int departmentId;
        private int planId;
        private String planEndTime;
        private int userId;

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getPracticeName() {
            return practiceName;
        }

        public void setPracticeName(String practiceName) {
            this.practiceName = practiceName;
        }

        public String getPlanStartTime() {
            return planStartTime;
        }

        public void setPlanStartTime(String planStartTime) {
            this.planStartTime = planStartTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public int getPlanId() {
            return planId;
        }

        public void setPlanId(int planId) {
            this.planId = planId;
        }

        public String getPlanEndTime() {
            return planEndTime;
        }

        public void setPlanEndTime(String planEndTime) {
            this.planEndTime = planEndTime;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
