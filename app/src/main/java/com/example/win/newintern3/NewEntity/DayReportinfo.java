package com.example.win.newintern3.NewEntity;
import java.util.List;


public class DayReportinfo implements java.io.Serializable {
    public DayReportinfo() {

    }

    public DayReportinfo(Integer dayReportId, Integer userId, Integer practiceId, String dayReportTime, String dayReportContent, String dayReportExperience, String dayReportDes, String dayReportAddress, String videoPath, String dayReportAddressText, Integer dayReportType, List<DayReportBack> dayReportBackList) {
        this.dayReportId = dayReportId;
        this.userId = userId;
        this.practiceId = practiceId;
        this.dayReportTime = dayReportTime;
        this.dayReportContent = dayReportContent;
        this.dayReportExperience = dayReportExperience;
        this.dayReportDes = dayReportDes;
        this.dayReportAddress = dayReportAddress;
        this.videoPath = videoPath;
        this.dayReportAddressText = dayReportAddressText;
        this.dayReportType = dayReportType;
        this.dayReportBackList = dayReportBackList;
    }

    private Integer dayReportId;
    /** 用户ID */
    private Integer userId;

    /** 实习ID */
    private Integer practiceId;

    /** 日志发布时间 */
    private String dayReportTime;

    /** 实习工作内容 */
    private String dayReportContent;

    /** 收获和体会 */
    private String dayReportExperience;

    /** 备注 */
    private String dayReportDes;

    /** 动态发布位置	经纬度 ，分割 */
    private String dayReportAddress;

    /** 小视频路径 */
    private String videoPath;

    /** 动态发布位置 */
    private String dayReportAddressText;

    /** 日志内容类型	1：文本；2：语音 */
    private Integer dayReportType;
    

    private List<DayReportBack> dayReportBackList;
    /*@Transient
    private DayReportImage dayReportImage;
*/

	/**
     * 获取 主键ID 的值
     * @return Integer
     */
    public Integer getDayReportId() {
        return dayReportId;
    }
    
    public List<DayReportBack> getDayReportBackList() {
		return dayReportBackList;
	}

	public void setDayReportBackList(List<DayReportBack> dayReportBackList) {
		this.dayReportBackList = dayReportBackList;
	}

	/**
     * 设置主键ID 的值
     *
     */
    public DayReportinfo setDayReportId(Integer dayReportId) {
        this.dayReportId = dayReportId;
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
    public DayReportinfo setUserId(Integer userId) {
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
    public DayReportinfo setPracticeId(Integer practiceId) {
        this.practiceId = practiceId;
        return this;
    }

    /**
     * 获取 日志发布时间 的值
     * @return String
     */
    public String getDayReportTime() {
        return dayReportTime;
    }
    
    /**
     * 设置日志发布时间 的值
     *
     */
    public DayReportinfo setDayReportTime(String dayReportTime) {
        this.dayReportTime = dayReportTime;
        return this;
    }

    /**
     * 获取 实习工作内容 的值
     * @return Object
     */
    public String getDayReportContent() {
        return dayReportContent;
    }
    
    /**
     * 设置实习工作内容 的值
     *
     */
    public DayReportinfo setDayReportContent(String dayReportContent) {
        this.dayReportContent = dayReportContent;
        return this;
    }

    /**
     * 获取 收获和体会 的值
     * @return Object
     */
    public String getDayReportExperience() {
        return dayReportExperience;
    }
    
    /**
     * 设置收获和体会 的值
     *
     */
    public DayReportinfo setDayReportExperience(String dayReportExperience) {
        this.dayReportExperience = dayReportExperience;
        return this;
    }

    /**
     * 获取 备注 的值
     * @return Object
     */
    public Object getDayReportDes() {
        return dayReportDes;
    }
    
    /**
     * 设置备注 的值
     *
     */
    public DayReportinfo setDayReportDes(String dayReportDes) {
        this.dayReportDes = dayReportDes;
        return this;
    }

    /**
     * 获取 动态发布位置	经纬度 ，分割 的值
     * @return String
     */
    public String getDayReportAddress() {
        return dayReportAddress;
    }
    
    /**
     * 设置动态发布位置	经纬度 ，分割 的值
     *
     */
    public DayReportinfo setDayReportAddress(String dayReportAddress) {
        this.dayReportAddress = dayReportAddress;
        return this;
    }

    /**
     * 获取 小视频路径 的值
     * @return String
     */
    public String getVideoPath() {
        return videoPath;
    }
    
    /**
     * 设置小视频路径 的值
     *
     */
    public DayReportinfo setVideoPath(String videoPath) {
        this.videoPath = videoPath;
        return this;
    }

    /**
     * 获取 动态发布位置 的值
     * @return String
     */
    public String getDayReportAddressText() {
        return dayReportAddressText;
    }
    
    /**
     * 设置动态发布位置 的值
     *
     */
    public DayReportinfo setDayReportAddressText(String dayReportAddressText) {
        this.dayReportAddressText = dayReportAddressText;
        return this;
    }

    /**
     * 获取 日志内容类型	1：文本；2：语音 的值
     * @return Integer
     */
    public Integer getDayReportType() {
        return dayReportType;
    }
    
    /**
     * 设置日志内容类型	1：文本；2：语音 的值
     *
     */
    public DayReportinfo setDayReportType(Integer dayReportType) {
        this.dayReportType = dayReportType;
        return this;
    }


    @Override
    public String toString() {
        return "DayReportinfo{" +
                "dayReportId=" + dayReportId +
                ", userId=" + userId +
                ", practiceId=" + practiceId +
                ", dayReportTime='" + dayReportTime + '\'' +
                ", dayReportContent=" + dayReportContent +
                ", dayReportExperience=" + dayReportExperience +
                ", dayReportDes=" + dayReportDes +
                ", dayReportAddress='" + dayReportAddress + '\'' +
                ", videoPath='" + videoPath + '\'' +
                ", dayReportAddressText='" + dayReportAddressText + '\'' +
                ", dayReportType=" + dayReportType +
                ", dayReportBackList=" + dayReportBackList +
                '}';
    }
}