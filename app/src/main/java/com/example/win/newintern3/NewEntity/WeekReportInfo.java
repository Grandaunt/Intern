package com.example.win.newintern3.NewEntity;
import java.util.List;




public class WeekReportInfo implements java.io.Serializable {

    public WeekReportInfo() {

    }

    public WeekReportInfo(Integer weekReportId, Integer userId, Integer practiceId, String weekReportTime, String weekpost, String weekReportExperience, String nextWeekPlan, String weekReportAddress, String weekReportAddressText, String mondayTime, String sundayTime, String mondayContent, String tuesdayContent, String wednesdayContent, String thursdayContent, String fridayContent, List<WeekReportBack> weekReportBackList) {
        this.weekReportId = weekReportId;
        this.userId = userId;
        this.practiceId = practiceId;
        this.weekReportTime = weekReportTime;
        this.weekpost = weekpost;
        this.weekReportExperience = weekReportExperience;
        this.nextWeekPlan = nextWeekPlan;
        this.weekReportAddress = weekReportAddress;
        this.weekReportAddressText = weekReportAddressText;
        this.mondayTime = mondayTime;
        this.sundayTime = sundayTime;
        this.mondayContent = mondayContent;
        this.tuesdayContent = tuesdayContent;
        this.wednesdayContent = wednesdayContent;
        this.thursdayContent = thursdayContent;
        this.fridayContent = fridayContent;
        this.weekReportBackList = weekReportBackList;
    }

    private Integer weekReportId;
    /** 用户ID */
    private Integer userId;

    /** 实习ID */
    private Integer practiceId;

    /** 周报发布时间 */
    private String weekReportTime;

    /** 工作岗位 */
    private String weekpost;

    /** 本周小结 */
    private String weekReportExperience;

    /** 下周计划 */
    private String nextWeekPlan;

    /** 动态发布位置	经纬度 ，分割 */
    private String weekReportAddress;

    /** 工作地点 */
    private String weekReportAddressText;

    /** 周一时间 */
    private String mondayTime;

    /** 周日时间 */
    private String sundayTime;

    /** 周一工作 */
    private String mondayContent;

    /** 周二工作 */
    private String tuesdayContent;

    /** 周三工作 */
    private String wednesdayContent;

    /** 周四工作 */
    private String thursdayContent;

    /** 周五工作 */
    private String fridayContent;


    private List<WeekReportBack> weekReportBackList;

    
    public List<WeekReportBack> getWeekReportBackList() {
		return weekReportBackList;
	}

