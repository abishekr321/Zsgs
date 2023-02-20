package com.zsgs.flightreservation.userlogin;

import com.zsgs.flightreservation.dto.User;

public interface UserLoginControllerModelCallBack {
	void loginFailure(String errorMessage);

	void loginSuccess(User userdetails);

	void additionSuccess(String string);

	void additionFailure(String string);

	

}
