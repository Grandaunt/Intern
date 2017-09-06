package com.example.win.newintern3.NewEntity;

public class UserPractice implements java.io.Serializable {
    public UserPractice() {

    }

    public UserPractice(Integer userPracticeId, Integer userId, Integer planId, Integer baseId, Integer postId, String practicePost, Integer schoolTeacherId, String basePlanStartTime, String basePlanEndTime, String companyTeacher, String companyTeacherTel, Integer status, String basePlanAddres, Integer basePlanProvinceId, Integer basePlanCityId, Integer basePlanContyId, Integer companyId, String companyName, Integer practiceType, Object practiceScore, Object practiceAssess, String companyContact, String companyPhone, String schoolTeacherName, String planName) {
        this.userPracticeId = userPracticeId;
        this.userId = userId;
        this.planId = planId;
        this.baseId = baseId;
        this.postId = postId;
        this.practicePost = practicePost;
        this.schoolTeacherId = schoolTeacherId;
        this.basePlanStartTime = basePlanStartTime;
        this.basePlanEndTime = basePlanEndTime;
        this.companyTeacher = companyTeacher;
        this.companyTeacherTel = companyTeacherTel;
        this.status = status;
        this.basePlanAddres = basePlanAddres;
        this.basePlanProvinceId = basePlanProvinceId;
        this.basePlanCityId = basePlanCityId;
        this.basePlanContyId = basePlanContyId;
        this.companyId = companyId;
        this.companyName = companyName;
        this.practiceType = practiceType;
        this.practiceScore = practiceScore;
        this.practiceAssess = practiceAssess;
        this.companyContact = companyContact;
        this.companyPhone = companyPhone;
        this.schoolTeacherName = schoolTeacherName;
        this.planName = planName;
    }

    private Integer userPracticeId;
    /** 用户ID */
    private Integer userId;

    /** 实习计划ID */
    private Integer planId;

    /** 基地计划ID */
    private Integer baseId;

    /** 岗位ID */
    private Integer postId;

    /** 基地计划职位 */
    private String practicePost;

    /** 学校指导教师ID */
    private Integer schoolTeacherId;

    /** 实习开始时间 */
    private String basePlanStartTime;

    /** 实习结束时间 */
    private String basePlanEndTime;

    /** 企业指导老师 */
    private String companyTeacher;

    /** 联系方式 */
    private String companyTeacherTel;

    /** 实习状态	1：未开始；2：已开始；3：已转岗；4：已结束 */
    private Integer status = 1;

    /** 实习地 */
    private String basePlanAddres;

    /** 实习省份ID */
    private Integer basePlanProvinceId;

    /** 实习城市ID */
    private Integer basePlanCityId;

    /** 实习区县ID */
    private Integer basePlanContyId;

    /** 企业ID */
    private Integer companyId;

    /** 企业名称 */
    private String companyName;

    /** 实习方式	1：基地实习；2：自主实习；3：企业实习 */
    private Integer practiceType;

    /** 成绩 */
    private Object practiceScore;

    /** 评价 */
    private Object practiceAssess;


    private String companyContact;

    private String companyPhone;

    private String schoolTeacherName;


    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getSchoolTeacherName() {
        return schoolTeacherName;
    }

