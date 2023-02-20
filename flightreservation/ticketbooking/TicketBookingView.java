package com.zsgs.flightreservation.ticketbooking;

import java.util.List;
import java.util.Scanner;

import com.zsgs.flightreservation.dto.Flight;
import com.zsgs.flightreservation.dto.Tickets;
import com.zsgs.flightreservation.dto.User;
import com.zsgs.flightreservation.ticketconfirmation.TicketConfirmationView;
import com.zsgs.flightreservation.userlogin.UserLoginView;

public class TicketBookingView implements TicketBookingViewCallBack {
	private Scanner scanner = new Scanner(System.in);
	private UserLoginView userLoginView;
	private User userdetails;
	private TicketBookingControllerCallBack ticketBookingController;

	public TicketBookingView(UserLoginView userLoginView) {
		this.userLoginView = userLoginView;
		ticketBookingController = new TicketBookingController(this);
	}

	public void bookingTickets(User userdetails) {
		this.userdetails = userdetails;
		choiceBookTickets();
	}

	private void choiceBookTickets() {
		System.out.println(
				"Enter 1 for Book Tickets\nEnter 2 for View Tickets\nEnter 3 for Cancel Tickets\nEnter 4 for logout\nEnter 5 for Exit");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			bookTickets();
			break;

		case 2:
			ViewTickets(userdetails);
			break;
		case 3:
			CancelTickets();
			break;
		case 4:
			userLoginView.userCheckLogin();
			;
		case 5:
			System.out.println("----->Thank You<-----");
		}
	}

	private void CancelTickets() {
		System.out.println("Enter Ticket Number to Cancel");
		String ticketNo = scanner.next();
		ticketBookingController.cancelTickets(ticketNo);

	}

	private void ViewTickets(User userdetails) {
		ticketBookingController.ViewTickets(userdetails);

	}

	private void bookTickets() {
		System.out.println("Enter the Arrival Location");
		String arrive = scanner.next();
		System.out.println("Enter the Departure Location");
		String depart = scanner.next();
		ticketBookingController.booksTickets(arrive, depart);

	}

	private void bookSeats(Flight flightdetails) {
		System.out.println("Enter 1 for continueBooking\nEnter 2 for CancelBooking");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			TicketConfirmationView ticketConfirmationView = new TicketConfirmationView(this);
			ticketConfirmationView.bookTickets(userdetails, flightdetails);
			break;

		case 2:
			System.out.println("your booking has been cancelled");
			bookTickets();

		}

	}

	@Override
	public void flightNotAvailability(Flight flight) {
		System.out.format("%-15s\t", "Flight Number");
		System.out.format("%-15s\t", "Flight Name");
		System.out.format("%-15s\t", "Arrival");
		System.out.format("%-15s\t", "Departure");
		System.out.format("%-15s\t", "Arrival Time");
		System.out.format("%-15s\t", "DepartureTime");
		System.out.format("%-15s\t", "Fare");
		System.out.println();
		System.out.format("%-15s\t", flight.getFlightNo());
		System.out.format("%-15s\t", flight.getFlightName());
		System.out.format("%-15s\t", flight.getArrive());
		System.out.format("%-15s\t", flight.getDepart());
		System.out.format("%-15s\t", flight.getArrivalTime());
		System.out.format("%-15s\t", flight.getDepartureTime());
		System.out.format("%-15s\t", flight.getFare());
		System.out.println();
		bookSeats(flight);

	}

	@Override
	public void flightAvailability(String errorMessage) {
		System.out.println(errorMessage);
		choiceBookTickets();
	}

	@Override
	public void cancelSuccess(String successMessage) {
		System.out.println(successMessage);
		choiceBookTickets();

	}

	@Override
	public void cancelFailure(String errorMessage) {
		System.out.println(errorMessage);
		choiceBookTickets();

	}

	@Override
	public void printAll(List<Tickets> viewAllTickets) {
		for (Tickets ticket : viewAllTickets) {
			System.out.format("%-15s", "Ticket Id");
			System.out.format("%-15s", "Passenger Name");
			System.out.format("%-15s", "Flight Number");
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
			System.out.println();
		}
		if (viewAllTickets.size() == 0) {
			System.out.println("No tickets available");

		}
		System.out.println();
		choiceBookTickets();

	}

}
