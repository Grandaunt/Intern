package com.example.win.newintern3.NewEntity;




public class CompanyPracticeApply implements java.io.Serializable {
    public CompanyPracticeApply() {

    }

    public CompanyPracticeApply(Integer companyApplyId, Integer userId, Integer postId, String applyTime, Integer applyStatus, Integer checker, String checkTime, Object checkDes) {
        this.companyApplyId = companyApplyId;
        this.userId = userId;
        this.postId = postId;
        this.applyTime = applyTime;
        this.applyStatus = applyStatus;
        this.checker = checker;
        this.checkTime = checkTime;
        this.checkDes = checkDes;
    }

    private Integer companyApplyId;
    /** 用户ID */
    private Integer userId;

    /** 职位ID */
    private Integer postId;

    /** 申请时间 */
    private String applyTime;

    /** 申请状态	1：待审核；2：审核通过；3：审核驳回；4：已失效 */
    private Integer applyStatus;

    /** 审核人ID */
    private Integer checker;

    /** 审核时间 */
    private String checkTime;

    /** 审核意见 */
    private Object checkDes;



    /**
     * 获取 申请ID 的值
     * @return Integer
     */
    public Integer getCompanyApplyId() {
        return companyApplyId;
    }
    
    /**
     * 设置申请ID 的值
     *
     */
    public CompanyPracticeApply setCompanyApplyId(Integer companyApplyId) {
        this.companyApplyId = companyApplyId;
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
    public CompanyPracticeApply setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 获取 职位ID 的值
     * @return Integer
     */
    public Integer getPostId() {
        return postId;
    }
    
    /**
     * 设置职位ID 的值
     *
     */
    public CompanyPracticeApply setPostId(Integer postId) {
        this.postId = postId;
        return this;
    }

    /**
     * 获取 申请时间 的值
     * @return String
     */
    public String getApplyTime() {
        return applyTime;
    }
    
    /**
     * 设置申请时间 的值
     *
     */
    public CompanyPracticeApply setApplyTime(String applyTime) {
        this.applyTime = applyTime;
        return this;
    }

    /**
     * 获取 申请状态	1：待审核；2：审核通过；3：审核驳回；4：已失效 的值
     * @return Integer
     */
    public Integer getApplyStatus() {
        return applyStatus;
    }
    
    /**
     * 设置申请状态	1：待审核；2：审核通过；3：审核驳回；4：已失效 的值
     *
     */
    public CompanyPracticeApply setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
        return this;
    }

    /**
     * 获取 审核人ID 的值
     * @return Integer
     */
    public Integer getChecker() {
        return checker;
    }
    
    /**
     * 设置审核人ID 的值
     *
     */
    public CompanyPracticeApply setChecker(Integer checker) {
        this.checker = checker;
        return this;
    }

    /**
     * 获取 审核时间 的值
     * @return String
     */
    public String getCheckTime() {
        return checkTime;
    }
    
    /**
     * 设置审核时间 的值
     *
     */
    public CompanyPracticeApply setCheckTime(String checkTime) {
        this.checkTime = checkTime;
        return this;
    }

    /**
     * 获取 审核意见 的值
     * @return Object
     */
    public Object getCheckDes() {
        return checkDes;
    }
    
    /**
     * 设置审核意见 的值
     *
     */
    public CompanyPracticeApply setCheckDes(Object checkDes) {
        this.checkDes = checkDes;
        return this;
    }

    @Override
    public String toString() {
        return "CompanyPracticeApply{" +
                "companyApplyId=" + companyApplyId +
                ", userId=" + userId +
                ", postId=" + postId +
                ", applyTime='" + applyTime + '\'' +
                ", applyStatus=" + applyStatus +
                ", checker=" + checker +
                ", checkTime='" + checkTime + '\'' +
                ", checkDes=" + checkDes +
                '}';
    }
//	public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append(this.getClass().getName());
//        sb.append("; companyApplyId=" + (companyApplyId == null ? "null" : companyApplyId.toString()));
//        sb.append("; userId=" + (userId == null ? "null" : userId.toString()));
//        sb.append("; postId=" + (postId == null ? "null" : postId.toString()));
//        sb.append("; applyTime=" + (applyTime == null ? "null" : applyTime.toString()));
//        sb.append("; applyStatus=" + (applyStatus == null ? "null" : applyStatus.toString()));
//        sb.append("; checker=" + (checker == null ? "null" : checker.toString()));
//        sb.append("; checkTime=" + (checkTime == null ? "null" : checkTime.toString()));
//        sb.append("; checkDes=" + (checkDes == null ? "null" : checkDes.toString()));
//
//        return sb.toString();
//    }
}