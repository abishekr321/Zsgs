package com.zsgs.flightreservation.userlogin;

public interface UserLoginControllerCallBack {

	void checkCredentials(String userName, String password);

	void addCredentials(String userName, String userId, String password);

}
