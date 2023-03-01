package com.zsgs.efarming.login;

import java.util.Scanner;

import com.zsgs.efarming.setupproducts.SetupProductsView;
import com.zsgs.efarming.shopproducts.ShopProductsView;
import com.zsgs.efarming.util.Validate;

public class LoginView implements LoginViewCallBack  {
	private LoginControllerCallBack loginController;
	private boolean boolCheck;
	private Scanner scanner = new Scanner(System.in);

	public LoginView() {
		loginController = new LoginController(this);
	}

	public static void main(String[] args) {
		LoginView loginView = new LoginView();
		loginView.loginMenu();
	}

	public void loginMenu() {
		System.out.println("------->EHO Farming<------");
		System.out.println("Enter 1 to Existing User SignIn\nEnter 2 to New User SignUp\nEnter 3 to Exit");
		char choice = scanner.next().charAt(0);
		switch (choice) {
		case '1':
			SignIn();
			break;
		case '2':
			SignUp();
			break;
		case '3':
			System.out.println("-------->Happy farming<--------");
			System.exit(0);
		default:
			System.out.println("Enter the valid key");
			loginMenu();
		}
	}

	private void SignIn() {
		System.out.println("Enter UserId");
		String userId = scanner.next();
		System.out.println("Enter password");
		String userpassword =loginController.hashingPassword(scanner.next());
		loginController.SignIn(userId, userpassword);
		
	}

	private void SignUp() {
		String designation="";
		System.out.println("Enter 1 for Farmer SignUp\nEnter 2 for User SignUp");
		char choice=scanner.next().charAt(0);
		switch(choice) {
		case '1':
			designation="FARMER";
			break;
		case '2':
			designation="USER";
			break;
		default:
			SignUp();
		}
		System.out.println("Enter First Name");
		String userName = scanner.next();
		System.out.println("Enter Last Name");
		String userLName = scanner.next();
		boolCheck = true;
		String mobileNumber = "";
		while (boolCheck) {
			System.out.println("Enter phone Number");
			mobileNumber = scanner.next();
			if (Validate.mobileNumber(mobileNumber)) {
				boolCheck = false;
			} else {
				System.out.println("please Enter valid Mobile number");
			}
		}
		boolCheck = true;
		String password = "";
		while (boolCheck) {
			System.out.println("Enter the password");
			password = loginController.hashingPassword(scanner.next());
			System.out.println("Re Enter the password");
			String password1 = loginController.hashingPassword(scanner.next());
			if (Validate.validpassword(password, password1)) {
				boolCheck = false;
			} else {
				System.out.println("Re-entered passwords are incorrect ");

			}
		}	
		String address="";
		if(designation.equals("USER")) {
	    address=scanner.nextLine();
		scanner.next();}
loginController.SignUp(designation,userName, userLName, mobileNumber, password,address);
	}

	@Override
	public void signupFailure(String errorMessage) {
		System.out.println(errorMessage);
		loginMenu();		
	}

	@Override
	public void signupSuccess(String userId,String successMessage) {
		System.out.println(successMessage);
		System.out.println("your user Id is "+userId);
		SignIn();
		
	}

	@Override
	public void farmerSignInSuccess(String userId,String successMessage) {
		System.out.println(successMessage);
		SetupProductsView setupProductsView=new SetupProductsView(this);
		setupProductsView.setupMenu();
		
	}

	@Override
	public void userSignInSuccess(String userId,String successMessage) {
		System.out.println(successMessage);
		ShopProductsView shopProductsView=new ShopProductsView(this);
		shopProductsView.shopMenu(userId);
		
	}
}