package com.example.win.newintern3.NewEntity;



public class CompanyPost implements java.io.Serializable {
    public CompanyPost() {

    }

    public CompanyPost(Integer postId, Integer companyId, String postName, Integer postNum, Object postDes, String postStartTime, String postEndTime, Integer postType, String postLabel, String postPoints, Object postSpecialDes, String postMoney, String practiceStartTime, String practiceEndTime, String practicePosition, String intentionTrade, Integer postSendNumber, Integer postClick, String postInvalidTime, Object isTrue, Integer publisher, Integer practiceProvinceId, Integer practiceCityId) {
        this.postId = postId;
        this.companyId = companyId;
        this.postName = postName;
        this.postNum = postNum;
        this.postDes = postDes;
        this.postStartTime = postStartTime;
        this.postEndTime = postEndTime;
        this.postType = postType;
        this.postLabel = postLabel;
        this.postPoints = postPoints;
        this.postSpecialDes = postSpecialDes;
        this.postMoney = postMoney;
        this.practiceStartTime = practiceStartTime;
        this.practiceEndTime = practiceEndTime;
        this.practicePosition = practicePosition;
        this.intentionTrade = intentionTrade;
        this.postSendNumber = postSendNumber;
        this.postClick = postClick;
        this.postInvalidTime = postInvalidTime;
        this.isTrue = isTrue;
        this.publisher = publisher;
        this.practiceProvinceId = practiceProvinceId;
        this.practiceCityId = practiceCityId;
    }

    private Integer postId;
    /** 企业ID */
    private Integer companyId;

    /** 岗位名称 */
    private String postName;

    /** 岗位需求人数 */
    private Integer postNum;

    /** 岗位描述 */
    private Object postDes;

    /** 发布时间	接收简历的开始时间 */
    private String postStartTime;

    /** 接收简历的截止时间 */
    private String postEndTime;

    /** 岗位类型	1：实习岗位；2：正式岗位  预留 */
    private Integer postType;

    /** 岗位标签	每个最多10字，最多10个标签 “，”分割 */
    private String postLabel;

    /** 岗位亮点 */
    private String postPoints;

    /** 特殊说明 */
    private Object postSpecialDes;

    /** 薪酬范围 */
    private String postMoney;

    /** 实习开始时间  无 */
    private String practiceStartTime;

    /** 实习结束时间  无 */
    private String practiceEndTime;

    /** 工作地 */
    private String practicePosition;

    /** 意向专业  一对多 */
    private String intentionTrade;

    /** 发布量 */
    private Integer postSendNumber = 0;

    /** 点击量 */
    private Integer postClick = 0;

    /** 岗位失效时间  （无效字段） */
    private String postInvalidTime;

    /** 是否可用 */
    private Object isTrue;

    /** 发布人（账号） */
    private Integer publisher;

    /** 实习省份 */
    private Integer practiceProvinceId;

    /** 实习城市 */
    private Integer practiceCityId;

