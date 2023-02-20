package com.zsgs.flightreservation.ticketbooking;

import java.util.List;

import com.zsgs.flightreservation.dto.Flight;
import com.zsgs.flightreservation.dto.Tickets;

public interface TicketBookingViewCallBack {

	void flightNotAvailability(Flight flightdetails);

	void flightAvailability(String errorMessage);

	void cancelSuccess(String successMessage);

	void cancelFailure(String errorMessage);

	void printAll(List<Tickets> viewAllTickets);

}
