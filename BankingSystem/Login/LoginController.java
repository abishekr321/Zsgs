package com.BankingSystem.Login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController implements LoginControllerCallBack,LoginModelControllerCallBack{

	
	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;

	public LoginController(LoginViewCallBack loginView) {
		this.loginView = loginView;
		this.loginModel = new LoginModel(this);
	}
	
	
	public void checkcredentials(String userId, String password) {
		loginModel.checkValidUser(userId,password);
	}
	
	public void loginSuccess(String userId) {
		loginView.loginSuccesful(userId);
	}
	
	public void loginFailure() {
		loginView.loginFailure();
	}
	
	public void signUp(String firstName, String lastName, String emailId,String phoneNumber, String userId, String password) {
		
		boolean number ;
		boolean email;
		
		Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9]*@[a-zA-Z0-9]+[.][c][o][m]");
		Matcher m = p.matcher(emailId);
		if(!(m.find())) {
			loginView.inputValidation("Incorrect Email");
			email = false;
		   
		}
		else email = true;;
		
		
		Pattern pattern = Pattern.compile("[6-9][0-9]{9}");
		Matcher match = pattern.matcher(phoneNumber);
		if(match.find() && phoneNumber.length()== 10) {
			 number = true;
		}
		else {
			loginView.inputValidation("Invalid Phone Number");
			number = false;
		}
		
		if(email && number)loginModel.signUpDb(firstName, lastName, emailId,phoneNumber, userId, password);
		else {
			System.out.println("Please enter your details again");
			loginView.signUpUser();
		}
	}
		
		

	
	public void signUpSuccess() {
		loginView.signUpDone();
	}
	
	public void signUpFailure() {
		loginView.signUpFailed();
	}


	@Override
	public long getAccountNumber(String userId) {
		 return loginModel.getAccountNumber(userId);
		
	}
	

}