    /**
     * 临时字段
     */
    /** 企业对象 */
   // private CompanyInfo companyInfo;
    
  
    
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
    public CompanyPost setPostId(Integer postId) {
        this.postId = postId;
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
    public CompanyPost setCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    /**
     * 获取 岗位名称 的值
     * @return String
     */
    public String getPostName() {
        return postName;
    }
    
    /**
     * 设置岗位名称 的值
     *
     */
    public CompanyPost setPostName(String postName) {
        this.postName = postName;
        return this;
    }

    /**
     * 获取 岗位需求人数 的值
     * @return Integer
     */
    public Integer getPostNum() {
        return postNum;
    }
    
    /**
     * 设置岗位需求人数 的值
     *
     */
    public CompanyPost setPostNum(Integer postNum) {
        this.postNum = postNum;
        return this;
    }

    /**
     * 获取 岗位描述 的值
     * @return Object
     */
    public Object getPostDes() {
        return postDes;
    }
    
    /**
     * 设置岗位描述 的值
     *
     */
    public CompanyPost setPostDes(Object postDes) {
        this.postDes = postDes;
        return this;
    }

    /**
     * 获取 发布时间	接收简历的开始时间 的值
     * @return String
     */
    public String getPostStartTime() {
        return postStartTime;
    }
    
    /**
     * 设置发布时间	接收简历的开始时间 的值
     *
     */
    public CompanyPost setPostStartTime(String postStartTime) {
        this.postStartTime = postStartTime;
        return this;
    }

    /**
     * 获取 接收简历的截止时间 的值
     * @return String
     */
    public String getPostEndTime() {
        return postEndTime;
    }
    
    /**
     * 设置接收简历的截止时间 的值
     *
     */
    public CompanyPost setPostEndTime(String postEndTime) {
        this.postEndTime = postEndTime;
        return this;
    }

    /**
     * 获取 岗位类型	1：实习岗位；2：正式岗位  预留 的值
     * @return Integer
     */
    public Integer getPostType() {
        return postType;
    }
    
    /**
     * 设置岗位类型	1：实习岗位；2：正式岗位  预留 的值
     *
     */
    public CompanyPost setPostType(Integer postType) {
        this.postType = postType;
        return this;
    }

    /**
     * 获取 岗位标签	每个最多10字，最多10个标签 “，”分割 的值
     * @return String
     */
    public String getPostLabel() {
        return postLabel;
    }
    
    /**
     * 设置岗位标签	每个最多10字，最多10个标签 “，”分割 的值
     *
     */
    public CompanyPost setPostLabel(String postLabel) {
        this.postLabel = postLabel;
        return this;
    }

    /**
     * 获取 岗位亮点 的值
     * @return String
     */
    public String getPostPoints() {
        return postPoints;
    }
    
    /**
     * 设置岗位亮点 的值
     *
     */
    public CompanyPost setPostPoints(String postPoints) {
        this.postPoints = postPoints;
        return this;
    }

    /**
     * 获取 特殊说明 的值
     * @return Object
     */
    public Object getPostSpecialDes() {
        return postSpecialDes;
    }
    
    /**
     * 设置特殊说明 的值
     *
     */
    public CompanyPost setPostSpecialDes(Object postSpecialDes) {
        this.postSpecialDes = postSpecialDes;
        return this;
    }

    /**
     * 获取 薪酬范围 的值
     * @return String
     */
    public String getPostMoney() {
        return postMoney;
    }
    
    /**
     * 设置薪酬范围 的值
     *
     */
    public CompanyPost setPostMoney(String postMoney) {
        this.postMoney = postMoney;
        return this;
    }

    /**
     * 获取 实习开始时间  无 的值
     * @return String
     */
    public String getPracticeStartTime() {
        return practiceStartTime;
    }
    
    /**
     * 设置实习开始时间  无 的值
     *
     */
    public CompanyPost setPracticeStartTime(String practiceStartTime) {
        this.practiceStartTime = practiceStartTime;
        return this;
    }

    /**
     * 获取 实习结束时间  无 的值
     * @return String
     */
    public String getPracticeEndTime() {
        return practiceEndTime;
    }
    
    /**
     * 设置实习结束时间  无 的值
     *
     */
    public CompanyPost setPracticeEndTime(String practiceEndTime) {
        this.practiceEndTime = practiceEndTime;
        return this;
    }

    /**
     * 获取 工作地 的值
     * @return String
     */
    public String getPracticePosition() {
        return practicePosition;
    }
    
    /**
     * 设置工作地 的值
     *
     */
    public CompanyPost setPracticePosition(String practicePosition) {
        this.practicePosition = practicePosition;
        return this;
    }

    /**
     * 获取 意向专业  一对多 的值
     * @return String
     */
    public String getIntentionTrade() {
        return intentionTrade;
    }
    
    /**
     * 设置意向专业  一对多 的值
     *
     */
    public CompanyPost setIntentionTrade(String intentionTrade) {
        this.intentionTrade = intentionTrade;
        return this;
    }

    /**
     * 获取 发布量 的值
     * @return Integer
     */
    public Integer getPostSendNumber() {
        return postSendNumber;
    }
    
    /**
     * 设置发布量 的值
     *
     */
    public CompanyPost setPostSendNumber(Integer postSendNumber) {
        this.postSendNumber = postSendNumber;
        return this;
    }

    /**
     * 获取 点击量 的值
     * @return Integer
     */
    public Integer getPostClick() {
        return postClick;
    }
    
    /**
     * 设置点击量 的值
     *
     */
    public CompanyPost setPostClick(Integer postClick) {
        this.postClick = postClick;
        return this;
    }

    /**
     * 获取 岗位失效时间  （无效字段） 的值
     * @return String
     */
    public String getPostInvalidTime() {
        return postInvalidTime;
    }
    
    /**
     * 设置岗位失效时间  （无效字段） 的值
     *
     */
    public CompanyPost setPostInvalidTime(String postInvalidTime) {
        this.postInvalidTime = postInvalidTime;
        return this;
    }

    /**
     * 获取 是否可用 的值
     * @return Object
     */
    public Object getIsTrue() {
        return isTrue;
    }
    
    /**
     * 设置是否可用 的值
     *
     */
    public CompanyPost setIsTrue(Object isTrue) {
        this.isTrue = isTrue;
        return this;
    }

    /**
     * 获取 发布人（账号） 的值
     * @return Integer
     */
    public Integer getPublisher() {
        return publisher;
    }
    
    /**
     * 设置发布人（账号） 的值
     *
     */
    public CompanyPost setPublisher(Integer publisher) {
        this.publisher = publisher;
        return this;
    }

    /**
     * 获取 实习省份 的值
     * @return Integer
     */
    public Integer getPracticeProvinceId() {
        return practiceProvinceId;
    }
    
    /**
     * 设置实习省份 的值
     *
     */
    public CompanyPost setPracticeProvinceId(Integer practiceProvinceId) {
        this.practiceProvinceId = practiceProvinceId;
        return this;
    }

    /**
     * 获取 实习城市 的值
     * @return Integer
     */
    public Integer getPracticeCityId() {
        return practiceCityId;
    }
    
    /**
     * 设置实习城市 的值
     *
     */
    public CompanyPost setPracticeCityId(Integer practiceCityId) {
        this.practiceCityId = practiceCityId;
        return this;
    }


	/*public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}*/

    @Override
    public String toString() {
        return "CompanyPost{" +
                "postId=" + postId +
                ", companyId=" + companyId +
                ", postName='" + postName + '\'' +
                ", postNum=" + postNum +
                ", postDes=" + postDes +
                ", postStartTime='" + postStartTime + '\'' +
                ", postEndTime='" + postEndTime + '\'' +
                ", postType=" + postType +
                ", postLabel='" + postLabel + '\'' +
                ", postPoints='" + postPoints + '\'' +
                ", postSpecialDes=" + postSpecialDes +
                ", postMoney='" + postMoney + '\'' +
                ", practiceStartTime='" + practiceStartTime + '\'' +
                ", practiceEndTime='" + practiceEndTime + '\'' +
                ", practicePosition='" + practicePosition + '\'' +
                ", intentionTrade='" + intentionTrade + '\'' +
                ", postSendNumber=" + postSendNumber +
                ", postClick=" + postClick +
                ", postInvalidTime='" + postInvalidTime + '\'' +
                ", isTrue=" + isTrue +
                ", publisher=" + publisher +
                ", practiceProvinceId=" + practiceProvinceId +
                ", practiceCityId=" + practiceCityId +
                '}';
    }
//	public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append(this.getClass().getName());
//        sb.append("; postId=" + (postId == null ? "null" : postId.toString()));
//        sb.append("; companyId=" + (companyId == null ? "null" : companyId.toString()));
//        sb.append("; postName=" + (postName == null ? "null" : postName.toString()));
//        sb.append("; postNum=" + (postNum == null ? "null" : postNum.toString()));
//        sb.append("; postDes=" + (postDes == null ? "null" : postDes.toString()));
//        sb.append("; postStartTime=" + (postStartTime == null ? "null" : postStartTime.toString()));
//        sb.append("; postEndTime=" + (postEndTime == null ? "null" : postEndTime.toString()));
//        sb.append("; postType=" + (postType == null ? "null" : postType.toString()));
//        sb.append("; postLabel=" + (postLabel == null ? "null" : postLabel.toString()));
//        sb.append("; postPoints=" + (postPoints == null ? "null" : postPoints.toString()));
//        sb.append("; postSpecialDes=" + (postSpecialDes == null ? "null" : postSpecialDes.toString()));
//        sb.append("; postMoney=" + (postMoney == null ? "null" : postMoney.toString()));
//        sb.append("; practiceStartTime=" + (practiceStartTime == null ? "null" : practiceStartTime.toString()));
//        sb.append("; practiceEndTime=" + (practiceEndTime == null ? "null" : practiceEndTime.toString()));
//        sb.append("; practicePosition=" + (practicePosition == null ? "null" : practicePosition.toString()));
//        sb.append("; intentionTrade=" + (intentionTrade == null ? "null" : intentionTrade.toString()));
//        sb.append("; postSendNumber=" + (postSendNumber == null ? "null" : postSendNumber.toString()));
//        sb.append("; postClick=" + (postClick == null ? "null" : postClick.toString()));
//        sb.append("; postInvalidTime=" + (postInvalidTime == null ? "null" : postInvalidTime.toString()));
//        sb.append("; isTrue=" + (isTrue == null ? "null" : isTrue.toString()));
//        sb.append("; publisher=" + (publisher == null ? "null" : publisher.toString()));
//        sb.append("; practiceProvinceId=" + (practiceProvinceId == null ? "null" : practiceProvinceId.toString()));
//        sb.append("; practiceCityId=" + (practiceCityId == null ? "null" : practiceCityId.toString()));
//
//        return sb.toString();
//    }
}