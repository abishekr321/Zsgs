package com.zsgs.flightreservation.ticketconfirmation;

import com.zsgs.flightreservation.dto.Flight;
import com.zsgs.flightreservation.dto.Tickets;
import com.zsgs.flightreservation.dto.User;

public class TicketConfirmationController implements TicketConfirmationControllerCallBack,TicketConfirmationControllerModelCallBack {

	private TicketConfirmationViewCallBack  ticketConfirmationView;
	private TicketConfirmationModelCallBack  ticketConfirmationModel; 
	 public TicketConfirmationController(TicketConfirmationViewCallBack  ticketConfirmationView) {
		 this.ticketConfirmationView=ticketConfirmationView;
		 ticketConfirmationModel=new  TicketConfirmationModel(this);
	 }
	@Override
	public void confirmsTickets(User userdetails, Flight flightdetails) {
		ticketConfirmationModel.confirmsTickets(userdetails,flightdetails);
		
	}
	@Override
	public void viewTickets(Tickets ticket) {
		ticketConfirmationView.viewTickets(ticket);
		
	}
	@Override
	public void noTickets(String errorMessage) {
		ticketConfirmationView.noTickets(errorMessage);
		
	}
	
	 
	
}
