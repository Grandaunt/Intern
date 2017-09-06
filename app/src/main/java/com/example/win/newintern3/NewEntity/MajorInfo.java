package com.example.win.newintern3.NewEntity;




public class MajorInfo implements java.io.Serializable {
    public MajorInfo() {

    }

    public MajorInfo(Integer majorId, String majorName, String majorDes, Integer schoolId, Integer departmentId, Object isTrue, String majorCode, String createYear) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.majorDes = majorDes;
        this.schoolId = schoolId;
        this.departmentId = departmentId;
        this.isTrue = isTrue;
        this.majorCode = majorCode;
        this.createYear = createYear;
    }

    private Integer majorId;
    /** 专业名称 */
    private String majorName;

    /** 专业描述 */
    private String majorDes;

    /** 学院ID */
    private Integer schoolId;

    /** 院系编号 */
    private Integer departmentId;

    /** 专业是否可用 */
    private Object isTrue;

    /** 专业编号 */
    private String majorCode;

    /** 创建年份 */
    private String createYear = "2016";



    /**
     * 获取 编号 的值
     * @return Integer
     */
    public Integer getMajorId() {
        return majorId;
    }
    
    /**
     * 设置编号 的值
     *
     */
    public MajorInfo setMajorId(Integer majorId) {
        this.majorId = majorId;
        return this;
    }

    /**
     * 获取 专业名称 的值
     * @return String
     */
    public String getMajorName() {
        return majorName;
    }
    
    /**
     * 设置专业名称 的值
     *
     */
    public MajorInfo setMajorName(String majorName) {
        this.majorName = majorName;
        return this;
    }

    /**
     * 获取 专业描述 的值
     * @return String
     */
    public String getMajorDes() {
        return majorDes;
    }
    
    /**
     * 设置专业描述 的值
     *
     */
    public MajorInfo setMajorDes(String majorDes) {
        this.majorDes = majorDes;
        return this;
    }

    /**
     * 获取 学院ID 的值
     * @return Integer
     */
    public Integer getSchoolId() {
        return schoolId;
    }
    
    /**
     * 设置学院ID 的值
     *
     */
    public MajorInfo setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
        return this;
    }

    /**
     * 获取 院系编号 的值
     * @return Integer
     */
    public Integer getDepartmentId() {
        return departmentId;
    }
    
    /**
     * 设置院系编号 的值
     *
     */
    public MajorInfo setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    /**
     * 获取 专业是否可用 的值
     * @return Object
     */
    public Object getIsTrue() {
        return isTrue;
    }
    
    /**
     * 设置专业是否可用 的值
     *
     */
    public MajorInfo setIsTrue(Object isTrue) {
        this.isTrue = isTrue;
        return this;
    }

    /**
     * 获取 专业编号 的值
     * @return String
     */
    public String getMajorCode() {
        return majorCode;
    }
    
    /**
     * 设置专业编号 的值
     *
     */
    public MajorInfo setMajorCode(String majorCode) {
        this.majorCode = majorCode;
        return this;
    }

    /**
     * 获取 创建年份 的值
     * @return String
     */
    public String getCreateYear() {
        return createYear;
    }
    
    /**
     * 设置创建年份 的值
     *
     */
    public MajorInfo setCreateYear(String createYear) {
        this.createYear = createYear;
        return this;
    }

    @Override
    public String toString() {
        return "MajorInfo{" +
                "majorId=" + majorId +
                ", majorName='" + majorName + '\'' +
                ", majorDes='" + majorDes + '\'' +
                ", schoolId=" + schoolId +
                ", departmentId=" + departmentId +
                ", isTrue=" + isTrue +
                ", majorCode='" + majorCode + '\'' +
                ", createYear='" + createYear + '\'' +
                '}';
    }
//	public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append(this.getClass().getName());
//        sb.append("; majorId=" + (majorId == null ? "null" : majorId.toString()));
//        sb.append("; majorName=" + (majorName == null ? "null" : majorName.toString()));
//        sb.append("; majorDes=" + (majorDes == null ? "null" : majorDes.toString()));
//        sb.append("; schoolId=" + (schoolId == null ? "null" : schoolId.toString()));
//        sb.append("; departmentId=" + (departmentId == null ? "null" : departmentId.toString()));
//        sb.append("; isTrue=" + (isTrue == null ? "null" : isTrue.toString()));
//        sb.append("; majorCode=" + (majorCode == null ? "null" : majorCode.toString()));
//        sb.append("; createYear=" + (createYear == null ? "null" : createYear.toString()));
//
//        return sb.toString();
//    }
}