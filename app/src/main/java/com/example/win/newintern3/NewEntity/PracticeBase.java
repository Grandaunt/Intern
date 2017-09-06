package com.example.win.newintern3.NewEntity;
import java.util.List;


public class PracticeBase implements java.io.Serializable {
    public PracticeBase() {

    }

    public PracticeBase(String baseId, String baseName, String companyId, String companyName, String baseIcon, String baseDes, String schoolId, String departmentId, String baselevel, List<BasePost> basePostList, PracticePlan practicePlan, String address, String contact, String contactPhone) {
        this.baseId = baseId;
        this.baseName = baseName;
        this.companyId = companyId;
        this.companyName = companyName;
        this.baseIcon = baseIcon;
        this.baseDes = baseDes;
        this.schoolId = schoolId;
        this.departmentId = departmentId;
        this.baselevel = baselevel;
        this.basePostList = basePostList;
        this.practicePlan = practicePlan;
        this.address = address;
        this.contact = contact;
        this.contactPhone = contactPhone;
    }

    public PracticeBase(String baseId, String baseName, String companyId, String companyName, String baseIcon, String baseDes, String schoolId, String departmentId, String baselevel, List<BasePost> basePostList, PracticePlan practicePlan) {
        this.baseId = baseId;
        this.baseName = baseName;
        this.companyId = companyId;
        this.companyName = companyName;
        this.baseIcon = baseIcon;
        this.baseDes = baseDes;
        this.schoolId = schoolId;
        this.departmentId = departmentId;
        this.baselevel = baselevel;
        this.basePostList = basePostList;
        this.practicePlan = practicePlan;

    }

    private String baseId;
    /** 基地名称 */
    private String baseName;

    /** 关联企业 */
    private String companyId;

    /** 企业名称 */
    private String companyName;

    /** 基地logo */
    private String baseIcon;

    /** 基地简介 */
    private String baseDes;

    /** 所属学校ID */
    private String schoolId;

    /** 所属院系ID */
    private String departmentId;

    /** 基地级别	1：校级；2：院系级 */
    private String baselevel;
    

    private List<BasePost> basePostList;

    private PracticePlan practicePlan;

    /** 基地logo */
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /** 基地logo */
    private String contact;

    /** 基地logo */
    private String contactPhone;

    
    public List<BasePost> getBasePostList() {
		return basePostList;
	}

	public void setBasePostList(List<BasePost> basePostList) {
		this.basePostList = basePostList;
	}

	public PracticePlan getPracticePlan() {
		return practicePlan;
	}

	public void setPracticePlan(PracticePlan practicePlan) {
		this.practicePlan = practicePlan;
	}

	/**
     * 获取 BaseId 的值
     * @return Integer
     */
    public String getBaseId() {
        return baseId;
    }
    
    /**
     * 设置BaseId 的值
     *
     */
    public PracticeBase setBaseId(String baseId) {
        this.baseId = baseId;
        return this;
    }

    /**
     * 获取 基地名称 的值
     * @return String
     */
    public String getBaseName() {
        return baseName;
    }
    
    /**
     * 设置基地名称 的值
     *
     */
    public PracticeBase setBaseName(String baseName) {
        this.baseName = baseName;
        return this;
    }

    /**
     * 获取 关联企业 的值
     * @return Integer
     */
    public String getCompanyId() {
        return companyId;
    }
    
    /**
     * 设置关联企业 的值
     *
     */
    public PracticeBase setCompanyId(String companyId) {
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
    public PracticeBase setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    /**
     * 获取 基地logo 的值
     * @return String
     */
    public String getBaseIcon() {
        return baseIcon;
    }
    
    /**
     * 设置基地logo 的值
     *
     */
    public PracticeBase setBaseIcon(String baseIcon) {
        this.baseIcon = baseIcon;
        return this;
    }

    /**
     * 获取 基地简介 的值
     * @return Object
     */
    public String getBaseDes() {
        return baseDes;
    }
    
    /**
     * 设置基地简介 的值
     *
     */
    public PracticeBase setBaseDes(String baseDes) {
        this.baseDes = baseDes;
        return this;
    }

    /**
     * 获取 所属学校ID 的值
     * @return Integer
     */
    public String getSchoolId() {
        return schoolId;
    }
    
    /**
     * 设置所属学校ID 的值
     *
     */
    public PracticeBase setSchoolId(String schoolId) {
        this.schoolId = schoolId;
        return this;
    }

    /**
     * 获取 所属院系ID 的值
     * @return Integer
     */
    public String getDepartmentId() {
        return departmentId;
    }
    
    /**
     * 设置所属院系ID 的值
     *
     */
    public PracticeBase setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    /**
     * 获取 基地级别	1：校级；2：院系级 的值
     * @return Integer
     */
    public String getBaselevel() {
        return baselevel;
    }
    
    /**
     * 设置基地级别	1：校级；2：院系级 的值
     *
     */
    public PracticeBase setBaselevel(String baselevel) {
        this.baselevel = baselevel;
        return this;
    }


    @Override
    public String toString() {
        return "PracticeBase{" +
                "baseId='" + baseId + '\'' +
                ", baseName='" + baseName + '\'' +
                ", companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", baseIcon='" + baseIcon + '\'' +
                ", baseDes='" + baseDes + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", baselevel='" + baselevel + '\'' +
                ", basePostList=" + basePostList +
                ", practicePlan=" + practicePlan +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                '}';
    }
}