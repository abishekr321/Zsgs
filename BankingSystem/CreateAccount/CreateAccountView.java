package com.BankingSystem.CreateAccount;

import java.time.LocalDate;
import java.util.Scanner;

import com.BankingSystem.Login.LoginView;
import com.BankingSystem.dto.CustomerAccounts;

public class CreateAccountView implements CreateAccountViewCallBack{
	private CreateAccountControllerCallBack createAccountController;
	private Scanner scanner = new Scanner(System.in);
	private Long AccountNumber;
	private LoginView loginView;

	public CreateAccountView(LoginView loginView) {
		this.loginView=loginView;
		createAccountController = new CreateAccountController(this);
	}
	
	
	public void accountMenu() {
		System.out.println("Enter 1 to create savings account");
		System.out.println("Enter 2 to create current account");
		int option = scanner.nextInt();
		switch(option) {
		case(1):
			savingsAccountCreation();
		    break;
		    
		case(2):
			currentAccountCreation();
		    break;
	
		}
	}
	

	public void savingsAccountCreation() {	
		System.out.println("Enter your first name: ");
		String firstName = scanner.next();
		System.out.println("Enter your last name: ");
		String lastName = scanner.next();
		System.out.println("Enter your gender(M/F): ");
		String gender = scanner.next();
		System.out.println("Enter your phone number: ");
		String phoneNumber = scanner.next();
		System.out.println("Enter email id: ");
		String emailId = scanner.next();
		System.out.println("Enter Aadhar number: ");
		Long aadharNumber = scanner.nextLong();
        LocalDate creationDate = LocalDate.now();

        System.out.println("Enter your pan number: ");
        String panNumber = scanner.next();
        scanner.nextLine();
        System.out.println("Enter your address: ");
       
        String address = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter branch: ");
        String branch = scanner.nextLine();        
        
        createAccountController.createAccount(firstName, lastName,gender, phoneNumber,emailId,
    			aadharNumber,creationDate, panNumber, address,branch,"Savings");
        
        
		
		
		
	}
	
	public void currentAccountCreation(){
		System.out.println("Enter your first name: ");
		
		String firstName = scanner.next();
		System.out.println("Enter your last name: ");
		String lastName = scanner.next();
		System.out.println("Enter your gender(M/F): ");
		String gender = scanner.next();
		System.out.println("Enter your phone number: ");
		String phoneNumber = scanner.next();
		System.out.println("Enter email id: ");
		String emailId = scanner.next();
		System.out.println("Enter Aadhar number: ");
		Long aadharNumber = scanner.nextLong();
        LocalDate creationDate = LocalDate.now();
        System.out.println("Enter your pan number: ");
        String panNumber = scanner.next();
        scanner.nextLine();
        System.out.println("Enter your address: ");
        String address = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter branch: ");
        String branch = scanner.nextLine();
     
                
        
        createAccountController.createAccount(firstName, lastName,gender, phoneNumber,emailId,
    			aadharNumber,creationDate, panNumber, address,branch,"Current");
		
	}


	@Override
	public void AccountCreationSuccess(CustomerAccounts customerPassBook) {
		System.out.println(customerPassBook.getFirstName()+" account added Successfully!");
		showPassBook(customerPassBook); 
		
	    
	}
	


	@Override
	public void AccountCreationFailure(CustomerAccounts customerPassBook,String errorMessage) {
	    
		System.out.println(errorMessage);
		showPassBook(customerPassBook);
	
		
	}
	private void showPassBook(CustomerAccounts customerPassBook) {
		System.out.printf("%30s%n%25s%n%n","------------->AhA Bank<--------------", customerPassBook.getBranch());
		System.out.printf("%-25s%-35s%n","Customer Name:",customerPassBook.getFirstName()+" "+customerPassBook.getLastName());
		System.out.printf("%-25s%-15s%n","Account Number:",customerPassBook.getAccountNumber());
		System.out.printf("%-25s%-15s%n","IFSC code:",customerPassBook.getIFSCcode());
		System.out.printf("%-25s%-15s%n","Account Type:",customerPassBook.getaccountType());
		System.out.printf("%-25s%-15s%n","Date of opened:",customerPassBook.getCreationDate());
	    this.AccountNumber=customerPassBook.getAccountNumber();
	    loginView.menu(AccountNumber);
	}
	
	

}
