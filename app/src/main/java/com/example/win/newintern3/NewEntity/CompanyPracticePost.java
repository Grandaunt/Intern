package com.example.win.newintern3.NewEntity;


public class CompanyPracticePost implements java.io.Serializable {

    public CompanyPracticePost() {

    }

    public CompanyPracticePost(Integer postId, Integer companyId, String postName, Integer postNum, String postDes, String postStartTime, String postEndTime, Integer postType, String postLabel, String postPoints, String postSpecialDes, String postMoney, String practiceStartTime, String practiceEndTime, String position, String intentionTrade, Integer postSendNumber, Integer postClick, String postInvalidTime, String isTrue, Integer publisher, Integer provinceId, Integer cityId, Integer areaId, String provinceName, String cityName, String areaName, Integer schoolId, CompanyInfo companyInfo) {
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
        this.position = position;
        this.intentionTrade = intentionTrade;
        this.postSendNumber = postSendNumber;
        this.postClick = postClick;
        this.postInvalidTime = postInvalidTime;
        this.isTrue = isTrue;
        this.publisher = publisher;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.areaId = areaId;
        this.provinceName = provinceName;
        this.cityName = cityName;
        this.areaName = areaName;
        this.schoolId = schoolId;
        this.companyInfo = companyInfo;
    }

    private Integer postId;
    /** 企业ID */
    private Integer companyId;

    /** 岗位名称 */
    private String postName;

    /** 岗位需求人数 */
    private Integer postNum;

    /** 岗位描述 */
    private String postDes;

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
    private String postSpecialDes;

    /** 薪酬范围 */
    private String postMoney;

    /** 实习开始时间  无 */
    private String practiceStartTime;

    /** 实习结束时间  无 */
    private String practiceEndTime;

    /** 工作地 */
    private String position;

    /** 意向专业  一对多 */
    private String intentionTrade;

    /** 发布量 */
    private Integer postSendNumber = 0;

    /** 点击量 */
    private Integer postClick = 0;

    /** 岗位失效时间  （无效字段） */
    private String postInvalidTime;

    /** 是否可用 1可用，0不可用 */
    private String isTrue;

    /** 发布人（账号） */
    private Integer publisher;

    /** 实习省份 */
    private Integer provinceId;

    /** 实习城市 */
    private Integer cityId;

    /** 实习区县 */
    private Integer areaId;

    /** 实习省份名称 */
    private String provinceName;

    /** 实习城市名称 */
    private String cityName;

    /** 实习区县名称 */
    private String areaName;

    /** 目标学校ID */
    private Integer schoolId;

    /** 企业对象 */

    private CompanyInfo companyInfo;

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
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
    public CompanyPracticePost setPostId(Integer postId) {
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
    public CompanyPracticePost setCompanyId(Integer companyId) {
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
    public CompanyPracticePost setPostName(String postName) {
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
    public CompanyPracticePost setPostNum(Integer postNum) {
        this.postNum = postNum;
        return this;
    }

    /**
     * 获取 岗位描述 的值
     * @return String
     */
    public String getPostDes() {
        return postDes;
    }

    /**
     * 设置岗位描述 的值
     *
     */
    public CompanyPracticePost setPostDes(String postDes) {
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
    public CompanyPracticePost setPostStartTime(String postStartTime) {
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
    public CompanyPracticePost setPostEndTime(String postEndTime) {
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
    public CompanyPracticePost setPostType(Integer postType) {
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
    public CompanyPracticePost setPostLabel(String postLabel) {
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
    public CompanyPracticePost setPostPoints(String postPoints) {
        this.postPoints = postPoints;
        return this;
    }

    /**
     * 获取 特殊说明 的值
     * @return String
     */
    public String getPostSpecialDes() {
        return postSpecialDes;
    }

    /**
     * 设置特殊说明 的值
     *
     */
    public CompanyPracticePost setPostSpecialDes(String postSpecialDes) {
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
    public CompanyPracticePost setPostMoney(String postMoney) {
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
    public CompanyPracticePost setPracticeStartTime(String practiceStartTime) {
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
    public CompanyPracticePost setPracticeEndTime(String practiceEndTime) {
        this.practiceEndTime = practiceEndTime;
        return this;
    }

    /**
     * 获取 工作地 的值
     * @return String
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置工作地 的值
     *
     */
    public CompanyPracticePost setPosition(String position) {
        this.position = position;
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
    public CompanyPracticePost setIntentionTrade(String intentionTrade) {
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
    public CompanyPracticePost setPostSendNumber(Integer postSendNumber) {
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
    public CompanyPracticePost setPostClick(Integer postClick) {
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
    public CompanyPracticePost setPostInvalidTime(String postInvalidTime) {
        this.postInvalidTime = postInvalidTime;
        return this;
    }

    /**
     * 获取 是否可用 1可用，0不可用 的值
     * @return String
     */
    public String getIsTrue() {
        return isTrue;
    }

    /**
     * 设置是否可用 1可用，0不可用 的值
     *
     */
    public CompanyPracticePost setIsTrue(String isTrue) {
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
    public CompanyPracticePost setPublisher(Integer publisher) {
        this.publisher = publisher;
        return this;
    }

    /**
     * 获取 实习省份 的值
     * @return Integer
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * 设置实习省份 的值
     *
     */
    public CompanyPracticePost setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
        return this;
    }

    /**
     * 获取 实习城市 的值
     * @return Integer
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 设置实习城市 的值
     *
     */
    public CompanyPracticePost setCityId(Integer cityId) {
        this.cityId = cityId;
        return this;
    }

    /**
     * 获取 实习区县 的值
     * @return Integer
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * 设置实习区县 的值
     *
     */
    public CompanyPracticePost setAreaId(Integer areaId) {
        this.areaId = areaId;
        return this;
    }

    /**
     * 获取 实习省份名称 的值
     * @return String
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * 设置实习省份名称 的值
     *
     */
    public CompanyPracticePost setProvinceName(String provinceName) {
        this.provinceName = provinceName;
        return this;
    }

    /**
     * 获取 实习城市名称 的值
     * @return String
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置实习城市名称 的值
     *
     */
    public CompanyPracticePost setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    /**
     * 获取 实习区县名称 的值
     * @return String
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置实习区县名称 的值
     *
     */
    public CompanyPracticePost setAreaName(String areaName) {
        this.areaName = areaName;
        return this;
    }

    /**
     * 获取 目标学校ID 的值
     * @return Integer
     */
    public Integer getSchoolId() {
        return schoolId;
    }

    /**
     * 设置目标学校ID 的值
     *
     */
    public CompanyPracticePost setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
        return this;
    }


    @Override
    public String toString() {
        return "CompanyPracticePost{" +
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
                ", position='" + position + '\'' +
                ", intentionTrade='" + intentionTrade + '\'' +
                ", postSendNumber=" + postSendNumber +
                ", postClick=" + postClick +
                ", postInvalidTime='" + postInvalidTime + '\'' +
                ", isTrue=" + isTrue +
                ", publisher=" + publisher +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", areaId=" + areaId +
                ", provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", schoolId=" + schoolId +
                ", companyInfo=" + companyInfo +
                '}';
    }
}