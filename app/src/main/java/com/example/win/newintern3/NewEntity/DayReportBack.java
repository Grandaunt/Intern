package com.example.win.newintern3.NewEntity;




public class DayReportBack implements java.io.Serializable {
    public DayReportBack() {

    }

    public DayReportBack(Integer backId, Integer dayReportId, Integer userId, String backTime, String backContent, String userName) {
        this.backId = backId;
        this.dayReportId = dayReportId;
        this.userId = userId;
        this.backTime = backTime;
        this.backContent = backContent;
        this.userName = userName;
    }

    public DayReportBack(Integer backId, Integer dayReportId, Integer userId, String backTime, String backContent) {
        this.backId = backId;
        this.dayReportId = dayReportId;
        this.userId = userId;
        this.backTime = backTime;
        this.backContent = backContent;
    }

    private Integer backId;
    /** DayReportId */
    private Integer dayReportId;

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
     * d
     */
    public DayReportBack setBackId(Integer backId) {
        this.backId = backId;
        return this;
    }

    /**
     * 获取 DayReportId 的值
     * @return Integer
     */
    public Integer getDayReportId() {
        return dayReportId;
    }
    
    /**
     * 设置DayReportId 的值
     *
     */
    public DayReportBack setDayReportId(Integer dayReportId) {
        this.dayReportId = dayReportId;
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
    public DayReportBack setUserId(Integer userId) {
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
    public DayReportBack setBackTime(String backTime) {
        this.backTime = backTime;
        return this;
    }

    /**
     * 获取 回答的原内容 的值
     * @return Object
     */
    public String getBackContent() {
        return backContent;
    }
    
    /**
     * 设置回答的原内容 的值
     *
     */
    public DayReportBack setBackContent(String backContent) {
        this.backContent = backContent;
        return this;
    }


    @Override
    public String toString() {
        return "DayReportBack{" +
                "backId=" + backId +
                ", dayReportId=" + dayReportId +
                ", userId=" + userId +
                ", backTime='" + backTime + '\'' +
                ", backContent='" + backContent + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}