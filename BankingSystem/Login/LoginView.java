package com.BankingSystem.Login;

import java.util.Scanner;

import com.BankingSystem.CreateAccount.CreateAccountView;
import com.BankingSystem.Transaction.TransactionView;
import com.BankingSystem.TransactionHistory.TransactionHistoryView;

public class LoginView implements LoginViewCallBack {

	private LoginControllerCallBack loginController;
	private Scanner scanner = new Scanner(System.in);
	private long accountNumber;

	public LoginView() {
		loginController = new LoginController(this);
	}

	public static void main(String args[]) {
		LoginView loginView = new LoginView();
		loginView.loginOption();
	}

	public void loginOption() {

		System.out.println("\n\n------>Welcome to AHA Bank<------");

		System.out.println("Enter 1 to login ");
		System.out.println("Enter 2 to sign up");
		System.out.println("Enter 3 to exit");

		int option = scanner.nextInt();

		switch (option) {
		case 1:
			checkLoginCredentials();
			break;

		case 2:
			signUpUser();
			break;

		case 3:
			System.out.println("------->ThankYou<-------");
			System.exit(0);

		}

	}

	public void checkLoginCredentials() {
		System.out.println("Enter user id: ");
		String userId = scanner.next();
		System.out.println("Enter password: ");
		String password = scanner.next();

		loginController.checkcredentials(userId, password);
	}

	public void loginSuccesful(String userId) {
		System.out.println( userId+ " ,You have logged in successfully!\n");
		getAccountNumber(userId);
		menu(accountNumber);
	}

	private void getAccountNumber(String userId) {
		accountNumber = loginController.getAccountNumber(userId);

	}

	public void loginFailure() {
		System.out.println("Invalid credentials");
		System.out.println("Please enter correct user id and password. ");
		System.out.println();
		loginOption();

	}

	public void signUpUser() {
		System.out.println();
		System.out.println("Enter first name: ");
		String firstName = scanner.next();
		System.out.println("Enter last name: ");
		String lastName = scanner.next();
		System.out.println("Enter email id: ");
		String emailId = scanner.next();
		System.out.println("Enter phone number: ");
		String phoneNumber = scanner.next();
		System.out.println("Enter user id: ");
		String userId = scanner.next();
		System.out.println("Enter password: ");
		String password = scanner.next();
		loginController.signUp(firstName, lastName, emailId, phoneNumber, userId, password);
	}

	public void signUpDone() {

		System.out.println("\nSign up successfully done");
		System.out.println("Please login to continue\n");

		checkLoginCredentials();
	}

	public void signUpFailed() {

		System.out.println("\nUser already exist, please login\n");

		checkLoginCredentials();
	}

	@Override
	public void inputValidation(String errorMessage) {
		System.out.println(errorMessage);

	}

	public void menu(Long accountNumber) {
		this.accountNumber = accountNumber;
		System.out.println("Enter 1 for creating new account");
		System.out.println("Enter 2 for money transaction");
		System.out.println("Enter 3 for Apply Loan");
		;
		System.out.println("Enter 4 to Logout");
		System.out.println("Enter 5 to exit");

		int option = scanner.nextInt();

		switch (option) {
		case (1):
			CreateAccountView createAccountView = new CreateAccountView(this);
			createAccountView.accountMenu();
			break;

		case (2):
			if (accountNumber == 0) {
				System.out.println("Please create Account First");
				menu(accountNumber);
				break;
			}
			TransactionView transactionView = new TransactionView(this);
			transactionView.transactionMenu(accountNumber);
			break;

		case (3):
			System.out.println("Visit Your Nearest our Branch");

			break;
		case (4):
			accountNumber = 0L;
			checkLoginCredentials();
			break;
		case (5):
			System.out.println("------------>Thankyou<------------");
			System.exit(0);
		}

	}

}
