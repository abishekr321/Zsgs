package com.zsgs.flightreservation.userlogin;

import java.util.Scanner;

import com.zsgs.flightreservation.adminlogin.AdminLoginView;
import com.zsgs.flightreservation.dto.User;
import com.zsgs.flightreservation.ticketbooking.TicketBookingView;

public class UserLoginView implements UserLoginViewCallBack {
	private UserLoginControllerCallBack userLoginController;
	private AdminLoginView adminLoginView;
	private Scanner scanner = new Scanner(System.in);
	public UserLoginView(AdminLoginView adminLoginView) {
		userLoginController=new UserLoginController(this);
	}
	public void userCheckLogin() {
		checkForLogin();
	}
	private void choiceLogin() {
		System.out.println("Enter 1 for new User Signup\nEnter 2 for userlogin\nEnter 3 for Back\nEnter 4 for Exit ");
		int choice = scanner.nextInt();
		switch(choice){
			case 1:
				userSignIn();
				break;
			case 2:
				userCheckLogin();
				break;
			case 3:
				adminLoginView.choiceLogin();
			case 4:
				System.out.println("-------->Thank you<---------");
				
				
		}
		
	}

	
	private void checkForLogin() {
		
		System.out.println("Enter User ID");
		String userId = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();
		userLoginController.checkCredentials(userId, password);	
	}
	private void userSignIn() {
		System.out.println("Enter the name");
		String userName=scanner.next();
		System.out.println("Enter the UserId");
		String userId = scanner.next();
		System.out.println("Enter password");
		String password= scanner.next();
		userLoginController.addCredentials(userName,userId, password);
		
	}
	
	@Override
	public void loginFailure(String errorMessage) {
		System.out.println(errorMessage);
		choiceLogin();
		
	}
	
	@Override
	public void loginSuccess(User userdetails) {
		System.out.println("\n-->Welcome " + userdetails.getUserName() + "<--\n");
		TicketBookingView ticketBookingView=new TicketBookingView(this);
		ticketBookingView.bookingTickets(userdetails);
		
	}
	@Override
	public void additionSuccess(String successMessage) {
		System.out.println(successMessage);
		userCheckLogin();
		
	}
	@Override
	public void additionFailure(String failureMessage) {
		System.out.println(failureMessage);
		userCheckLogin();
		
	}
	

	
	

}
