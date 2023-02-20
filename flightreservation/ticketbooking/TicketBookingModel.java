package com.zsgs.flightreservation.ticketbooking;

import com.zsgs.flightreservation.dto.Flight;
import com.zsgs.flightreservation.dto.Tickets;
import com.zsgs.flightreservation.dto.User;
import com.zsgs.flightreservation.repository.FlightRepository;

public class TicketBookingModel implements TicketBookingModelCallBack {
	private TicketBookingControllerModelCallBack ticketBookingController;
	public TicketBookingModel(TicketBookingControllerModelCallBack ticketBookingController) {
		this.ticketBookingController=ticketBookingController;
	}
	@Override
	public void booksTickets(String arrive, String depart) {
		Flight flightdetails = FlightRepository.getInstance().showFlights(arrive,depart);
		if (flightdetails !=null) {
			ticketBookingController.flightAvailability(flightdetails);
			
		} else {
			ticketBookingController.flightNotAvailability ("\nSorry for Inconvinience,  Flight is not available!\n");
		}
		
		
	}
	@Override
	public void ViewTickets(User userdetails) {
		ticketBookingController.printAll(FlightRepository.getInstance().viewAllTickets(userdetails));
		
		
	}
	@Override
	public void cancelTickets(String ticketNo) {
		if(FlightRepository.getInstance().cancelTickets(ticketNo)) {
			ticketBookingController.cancelSuccess("Your ticket has been Cancelled");
		}
		else {
			ticketBookingController.cancelFailure("Ticket Not found");
		}
		
	}
		
	}


