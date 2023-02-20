package com.zsgs.flightreservation.userlogin;

import com.zsgs.flightreservation.dto.User;

public class UserLoginController implements UserLoginControllerCallBack,UserLoginControllerModelCallBack {
	private UserLoginViewCallBack userLoginView;
	private UserLoginModelCallBack userLoginModel;
	public UserLoginController(UserLoginViewCallBack userLoginView) {
		this.userLoginView=userLoginView;
		userLoginModel= new UserLoginModel(this);
		
	}
	public void checkCredentials(String userID, String password) {
		userLoginModel.checkCredentials(userID,password);
	}
	@Override
	public void loginFailure(String errorMessage) {
		userLoginView.loginFailure(errorMessage);
		
	}
	@Override
	public void loginSuccess(User userdetails) {
		userLoginView.loginSuccess(userdetails);
		
		
	}
	@Override
	public void addCredentials(String userName, String userId, String password) {
		userLoginModel.addCredentials(userName,userId,password);
		
	}
	@Override
	public void additionSuccess(String successMessage) {
		userLoginView.additionSuccess(successMessage);
		
	}
	@Override
	public void additionFailure(String FailureMessage) {
		userLoginView.additionFailure(FailureMessage);
		
	}


}
