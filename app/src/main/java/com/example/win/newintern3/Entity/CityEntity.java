package com.example.win.newintern3.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by TAO_SX on 2016/7/7/007.
 */
public class CityEntity implements Serializable {

    /**
     * code : 200
     * citylist : [{"firstChar":"A","cityName":"阿拉善盟","parentCode":"150000","cityCode":152900}]
     */

    private String code;
    /**
     * firstChar : A
     * cityName : 阿拉善盟
     * parentCode : 150000
     * cityCode : 152900
     */

    private List<CitylistEntity> citylist;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CitylistEntity> getCitylist() {
        return citylist;
    }

    public void setCitylist(List<CitylistEntity> citylist) {
        this.citylist = citylist;
    }

    public static class CitylistEntity implements Serializable {
        private String firstChar;
        private String cityName;
        private String parentCode;
        private int cityCode;

        public String getFirstChar() {
            return firstChar;
        }

        public void setFirstChar(String firstChar) {
            this.firstChar = firstChar;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getParentCode() {
            return parentCode;
        }

        public void setParentCode(String parentCode) {
            this.parentCode = parentCode;
        }

        public int getCityCode() {
            return cityCode;
        }

        public void setCityCode(int cityCode) {
            this.cityCode = cityCode;
        }

    }

}
