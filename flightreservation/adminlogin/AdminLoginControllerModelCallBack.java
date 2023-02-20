package com.zsgs.flightreservation.adminlogin;

import com.zsgs.flightreservation.dto.Admin;

public interface AdminLoginControllerModelCallBack {

	void loginSuccess(Admin admindetails);

	void loginFailure(String string);

}