	public void setWeekReportBackList(List<WeekReportBack> weekReportBackList) {
		this.weekReportBackList = weekReportBackList;
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
    public WeekReportInfo setWeekReportId(Integer weekReportId) {
        this.weekReportId = weekReportId;
        return this;
    }

    /**
     * 获取 用户ID 的值
     * @return Integer
     */
    public Integer getUserId() {
        return userId;
    }
    
    /**
     * 设置用户ID 的值
     *
     */
    public WeekReportInfo setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 获取 实习ID 的值
     * @return Integer
     */
    public Integer getPracticeId() {
        return practiceId;
    }
    
    /**
     * 设置实习ID 的值
     *
     */
    public WeekReportInfo setPracticeId(Integer practiceId) {
        this.practiceId = practiceId;
        return this;
    }

    /**
     * 获取 周报发布时间 的值
     * @return String
     */
    public String getWeekReportTime() {
        return weekReportTime;
    }
    
    /**
     * 设置周报发布时间 的值
     *
     */
    public WeekReportInfo setWeekReportTime(String weekReportTime) {
        this.weekReportTime = weekReportTime;
        return this;
    }

    /**
     * 获取 工作岗位 的值
     * @return String
     */
    public String getWeekpost() {
        return weekpost;
    }
    
    /**
     * 设置工作岗位 的值
     *
     */
    public WeekReportInfo setWeekpost(String weekpost) {
        this.weekpost = weekpost;
        return this;
    }

    /**
     * 获取 本周小结 的值
     * @return String
     */
    public String getWeekReportExperience() {
        return weekReportExperience;
    }
    
    /**
     * 设置本周小结 的值
     *
     */
    public WeekReportInfo setWeekReportExperience(String weekReportExperience) {
        this.weekReportExperience = weekReportExperience;
        return this;
    }

    /**
     * 获取 下周计划 的值
     * @return String
     */
    public String getNextWeekPlan() {
        return nextWeekPlan;
    }
    
    /**
     * 设置下周计划 的值
     *
     */
    public WeekReportInfo setNextWeekPlan(String nextWeekPlan) {
        this.nextWeekPlan = nextWeekPlan;
        return this;
    }

    /**
     * 获取 动态发布位置	经纬度 ，分割 的值
     * @return String
     */
    public String getWeekReportAddress() {
        return weekReportAddress;
    }
    
    /**
     * 设置动态发布位置	经纬度 ，分割 的值
     *
     */
    public WeekReportInfo setWeekReportAddress(String weekReportAddress) {
        this.weekReportAddress = weekReportAddress;
        return this;
    }

    /**
     * 获取 工作地点 的值
     * @return String
     */
    public String getWeekReportAddressText() {
        return weekReportAddressText;
    }
    
    /**
     * 设置工作地点 的值
     *
     */
    public WeekReportInfo setWeekReportAddressText(String weekReportAddressText) {
        this.weekReportAddressText = weekReportAddressText;
        return this;
    }

    /**
     * 获取 周一时间 的值
     * @return String
     */
    public String getMondayTime() {
        return mondayTime;
    }
    
    /**
     * 设置周一时间 的值
     *
     */
    public WeekReportInfo setMondayTime(String mondayTime) {
        this.mondayTime = mondayTime;
        return this;
    }

    /**
     * 获取 周日时间 的值
     * @return String
     */
    public String getSundayTime() {
        return sundayTime;
    }
    
    /**
     * 设置周日时间 的值
     *
     */
    public WeekReportInfo setSundayTime(String sundayTime) {
        this.sundayTime = sundayTime;
        return this;
    }

    /**
     * 获取 周一工作 的值
     * @return String
     */
    public String getMondayContent() {
        return mondayContent;
    }
    
    /**
     * 设置周一工作 的值
     *
     */
    public WeekReportInfo setMondayContent(String mondayContent) {
        this.mondayContent = mondayContent;
        return this;
    }

    /**
     * 获取 周二工作 的值
     * @return String
     */
    public String getTuesdayContent() {
        return tuesdayContent;
    }
    
    /**
     * 设置周二工作 的值
     *
     */
    public WeekReportInfo setTuesdayContent(String tuesdayContent) {
        this.tuesdayContent = tuesdayContent;
        return this;
    }

    /**
     * 获取 周三工作 的值
     * @return String
     */
    public String getWednesdayContent() {
        return wednesdayContent;
    }
    
    /**
     * 设置周三工作 的值
     *
     */
    public WeekReportInfo setWednesdayContent(String wednesdayContent) {
        this.wednesdayContent = wednesdayContent;
        return this;
    }

    /**
     * 获取 周四工作 的值
     * @return String
     */
    public String getThursdayContent() {
        return thursdayContent;
    }
    
    /**
     * 设置周四工作 的值
     *
     */
    public WeekReportInfo setThursdayContent(String thursdayContent) {
        this.thursdayContent = thursdayContent;
        return this;
    }

    /**
     * 获取 周五工作 的值
     * @return String
     */
    public String getFridayContent() {
        return fridayContent;
    }
    
    /**
     * 设置周五工作 的值
     *
     */
    public WeekReportInfo setFridayContent(String fridayContent) {
        this.fridayContent = fridayContent;
        return this;
    }


    @Override
    public String toString() {
        return "WeekReportInfo{" +
                "weekReportId=" + weekReportId +
                ", userId=" + userId +
                ", practiceId=" + practiceId +
                ", weekReportTime='" + weekReportTime + '\'' +
                ", weekpost=" + weekpost +
                ", weekReportExperience=" + weekReportExperience +
                ", nextWeekPlan=" + nextWeekPlan +
                ", weekReportAddress='" + weekReportAddress + '\'' +
                ", weekReportAddressText='" + weekReportAddressText + '\'' +
                ", mondayTime='" + mondayTime + '\'' +
                ", sundayTime='" + sundayTime + '\'' +
                ", mondayContent=" + mondayContent +
                ", tuesdayContent=" + tuesdayContent +
                ", wednesdayContent=" + wednesdayContent +
                ", thursdayContent=" + thursdayContent +
                ", fridayContent=" + fridayContent +
                ", weekReportBackList=" + weekReportBackList +
                '}';
    }
}