    public void setSchoolTeacherName(String schoolTeacherName) {
        this.schoolTeacherName = schoolTeacherName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    private String planName;

    /**
     * 获取 UserPracticeId 的值
     * @return Integer
     */
    public Integer getUserPracticeId() {
        return userPracticeId;
    }
    

    public UserPractice setUserPracticeId(Integer userPracticeId) {
        this.userPracticeId = userPracticeId;
        return this;
    }

    /**
     * 获取 用户ID 的值
     * @return Integer
     */
    public Integer getUserId() {
        return userId;
    }
    

    public UserPractice setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 获取 实习计划ID 的值
     * @return Integer
     */
    public Integer getPlanId() {
        return planId;
    }
    
    /**
     * 设置实习计划ID 的值
     *
     */
    public UserPractice setPlanId(Integer planId) {
        this.planId = planId;
        return this;
    }

    /**
     * 获取 基地计划ID 的值
     * @return Integer
     */
    public Integer getBaseId() {
        return baseId;
    }
    
    /**
     * 设置基地计划ID 的值
     *
     */
    public UserPractice setBaseId(Integer baseId) {
        this.baseId = baseId;
        return this;
    }

    /**
     * 获取 岗位ID 的值
     * @return Integer
     */
    public Integer getPostId() {
        return postId;
    }
    
    /**
     * 设置岗位ID 的值
     *
     */
    public UserPractice setPostId(Integer postId) {
        this.postId = postId;
        return this;
    }

    /**
     * 获取 基地计划职位 的值
     * @return String
     */
    public String getPracticePost() {
        return practicePost;
    }
    
    /**
     * 设置基地计划职位 的值
     *
     */
    public UserPractice setPracticePost(String practicePost) {
        this.practicePost = practicePost;
        return this;
    }

    /**
     * 获取 学校指导教师ID 的值
     * @return Integer
     */
    public Integer getSchoolTeacherId() {
        return schoolTeacherId;
    }
    
    /**
     * 设置学校指导教师ID 的值
     *
     */
    public UserPractice setSchoolTeacherId(Integer schoolTeacherId) {
        this.schoolTeacherId = schoolTeacherId;
        return this;
    }

    /**
     * 获取 实习开始时间 的值
     * @return String
     */
    public String getBasePlanStartTime() {
        return basePlanStartTime;
    }
    
    /**
     * 设置实习开始时间 的值
     *
     */
    public UserPractice setBasePlanStartTime(String basePlanStartTime) {
        this.basePlanStartTime = basePlanStartTime;
        return this;
    }

    /**
     * 获取 实习结束时间 的值
     * @return String
     */
    public String getBasePlanEndTime() {
        return basePlanEndTime;
    }
    
    /**
     * 设置实习结束时间 的值
     *
     */
    public UserPractice setBasePlanEndTime(String basePlanEndTime) {
        this.basePlanEndTime = basePlanEndTime;
        return this;
    }

    /**
     * 获取 企业指导老师 的值
     * @return String
     */
    public String getCompanyTeacher() {
        return companyTeacher;
    }
    
    /**
     * 设置企业指导老师 的值
     *
     */
    public UserPractice setCompanyTeacher(String companyTeacher) {
        this.companyTeacher = companyTeacher;
        return this;
    }

    /**
     * 获取 联系方式 的值
     * @return String
     */
    public String getCompanyTeacherTel() {
        return companyTeacherTel;
    }
    
    /**
     * 设置联系方式 的值
     *
     */
    public UserPractice setCompanyTeacherTel(String companyTeacherTel) {
        this.companyTeacherTel = companyTeacherTel;
        return this;
    }

    /**
     * 获取 实习状态	1：未开始；2：已开始；3：已转岗；4：已结束 的值
     * @return Integer
     */
    public Integer getStatus() {
        return status;
    }
    
    /**
     * 设置实习状态	1：未开始；2：已开始；3：已转岗；4：已结束 的值
     *
     */
    public UserPractice setStatus(Integer status) {
        this.status = status;
        return this;
    }

    /**
     * 获取 实习地 的值
     * @return String
     */
    public String getBasePlanAddres() {
        return basePlanAddres;
    }
    
    /**
     * 设置实习地 的值
     *
     */
    public UserPractice setBasePlanAddres(String basePlanAddres) {
        this.basePlanAddres = basePlanAddres;
        return this;
    }

    /**
     * 获取 实习省份ID 的值
     * @return Integer
     */
    public Integer getBasePlanProvinceId() {
        return basePlanProvinceId;
    }
    
    /**
     * 设置实习省份ID 的值
     *
     */
    public UserPractice setBasePlanProvinceId(Integer basePlanProvinceId) {
        this.basePlanProvinceId = basePlanProvinceId;
        return this;
    }

    /**
     * 获取 实习城市ID 的值
     * @return Integer
     */
    public Integer getBasePlanCityId() {
        return basePlanCityId;
    }
    
    /**
     * 设置实习城市ID 的值
     *
     */
    public UserPractice setBasePlanCityId(Integer basePlanCityId) {
        this.basePlanCityId = basePlanCityId;
        return this;
    }

    /**
     * 获取 实习区县ID 的值
     * @return Integer
     */
    public Integer getBasePlanContyId() {
        return basePlanContyId;
    }
    
    /**
     * 设置实习区县ID 的值
     *
     */
    public UserPractice setBasePlanContyId(Integer basePlanContyId) {
        this.basePlanContyId = basePlanContyId;
        return this;
    }

    /**
     * 获取 企业ID 的值
     * @return Integer
     */
    public Integer getCompanyId() {
        return companyId;
    }
    
    /**
     * 设置企业ID 的值
     *
     */
    public UserPractice setCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    /**
     * 获取 企业名称 的值
     * @return String
     */
    public String getCompanyName() {
        return companyName;
    }
    
    /**
     * 设置企业名称 的值
     *
     */
    public UserPractice setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    /**
     * 获取 实习方式	1：基地实习；2：自主实习；3：企业实习 的值
     * @return Integer
     */
    public Integer getPracticeType() {
        return practiceType;
    }
    
    /**
     * 设置实习方式	1：基地实习；2：自主实习；3：企业实习 的值
     *
     */
    public UserPractice setPracticeType(Integer practiceType) {
        this.practiceType = practiceType;
        return this;
    }

    /**
     * 获取 成绩 的值
     * @return Object
     */
    public Object getPracticeScore() {
        return practiceScore;
    }
    
    /**
     * 设置成绩 的值
     *
     */
    public UserPractice setPracticeScore(Object practiceScore) {
        this.practiceScore = practiceScore;
        return this;
    }

    /**
     * 获取 评价 的值
     * @return Object
     */
    public Object getPracticeAssess() {
        return practiceAssess;
    }
    
    /**
     * 设置评价 的值
     *
     */
    public UserPractice setPracticeAssess(Object practiceAssess) {
        this.practiceAssess = practiceAssess;
        return this;
    }

    @Override
    public String toString() {
        return "UserPractice{" +
                "userPracticeId=" + userPracticeId +
                ", userId=" + userId +
                ", planId=" + planId +
                ", baseId=" + baseId +
                ", postId=" + postId +
                ", practicePost='" + practicePost + '\'' +
                ", schoolTeacherId=" + schoolTeacherId +
                ", basePlanStartTime='" + basePlanStartTime + '\'' +
                ", basePlanEndTime='" + basePlanEndTime + '\'' +
                ", companyTeacher='" + companyTeacher + '\'' +
                ", companyTeacherTel='" + companyTeacherTel + '\'' +
                ", status=" + status +
                ", basePlanAddres='" + basePlanAddres + '\'' +
                ", basePlanProvinceId=" + basePlanProvinceId +
                ", basePlanCityId=" + basePlanCityId +
                ", basePlanContyId=" + basePlanContyId +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", practiceType=" + practiceType +
                ", practiceScore=" + practiceScore +
                ", practiceAssess=" + practiceAssess +
                ", companyContact='" + companyContact + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", schoolTeacherName='" + schoolTeacherName + '\'' +
                ", planName='" + planName + '\'' +
                '}';
    }

}