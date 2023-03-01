package com.zsgs.efarming.login;

public interface LoginViewCallBack {

	void signupFailure(String errorMessage);

	void signupSuccess(String userId, String successMessage);;

	void farmerSignInSuccess(String userId, String successMessage);

	void userSignInSuccess(String userId, String successMessage);

}