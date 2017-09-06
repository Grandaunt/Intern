package com.example.win.newintern3.NewEntity;




public class CompanyInfo implements java.io.Serializable {
    public CompanyInfo() {

    }

    public CompanyInfo(Integer companyId, String companyName, Integer authenType, Object companyDes, String position, String scale, String industryId, String companyAddress, String companyTel, String companyIcon, String companyNick, Integer companyCityId, Integer companyProvinceId, String companyTime, Object companyContent, String companyContacts, Object isTrue) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.authenType = authenType;
        this.companyDes = companyDes;
        this.position = position;
        this.scale = scale;
        this.industryId = industryId;
        this.companyAddress = companyAddress;
        this.companyTel = companyTel;
        this.companyIcon = companyIcon;
        this.companyNick = companyNick;
        this.companyCityId = companyCityId;
        this.companyProvinceId = companyProvinceId;
        this.companyTime = companyTime;
        this.companyContent = companyContent;
        this.companyContacts = companyContacts;
        this.isTrue = isTrue;
    }

    private Integer companyId;
    /** 企业名称 */
    private String companyName;

    /** 认证类型	0：未认证；1：学校认证；2：平台认证 */
    private Integer authenType = 0;

    /** 企业描述 */
    private Object companyDes;

    /** 位置	经纬度 */
    private String position;

    /** 规模 */
    private String scale;

    /** 行业	标准行业表 */
    private String industryId;

    /** 地址 */
    private String companyAddress;

    /** 企业联系电话 */
    private String companyTel;

    /** 企业LOGO */
    private String companyIcon;

    /** 企业昵称 */
    private String companyNick;

    /** 企业所属市 */
    private Integer companyCityId;

    /** 企业所属省份 */
    private Integer companyProvinceId;

    /** 企业成立时间 */
    private String companyTime;

    /** 详情 */
    private Object companyContent;

    /** 企业联系人 */
    private String companyContacts;

    /** IsTrue */
    private Object isTrue;



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
    public CompanyInfo setCompanyId(Integer companyId) {
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
    public CompanyInfo setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    /**
     * 获取 认证类型	0：未认证；1：学校认证；2：平台认证 的值
     * @return Integer
     */
    public Integer getAuthenType() {
        return authenType;
    }
    
    /**
     * 设置认证类型	0：未认证；1：学校认证；2：平台认证 的值
     *
     */
    public CompanyInfo setAuthenType(Integer authenType) {
        this.authenType = authenType;
        return this;
    }

    /**
     * 获取 企业描述 的值
     * @return Object
     */
    public Object getCompanyDes() {
        return companyDes;
    }
    
    /**
     * 设置企业描述 的值
     *
     */
    public CompanyInfo setCompanyDes(Object companyDes) {
        this.companyDes = companyDes;
        return this;
    }

    /**
     * 获取 位置	经纬度 的值
     * @return String
     */
    public String getPosition() {
        return position;
    }
    
    /**
     * 设置位置	经纬度 的值
     *
     */
    public CompanyInfo setPosition(String position) {
        this.position = position;
        return this;
    }

    /**
     * 获取 规模 的值
     * @return String
     */
    public String getScale() {
        return scale;
    }
    
    /**
     * 设置规模 的值
     *
     */
    public CompanyInfo setScale(String scale) {
        this.scale = scale;
        return this;
    }

    /**
     * 获取 行业	标准行业表 的值
     * @return String
     */
    public String getIndustryId() {
        return industryId;
    }
    
    /**
     * 设置行业	标准行业表 的值
     *
     */
    public CompanyInfo setIndustryId(String industryId) {
        this.industryId = industryId;
        return this;
    }

    /**
     * 获取 地址 的值
     * @return String
     */
    public String getCompanyAddress() {
        return companyAddress;
    }
    
    /**
     * 设置地址 的值
     *
     */
    public CompanyInfo setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
        return this;
    }

    /**
     * 获取 企业联系电话 的值
     * @return String
     */
    public String getCompanyTel() {
        return companyTel;
    }
    
    /**
     * 设置企业联系电话 的值
     *
     */
    public CompanyInfo setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
        return this;
    }

    /**
     * 获取 企业LOGO 的值
     * @return String
     */
    public String getCompanyIcon() {
        return companyIcon;
    }
    
    /**
     * 设置企业LOGO 的值
     *
     */
    public CompanyInfo setCompanyIcon(String companyIcon) {
        this.companyIcon = companyIcon;
        return this;
    }

    /**
     * 获取 企业昵称 的值
     * @return String
     */
    public String getCompanyNick() {
        return companyNick;
    }
    
    /**
     * 设置企业昵称 的值
     *
     */
    public CompanyInfo setCompanyNick(String companyNick) {
        this.companyNick = companyNick;
        return this;
    }

    /**
     * 获取 企业所属市 的值
     * @return Integer
     */
    public Integer getCompanyCityId() {
        return companyCityId;
    }
    
    /**
     * 设置企业所属市 的值
     *
     */
    public CompanyInfo setCompanyCityId(Integer companyCityId) {
        this.companyCityId = companyCityId;
        return this;
    }

    /**
     * 获取 企业所属省份 的值
     * @return Integer
     */
    public Integer getCompanyProvinceId() {
        return companyProvinceId;
    }
    
    /**
     * 设置企业所属省份 的值
     *
     */
    public CompanyInfo setCompanyProvinceId(Integer companyProvinceId) {
        this.companyProvinceId = companyProvinceId;
        return this;
    }

    /**
     * 获取 企业成立时间 的值
     * @return String
     */
    public String getCompanyTime() {
        return companyTime;
    }
    
    /**
     * 设置企业成立时间 的值
     *
     */
    public CompanyInfo setCompanyTime(String companyTime) {
        this.companyTime = companyTime;
        return this;
    }

    /**
     * 获取 详情 的值
     * @return Object
     */
    public Object getCompanyContent() {
        return companyContent;
    }
    
    /**
     * 设置详情 的值
     *
     */
    public CompanyInfo setCompanyContent(Object companyContent) {
        this.companyContent = companyContent;
        return this;
    }

    /**
     * 获取 企业联系人 的值
     * @return String
     */
    public String getCompanyContacts() {
        return companyContacts;
    }
    
    /**
     * 设置企业联系人 的值
     *
     */
    public CompanyInfo setCompanyContacts(String companyContacts) {
        this.companyContacts = companyContacts;
        return this;
    }

    /**
     * 获取 IsTrue 的值
     * @return Object
     */
    public Object getIsTrue() {
        return isTrue;
    }
    
    /**
     * 设置IsTrue 的值
     *
     */
    public CompanyInfo setIsTrue(Object isTrue) {
        this.isTrue = isTrue;
        return this;
    }


