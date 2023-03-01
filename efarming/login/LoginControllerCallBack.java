package com.zsgs.efarming.login;

public interface LoginControllerCallBack {

	void SignUp(String userName, String userLName, String mobileNumber, String password, String password2, String address);

	String hashingPassword(String password);

	void SignIn(String userId, String userpassword);

}
