package com.zsgs.flightreservation.adminlogin;

import com.zsgs.flightreservation.dto.Admin;

public class AdminLoginController implements AdminLoginControllerCallBack,AdminLoginControllerModelCallBack {
    private AdminLoginView adminLoginView;
    private AdminLoginModelCallBack adminLoginModel;
	public AdminLoginController(AdminLoginView adminLoginView) {
		  this.adminLoginView=adminLoginView;
		  adminLoginModel=new  AdminLoginModel(this);
		
	}
	
	@Override
	public void checkCredentials(String AdminID, String password) {
		adminLoginModel.checkCredentials(AdminID,password);
		
	}
	@Override
	public void loginSuccess(Admin admindetails) {
		adminLoginView.loginSuccess(admindetails);
		
	}
	@Override
	public void loginFailure(String errorMessage) {
		adminLoginView.loginFailure(errorMessage);
		
		
	}

}
