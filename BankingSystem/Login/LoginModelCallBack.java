package com.BankingSystem.Login;

public interface LoginModelCallBack {

	void checkValidUser(String userId, String password);

	void signUpDb(String firstName, String lastName, String emailId, String phoneNumber, String userId, String password);

	long getAccountNumber(String userId);

}
