package com.example.win.newintern3.NewEntity;

import java.util.List;

public class Resumeinfo implements java.io.Serializable {
    public Resumeinfo() {

    }

    public Resumeinfo(String resumeId, String userId, String userName, String resumeMale, String resumeTrade, String companyId, String companyName, String resumepost, String resumeCityID, String resumeAddress, String resumeTel, String resumeEmile, String resumeUserIcon, String resumeTime, String userStatus, String resumeSelfDes, List<ExperienceEducation> experienceEducationList, List<ExperiencePractice> experiencePracticeList, List<ExperienceProject> experienceProjectList, List<Experiencework> experienceworkList) {
        this.resumeId = resumeId;
        this.userId = userId;
        this.userName = userName;
        this.resumeMale = resumeMale;
        this.resumeTrade = resumeTrade;
        this.companyId = companyId;
        this.companyName = companyName;
        this.resumepost = resumepost;
        this.resumeCityID = resumeCityID;
        this.resumeAddress = resumeAddress;
        this.resumeTel = resumeTel;
        this.resumeEmile = resumeEmile;
        this.resumeUserIcon = resumeUserIcon;
        this.resumeTime = resumeTime;
        this.userStatus = userStatus;
        this.resumeSelfDes = resumeSelfDes;
        this.experienceEducationList = experienceEducationList;
        this.experiencePracticeList = experiencePracticeList;
        this.experienceProjectList = experienceProjectList;
        this.experienceworkList = experienceworkList;
    }

    private String resumeId;
    /** 用户ID */
    private String userId;

    /** 姓名 */
    private String userName;

    /** 性别    1男0女 */
    private String resumeMale;

    /** 行业方向 */
    private String resumeTrade;

    /** 在职公司ID */
    private String companyId;

    /** 在职企业名称 */
    private String companyName;

    /** 当前职位 */
    private String resumepost;

    /** 工作地区 */
    private String resumeCityID;

    /** 详细地址 */
    private String resumeAddress;

    /** 手机号 */
    private String resumeTel;

    /** 邮箱 */
    private String resumeEmile;

    /** 头像 */
    private String resumeUserIcon;

    /** 更新时间 */
    private String resumeTime;

    /** 用户状态    0：在校；2、毕业 */
    private String userStatus;

    /** 自我介绍 */
    private String resumeSelfDes;


    private List<ExperienceEducation> experienceEducationList;
    

    private List<ExperiencePractice> experiencePracticeList;
    

    private List<ExperienceProject> experienceProjectList;
    

    private List<Experiencework> experienceworkList;

    
    public List<ExperienceEducation> getExperienceEducationList() {
		return experienceEducationList;
	}

	public void setExperienceEducationList(List<ExperienceEducation> experienceEducationList) {
		this.experienceEducationList = experienceEducationList;
	}

	public List<ExperiencePractice> getExperiencePracticeList() {
		return experiencePracticeList;
	}

	public void setExperiencePracticeList(List<ExperiencePractice> experiencePracticeList) {
		this.experiencePracticeList = experiencePracticeList;
	}

	public List<ExperienceProject> getExperienceProjectList() {
		return experienceProjectList;
	}

	public void setExperienceProjectList(List<ExperienceProject> experienceProjectList) {
		this.experienceProjectList = experienceProjectList;
	}

	public List<Experiencework> getExperienceworkList() {
		return experienceworkList;
	}

	public void setExperienceworkList(List<Experiencework> experienceworkList) {
		this.experienceworkList = experienceworkList;
	}

	/**
     * 获取 简历ID 的值
     * @return String
     */
    public String getResumeId() {
        return resumeId;
    }
    
    /**
     * 设置简历ID 的值
     *
     */
    public Resumeinfo setResumeId(String resumeId) {
        this.resumeId = resumeId;
        return this;
    }

    /**
     * 获取 用户ID 的值
     * @return String
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * 设置用户ID 的值
     *
     */
    public Resumeinfo setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 获取 姓名 的值
     * @return String
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * 设置姓名 的值
     *
     */
    public Resumeinfo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * 获取 性别    1男0女 的值
     * @return String
     */
    public String getResumeMale() {
        return resumeMale;
    }
    
    /**
     * 设置性别    1男0女 的值
     *
     */
    public Resumeinfo setResumeMale(String resumeMale) {
        this.resumeMale = resumeMale;
        return this;
    }

