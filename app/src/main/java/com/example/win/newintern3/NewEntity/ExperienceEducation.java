package com.example.win.newintern3.NewEntity;

public class ExperienceEducation implements java.io.Serializable {
    public ExperienceEducation() {

    }

    public ExperienceEducation(Integer educationId, Integer userId, Integer schoolId, String schoolName, String educationMajor, Integer educationLevel, String educationStartTime, String educationEndTime, String educationDes, Integer isTrue) {
        this.educationId = educationId;
        this.userId = userId;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.educationMajor = educationMajor;
        this.educationLevel = educationLevel;
        this.educationStartTime = educationStartTime;
        this.educationEndTime = educationEndTime;
        this.educationDes = educationDes;
        this.isTrue = isTrue;
    }

    private Integer educationId;
    /** 用户ID */
    private Integer userId;

    /** 学校ID    暂不启用 */
    private Integer schoolId;

    /** 学校名称 */
    private String schoolName;

    /** 专业 */
    private String educationMajor;

    /** 学历 */
    private Integer educationLevel;

    /** 开始时间 */
    private String educationStartTime;

    /** 结束时间 */
    private String educationEndTime;

    /** 经历描述 */
    private String educationDes;

    /** 是否认证    暂不启用 */
    private Integer isTrue;



    /**
     * 获取 教育经历ID 的值
     * @return String
     */
    public Integer getEducationId() {
		return educationId;
	}

	public ExperienceEducation setEducationId(Integer educationId) {
		this.educationId = educationId;
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
    public ExperienceEducation setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 获取 学校ID    暂不启用 的值
     * @return Integer
     */
    public Integer getSchoolId() {
        return schoolId;
    }
    
    /**
     * 设置学校ID    暂不启用 的值
     *
     */
    public ExperienceEducation setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
        return this;
    }

    /**
     * 获取 学校名称 的值
     * @return String
     */
    public String getSchoolName() {
        return schoolName;
    }
    
    /**
     * 设置学校名称 的值
     *
     */
    public ExperienceEducation setSchoolName(String schoolName) {
        this.schoolName = schoolName;
        return this;
    }

    /**
     * 获取 专业 的值
     * @return String
     */
    public String getEducationMajor() {
        return educationMajor;
    }
    
    /**
     * 设置专业 的值
     *
     */
    public ExperienceEducation setEducationMajor(String educationMajor) {
        this.educationMajor = educationMajor;
        return this;
    }

    /**
     * 获取 学历 的值
     * @return Integer
     */
    public Integer getEducationLevel() {
        return educationLevel;
    }
    
    /**
     * 设置学历 的值
     *
     */
    public ExperienceEducation setEducationLevel(Integer educationLevel) {
        this.educationLevel = educationLevel;
        return this;
    }

    /**
     * 获取 开始时间 的值
     * @return String
     */
    public String getEducationStartTime() {
        return educationStartTime;
    }
    
    /**
     * 设置开始时间 的值
     *
     */
    public ExperienceEducation setEducationStartTime(String educationStartTime) {
        this.educationStartTime = educationStartTime;
        return this;
    }

    /**
     * 获取 结束时间 的值
     * @return String
     */
    public String getEducationEndTime() {
        return educationEndTime;
    }
    
    /**
     * 设置结束时间 的值
     *
     */
    public ExperienceEducation setEducationEndTime(String educationEndTime) {
        this.educationEndTime = educationEndTime;
        return this;
    }

    /**
     * 获取 经历描述 的值
     * @return String
     */
    public String getEducationDes() {
        return educationDes;
    }
    
    /**
     * 设置经历描述 的值
     *
     */
    public ExperienceEducation setEducationDes(String educationDes) {
        this.educationDes = educationDes;
        return this;
    }

    /**
     * 获取 是否认证    暂不启用 的值
     * @return Integer
     */
    public Integer getIsTrue() {
        return isTrue;
    }
    
    /**
     * 设置是否认证    暂不启用 的值
     *
     */
    public ExperienceEducation setIsTrue(Integer isTrue) {
        this.isTrue = isTrue;
        return this;
    }

    @Override
    public String toString() {
        return "ExperienceEducation{" +
                "educationId=" + educationId +
                ", userId=" + userId +
                ", schoolId=" + schoolId +
                ", schoolName='" + schoolName + '\'' +
                ", educationMajor='" + educationMajor + '\'' +
                ", educationLevel=" + educationLevel +
                ", educationStartTime='" + educationStartTime + '\'' +
                ", educationEndTime='" + educationEndTime + '\'' +
                ", educationDes=" + educationDes +
                ", isTrue=" + isTrue +
                '}';
    }
}