package com.zsgs.flightreservation.ticketconfirmation;

import com.zsgs.flightreservation.dto.Tickets;

public interface TicketConfirmationControllerModelCallBack {

	void viewTickets(Tickets ticket);

	void noTickets(String errorMessage);

}
