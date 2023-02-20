package com.zsgs.flightreservation.ticketbooking;

import java.util.List;

import com.zsgs.flightreservation.dto.Flight;
import com.zsgs.flightreservation.dto.Tickets;
import com.zsgs.flightreservation.dto.User;

public class TicketBookingController implements TicketBookingControllerCallBack,TicketBookingControllerModelCallBack {
	private TicketBookingViewCallBack ticketBookingView;
	private TicketBookingModelCallBack ticketBookingModel;
	public TicketBookingController(TicketBookingViewCallBack ticketBookingView) {
		this.ticketBookingView=ticketBookingView;
		ticketBookingModel=new TicketBookingModel(this);
		
	}
	@Override
	public void booksTickets(String arrive, String depart) {
		ticketBookingModel.booksTickets(arrive,depart);
		
	}
	@Override
	public void flightNotAvailability(String errorMessage) {
		ticketBookingView.flightAvailability(errorMessage);
		
	}
	@Override
	public void flightAvailability(Flight flightdetails) {
		ticketBookingView.flightNotAvailability(flightdetails);
		
	}
	@Override
	public void ViewTickets(User userdetails) {
		ticketBookingModel.ViewTickets(userdetails);
		
	}

	@Override
	public void cancelTickets(String ticketNo) {
		ticketBookingModel.cancelTickets(ticketNo);
		
	}
	@Override
	public void cancelSuccess(String successMessage) {
		ticketBookingView.cancelSuccess(successMessage);
		
	}
	@Override
	public void cancelFailure(String errorMessage) {
		ticketBookingView.cancelFailure(errorMessage);
		
	}
	@Override
	public void printAll(List<Tickets> viewAllTickets) {
		   ticketBookingView.printAll(viewAllTickets);
		
	}

}
