package com.example.win.newintern3.NewEntity;

public class Experiencework implements java.io.Serializable {
    public Experiencework() {

    }

    public Experiencework(Integer workId, Integer userId, Integer companyId, String companyName, String workPost, String workStartTime, String workEndTime, String workDes, Integer isTrue) {
        this.workId = workId;
        this.userId = userId;
        this.companyId = companyId;
        this.companyName = companyName;
        this.workPost = workPost;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
        this.workDes = workDes;
        this.isTrue = isTrue;
    }

    private Integer workId;
    /** 用户ID */
    private Integer userId;

    /** 公司ID  暂不启用 */
    private Integer companyId;

    /** 在职企业名称 */
    private String companyName;

    /** 岗位 */
    private String workPost;

    /** 开始时间 */
    private String workStartTime;

    /** 结束时间 */
    private String workEndTime;

    /** 经历描述 */
    private String workDes;

    /** 是否认证    暂不启用 */
    private Integer isTrue;



    /**
     * 获取 工作经历ID 的值
     * @return String
     */
    public Integer getWorkId() {
        return workId;
    }
    
    /**
     * 设置工作经历ID 的值
     *
     */
    public Experiencework setWorkId(Integer workId) {
        this.workId = workId;
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
    public Experiencework setUserId(Integer userId) {
        this.userId = userId;
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
    public Experiencework setCompanyId(Integer companyId) {
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
    public Experiencework setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    /**
     * 获取 岗位 的值
     * @return String
     */
    public String getWorkPost() {
        return workPost;
    }
    
    /**
     * 设置岗位 的值
     *
     */
    public Experiencework setWorkPost(String workPost) {
        this.workPost = workPost;
        return this;
    }

    /**
     * 获取 开始时间 的值
     * @return String
     */
    public String getWorkStartTime() {
        return workStartTime;
    }
    
    /**
     * 设置开始时间 的值
     *
     */
    public Experiencework setWorkStartTime(String workStartTime) {
        this.workStartTime = workStartTime;
        return this;
    }

    /**
     * 获取 结束时间 的值
     * @return String
     */
    public String getWorkEndTime() {
        return workEndTime;
    }
    
    /**
     * 设置结束时间 的值
     *
     */
    public Experiencework setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
        return this;
    }

    /**
     * 获取 经历描述 的值
     * @return String
     */
    public String getWorkDes() {
        return workDes;
    }
    
    /**
     * 设置经历描述 的值
     *
     */
    public Experiencework setWorkDes(String workDes) {
        this.workDes = workDes;
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
    public Experiencework setIsTrue(Integer isTrue) {
        this.isTrue = isTrue;
        return this;
    }


    @Override
    public String toString() {
        return "Experiencework{" +
                "workId=" + workId +
                ", userId=" + userId +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", workPost='" + workPost + '\'' +
                ", workStartTime='" + workStartTime + '\'' +
                ", workEndTime='" + workEndTime + '\'' +
                ", workDes=" + workDes +
                ", isTrue=" + isTrue +
                '}';
    }
}