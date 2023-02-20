package com.zsgs.flightreservation.adminlogin;

import com.zsgs.flightreservation.dto.Admin;
import com.zsgs.flightreservation.repository.FlightRepository;

public class AdminLoginModel implements AdminLoginModelCallBack {
	private AdminLoginControllerModelCallBack adminLoginController;

	public AdminLoginModel(AdminLoginControllerModelCallBack adminLoginController) {
		this.adminLoginController=adminLoginController;
	}

	@Override
	
	public void checkCredentials(String AdminID, String password) {
		Admin admindetails = FlightRepository.getInstance().checkValidAdmin(AdminID,password);
		if (admindetails !=null) {
			adminLoginController.loginSuccess(admindetails);
		} else {
			adminLoginController.loginFailure("\nInvalid Credentials. Please try again!\n");
		}
		
	}

}
