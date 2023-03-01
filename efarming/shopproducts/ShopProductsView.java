package com.zsgs.efarming.shopproducts;

import java.util.List;
import java.util.Scanner;

import com.zsgs.efarming.dto.Orders;
import com.zsgs.efarming.dto.Products;
import com.zsgs.efarming.login.LoginView;

public class ShopProductsView implements ShopProductsViewCallBack {
	 private ShopProductsControllerCallBack shopProductsController;
	 private LoginView loginView;
	 private String userId;
	 private Scanner scanner =new Scanner(System.in);
	 public ShopProductsView(LoginView loginView) {
		 this.loginView=loginView;
		 shopProductsController=new ShopProductsController(this);
	 }
	public void shopMenu(String userId) {
		this.userId=userId;
		System.out.println("Enter 1 to Buy Products\nEnter 3 to View Orders\nEnter 3 to logout");
		char choice =scanner.next().charAt(0);
		switch(choice) {
		case '1':
			buyProducts(userId);
			break;
		case '2':
			viewOrders(userId);
			break;
		case '3':
			loginView.loginMenu();
			break;
		default:
			System.out.println("Enter valid input");
			shopMenu(userId);
		}
		
		
	}
	private void viewOrders(String userId) {
		List<Orders> orderList=shopProductsController.getOrders(userId);
		System.out.printf("%-15s%-30s%-20s%-20s%n","product Id","Product Name","quantity","price","DateOfOrders","DateOfDelivers");
		for(Orders order:orderList) {
			System.out.printf("%-15s%-30s%-20s%-20s%n",order.getProductId(),order.getProductName(),order.getQuantity(),order.getPrice(),order.getDateOfOrder().toString());	
		}
		
	}
	private void buyProducts(String userId) {
		List<Products> productList=shopProductsController.getProducts();
		System.out.printf("%-15s%-30s%-20s%-20s%n","product Id","Product Name","quantity","price");
		for(Products product:productList) {
			System.out.printf("%-15s%-30s%-20s%-20s%n",product.getProductId(),product.getProductName(),product.getQuantity(),product.getPrice());	
		}
		float originalQuantity=0.0f;
		float originalPrice=0.0f;
		String productName="";
		String productId="";
		boolean boolCheck=true;
		while(boolCheck) {
		System.out.println("Enter the product Id to Buy");
		 productId=scanner.next();
		for(Products product:productList) {
			if(product.getProductId().equals(productId)) {
				originalQuantity=product.getQuantity();
				originalPrice=product.getPrice();
				productName=product.getProductName();
				boolCheck=false;
			}
			else {
				System.out.println("please Enter valid product Key");
			}
		}
		}
		System.out.println("Enter the quantity to buy");
		float quantity=scanner.nextFloat();
		if(quantity>originalQuantity) {
			System.out.println("Sorry,stock not available");
			shopMenu(userId);
			
		}
		else {
		System.out.println("The total amount is Rs."+quantity*originalPrice);
		System.out.println("Enter 1 to confirm Order\nEnter 2 to cancel order");
		char choice =scanner.next().charAt(0);
		switch(choice) {
		case '1':
			System.out.println("please pay the amount");
			float amount=scanner.nextFloat();
		   boolCheck=true;
			while(boolCheck) {
				if(amount==quantity*originalPrice) {
					shopProductsController.placeOrders(userId,productId,productName,quantity,amount);
					boolCheck=false;
				}
			}
			break;
		case '2':
			buyProducts(userId);
		}
		}
		
	}
	public  void additionSuccess(String successMessage) {
		System.out.println(successMessage);
		shopMenu(userId);
		
	}
	public void additionFailure(String failureMessage) {
		System.out.println(failureMessage);
		shopMenu(userId);
		
	}
	
	

}

