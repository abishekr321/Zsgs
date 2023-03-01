package com.zsgs.efarming.login;

public interface LoginModelCallBack {

	void SignUp(String userName, String userLName, String mobileNumber, String password, String password2, String address);

	void SignIn(String userId, String userPassword);

}