//	public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append(this.getClass().getName());
//        sb.append("; companyId=" + (companyId == null ? "null" : companyId.toString()));
//        sb.append("; companyName=" + (companyName == null ? "null" : companyName.toString()));
//        sb.append("; authenType=" + (authenType == null ? "null" : authenType.toString()));
//        sb.append("; companyDes=" + (companyDes == null ? "null" : companyDes.toString()));
//        sb.append("; position=" + (position == null ? "null" : position.toString()));
//        sb.append("; scale=" + (scale == null ? "null" : scale.toString()));
//        sb.append("; industryId=" + (industryId == null ? "null" : industryId.toString()));
//        sb.append("; companyAddress=" + (companyAddress == null ? "null" : companyAddress.toString()));
//        sb.append("; companyTel=" + (companyTel == null ? "null" : companyTel.toString()));
//        sb.append("; companyIcon=" + (companyIcon == null ? "null" : companyIcon.toString()));
//        sb.append("; companyNick=" + (companyNick == null ? "null" : companyNick.toString()));
//        sb.append("; companyCityId=" + (companyCityId == null ? "null" : companyCityId.toString()));
//        sb.append("; companyProvinceId=" + (companyProvinceId == null ? "null" : companyProvinceId.toString()));
//        sb.append("; companyTime=" + (companyTime == null ? "null" : companyTime.toString()));
//        sb.append("; companyContent=" + (companyContent == null ? "null" : companyContent.toString()));
//        sb.append("; companyContacts=" + (companyContacts == null ? "null" : companyContacts.toString()));
//        sb.append("; isTrue=" + (isTrue == null ? "null" : isTrue.toString()));
//
//        return sb.toString();
//    }
}