package com.zsgs.flightreservation.dto;

public class Tickets  {
	private String userName;
	private String arrival;
	private String departure;
	private String arrivalTime;
	private String departureTime;
	private String flightNo;
	private String ticketId;
	
	public Tickets(String ticketId,String userName, String arrival, String departure, String arrivalTime, String departureTime,
			String flightNo) {
		this.setTicketId(ticketId);
		this.userName = userName;
		this.arrival = arrival;
		this.departure = departure;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.flightNo = flightNo;
	}
	@Override
	public String toString() {
		return "PassangerName = " + userName +"\nflightNo = " + flightNo+ "\narrival = " + arrival + "\ndeparture = " + departure + "\narrivalTime = "
				+ arrivalTime + "\ndepartureTime = " + departureTime + "\n ----->Happy Journey<-----";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	
	
	

}
