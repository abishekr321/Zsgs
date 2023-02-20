package com.zsgs.flightreservation.userlogin;

import com.zsgs.flightreservation.dto.User;

public interface UserLoginViewCallBack {

	void loginFailure(String errorMessage);

	void loginSuccess(User userdetails);

	void additionSuccess(String successMessage);

	void additionFailure(String failureMessage);

}
