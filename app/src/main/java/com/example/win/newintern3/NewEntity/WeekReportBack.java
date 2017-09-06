package com.example.win.newintern3.NewEntity;




public class WeekReportBack implements java.io.Serializable {
    public WeekReportBack() {

    }

    public WeekReportBack(Integer backId, Integer weekReportId, Integer userId, String backTime, String backContent, String userName) {
        this.backId = backId;
        this.weekReportId = weekReportId;
        this.userId = userId;
        this.backTime = backTime;
        this.backContent = backContent;
        this.userName = userName;
    }

    public WeekReportBack(Integer backId, Integer weekReportId, Integer userId, String backTime, String backContent) {
        this.backId = backId;
        this.weekReportId = weekReportId;
        this.userId = userId;
        this.backTime = backTime;
        this.backContent = backContent;
    }

    private Integer backId;
    /** WeekReportId */
    private Integer weekReportId;

    /** 回答的用户ID */
    private Integer userId;

    /** 回答的时间 */
    private String backTime;

    /** 回答的原内容 */
    private String backContent;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** 回答的原内容 */
    private String userName;


    /**
     * 获取 BackId 的值
     * @return Integer
     */
    public Integer getBackId() {
        return backId;
    }
    
    /**
     * 设置BackId 的值
     *
     */
    public WeekReportBack setBackId(Integer backId) {
        this.backId = backId;
        return this;
    }

    /**
     * 获取 WeekReportId 的值
     * @return Integer
     */
    public Integer getWeekReportId() {
        return weekReportId;
    }
    
    /**
     * 设置WeekReportId 的值
     *
     */
    public WeekReportBack setWeekReportId(Integer weekReportId) {
        this.weekReportId = weekReportId;
        return this;
    }

    /**
     * 获取 回答的用户ID 的值
     * @return Integer
     */
    public Integer getUserId() {
        return userId;
    }
    
    /**
     * 设置回答的用户ID 的值
     *
     */
    public WeekReportBack setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 获取 回答的时间 的值
     * @return String
     */
    public String getBackTime() {
        return backTime;
    }
    
    /**
     * 设置回答的时间 的值
     *
     */
    public WeekReportBack setBackTime(String backTime) {
        this.backTime = backTime;
        return this;
    }

    /**
     * 获取 回答的原内容 的值
     * @return String
     */
    public String getBackContent() {
        return backContent;
    }
    
    /**
     * 设置回答的原内容 的值
     *
     */
    public WeekReportBack setBackContent(String backContent) {
        this.backContent = backContent;
        return this;
    }


    @Override
    public String toString() {
        return "WeekReportBack{" +
                "backId=" + backId +
                ", weekReportId=" + weekReportId +
                ", userId=" + userId +
                ", backTime='" + backTime + '\'' +
                ", backContent='" + backContent + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}