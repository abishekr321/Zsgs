package com.zsgs.flightreservation.adminlogin;

import com.zsgs.flightreservation.dto.Admin;

public interface AdminLoginViewCallBack {

	void loginSuccess(Admin admindetails);

	void loginFailure(String errorMessage);

}
