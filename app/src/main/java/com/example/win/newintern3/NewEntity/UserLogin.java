package com.example.win.newintern3.NewEntity;

public class UserLogin implements java.io.Serializable {
    public UserLogin() {

    }



    public UserLogin(Integer userId, String userName, String password, String mobile, Object isTrue, String lastLoginTime, Integer schoolId, String qrcode, String qQNumber, String weChat, String weibo, Integer userType, String jgid, String deviceType, UserBaseInfo userBaseInfo) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.mobile = mobile;
        this.isTrue = isTrue;
        this.lastLoginTime = lastLoginTime;
        this.schoolId = schoolId;
        this.qrcode = qrcode;
        this.qQNumber = qQNumber;
        this.weChat = weChat;
        this.weibo = weibo;
        this.userType = userType;
        this.jgid = jgid;
        this.deviceType = deviceType;
        this.userBaseInfo = userBaseInfo;
    }


    private Integer userId;
    /** 用户名 */
    private String userName;

    /** Password */
    private String password;

    /** Mobile */
    private String mobile;

    /** 是否可用	1可用，0不可用 */
    private Object isTrue;

    /** LastLoginTime */
    private String lastLoginTime;

    /** SchoolId */
    private Integer schoolId;

    /** Qrcode */
    private String qrcode;

    /** QQ号 */
    private String qQNumber;

    /** 微信号 */
    private String weChat;

    /** 微博号 */
    private String weibo;

    /** UserType */
    private Integer userType;

    /** 极光ID */
    private String jgid;

    /** 登录的类型固定Android 、IOS */
    private String deviceType;

    private UserBaseInfo userBaseInfo;

//    private UserPractice userPractice;
//
//    /** 是否实习 */
//    private String isHasUserPractice;
    
    public UserBaseInfo getUserBaseInfo() {
		return userBaseInfo;
	}

	public void setUserBaseInfo(UserBaseInfo userBaseInfo) {
		this.userBaseInfo = userBaseInfo;
	}

    public String getqQNumber() {
        return qQNumber;
    }

    public void setqQNumber(String qQNumber) {
        this.qQNumber = qQNumber;
    }



    /**
     * 获取 UserId 的值
     * @return Integer
     */
    public Integer getUserId() {
        return userId;
    }
    
    /**
     * 设置UserId 的值
     *
     */
    public UserLogin setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 获取 用户名 的值
     * @return String
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * 设置用户名 的值
     *
     */
    public UserLogin setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * 获取 Password 的值
     * @return String
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * 设置Password 的值
     *
     */
    public UserLogin setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * 获取 Mobile 的值
     * @return String
     */
    public String getMobile() {
        return mobile;
    }
    
    /**
     * 设置Mobile 的值
     *
     */
    public UserLogin setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    /**
     * 获取 是否可用	1可用，0不可用 的值
     * @return Object
     */
    public Object getIsTrue() {
        return isTrue;
    }
    
    /**
     * 设置是否可用	1可用，0不可用 的值
     *
     */
    public UserLogin setIsTrue(Object isTrue) {
        this.isTrue = isTrue;
        return this;
    }

    /**
     * 获取 LastLoginTime 的值
     * @return String
     */
    public String getLastLoginTime() {
        return lastLoginTime;
    }
    
    /**
     * 设置LastLoginTime 的值
     *
     */
    public UserLogin setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    /**
     * 获取 SchoolId 的值
     * @return Integer
     */
    public Integer getSchoolId() {
        return schoolId;
    }
    
    /**
     * 设置SchoolId 的值
     *
     */
    public UserLogin setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
        return this;
    }

    /**
     * 获取 Qrcode 的值
     * @return String
     */
    public String getQrcode() {
        return qrcode;
    }
    
    /**
     * 设置Qrcode 的值
     *
     */
    public UserLogin setQrcode(String qrcode) {
        this.qrcode = qrcode;
        return this;
    }

    /**
     * 获取 QQ号 的值
     * @return String
     */
    public String getQQNumber() {
        return qQNumber;
    }
    
    /**
     * 设置QQ号 的值
     *
     */
    public UserLogin setQQNumber(String qQNumber) {
        this.qQNumber = qQNumber;
        return this;
    }

    /**
     * 获取 微信号 的值
     * @return String
     */
    public String getWeChat() {
        return weChat;
    }
    
    /**
     * 设置微信号 的值
     *
     */
    public UserLogin setWeChat(String weChat) {
        this.weChat = weChat;
        return this;
    }

    /**
     * 获取 微博号 的值
     * @return String
     */
    public String getWeibo() {
        return weibo;
    }
    
    /**
     * 设置微博号 的值
     *
     */
    public UserLogin setWeibo(String weibo) {
        this.weibo = weibo;
        return this;
    }

    /**
     * 获取 UserType 的值
     * @return Integer
     */
    public Integer getUserType() {
        return userType;
    }
    
    /**
     * 设置UserType 的值
     *
     */
    public UserLogin setUserType(Integer userType) {
        this.userType = userType;
        return this;
    }

    /**
     * 获取 极光ID 的值
     * @return String
     */
    public String getJgid() {
        return jgid;
    }
    
    /**
     * 设置极光ID 的值
     *
     */
    public UserLogin setJgid(String jgid) {
        this.jgid = jgid;
        return this;
    }

    /**
     * 获取 登录的类型固定Android 、IOS 的值
     * @return String
     */
    public String getDeviceType() {
        return deviceType;
    }
    
    /**
     * 设置登录的类型固定Android 、IOS 的值
     *
     */
    public UserLogin setDeviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }


    @Override
    public String toString() {
        return "UserLogin{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", isTrue=" + isTrue +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", schoolId=" + schoolId +
                ", qrcode='" + qrcode + '\'' +
                ", qQNumber='" + qQNumber + '\'' +
                ", weChat='" + weChat + '\'' +
                ", weibo='" + weibo + '\'' +
                ", userType=" + userType +
                ", jgid='" + jgid + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", userBaseInfo=" + userBaseInfo +
                '}';
    }
}