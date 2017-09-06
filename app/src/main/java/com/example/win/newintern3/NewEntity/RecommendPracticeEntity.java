package com.example.win.newintern3.NewEntity;

import java.util.List;

/**
 * Created by win on 2017/8/25.
 */

public class RecommendPracticeEntity {
//    CompanyPracticePost

    private List<CompanyPracticePost> companyPostList;

    private String code;

    public RecommendPracticeEntity() {

    }

    public RecommendPracticeEntity(List<CompanyPracticePost> companyPostList, String code) {
        this.companyPostList = companyPostList;
        this.code = code;
    }

    public List<CompanyPracticePost> getCompanyPostList() {
        return companyPostList;
    }

    public void setCompanyPostList(List<CompanyPracticePost> companyPostList) {
        this.companyPostList = companyPostList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RecommendPracticeEntity{" +
                "companyPostList=" + companyPostList +
                ", code='" + code + '\'' +
                '}';
    }
}
