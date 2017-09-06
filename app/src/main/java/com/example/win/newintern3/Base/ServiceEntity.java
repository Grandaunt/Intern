package com.example.win.newintern3.Base;
import java.util.List;

/**
 * Created by win on 2017/8/25.
 */

public class ServiceEntity<T> {
//    CompanyPracticePost

    private T entity;

    private String code;

    public ServiceEntity() {

    }

    public ServiceEntity(T entity, String code) {
        this.entity = entity;
        this.code = code;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ServiceEntity{" +
                "entity=" + entity +
                ", code='" + code + '\'' +
                '}';
    }
}

