package com.zsgs.efarming.login;

import com.zsgs.efarming.repository.DbRepository;

public class LoginModel implements LoginModelCallBack {
	private LoginModelControllerCallBack loginController;
	public LoginModel(LoginController loginController) {
		this.loginController=loginController;
	}

	@Override
	public void SignUp(String designation,String userName, String userLName, String mobileNumber, String password,String address) {
	    if(designation.equals("FARMER")) {
	    	String userId=DbRepository.getInstance().addFarmer(userName,userLName,mobileNumber,password); 
              if(userId!=null) {
	    	  loginController.signupSuccess(userId,userName+" Added Successfully");
	   
	    	}
	    	else {
	    	
	    		loginController.signupFailure(userName+" Already Exist");
	    	}
	    }
	    else  {
	    	String userId=DbRepository.getInstance().addUser(userName,userLName,mobileNumber,password,address);
	    	if(userId!=null) {
	    		loginController.signupSuccess(userId,userName+" Added Successfully");
	    	}
	    	else {
	    		loginController.signupFailure(userName+" Already Exist");
	    	}
	    	
	    }
		
		}

	@Override
	public void SignIn(String userId, String userPassword) {
		if(userId.charAt(0)=='F') {
	    	if(DbRepository.getInstance().checkFarmerID(userId,userPassword)) {
	    	   loginController.farmerSignInSuccess(userId,userId+" Welcome Farmer");
	    	}
	    	else {
	    		loginController.signupFailure("Invalid Credentials");
	    	}
	    }
	    else {
	    	if(DbRepository.getInstance().checkUserID(userId,userPassword)) {
	    		loginController.UserSignInSuccess(userId,userId+"Welcome User");
	    	}
	    	else {
	    		loginController.signupFailure("Invalid Credentials");
	    	}
	    }
		
		}

}
