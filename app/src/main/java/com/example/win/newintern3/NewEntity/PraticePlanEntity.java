package com.example.win.newintern3.NewEntity;

import java.util.List;

/**
 * Created by win on 2017/8/25.
 */

public class PraticePlanEntity {
//    CompanyPracticePost

    private PracticePlan practicePlan;

    private String code;

    public PraticePlanEntity() {

    }

    public PraticePlanEntity(PracticePlan practicePlan, String code) {
        this.practicePlan = practicePlan;
        this.code = code;
    }


    public PracticePlan getPracticePlan() {
        return practicePlan;
    }

    public void setPracticePlan(PracticePlan practicePlan) {
        this.practicePlan = practicePlan;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "PraticePlanEntity{" +
                "practicePlan=" + practicePlan +
                ", code='" + code + '\'' +
                '}';
    }
}
