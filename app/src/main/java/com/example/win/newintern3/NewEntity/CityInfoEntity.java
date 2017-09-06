package com.example.win.newintern3.NewEntity;


import java.util.List;

public class CityInfoEntity implements java.io.Serializable {
    public CityInfoEntity() {

    }

    public CityInfoEntity(List<CityInfo> cityInfoList) {
        this.cityInfoList = cityInfoList;
    }

    private List<CityInfo> cityInfoList;

    public List<CityInfo> getCityInfoList() {
        return cityInfoList;
    }

    public void setCityInfoList(List<CityInfo> cityInfoList) {
        this.cityInfoList = cityInfoList;
    }

}