package com.example.win.newintern3.NewEntity;

public class UserBaseInfo implements java.io.Serializable {
    public UserBaseInfo( ) {

    }

    public UserBaseInfo(Integer userId, String trueName, Integer male, String nickName, Integer schoolId, String intoSchool, Integer majorId, String icon, Integer departmentId, Integer tearcher, Integer groupId, Integer gradesId, String leftSchool, String userBirth, String userIDCard, String userCode, String logo, String schoolName, String majorName, String departmentName, String gradeName) {
        this.userId = userId;
        this.trueName = trueName;
        this.male = male;
        this.nickName = nickName;
        this.schoolId = schoolId;
        this.intoSchool = intoSchool;
        this.majorId = majorId;
        this.icon = icon;
        this.departmentId = departmentId;
        this.tearcher = tearcher;
        this.groupId = groupId;
        this.gradesId = gradesId;
        this.leftSchool = leftSchool;
        this.userBirth = userBirth;
        this.userIDCard = userIDCard;
        this.userCode = userCode;
        this.logo = logo;
        this.schoolName = schoolName;
        this.majorName = majorName;
        this.departmentName = departmentName;
        this.gradeName = gradeName;
    }

    public UserBaseInfo(Integer userId, String trueName, Integer male, String nickName, Integer schoolId, String intoSchool, Integer majorId, String icon, Integer departmentId, Integer tearcher, Integer groupId, Integer gradesId, String leftSchool, String userBirth, String userIDCard, String userCode, String logo) {
        this.userId = userId;
        this.trueName = trueName;
        this.male = male;
        this.nickName = nickName;
        this.schoolId = schoolId;
        this.intoSchool = intoSchool;
        this.majorId = majorId;
        this.icon = icon;
        this.departmentId = departmentId;
        this.tearcher = tearcher;
        this.groupId = groupId;
        this.gradesId = gradesId;
        this.leftSchool = leftSchool;
        this.userBirth = userBirth;
        this.userIDCard = userIDCard;
        this.userCode = userCode;
        this.logo = logo;
    }

    private Integer userId = 0;
    /** 用户姓名 */
    private String trueName;

    /** 性别	1男0女 */
    private Integer male;

    /** 昵称 */
    private String nickName;

    /** 学校	学校的ID */
    private Integer schoolId;

    /** 入校时间 */
    private String intoSchool;

    /** 所属专业	院系的ID */
    private Integer majorId;

    /** 用户头像 */
    private String icon;

    /** 院系ID */
    private Integer departmentId;

    /** 所属教师	预留 */
    private Integer tearcher;

    /** 所属组	预留 */
    private Integer groupId;

    /** 所属班级	groupId 对应班级表 */
    private Integer gradesId;

    /** 毕业时间 */
    private String leftSchool;

    /** 出生年月 */
    private String userBirth;

    /** 身份证号 */
    private String userIDCard;

    /** 学号 */
    private String userCode;

    /** 头像 */
    private String logo;

    private String schoolName;

    private String majorName;

    private String departmentName;

    private String gradeName;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    /**
     * 获取 用户id 的值
     * @return Integer
     */
    public Integer getUserId() {
        return userId;
    }
    
    /**
     * 设置用户id 的值
     *
     */
    public UserBaseInfo setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 获取 用户姓名 的值
     * @return String
     */
    public String getTrueName() {
        return trueName;
    }
    
    /**
     * 设置用户姓名 的值
     *
     */
    public UserBaseInfo setTrueName(String trueName) {
        this.trueName = trueName;
        return this;
    }

    /**
     * 获取 性别	1男0女 的值
     * @return Integer
     */
    public Integer getMale() {
        return male;
    }
    
    /**
     * 设置性别	1男0女 的值
     *
     */
    public UserBaseInfo setMale(Integer male) {
        this.male = male;
        return this;
    }

    /**
     * 获取 昵称 的值
     * @return String
     */
    public String getNickName() {
        return nickName;
    }
    
    /**
     * 设置昵称 的值
     *
     */
    public UserBaseInfo setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    /**
     * 获取 学校	学校的ID 的值
     * @return Integer
     */
    public Integer getSchoolId() {
        return schoolId;
    }
    
