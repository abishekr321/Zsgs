package com.zsgs.flightreservation.dto;

public class Flight {
	private String arrive;
	private String depart;
	private String flightNo;
	private String flightName;
	private String arrivalTime;
	private String departureTime;
	private String fare;
	
	public Flight(String arrive, String depart, String flightNo, String flightName, String arrivalTime, String departureTime ,
			String fare) {
		this.arrive=arrive;
		this.depart=depart;
		this.flightNo=flightNo;
		this.arrivalTime=arrivalTime;
		this.departureTime=departureTime;
		this.flightName=flightName;
		this.fare=fare;
		
	}
	@Override
	public String toString() {
		return "arrive = " + arrive + "\ndepart = " + depart + "\nflightNo = " + flightNo + "\nflightName = "
				+ flightName + "\narrivalTime = " + arrivalTime + "\ndepartureTime = " + departureTime + "\nfare = " + fare
				;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	
	public String getArrive() {
		return arrive;
	}
	public void setArrive(String arrive) {
		this.arrive = arrive;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
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
	
	

}
