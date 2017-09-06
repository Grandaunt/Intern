package com.example.win.newintern3.NewEntity;

public class ExperienceProject implements java.io.Serializable {
    public ExperienceProject() {

    }

    public ExperienceProject(Integer projectId, Integer userId, String projectName, Integer companyId, String companyName, String projectPost, String projectStartTime, String projectEndTime, String projectDes, Integer isTrue) {
        this.projectId = projectId;
        this.userId = userId;
        this.projectName = projectName;
        this.companyId = companyId;
        this.companyName = companyName;
        this.projectPost = projectPost;
        this.projectStartTime = projectStartTime;
        this.projectEndTime = projectEndTime;
        this.projectDes = projectDes;
        this.isTrue = isTrue;
    }

    private Integer projectId;
    /** 用户ID */
    private Integer userId;

    /** 项目名称 */
    private String projectName;

    /** 公司ID  暂不启用 */
    private Integer companyId;

    /** 在职企业名称 */
    private String companyName;

    /** 担任职位 */
    private String projectPost;

    /** 项目开始时间 */
    private String projectStartTime;

    /** 项目结束时间 */
    private String projectEndTime;

    /** 项目描述 */
    private String projectDes;

    /** 是否认证    暂不启用 */
    private Integer isTrue;



    /**
     * 获取 项目经历 的值
     * @return String
     */
    public Integer getProjectId() {
        return projectId;
    }
    
    /**
     * 设置项目经历 的值
     *
     */
    public ExperienceProject setProjectId(Integer projectId) {
        this.projectId = projectId;
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
    public ExperienceProject setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 获取 项目名称 的值
     * @return String
     */
    public String getProjectName() {
        return projectName;
    }
    
    /**
     * 设置项目名称 的值
     *
     */
    public ExperienceProject setProjectName(String projectName) {
        this.projectName = projectName;
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
    public ExperienceProject setCompanyId(Integer companyId) {
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
    public ExperienceProject setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    /**
     * 获取 担任职位 的值
     * @return String
     */
    public String getProjectPost() {
        return projectPost;
    }
    
    /**
     * 设置担任职位 的值
     *
     */
    public ExperienceProject setProjectPost(String projectPost) {
        this.projectPost = projectPost;
        return this;
    }

    /**
     * 获取 项目开始时间 的值
     * @return String
     */
    public String getProjectStartTime() {
        return projectStartTime;
    }
    
    /**
     * 设置项目开始时间 的值
     *
     */
    public ExperienceProject setProjectStartTime(String projectStartTime) {
        this.projectStartTime = projectStartTime;
        return this;
    }

    /**
     * 获取 项目结束时间 的值
     * @return String
     */
    public String getProjectEndTime() {
        return projectEndTime;
    }
    
    /**
     * 设置项目结束时间 的值
     *
     */
    public ExperienceProject setProjectEndTime(String projectEndTime) {
        this.projectEndTime = projectEndTime;
        return this;
    }

    /**
     * 获取 项目描述 的值
     * @return String
     */
    public String getProjectDes() {
        return projectDes;
    }
    
    /**
     * 设置项目描述 的值
     *
     */
    public ExperienceProject setProjectDes(String projectDes) {
        this.projectDes = projectDes;
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
    public ExperienceProject setIsTrue(Integer isTrue) {
        this.isTrue = isTrue;
        return this;
    }

    @Override
    public String toString() {
        return "ExperienceProject{" +
                "projectId=" + projectId +
                ", userId=" + userId +
                ", projectName='" + projectName + '\'' +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", projectPost='" + projectPost + '\'' +
                ", projectStartTime='" + projectStartTime + '\'' +
                ", projectEndTime='" + projectEndTime + '\'' +
                ", projectDes=" + projectDes +
                ", isTrue=" + isTrue +
                '}';
    }
}