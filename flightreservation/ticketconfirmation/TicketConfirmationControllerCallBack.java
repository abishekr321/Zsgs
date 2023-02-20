package com.zsgs.flightreservation.ticketconfirmation;

import com.zsgs.flightreservation.dto.Flight;
import com.zsgs.flightreservation.dto.User;

public interface TicketConfirmationControllerCallBack {

	void confirmsTickets(User userdetails, Flight flightdetails);

}
