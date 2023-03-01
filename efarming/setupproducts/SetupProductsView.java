package com.zsgs.efarming.setupproducts;

import java.util.Scanner;

import com.zsgs.efarming.login.LoginView;

public class SetupProductsView implements SetupProductsViewCallBack {
	 private SetupProductsControllerCallBack setupProductsController;
	 private LoginView loginView;
	 private Scanner scanner=new Scanner(System.in);
	 public SetupProductsView(LoginView loginView) {
		 this.loginView=loginView;
		 setupProductsController=new SetupProductsController(this);
	 }
	 public void setupMenu() {
		System.out.println("Enter 1 to Add Products\nEnter 2 to logout"); 
		char choice = scanner.next().charAt(0);
		switch(choice) {
		case'1':
			addProducts();
			break;
		case '2':
		    loginView.loginMenu();
			break;
			
			
			
		
		}
	 }
	private void addProducts() {
		System.out.println("Enter the product Name");
		String productName=scanner.next();
		System.out.println("Enter the quantity");
		float quantity=scanner.nextFloat();
		System.out.println("Enter the price");
		float price =scanner.nextFloat();
		setupProductsController.addProducts(productName,quantity,price);
		
	}
	@Override
	public void AdditionSuccess(String successMessage) {
		System.out.println(successMessage);
		setupMenu();
		
	}
	@Override
	public void AdditionFailure(String failureMessage) {
		System.out.println(failureMessage);
		setupMenu();
		
	}

}
