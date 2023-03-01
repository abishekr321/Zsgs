package com.zsgs.efarming.login;


public class LoginController implements LoginControllerCallBack,LoginModelControllerCallBack {
	 private LoginViewCallBack loginView;
	 private LoginModelCallBack loginModel;
	 public LoginController(LoginViewCallBack loginView) {
		 this.loginView=loginView;
		 loginModel =new LoginModel(this);
	 }

	@Override
	public String hashingPassword(String password) {
		int i=11;
		String passedword="";
		 for(char c: password.toCharArray()) {
			passedword+=((c+i++)%26); 
			 
		 }
		return passedword;
	}

	@Override
	public void SignUp(String designation,String userName, String userLName,String mobileNumber, String password,String address) {
		loginModel.SignUp(designation,userName,userLName,mobileNumber,password,address);
		
	}

	@Override
	public void SignIn(String userId, String userPassword) {
		loginModel.SignIn(userId,userPassword);
		
	}

	@Override
	public void signupSuccess(String userId,String successMessage) {
		loginView.signupSuccess(userId,successMessage);
		
	}

	@Override
	public void signupFailure(String errorMessage) {
		loginView.signupFailure(errorMessage);
	}

	@Override
	public void farmerSignInSuccess(String userId,String successMessage) {
		loginView.farmerSignInSuccess(userId,successMessage);
		
	}

	@Override
	public void UserSignInSuccess(String userId,String successMessage) {
		loginView.userSignInSuccess(userId,successMessage);
		
	}

	}
