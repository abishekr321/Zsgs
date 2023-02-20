package com.zsgs.flightreservation.ticketbooking;

import java.util.List;

import com.zsgs.flightreservation.dto.Flight;
import com.zsgs.flightreservation.dto.Tickets;

public interface TicketBookingControllerModelCallBack {

	void flightNotAvailability(String string);

	void flightAvailability(Flight flightdetails);

	void cancelSuccess(String string);

	void cancelFailure(String string);

	void printAll(List<Tickets> viewAllTickets);

}
