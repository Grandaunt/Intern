package com.example.win.newintern3.NewEntity;




public class CityInfo implements java.io.Serializable {
    public CityInfo() {

    }

    public CityInfo(String cityCode, String cityName, String parentCode, String cityNick, String cityLevel, String cityTel, String citypost, String cityPinYin, String firstChar) {
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.parentCode = parentCode;
        this.cityNick = cityNick;
        this.cityLevel = cityLevel;
        this.cityTel = cityTel;
        this.citypost = citypost;
        this.cityPinYin = cityPinYin;
        this.firstChar = firstChar;
    }

    private String cityCode;
    /** 城市名称 */
    private String cityName;

    /** 父级Id */
    private String parentCode;

    /** 简称 */
    private String cityNick;

    /** 级别 */
    private String cityLevel;

    /** 区电话 */
    private String cityTel;

    /** 邮编 */
    private String citypost;

    /** 拼音 */
    private String cityPinYin;

    /** FirstChar */
    private String firstChar;



    /**
     * 获取 城市Code 的值
     * @return Integer
     */
    public String getCityCode() {
        return cityCode;
    }
    
    /**
     * 设置城市Code 的值
     *
     */
    public CityInfo setCityCode(String cityCode) {
        this.cityCode = cityCode;
        return this;
    }

    /**
     * 获取 城市名称 的值
     * @return String
     */
    public String getCityName() {
        return cityName;
    }
    
    /**
     * 设置城市名称 的值
     *
     */
    public CityInfo setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    /**
     * 获取 父级Id 的值
     * @return String
     */
    public String getParentCode() {
        return parentCode;
    }
    
    /**
     * 设置父级Id 的值
     *
     */
    public CityInfo setParentCode(String parentCode) {
        this.parentCode = parentCode;
        return this;
    }

    /**
     * 获取 简称 的值
     * @return String
     */
    public String getCityNick() {
        return cityNick;
    }
    
    /**
     * 设置简称 的值
     *
     */
    public CityInfo setCityNick(String cityNick) {
        this.cityNick = cityNick;
        return this;
    }

    /**
     * 获取 级别 的值
     * @return Integer
     */
    public String getCityLevel() {
        return cityLevel;
    }
    
    /**
     * 设置级别 的值
     *
     */
    public CityInfo setCityLevel(String cityLevel) {
        this.cityLevel = cityLevel;
        return this;
    }

    /**
     * 获取 区电话 的值
     * @return String
     */
    public String getCityTel() {
        return cityTel;
    }
    
    /**
     * 设置区电话 的值
     *
     */
    public CityInfo setCityTel(String cityTel) {
        this.cityTel = cityTel;
        return this;
    }

    /**
     * 获取 邮编 的值
     * @return String
     */
    public String getCitypost() {
        return citypost;
    }
    
    /**
     * 设置邮编 的值
     *
     */
    public CityInfo setCitypost(String citypost) {
        this.citypost = citypost;
        return this;
    }

    /**
     * 获取 拼音 的值
     * @return String
     */
    public String getCityPinYin() {
        return cityPinYin;
    }
    
    /**
     * 设置拼音 的值
     *
     */
    public CityInfo setCityPinYin(String cityPinYin) {
        this.cityPinYin = cityPinYin;
        return this;
    }

    /**
     * 获取 FirstChar 的值
     * @return String
     */
    public String getFirstChar() {
        return firstChar;
    }
    
    /**
     * 设置FirstChar 的值
     *
     */
    public CityInfo setFirstChar(String firstChar) {
        this.firstChar = firstChar;
        return this;
    }

    @Override
    public String toString() {
        return "CityInfo{" +
                "cityCode=" + cityCode +
                ", cityName='" + cityName + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", cityNick='" + cityNick + '\'' +
                ", cityLevel=" + cityLevel +
                ", cityTel='" + cityTel + '\'' +
                ", citypost='" + citypost + '\'' +
                ", cityPinYin='" + cityPinYin + '\'' +
                ", firstChar='" + firstChar + '\'' +
                '}';
    }

//	public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append(this.getClass().getName());
//        sb.append("; cityCode=" + (cityCode == null ? "null" : cityCode.toString()));
//        sb.append("; cityName=" + (cityName == null ? "null" : cityName.toString()));
//        sb.append("; parentCode=" + (parentCode == null ? "null" : parentCode.toString()));
//        sb.append("; cityNick=" + (cityNick == null ? "null" : cityNick.toString()));
//        sb.append("; cityLevel=" + (cityLevel == null ? "null" : cityLevel.toString()));
//        sb.append("; cityTel=" + (cityTel == null ? "null" : cityTel.toString()));
//        sb.append("; citypost=" + (citypost == null ? "null" : citypost.toString()));
//        sb.append("; cityPinYin=" + (cityPinYin == null ? "null" : cityPinYin.toString()));
//        sb.append("; firstChar=" + (firstChar == null ? "null" : firstChar.toString()));
//
//        return sb.toString();
//    }
}