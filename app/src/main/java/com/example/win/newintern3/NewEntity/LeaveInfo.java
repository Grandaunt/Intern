package com.example.win.newintern3.NewEntity;

public class LeaveInfo implements java.io.Serializable {
    public LeaveInfo() {

    }

    public LeaveInfo(String leaveId, String userId, String applyTime, String leaveDes, String leaveStartTime, String leaveEndTime, String leaveToAddress, String practiceId, String checker, String checkTime, String checkStatus, String checkDes, String leaveType, String userTel) {
        this.leaveId = leaveId;
        this.userId = userId;
        this.applyTime = applyTime;
        this.leaveDes = leaveDes;
        this.leaveStartTime = leaveStartTime;
        this.leaveEndTime = leaveEndTime;
        this.leaveToAddress = leaveToAddress;
        this.practiceId = practiceId;
        this.checker = checker;
        this.checkTime = checkTime;
        this.checkStatus = checkStatus;
        this.checkDes = checkDes;
        this.leaveType = leaveType;
        this.userTel = userTel;
    }

    private String leaveId;
    /** 申请人 */
    private String userId;

    /** 申请时间 */
    private String applyTime;

    /** 申请原因 */
    private String leaveDes;

    /** 请假开始时间 */
    private String leaveStartTime;

    /** 请假结束时间 */
    private String leaveEndTime;

    /** 外出目的地 */
    private String leaveToAddress;

    /** 实习ID */
    private String practiceId;

    /** 审核人 */
    private String checker;

    /** 审核时间 */
    private String checkTime;

    /** 审核状态	1：待审核；2：请假批准；3：请假驳回；4：主动撤销 */
    private String checkStatus;

    /** 审核意见 */
    private String checkDes;

    /** 外出类型	1：请假；2：出差 */
    private String leaveType;

    /** 手机号 */
    private String userTel;



    /**
     * 获取 主键ID 的值
     * @return String
     */
    public String getLeaveId() {
        return leaveId;
    }
    
    /**
     * 设置主键ID 的值
     *
     */
    public LeaveInfo setLeaveId(String leaveId) {
        this.leaveId = leaveId;
        return this;
    }

    /**
     * 获取 申请人 的值
     * @return String
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * 设置申请人 的值
     *
     */
    public LeaveInfo setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 获取 申请时间 的值
     * @return String
     */
    public String getApplyTime() {
        return applyTime;
    }
    
    /**
     * 设置申请时间 的值
     *
     */
    public LeaveInfo setApplyTime(String applyTime) {
        this.applyTime = applyTime;
        return this;
    }

    /**
     * 获取 申请原因 的值
     * @return String
     */
    public String getLeaveDes() {
        return leaveDes;
    }
    
    /**
     * 设置申请原因 的值
     *
     */
    public LeaveInfo setLeaveDes(String leaveDes) {
        this.leaveDes = leaveDes;
        return this;
    }

    /**
     * 获取 请假开始时间 的值
     * @return String
     */
    public String getLeaveStartTime() {
        return leaveStartTime;
    }
    
    /**
     * 设置请假开始时间 的值
     *
     */
    public LeaveInfo setLeaveStartTime(String leaveStartTime) {
        this.leaveStartTime = leaveStartTime;
        return this;
    }

    /**
     * 获取 请假结束时间 的值
     * @return String
     */
    public String getLeaveEndTime() {
        return leaveEndTime;
    }
    
    /**
     * 设置请假结束时间 的值
     *
     */
    public LeaveInfo setLeaveEndTime(String leaveEndTime) {
        this.leaveEndTime = leaveEndTime;
        return this;
    }

    /**
     * 获取 外出目的地 的值
     * @return String
     */
    public String getLeaveToAddress() {
        return leaveToAddress;
    }
    
    /**
     * 设置外出目的地 的值
     *
     */
    public LeaveInfo setLeaveToAddress(String leaveToAddress) {
        this.leaveToAddress = leaveToAddress;
        return this;
    }

    /**
     * 获取 实习ID 的值
     * @return String
     */
    public String getPracticeId() {
        return practiceId;
    }
    
    /**
     * 设置实习ID 的值
     *
     */
    public LeaveInfo setPracticeId(String practiceId) {
        this.practiceId = practiceId;
        return this;
    }

    /**
     * 获取 审核人 的值
     * @return String
     */
    public String getChecker() {
        return checker;
    }
    
    /**
     * 设置审核人 的值
     *
     */
    public LeaveInfo setChecker(String checker) {
        this.checker = checker;
        return this;
    }

    /**
     * 获取 审核时间 的值
     * @return String
     */
    public String getCheckTime() {
        return checkTime;
    }
    
    /**
     * 设置审核时间 的值
     *
     */
    public LeaveInfo setCheckTime(String checkTime) {
        this.checkTime = checkTime;
        return this;
    }

    /**
     * 获取 审核状态	1：待审核；2：请假批准；3：请假驳回；4：主动撤销 的值
     * @return String
     */
    public String getCheckStatus() {
        return checkStatus;
    }
    
    /**
     * 设置审核状态	1：待审核；2：请假批准；3：请假驳回；4：主动撤销 的值
     *
     */
    public LeaveInfo setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
        return this;
    }

    /**
     * 获取 审核意见 的值
     * @return String
     */
    public String getCheckDes() {
        return checkDes;
    }
    
    /**
     * 设置审核意见 的值
     *
     */
    public LeaveInfo setCheckDes(String checkDes) {
        this.checkDes = checkDes;
        return this;
    }

    /**
     * 获取 外出类型	1：请假；2：出差 的值
     * @return String
     */
    public String getLeaveType() {
        return leaveType;
    }
    
    /**
     * 设置外出类型	1：请假；2：出差 的值
     *
     */
    public LeaveInfo setLeaveType(String leaveType) {
        this.leaveType = leaveType;
        return this;
    }

    /**
     * 获取 手机号 的值
     * @return String
     */
    public String getUserTel() {
        return userTel;
    }
    
    /**
     * 设置手机号 的值
     *
     */
    public LeaveInfo setUserTel(String userTel) {
        this.userTel = userTel;
        return this;
    }


    @Override
    public String toString() {
        return "LeaveInfo{" +
                "leaveId=" + leaveId +
                ", userId=" + userId +
                ", applyTime='" + applyTime + '\'' +
                ", leaveDes=" + leaveDes +
                ", leaveStartTime='" + leaveStartTime + '\'' +
                ", leaveEndTime='" + leaveEndTime + '\'' +
                ", leaveToAddress='" + leaveToAddress + '\'' +
                ", practiceId=" + practiceId +
                ", checker=" + checker +
                ", checkTime='" + checkTime + '\'' +
                ", checkStatus=" + checkStatus +
                ", checkDes=" + checkDes +
                ", leaveType=" + leaveType +
                ", userTel='" + userTel + '\'' +
                '}';
    }
}