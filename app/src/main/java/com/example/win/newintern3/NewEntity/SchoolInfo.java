package com.example.win.newintern3.NewEntity;



public class SchoolInfo implements java.io.Serializable {

    public SchoolInfo() {

    }

    public SchoolInfo(Integer schoolId, String schoolName, String authorities, String cityID, String city, String schoollevel, Integer sort, String schoolAddress, String schoolPhone, String schoolDes, Object isTrue) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.authorities = authorities;
        this.cityID = cityID;
        this.city = city;
        this.schoollevel = schoollevel;
        this.sort = sort;
        this.schoolAddress = schoolAddress;
        this.schoolPhone = schoolPhone;
        this.schoolDes = schoolDes;
        this.isTrue = isTrue;
    }

    private Integer schoolId;
    /** 学校名称 */
    private String schoolName;

    /** 主管部门 */
    private String authorities;

    /** 所属市区ID */
    private String cityID;

    /** 所属市区名 */
    private String city;

    /** 办学层次 */
    private String schoollevel;

    /** Sort */
    private Integer sort;

    /** 学院地址 */
    private String schoolAddress;

    /** 学院电话 */
    private String schoolPhone;

    /** 学院描述 */
    private String schoolDes;

    /** 学校是否可用 */
    private Object isTrue;



    /**
     * 获取 SchoolId 的值
     * @return Integer
     */
    public Integer getSchoolId() {
        return schoolId;
    }
    
    /**
     * 设置SchoolId 的值
     *
     */
    public SchoolInfo setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
        return this;
    }

    /**
     * 获取 学校名称 的值
     * @return String
     */
    public String getSchoolName() {
        return schoolName;
    }
    
    /**
     * 设置学校名称 的值
     *
     */
    public SchoolInfo setSchoolName(String schoolName) {
        this.schoolName = schoolName;
        return this;
    }

    /**
     * 获取 主管部门 的值
     * @return String
     */
    public String getAuthorities() {
        return authorities;
    }
    
    /**
     * 设置主管部门 的值
     *
     */
    public SchoolInfo setAuthorities(String authorities) {
        this.authorities = authorities;
        return this;
    }

    /**
     * 获取 所属市区ID 的值
     * @return String
     */
    public String getCityID() {
        return cityID;
    }
    
    /**
     * 设置所属市区ID 的值
     *
     */
    public SchoolInfo setCityID(String cityID) {
        this.cityID = cityID;
        return this;
    }

    /**
     * 获取 所属市区名 的值
     * @return String
     */
    public String getCity() {
        return city;
    }
    
    /**
     * 设置所属市区名 的值
     *
     */
    public SchoolInfo setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * 获取 办学层次 的值
     * @return String
     */
    public String getSchoollevel() {
        return schoollevel;
    }
    
    /**
     * 设置办学层次 的值
     *
     */
    public SchoolInfo setSchoollevel(String schoollevel) {
        this.schoollevel = schoollevel;
        return this;
    }

    /**
     * 获取 Sort 的值
     * @return Integer
     */
    public Integer getSort() {
        return sort;
    }
    
    /**
     * 设置Sort 的值
     *
     */
    public SchoolInfo setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    /**
     * 获取 学院地址 的值
     * @return String
     */
    public String getSchoolAddress() {
        return schoolAddress;
    }
    
    /**
     * 设置学院地址 的值
     *
     */
    public SchoolInfo setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
        return this;
    }

    /**
     * 获取 学院电话 的值
     * @return String
     */
    public String getSchoolPhone() {
        return schoolPhone;
    }
    
    /**
     * 设置学院电话 的值
     *
     */
    public SchoolInfo setSchoolPhone(String schoolPhone) {
        this.schoolPhone = schoolPhone;
        return this;
    }

    /**
     * 获取 学院描述 的值
     * @return String
     */
    public String getSchoolDes() {
        return schoolDes;
    }
    
    /**
     * 设置学院描述 的值
     *
     */
    public SchoolInfo setSchoolDes(String schoolDes) {
        this.schoolDes = schoolDes;
        return this;
    }

    /**
     * 获取 学校是否可用 的值
     * @return Object
     */
    public Object getIsTrue() {
        return isTrue;
    }
    
    /**
     * 设置学校是否可用 的值
     *
     */
    public SchoolInfo setIsTrue(Object isTrue) {
        this.isTrue = isTrue;
        return this;
    }

    @Override
    public String toString() {
        return "SchoolInfo{" +
                "schoolId=" + schoolId +
                ", schoolName='" + schoolName + '\'' +
                ", authorities='" + authorities + '\'' +
                ", cityID='" + cityID + '\'' +
                ", city='" + city + '\'' +
                ", schoollevel='" + schoollevel + '\'' +
                ", sort=" + sort +
                ", schoolAddress='" + schoolAddress + '\'' +
                ", schoolPhone='" + schoolPhone + '\'' +
                ", schoolDes='" + schoolDes + '\'' +
                ", isTrue=" + isTrue +
                '}';
    }

//	public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append(this.getClass().getName());
//        sb.append("; schoolId=" + (schoolId == null ? "null" : schoolId.toString()));
//        sb.append("; schoolName=" + (schoolName == null ? "null" : schoolName.toString()));
//        sb.append("; authorities=" + (authorities == null ? "null" : authorities.toString()));
//        sb.append("; cityID=" + (cityID == null ? "null" : cityID.toString()));
//        sb.append("; city=" + (city == null ? "null" : city.toString()));
//        sb.append("; schoollevel=" + (schoollevel == null ? "null" : schoollevel.toString()));
//        sb.append("; sort=" + (sort == null ? "null" : sort.toString()));
//        sb.append("; schoolAddress=" + (schoolAddress == null ? "null" : schoolAddress.toString()));
//        sb.append("; schoolPhone=" + (schoolPhone == null ? "null" : schoolPhone.toString()));
//        sb.append("; schoolDes=" + (schoolDes == null ? "null" : schoolDes.toString()));
//        sb.append("; isTrue=" + (isTrue == null ? "null" : isTrue.toString()));
//
//        return sb.toString();
//    }
}