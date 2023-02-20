package com.zsgs.flightreservation.userlogin;

import com.zsgs.flightreservation.dto.User;
import com.zsgs.flightreservation.repository.FlightRepository;

public class UserLoginModel implements UserLoginModelCallBack {
	private UserLoginControllerModelCallBack userLoginController;
	public  UserLoginModel(UserLoginControllerModelCallBack userLoginController){
		this.userLoginController=userLoginController;
	}
	public void checkCredentials(String userID, String password) {
		User userdetails = FlightRepository.getInstance().checkValidUser(userID,password);
		if (userdetails !=null) {
			userLoginController.loginSuccess(userdetails);
		} else {
			userLoginController.loginFailure("\nInvalid Credentials. Please try again!\n");
		}
		
		
	}
	@Override
	public void addCredentials(String userName, String userId, String password) {
		if(FlightRepository.getInstance().addCredentials(userName,userId,password)){
			userLoginController.additionSuccess( userName+" Added Successfully");
		}
		else {
			userLoginController.additionFailure("Already Existing User please login again");
		}
		
	}

}
