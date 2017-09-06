package com.example.win.newintern3.NewEntity;

public class ExperiencePractice implements java.io.Serializable {
    public ExperiencePractice() {

    }

    public ExperiencePractice(Integer practiceId, Integer userId, Integer userPracticeId, Integer companyId, String companyName, String practicePost, String practiceStartTime, String practiceEndTime, String practiceDes, Integer practiceExperienceType, Integer isTrue) {
        this.practiceId = practiceId;
        this.userId = userId;
        this.userPracticeId = userPracticeId;
        this.companyId = companyId;
        this.companyName = companyName;
        this.practicePost = practicePost;
        this.practiceStartTime = practiceStartTime;
        this.practiceEndTime = practiceEndTime;
        this.practiceDes = practiceDes;
        this.practiceExperienceType = practiceExperienceType;
        this.isTrue = isTrue;
    }

    private Integer practiceId;
    /** 用户ID */
    private Integer userId;

    /** 实习ID */
    private Integer userPracticeId;

    /** 公司ID  暂不启用 */
    private Integer companyId;

    /** 在职企业名称 */
    private String companyName;

    /** 担任职位 */
    private String practicePost;

    /** 实习开始时间 */
    private String practiceStartTime;

    /** 实习结束时间 */
    private String practiceEndTime;

    /** 项目描述 */
    private String practiceDes;

    /** 实习经历类型    0：未认证；1：系统认证 */
    private Integer practiceExperienceType;

    /** 是否认证    暂不启用 */
    private Integer isTrue;



    /**
     * 获取 实习经历ID 的值
     * @return String
     */
    public Integer getPracticeId() {
		return practiceId;
	}

	public ExperiencePractice setPracticeId(Integer practiceId) {
		this.practiceId = practiceId;
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
    public ExperiencePractice setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 获取 实习ID 的值
     * @return Integer
     */
    public Integer getUserPracticeId() {
        return userPracticeId;
    }
    
    /**
     * 设置实习ID 的值
     *
     */
    public ExperiencePractice setUserPracticeId(Integer userPracticeId) {
        this.userPracticeId = userPracticeId;
        return this;
    }

    /**
     * 获取 公司ID  暂不启用 的值
     * @return Integer
     */
    public Integer getCompanyId() {
        return companyId;
    }
    
    /**
     * 设置公司ID  暂不启用 的值
     *
     */
    public ExperiencePractice setCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    /**
     * 获取 在职企业名称 的值
     * @return String
     */
    public String getCompanyName() {
        return companyName;
    }
    
    /**
     * 设置在职企业名称 的值
     *
     */
    public ExperiencePractice setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    /**
     * 获取 担任职位 的值
     * @return String
     */
    public String getPracticePost() {
        return practicePost;
    }
    
    /**
     * 设置担任职位 的值
     *
     */
    public ExperiencePractice setPracticePost(String practicePost) {
        this.practicePost = practicePost;
        return this;
    }

    /**
     * 获取 实习开始时间 的值
     * @return String
     */
    public String getPracticeStartTime() {
        return practiceStartTime;
    }
    
    /**
     * 设置实习开始时间 的值
     *
     */
    public ExperiencePractice setPracticeStartTime(String practiceStartTime) {
        this.practiceStartTime = practiceStartTime;
        return this;
    }

    /**
     * 获取 实习结束时间 的值
     * @return String
     */
    public String getPracticeEndTime() {
        return practiceEndTime;
    }
    
    /**
     * 设置实习结束时间 的值
     *
     */
    public ExperiencePractice setPracticeEndTime(String practiceEndTime) {
        this.practiceEndTime = practiceEndTime;
        return this;
    }

    /**
     * 获取 项目描述 的值
     * @return String
     */
    public String getPracticeDes() {
        return practiceDes;
    }
    
    /**
     * 设置项目描述 的值
     *
     */
    public ExperiencePractice setPracticeDes(String practiceDes) {
        this.practiceDes = practiceDes;
        return this;
    }

    /**
     * 获取 实习经历类型    0：未认证；1：系统认证 的值
     * @return Integer
     */
    public Integer getPracticeExperienceType() {
        return practiceExperienceType;
    }
    
    /**
     * 设置实习经历类型    0：未认证；1：系统认证 的值
     *
     */
    public ExperiencePractice setPracticeExperienceType(Integer practiceExperienceType) {
        this.practiceExperienceType = practiceExperienceType;
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
    public ExperiencePractice setIsTrue(Integer isTrue) {
        this.isTrue = isTrue;
        return this;
    }


    @Override
    public String toString() {
        return "ExperiencePractice{" +
                "practiceId=" + practiceId +
                ", userId=" + userId +
                ", userPracticeId=" + userPracticeId +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", practicePost='" + practicePost + '\'' +
                ", practiceStartTime='" + practiceStartTime + '\'' +
                ", practiceEndTime='" + practiceEndTime + '\'' +
                ", practiceDes=" + practiceDes +
                ", practiceExperienceType=" + practiceExperienceType +
                ", isTrue=" + isTrue +
                '}';
    }
}