package com.BankingSystem.Login;

import com.BankingSystem.Repository.*;
public class LoginModel implements LoginModelCallBack{

	private LoginModelControllerCallBack loginController;
 
	public LoginModel(LoginModelControllerCallBack loginController) {
		this.loginController = loginController;
	}

	public void checkValidUser(String  userId, String password) {
		if (BankAccountsRepository.getInstance().verifyUser(userId, password)) {
			loginController.loginSuccess(userId);
		} else {
			loginController.loginFailure();
		}
	}

	public void signUpDb(String firstName, String lastName, String emailId, String phoneNumber, String userId,
			String password) {
		if (BankAccountsRepository.getInstance().addUser(firstName, lastName, emailId, phoneNumber, userId,
				password)) {
			loginController.signUpSuccess();
		} else {
			loginController.signUpFailure();
		}
	}

	@Override
	public long getAccountNumber(String userId) {
		return BankAccountsRepository.getInstance().getAccountNumber(userId);
		
	}

	

}
