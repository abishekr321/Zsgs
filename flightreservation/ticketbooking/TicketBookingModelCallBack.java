package com.zsgs.flightreservation.ticketbooking;

import com.zsgs.flightreservation.dto.User;

public interface TicketBookingModelCallBack {

	void booksTickets(String arrive, String depart);

	void ViewTickets(User userdetails);

	void cancelTickets(String ticketNo);

}
