package com.BankingSystem.Login;

public interface LoginViewCallBack {

	void signUpUser();

	void signUpDone();

	void signUpFailed();

	void loginSuccesful(String userId);

	void loginFailure();

	void inputValidation(String errorMessage);

}
