package com.example.win.newintern3.NewEntity;



public class PracticePlan implements java.io.Serializable {

    public PracticePlan() {

    }

    public PracticePlan(Integer planId, Integer schoolPlanId, String practiceName, Integer departmentId, String planStartTime, String planEndTime, String discribe, String creator, Integer userId, String createTime) {
        this.planId = planId;
        this.schoolPlanId = schoolPlanId;
        this.practiceName = practiceName;
        this.departmentId = departmentId;
        this.planStartTime = planStartTime;
        this.planEndTime = planEndTime;
        this.discribe = discribe;
        this.creator = creator;
        this.userId = userId;
        this.createTime = createTime;
    }

    private Integer planId;
    /** SchoolPlanId */
    private Integer schoolPlanId = 0;

    /** 实习名称 */
    private String practiceName;

    /** 所属院系 */
    private Integer departmentId;

    /** 开始时间 */
    private String planStartTime;

    /** 结束时间 */
    private String planEndTime;

    /** 描述 */
    private String discribe;

    /** 创建人 */
    private String creator;

    /** 创建人ID */
    private Integer userId;

    /** 创建时间 */
    private String createTime;



    /**
     * 获取 PlanId 的值
     * @return Integer
     */
    public Integer getPlanId() {
        return planId;
    }
    
    /**
     * 设置PlanId 的值
     *
     */
    public PracticePlan setPlanId(Integer planId) {
        this.planId = planId;
        return this;
    }

    /**
     * 获取 SchoolPlanId 的值
     * @return Integer
     */
    public Integer getSchoolPlanId() {
        return schoolPlanId;
    }
    
    /**
     * 设置SchoolPlanId 的值
     *
     */
    public PracticePlan setSchoolPlanId(Integer schoolPlanId) {
        this.schoolPlanId = schoolPlanId;
        return this;
    }

    /**
     * 获取 实习名称 的值
     * @return String
     */
    public String getPracticeName() {
        return practiceName;
    }
    
    /**
     * 设置实习名称 的值
     *
     */
    public PracticePlan setPracticeName(String practiceName) {
        this.practiceName = practiceName;
        return this;
    }

    /**
     * 获取 所属院系 的值
     * @return Integer
     */
    public Integer getDepartmentId() {
        return departmentId;
    }
    
    /**
     * 设置所属院系 的值
     *
     */
    public PracticePlan setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    /**
     * 获取 开始时间 的值
     * @return String
     */
    public String getPlanStartTime() {
        return planStartTime;
    }
    
    /**
     * 设置开始时间 的值
     *
     */
    public PracticePlan setPlanStartTime(String planStartTime) {
        this.planStartTime = planStartTime;
        return this;
    }

    /**
     * 获取 结束时间 的值
     * @return String
     */
    public String getPlanEndTime() {
        return planEndTime;
    }
    
    /**
     * 设置结束时间 的值
     *
     */
    public PracticePlan setPlanEndTime(String planEndTime) {
        this.planEndTime = planEndTime;
        return this;
    }

    /**
     * 获取 描述 的值
     * @return String
     */
    public String getDiscribe() {
        return discribe;
    }
    
    /**
     * 设置描述 的值
     *
     */
    public PracticePlan setDiscribe(String discribe) {
        this.discribe = discribe;
        return this;
    }

    /**
     * 获取 创建人 的值
     * @return String
     */
    public String getCreator() {
        return creator;
    }
    
    /**
     * 设置创建人 的值
     *
     */
    public PracticePlan setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    /**
     * 获取 创建人ID 的值
     * @return Integer
     */
    public Integer getUserId() {
        return userId;
    }
    
    /**
     * 设置创建人ID 的值
     *
     */
    public PracticePlan setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 获取 创建时间 的值
     * @return String
     */
    public String getCreateTime() {
        return createTime;
    }
    
    /**
     * 设置创建时间 的值
     *
     */
    public PracticePlan setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public String toString() {
        return "PracticePlan{" +
                "planId=" + planId +
                ", schoolPlanId=" + schoolPlanId +
                ", practiceName='" + practiceName + '\'' +
                ", departmentId=" + departmentId +
                ", planStartTime='" + planStartTime + '\'' +
                ", planEndTime='" + planEndTime + '\'' +
                ", discribe='" + discribe + '\'' +
                ", creator='" + creator + '\'' +
                ", userId=" + userId +
                ", createTime='" + createTime + '\'' +
                '}';
    }
//
//	public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append(this.getClass().getName());
//        sb.append("; planId=" + (planId == null ? "null" : planId.toString()));
//        sb.append("; schoolPlanId=" + (schoolPlanId == null ? "null" : schoolPlanId.toString()));
//        sb.append("; practiceName=" + (practiceName == null ? "null" : practiceName.toString()));
//        sb.append("; departmentId=" + (departmentId == null ? "null" : departmentId.toString()));
//        sb.append("; planStartTime=" + (planStartTime == null ? "null" : planStartTime.toString()));
//        sb.append("; planEndTime=" + (planEndTime == null ? "null" : planEndTime.toString()));
//        sb.append("; discribe=" + (discribe == null ? "null" : discribe.toString()));
//        sb.append("; creator=" + (creator == null ? "null" : creator.toString()));
//        sb.append("; userId=" + (userId == null ? "null" : userId.toString()));
//        sb.append("; createTime=" + (createTime == null ? "null" : createTime.toString()));
//
//        return sb.toString();
//    }
}