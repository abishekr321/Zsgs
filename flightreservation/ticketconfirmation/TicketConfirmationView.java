package com.zsgs.flightreservation.ticketconfirmation;

import java.util.Scanner;

import com.zsgs.flightreservation.dto.Flight;
import com.zsgs.flightreservation.dto.Tickets;
import com.zsgs.flightreservation.dto.User;
import com.zsgs.flightreservation.ticketbooking.TicketBookingView;

public class TicketConfirmationView implements TicketConfirmationViewCallBack {
	private TicketConfirmationControllerCallBack ticketConfirmationController;
	private Scanner scanner=new Scanner(System.in);
	private TicketBookingView ticketBookingView;
	private User userdetails;
	public TicketConfirmationView(TicketBookingView ticketBookingView) {
		this.ticketBookingView=ticketBookingView;
		ticketConfirmationController=new  TicketConfirmationController(this);
	}
	public void bookTickets(User userdetails, Flight flightdetails) {
		this.userdetails=userdetails;
		confirmTickets(userdetails,flightdetails);
		
	}
	
	private void confirmTickets(User userdetails, Flight flightdetails) {
		System.out.println("pay "+flightdetails.getFare() +" for Confirmation");
		String amount=scanner.next();
		amount="Rs."+amount;
		if(amount.equals(flightdetails.getFare())) {
		ticketConfirmationController.confirmsTickets( userdetails,flightdetails);}
		else {
			System.out.print("Enter valid amount ");
			confirmTickets(userdetails,flightdetails);
			
		}
		
		
	}
	@Override
	public void viewTickets(Tickets ticket) {
		System.out.format("%-15s","Ticket Id");
		System.out.format("%-15s", "Passenger Name");
		System.out.format("%-15s","Flight Number");
		System.out.println();
		System.out.format("%-15s", ticket.getTicketId());
		System.out.format("%-15s", ticket.getUserName());
		System.out.format("%-15s", ticket.getFlightNo());
		System.out.println();
		System.out.format("%-15s", "Arrival");
		System.out.format("%-15s", "Departure");
		System.out.println();
		System.out.format("%-15s", ticket.getArrival());
		System.out.format("%-15s", ticket.getDeparture());
		System.out.println();
		System.out.format("%-15s", "Arrival Time");
		System.out.format("%-15s", "Departure Time");
		System.out.println();
		System.out.format("%-15s", ticket.getArrivalTime());
		System.out.format("%-15s", ticket.getDepartureTime());
		System.out.println();
		System.out.println("---------->Happy Journey<----------");
		System.out.println();
		ticketBookingView.bookingTickets(userdetails);
		
	}
	@Override
	public void noTickets(String errorMessage) {
		System.out.println(errorMessage);
		ticketBookingView.bookingTickets(userdetails);
		
	}
	

	
}
