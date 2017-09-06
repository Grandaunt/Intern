package com.example.win.newintern3.NewEntity;


public class AUserLogin implements java.io.Serializable {


     private String IsHasUserPractice;
    

	 private UserLogin userLogin;


     private UserPractice userPracticeInfo;

	public String getIsHasUserPractice() {
		return IsHasUserPractice;
	}

	public void setIsHasUserPractice(String isHasUserPractice) {
		IsHasUserPractice = isHasUserPractice;
	}

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

     
}