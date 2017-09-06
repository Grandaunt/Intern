package com.example.win.newintern3.NewEntity;


public class Signinfo implements java.io.Serializable {
    public Signinfo() {

    }

    public Signinfo(Integer signId, Integer userId, String signDateTime, String signTime, String signAddress, Integer points, Integer signType, String addressText, Integer practiceId) {
        this.signId = signId;
        this.userId = userId;
        this.signDateTime = signDateTime;
        this.signTime = signTime;
        this.signAddress = signAddress;
        this.points = points;
        this.signType = signType;
        this.addressText = addressText;
        this.practiceId = practiceId;
    }

    private Integer signId;
    /** 用户ID */
    private Integer userId;

    /** 签到日期	年月日-服务器时间 */
    private String signDateTime;

    /** 签到时间	时分秒-服务器时间 */
    private String signTime;

    /** 签到地点	经纬度 X，Y */
    private String signAddress;

    /** 积分	正负 */
    private Integer points;

    /** 类型	1、签到；2、动态积分；3、报告积分；4、游戏积分 */
    private Integer signType;

    /** 签到地点文本 */
    private String addressText;

    /** PracticeId */
    private Integer practiceId;



    /**
     * 获取 signId 的值
     * @return Integer
     */
    public Integer getSignId() {
        return signId;
    }
    
    /**
     * 设置signId 的值
     *
     */
    public Signinfo setSignId(Integer signId) {
        this.signId = signId;
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
    public Signinfo setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 获取 签到日期	年月日-服务器时间 的值
     * @return String
     */
    public String getSignDateTime() {
        return signDateTime;
    }
    
    /**
     * 设置签到日期	年月日-服务器时间 的值
     *
     */
    public Signinfo setSignDateTime(String signDateTime) {
        this.signDateTime = signDateTime;
        return this;
    }

    /**
     * 获取 签到时间	时分秒-服务器时间 的值
     * @return String
     */
    public String getSignTime() {
        return signTime;
    }
    
    /**
     * 设置签到时间	时分秒-服务器时间 的值
     *
     */
    public Signinfo setSignTime(String signTime) {
        this.signTime = signTime;
        return this;
    }

    /**
     * 获取 签到地点	经纬度 X，Y 的值
     * @return String
     */
    public String getSignAddress() {
        return signAddress;
    }
    
    /**
     * 设置签到地点	经纬度 X，Y 的值
     *
     */
    public Signinfo setSignAddress(String signAddress) {
        this.signAddress = signAddress;
        return this;
    }



    /**
     * 获取 practiceId 的值
     * @return Integer
     */
    public Integer getPracticeId() {
        return practiceId;
    }
    
    /**
     * 设置practiceId 的值
     *
     */
    public Signinfo setPracticeId(Integer practiceId) {
        this.practiceId = practiceId;
        return this;
    }

    /**
     * 获取 积分	正负 的值
     * @return Integer
     */
    public Integer getPoints() {
        return points;
    }
    
    /**
     * 设置积分	正负 的值
     *
     */
    public Signinfo setPoints(Integer points) {
        this.points = points;
        return this;
    }

    /**
     * 获取 类型	1、签到；2、动态积分；3、报告积分；4、游戏积分 的值
     * @return Integer
     */
    public Integer getSignType() {
        return signType;
    }
    
    /**
     * 设置类型	1、签到；2、动态积分；3、报告积分；4、游戏积分 的值
     *
     */
    public Signinfo setSignType(Integer signType) {
        this.signType = signType;
        return this;
    }



    /**
     * 获取 签到地点	经纬度 X，Y 的值
     * @return String
     */
    public String getAddressText() {
        return addressText;
    }
    
    /**
     * 设置签到地点	经纬度 X，Y 的值
     *
     */
    public Signinfo setAddressText(String addressText) {
        this.addressText = addressText;
        return this;
    }

    //	public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append(this.getClass().getName());
//        sb.append("; signId=" + (signId == null ? "null" : signId.toString()));

    @Override
    public String toString() {
        return "Signinfo{" +
                "signId=" + signId +
                ", userId=" + userId +
                ", signDateTime='" + signDateTime + '\'' +
                ", signTime='" + signTime + '\'' +
                ", signAddress='" + signAddress + '\'' +
                ", points=" + points +
                ", signType=" + signType +
                ", addressText='" + addressText + '\'' +
                ", practiceId=" + practiceId +
                '}';
    }
//        sb.append("; userId=" + (userId == null ? "null" : userId.toString()));
//        sb.append("; signDateTime=" + (signDateTime == null ? "null" : signDateTime.toString()));
//        sb.append("; signTime=" + (signTime == null ? "null" : signTime.toString()));
//        sb.append("; signAddress=" + (signAddress == null ? "null" : signAddress.toString()));
//        sb.append("; signMonth=" + (signMonth == null ? "null" : signMonth.toString()));
//        sb.append("; practiceId=" + (practiceId == null ? "null" : practiceId.toString()));
//        sb.append("; points=" + (points == null ? "null" : points.toString()));
//        sb.append("; signType=" + (signType == null ? "null" : signType.toString()));
//        sb.append("; signEndTime=" + (signEndTime == null ? "null" : signEndTime.toString()));
//        sb.append("; signTitle=" + (signTitle == null ? "null" : signTitle.toString()));
//        sb.append("; addressText=" + (addressText == null ? "null" : addressText.toString()));
//
//        return sb.toString();
//    }
}