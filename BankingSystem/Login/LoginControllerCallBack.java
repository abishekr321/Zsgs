package com.BankingSystem.Login;

public interface LoginControllerCallBack {

	void checkcredentials(String userId, String password);

	void signUp(String firstName, String lastName, String emailId, String phoneNumber, String userId, String password);

	long getAccountNumber(String userId);

}
