package com.example.win.newintern3.NewEntity;

import java.io.Serializable;

/**
 * Created by win on 2017/8/29.
 */

public class NewInternMainEntity implements Serializable {
    public NewInternMainEntity() {

    }

    public NewInternMainEntity(UserLogin userLogin, UserPractice userPracticeInfo, String isHasUserPractice) {
        this.userLogin = userLogin;
        this.userPracticeInfo = userPracticeInfo;
        this.isHasUserPractice = isHasUserPractice;
    }


    private UserLogin userLogin;


    private UserPractice userPracticeInfo;

    /** 是否实习 */
    private String isHasUserPractice;

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public UserPractice getUserPracticeInfo() {
        return userPracticeInfo;
    }

    public void setUserPracticeInfo(UserPractice userPracticeInfo) {
        this.userPracticeInfo = userPracticeInfo;
    }

    public String getIsHasUserPractice() {
        return isHasUserPractice;
    }

    public void setIsHasUserPractice(String isHasUserPractice) {
        this.isHasUserPractice = isHasUserPractice;
    }

    @Override
    public String toString() {
        return "UserLoginEntity{" +
                "userLogin=" + userLogin +
                ", userPracticeInfo=" + userPracticeInfo +
                ", isHasUserPractice='" + isHasUserPractice + '\'' +
                '}';
    }
}
