package com.BankingSystem.Login;

public interface LoginModelControllerCallBack {

	void loginSuccess(String userId);

	void loginFailure();

	void signUpSuccess();

	void signUpFailure();

}
