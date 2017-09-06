package com.example.win.newintern3.NewEntity;

public class DayReportImage implements java.io.Serializable {
    public DayReportImage() {

    }

    public DayReportImage(Integer photoId, String dayReportId, String photoPath) {
        this.photoId = photoId;
        this.dayReportId = dayReportId;
        this.photoPath = photoPath;
    }

    private Integer photoId;
    /** DayReportId */
    private String dayReportId;

    /** 照片地址 */
    private String photoPath;



    /**
     * 获取 PhotoId 的值
     * @return Integer
     */
    public Integer getPhotoId() {
        return photoId;
    }
    
    /**
     * 设置PhotoId 的值
     *
     */
    public DayReportImage setPhotoId(Integer photoId) {
        this.photoId = photoId;
        return this;
    }

    /**
     * 获取 DayReportId 的值
     * @return String
     */
    public String getDayReportId() {
        return dayReportId;
    }
    
    /**
     * 设置DayReportId 的值
     *
     */
    public DayReportImage setDayReportId(String dayReportId) {
        this.dayReportId = dayReportId;
        return this;
    }

    /**
     * 获取 照片地址 的值
     * @return String
     */
    public String getPhotoPath() {
        return photoPath;
    }
    
    /**
     * 设置照片地址 的值
     *
     */
    public DayReportImage setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
        return this;
    }


    @Override
    public String toString() {
        return "DayReportImage{" +
                "photoId=" + photoId +
                ", dayReportId='" + dayReportId + '\'' +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}