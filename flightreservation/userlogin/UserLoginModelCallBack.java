package com.zsgs.flightreservation.userlogin;

public interface UserLoginModelCallBack {

	void checkCredentials(String userID, String password);

	void addCredentials(String userName, String userId, String password);

}
