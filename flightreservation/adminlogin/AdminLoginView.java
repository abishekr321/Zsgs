package com.zsgs.flightreservation.adminlogin;

import java.util.Scanner;

import com.zsgs.flightreservation.dto.Admin;
import com.zsgs.flightreservation.setupflights.SetupFlightView;
import com.zsgs.flightreservation.userlogin.UserLoginView;


public class AdminLoginView implements AdminLoginViewCallBack {
         private AdminLoginControllerCallBack adminLoginController;
         private Scanner scanner=new Scanner(System.in);
      public AdminLoginView() {
    	  adminLoginController=new AdminLoginController(this);
      }
      public static void main(String[] args) {
  		AdminLoginView userLoginView =new AdminLoginView ();
  	 	   userLoginView.choiceLogin();
  	}
      
  	public void choiceLogin() {
  		choiceOfLogin();
  		
		
	}
	private void choiceOfLogin() {
  		System.out.println("Welcome to Flight Reservation System\n ------------------------");
  		System.out.println("Enter 1 for AdminLogin\nEnter 2 for UserLogin\nEnter 3 for Exit");
  		int choice = scanner.nextInt();
  		switch(choice) {
  		case 1:
  			CheckForLogin();
  			break;
  		case 2:
  			UserLoginView userLoginView =new UserLoginView (this);
 	 	     userLoginView.userCheckLogin();
 	 	     break;
  		case 3:
  			System.out.println("------>Thank You<-------");
  		}
  	}
  	private void CheckForLogin() {
  		System.out.println("Enter Admin ID");
  		String userName = scanner.next();
  		System.out.println("Enter password");
  		String password = scanner.next();
  		adminLoginController.checkCredentials(userName, password);	
  	}
	@Override
	public void loginSuccess(Admin admindetails) {
		System.out.println("\n-->Welcome " + admindetails.getAdminName() + " Admin <--\n");
		SetupFlightView setupFlightView =new SetupFlightView(this);
		setupFlightView.setupFlights();
		
	}
	@Override
	public void loginFailure(String errorMessage) {
	     System.out.println(errorMessage);
	     choiceOfLogin();
		
	}
         

}