    /**
     * 设置学校	学校的ID 的值
     *
     */
    public UserBaseInfo setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
        return this;
    }

    /**
     * 获取 入校时间 的值
     * @return String
     */
    public String getIntoSchool() {
        return intoSchool;
    }
    
    /**
     * 设置入校时间 的值
     *
     */
    public UserBaseInfo setIntoSchool(String intoSchool) {
        this.intoSchool = intoSchool;
        return this;
    }

    /**
     * 获取 所属专业	院系的ID 的值
     * @return Integer
     */
    public Integer getMajorId() {
        return majorId;
    }
    
    /**
     * 设置所属专业	院系的ID 的值
     *
     */
    public UserBaseInfo setMajorId(Integer majorId) {
        this.majorId = majorId;
        return this;
    }

    /**
     * 获取 用户头像 的值
     * @return String
     */
    public String getIcon() {
        return icon;
    }
    
    /**
     * 设置用户头像 的值
     *
     */
    public UserBaseInfo setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    /**
     * 获取 院系ID 的值
     * @return Integer
     */
    public Integer getDepartmentId() {
        return departmentId;
    }
    
    /**
     * 设置院系ID 的值
     *
     */
    public UserBaseInfo setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    /**
     * 获取 所属教师	预留 的值
     * @return Integer
     */
    public Integer getTearcher() {
        return tearcher;
    }
    
    /**
     * 设置所属教师	预留 的值
     *
     */
    public UserBaseInfo setTearcher(Integer tearcher) {
        this.tearcher = tearcher;
        return this;
    }

    /**
     * 获取 所属组	预留 的值
     * @return Integer
     */
    public Integer getGroupId() {
        return groupId;
    }
    
    /**
     * 设置所属组	预留 的值
     *
     */
    public UserBaseInfo setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    /**
     * 获取 所属班级	groupId 对应班级表 的值
     * @return Integer
     */
    public Integer getGradesId() {
        return gradesId;
    }
    
    /**
     * 设置所属班级	groupId 对应班级表 的值
     *
     */
    public UserBaseInfo setGradesId(Integer gradesId) {
        this.gradesId = gradesId;
        return this;
    }

    /**
     * 获取 毕业时间 的值
     * @return String
     */
    public String getLeftSchool() {
        return leftSchool;
    }
    
    /**
     * 设置毕业时间 的值
     *
     */
    public UserBaseInfo setLeftSchool(String leftSchool) {
        this.leftSchool = leftSchool;
        return this;
    }

    /**
     * 获取 出生年月 的值
     * @return String
     */
    public String getUserBirth() {
        return userBirth;
    }
    
    /**
     * 设置出生年月 的值
     *
     */
    public UserBaseInfo setUserBirth(String userBirth) {
        this.userBirth = userBirth;
        return this;
    }

    /**
     * 获取 身份证号 的值
     * @return String
     */
    public String getUserIDCard() {
        return userIDCard;
    }
    
    /**
     * 设置身份证号 的值
     *
     */
    public UserBaseInfo setUserIDCard(String userIDCard) {
        this.userIDCard = userIDCard;
        return this;
    }

    /**
     * 获取 学号 的值
     * @return String
     */
    public String getUserCode() {
        return userCode;
    }
    
    /**
     * 设置学号 的值
     *
     */
    public UserBaseInfo setUserCode(String userCode) {
        this.userCode = userCode;
        return this;
    }

    /**
     * 获取 头像 的值
     * @return String
     */
    public String getLogo() {
        return logo;
    }
    
    /**
     * 设置头像 的值
     *
     */
    public UserBaseInfo setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    @Override
    public String toString() {
        return "UserBaseInfo{" +
                "userId=" + userId +
                ", trueName='" + trueName + '\'' +
                ", male=" + male +
                ", nickName='" + nickName + '\'' +
                ", schoolId=" + schoolId +
                ", intoSchool='" + intoSchool + '\'' +
                ", majorId=" + majorId +
                ", icon='" + icon + '\'' +
                ", departmentId=" + departmentId +
                ", tearcher=" + tearcher +
                ", groupId=" + groupId +
                ", gradesId=" + gradesId +
                ", leftSchool='" + leftSchool + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userIDCard='" + userIDCard + '\'' +
                ", userCode='" + userCode + '\'' +
                ", logo='" + logo + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", majorName='" + majorName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", gradeName='" + gradeName + '\'' +
                '}';
    }

}