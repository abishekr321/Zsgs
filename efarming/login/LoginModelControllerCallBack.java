package com.zsgs.efarming.login;

public interface LoginModelControllerCallBack {

	void signupSuccess(String userId, String successMessage);

	void signupFailure(String errorMessage);

	void farmerSignInSuccess(String userId, String successMessage);

	void UserSignInSuccess(String userId, String string);

}
