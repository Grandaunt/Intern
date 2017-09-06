package com.example.win.newintern3.Base;

import java.util.List;

/**
 * Created by win on 2017/8/25.
 */

public class ServiceListEntity<T> {
//    CompanyPracticePost

    private List<T> list;

    private String code;

    public ServiceListEntity() {

    }

    public ServiceListEntity(List<T> list, String code) {
        this.list = list;
        this.code = code;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ServiceListEntity{" +
                "list=" + list +
                ", code='" + code + '\'' +
                '}';
    }
}
