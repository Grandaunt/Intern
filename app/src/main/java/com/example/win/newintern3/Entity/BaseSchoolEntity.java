package com.example.win.newintern3.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by TAO_SX on 2016/7/13/013.
 */
public class BaseSchoolEntity implements Serializable{

    /**
     * code : 200
     * schoollist : [{"sort":1,"schoolName":"北京大学","authorities":"教育部","cityID":"110000","isTrue":1,"schoolId":1,"schoollevel":"本科","city":"北京市"}]
     */

    private String code;
    /**
     * sort : 1
     * schoolName : 北京大学
     * authorities : 教育部
     * cityID : 110000
     * isTrue : 1
     * schoolId : 1
     * schoollevel : 本科
     * city : 北京市
     */

    private List<SchoollistEntity> schoollist;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<SchoollistEntity> getSchoollist() {
        return schoollist;
    }

    public void setSchoollist(List<SchoollistEntity> schoollist) {
        this.schoollist = schoollist;
    }

    public static class SchoollistEntity implements Serializable {
        private int sort;
        private String schoolName;
        private String authorities;
        private String cityID;
        private int isTrue;
        private int schoolId;
        private String schoollevel;
        private String city;

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

        public String getAuthorities() {
            return authorities;
        }

        public void setAuthorities(String authorities) {
            this.authorities = authorities;
        }

        public String getCityID() {
            return cityID;
        }

        public void setCityID(String cityID) {
            this.cityID = cityID;
        }

        public int getIsTrue() {
            return isTrue;
        }

        public void setIsTrue(int isTrue) {
            this.isTrue = isTrue;
        }

        public int getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(int schoolId) {
            this.schoolId = schoolId;
        }

        public String getSchoollevel() {
            return schoollevel;
        }

        public void setSchoollevel(String schoollevel) {
            this.schoollevel = schoollevel;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
