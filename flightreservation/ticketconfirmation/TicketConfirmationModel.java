package com.zsgs.flightreservation.ticketconfirmation;

import com.zsgs.flightreservation.dto.Flight;
import com.zsgs.flightreservation.dto.Tickets;
import com.zsgs.flightreservation.dto.User;
import com.zsgs.flightreservation.repository.FlightRepository;

public class TicketConfirmationModel implements TicketConfirmationModelCallBack{
	private TicketConfirmationControllerModelCallBack ticketConfirmationController;
	public TicketConfirmationModel(TicketConfirmationControllerModelCallBack ticketConfirmationController) {
		this.ticketConfirmationController=ticketConfirmationController;
		
	}
	@Override
	public void confirmsTickets(User userdetails, Flight flightdetails) {
		Tickets ticket=FlightRepository.getInstance().viewTickets(userdetails,flightdetails);
		if(ticket!=null) {
			ticketConfirmationController.viewTickets(ticket);
		}
		else {
			ticketConfirmationController.noTickets("No tickets available");
		}
		
		
		
	}
	

}
