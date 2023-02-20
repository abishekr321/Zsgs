package com.zsgs.flightreservation.setupflights;

import java.util.List;
import java.util.Scanner;

import com.zsgs.flightreservation.adminlogin.AdminLoginView;
import com.zsgs.flightreservation.dto.Flight;

public class SetupFlightView implements SetupFlightViewCallBack{
	private SetupFlightControllerCallBack setupFlightController;
	AdminLoginView adminLoginView;
	private Scanner scanner =new Scanner(System.in);
	public SetupFlightView(AdminLoginView adminLoginView) {
		this.adminLoginView=adminLoginView;
		setupFlightController = new SetupFlightController(this);
	}
	public void setupFlights() {
		System.out.println("Enter 1 for View Flights\nEnter 2 for add Flights\nEnter 3 for remove Flights\nEnter 4 for logout\nEnter 5 for Exit");
		int choice=scanner.nextInt();
		switch(choice) {
		case 1:
			viewFlights();
			break;
		case 2:
			addFlights();
			break;
		case 3:
			deleteFlights();
			break;
		case 4:
			System.out.println("Logout Successfully");
			adminLoginView.choiceLogin();
			break;
		case 5:
			System.out.println("<------Thank You----->");
			
		}
		
		
	}
	private void viewFlights() {
		setupFlightController.viewFlights();
		setupFlights();
		
	}
	public void  printFlights(List<Flight> flightdetails) {
		System.out.format("%-15s\t","Flight Number");
		System.out.format("%-15s\t","Flight Name");
		System.out.format("%-15s\t","Arrival");
		System.out.format("%-15s\t","Departure");
		System.out.format("%-15s\t","Arrival Time");
		System.out.format("%-15s\t","DepartureTime");
		System.out.format("%-15s\t","Fare");
		System.out.println();
		for(Flight flight:flightdetails ) {
			System.out.format("%-15s\t",flight.getFlightNo());
			System.out.format("%-15s\t",flight.getFlightName());
			System.out.format("%-15s\t",flight.getArrive());
			System.out.format("%-15s\t",flight.getDepart());
			System.out.format("%-15s\t",flight.getArrivalTime());
			System.out.format("%-15s\t",flight.getDepartureTime());
			System.out.format("%-15s\t",flight.getFare());
			System.out.println();
			System.out.println();
			
		}
		setupFlights();
		
		
		
	}
	private void deleteFlights() {
		System.out.println("Enter flight No");
		String flightNo=scanner.next();
		setupFlightController.deleteFlights(flightNo);
		
		
	}
	private void addFlights() {
		System.out.println("Enter flight No");
		String flightNo=scanner.next();
		System.out.println("Enter flight Name");
		String flightName=scanner.nextLine();
		System.out.println("Enter Arrival of flight");
		String arrival=scanner.next();
		System.out.println("Enter Departure of flight ");
		String departure=scanner.next();
		System.out.println("Enter Arrival time of flight");
		String arrivalTime=scanner.nextLine();
		System.out.println("Enter Departure time of flight");
		String departureTime=scanner.nextLine();
		System.out.println("Enter fare of flight");
		String fare=scanner.next();
		setupFlightController.addFlights(arrival,departure,flightNo,flightName,arrivalTime,departureTime,fare);
	}
	@Override
	public void additionSuccess(String successMessage) {
		System.out.println(successMessage);
		setupFlights();
		
	}
	@Override
	public void additionFailure(String errorMessage) {
	    System.out.println(errorMessage);
	    setupFlights();
	}
	@Override
	public void deletionSuccess(String successMessage) {
		System.out.println(successMessage);
		setupFlights();
		
	}
	@Override
	public void deletionFailure(String errorMessage) {
		System.out.println(errorMessage);
		setupFlights();
		
	}
	
	
	

}
