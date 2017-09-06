package com.example.win.newintern3.NewEntity;

public class ProvinceInfo implements java.io.Serializable {
    public ProvinceInfo() {
    }

    public ProvinceInfo(Integer provinceCode, String provinceName, Integer parentCode, String provinceNick, String provinceLevel, String provinceTel, String provincePost, String provincePinYin) {
        this.provinceCode = provinceCode;
        this.provinceName = provinceName;
        this.parentCode = parentCode;
        this.provinceNick = provinceNick;
        this.provinceLevel = provinceLevel;
        this.provinceTel = provinceTel;
        this.provincePost = provincePost;
        this.provincePinYin = provincePinYin;
    }

    private Integer provinceCode;
    /** 省份名称 */
    private String provinceName;

    /** 父级Id */
    private Integer parentCode;

    /** 简称 */
    private String provinceNick;

    /** 级别 */
    private String provinceLevel;

    /** 区电话 */
    private String provinceTel;

    /** 邮编 */
    private String provincePost;

    /** 拼音 */
    private String provincePinYin;



    /**
     * 获取 省份Code 的值
     * @return Integer
     */
    public Integer getProvinceCode() {
        return provinceCode;
    }
    
    /**
     * 设置省份Code 的值
     *
     */
    public ProvinceInfo setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
        return this;
    }

    /**
     * 获取 省份名称 的值
     * @return String
     */
    public String getProvinceName() {
        return provinceName;
    }
    
    /**
     * 设置省份名称 的值
     *
     */
    public ProvinceInfo setProvinceName(String provinceName) {
        this.provinceName = provinceName;
        return this;
    }

    /**
     * 获取 父级Id 的值
     * @return Integer
     */
    public Integer getParentCode() {
        return parentCode;
    }
    
    /**
     * 设置父级Id 的值
     *
     */
    public ProvinceInfo setParentCode(Integer parentCode) {
        this.parentCode = parentCode;
        return this;
    }

    /**
     * 获取 简称 的值
     * @return String
     */
    public String getProvinceNick() {
        return provinceNick;
    }
    
    /**
     * 设置简称 的值
     *
     */
    public ProvinceInfo setProvinceNick(String provinceNick) {
        this.provinceNick = provinceNick;
        return this;
    }

    /**
     * 获取 级别 的值
     * @return String
     */
    public String getProvinceLevel() {
        return provinceLevel;
    }
    
    /**
     * 设置级别 的值
     *
     */
    public ProvinceInfo setProvinceLevel(String provinceLevel) {
        this.provinceLevel = provinceLevel;
        return this;
    }

    /**
     * 获取 区电话 的值
     * @return String
     */
    public String getProvinceTel() {
        return provinceTel;
    }
    
    /**
     * 设置区电话 的值
     *
     */
    public ProvinceInfo setProvinceTel(String provinceTel) {
        this.provinceTel = provinceTel;
        return this;
    }

    /**
     * 获取 邮编 的值
     * @return String
     */
    public String getProvincePost() {
        return provincePost;
    }
    
    /**
     * 设置邮编 的值
     *
     */
    public ProvinceInfo setProvincePost(String provincePost) {
        this.provincePost = provincePost;
        return this;
    }

    /**
     * 获取 拼音 的值
     * @return String
     */
    public String getProvincePinYin() {
        return provincePinYin;
    }
    
    /**
     * 设置拼音 的值
     *
     */
    public ProvinceInfo setProvincePinYin(String provincePinYin) {
        this.provincePinYin = provincePinYin;
        return this;
    }

    @Override
    public String toString() {
        return "ProvinceInfo{" +
                "provinceCode=" + provinceCode +
                ", provinceName='" + provinceName + '\'' +
                ", parentCode=" + parentCode +
                ", provinceNick='" + provinceNick + '\'' +
                ", provinceLevel='" + provinceLevel + '\'' +
                ", provinceTel='" + provinceTel + '\'' +
                ", provincePost='" + provincePost + '\'' +
                ", provincePinYin='" + provincePinYin + '\'' +
                '}';
    }

//	public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append(this.getClass().getName());
//        sb.append("; provinceCode=" + (provinceCode == null ? "null" : provinceCode.toString()));
//        sb.append("; provinceName=" + (provinceName == null ? "null" : provinceName.toString()));
//        sb.append("; parentCode=" + (parentCode == null ? "null" : parentCode.toString()));
//        sb.append("; provinceNick=" + (provinceNick == null ? "null" : provinceNick.toString()));
//        sb.append("; provinceLevel=" + (provinceLevel == null ? "null" : provinceLevel.toString()));
//        sb.append("; provinceTel=" + (provinceTel == null ? "null" : provinceTel.toString()));
//        sb.append("; provincePost=" + (provincePost == null ? "null" : provincePost.toString()));
//        sb.append("; provincePinYin=" + (provincePinYin == null ? "null" : provincePinYin.toString()));
//
//        return sb.toString();
//    }
}