    /**
     * 获取 行业方向 的值
     * @return String
     */
    public String getResumeTrade() {
        return resumeTrade;
    }
    
    /**
     * 设置行业方向 的值
     *
     */
    public Resumeinfo setResumeTrade(String resumeTrade) {
        this.resumeTrade = resumeTrade;
        return this;
    }

    /**
     * 获取 在职公司ID 的值
     * @return String
     */
    public String getCompanyId() {
        return companyId;
    }
    
    /**
     * 设置在职公司ID 的值
     *
     */
    public Resumeinfo setCompanyId(String companyId) {
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
    public Resumeinfo setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    /**
     * 获取 当前职位 的值
     * @return String
     */
    public String getResumepost() {
        return resumepost;
    }
    
    /**
     * 设置当前职位 的值
     *
     */
    public Resumeinfo setResumepost(String resumepost) {
        this.resumepost = resumepost;
        return this;
    }

    /**
     * 获取 工作地区 的值
     * @return String
     */
    public String getResumeCityID() {
        return resumeCityID;
    }
    
    /**
     * 设置工作地区 的值
     *
     */
    public Resumeinfo setResumeCityID(String resumeCityID) {
        this.resumeCityID = resumeCityID;
        return this;
    }

    /**
     * 获取 详细地址 的值
     * @return String
     */
    public String getResumeAddress() {
        return resumeAddress;
    }
    
    /**
     * 设置详细地址 的值
     *
     */
    public Resumeinfo setResumeAddress(String resumeAddress) {
        this.resumeAddress = resumeAddress;
        return this;
    }

    /**
     * 获取 手机号 的值
     * @return String
     */
    public String getResumeTel() {
        return resumeTel;
    }
    
    /**
     * 设置手机号 的值
     *
     */
    public Resumeinfo setResumeTel(String resumeTel) {
        this.resumeTel = resumeTel;
        return this;
    }

    /**
     * 获取 邮箱 的值
     * @return String
     */
    public String getResumeEmile() {
        return resumeEmile;
    }
    
    /**
     * 设置邮箱 的值
     *
     */
    public Resumeinfo setResumeEmile(String resumeEmile) {
        this.resumeEmile = resumeEmile;
        return this;
    }

    /**
     * 获取 头像 的值
     * @return String
     */
    public String getResumeUserIcon() {
        return resumeUserIcon;
    }
    
    /**
     * 设置头像 的值
     *
     */
    public Resumeinfo setResumeUserIcon(String resumeUserIcon) {
        this.resumeUserIcon = resumeUserIcon;
        return this;
    }

    /**
     * 获取 更新时间 的值
     * @return String
     */
    public String getResumeTime() {
        return resumeTime;
    }
    
    /**
     * 设置更新时间 的值
     *
     */
    public Resumeinfo setResumeTime(String resumeTime) {
        this.resumeTime = resumeTime;
        return this;
    }

    /**
     * 获取 用户状态    0：在校；2、毕业 的值
     * @return String
     */
    public String getUserStatus() {
        return userStatus;
    }
    
    /**
     * 设置用户状态    0：在校；2、毕业 的值
     *
     */
    public Resumeinfo setUserStatus(String userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    /**
     * 获取 自我介绍 的值
     * @return String
     */
    public String getResumeSelfDes() {
        return resumeSelfDes;
    }
    
    /**
     * 设置自我介绍 的值
     *
     */
    public Resumeinfo setResumeSelfDes(String resumeSelfDes) {
        this.resumeSelfDes = resumeSelfDes;
        return this;
    }


    @Override
    public String toString() {
        return "Resumeinfo{" +
                "resumeId=" + resumeId +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", resumeMale=" + resumeMale +
                ", resumeTrade='" + resumeTrade + '\'' +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", resumepost='" + resumepost + '\'' +
                ", resumeCityID=" + resumeCityID +
                ", resumeAddress='" + resumeAddress + '\'' +
                ", resumeTel='" + resumeTel + '\'' +
                ", resumeEmile='" + resumeEmile + '\'' +
                ", resumeUserIcon='" + resumeUserIcon + '\'' +
                ", resumeTime='" + resumeTime + '\'' +
                ", userStatus=" + userStatus +
                ", resumeSelfDes=" + resumeSelfDes +
                ", experienceEducationList=" + experienceEducationList +
                ", experiencePracticeList=" + experiencePracticeList +
                ", experienceProjectList=" + experienceProjectList +
                ", experienceworkList=" + experienceworkList +
                '}';
    }
}