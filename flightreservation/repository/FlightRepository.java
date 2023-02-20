package com.zsgs.flightreservation.repository;

import java.util.ArrayList;
import java.util.List;
import com.zsgs.flightreservation.dto.*;



public class FlightRepository {
	private static FlightRepository flightDbInstance;
	private static int Ticketcount;
private List<AdminCredentials> credentials = new ArrayList<AdminCredentials>();
private List<Credentials> userCredentials = new ArrayList<Credentials>();
private List<Flight> flightdetails=new ArrayList<Flight>();
private List<Tickets> userTickets =new ArrayList<Tickets>();
private FlightRepository() {

}


public static FlightRepository getInstance() {
	if (flightDbInstance == null) {
		flightDbInstance = new FlightRepository();
		flightDbInstance.initialAdminSetUp();
		flightDbInstance.initialUserSetup();
		flightDbInstance.initialFlightSetup();
	}
	return flightDbInstance;
}

private void initialAdminSetUp() {
	credentials.add(new AdminCredentials("01", "Abishek", "Owner"));
	credentials.add(new AdminCredentials("02", "Bala", "San"));
	credentials.add(new AdminCredentials("03", "Vijay","Thalapathy"));

}

private void initialUserSetup() {
	userCredentials.add(new Credentials("11", "KrishAnand", "Turtle"));
	userCredentials.add(new Credentials("12", "Kirubhakaran", "Coffee"));
	userCredentials.add(new Credentials("13", "Gokul","Coins"));
}
private void initialFlightSetup() {
	flightdetails.add(new Flight("Chennai","Mumbai","cm01","OHO Airlines","10:00 am","12:00 pm","Rs.4999"));
	flightdetails.add(new Flight("Chennai","Bengaluru","cb01","AHO Airlines","11:00 am","01:00 pm","Rs.5999"));
	flightdetails.add(new Flight("Chennai","Delhi","cd01","AHA Airlines","12:00 am","02:00 pm","Rs.6999"));
	flightdetails.add(new Flight("Mumbai","Chennai","mc01","OHO Airlines","01:00 am","03:00 pm","Rs.4999"));
	flightdetails.add(new Flight("Mumbai","Benagluru","mb01","AHO Airlines","02:00 am","04:00 pm","Rs.5999"));
	flightdetails.add(new Flight("Mumbai","Delhi","md01","AHA Airlines","03:00 am","05:00 pm","Rs.6999"));
	
}
private void initialTicketSetup(User userdetails,Flight flightdetails) {
	userTickets.add(new Tickets(++Ticketcount+"",userdetails.getUserName(),flightdetails.getArrive(),flightdetails.getDepart(),flightdetails.getArrivalTime(),flightdetails.getDepartureTime(),flightdetails.getFlightNo()));	
}
public boolean adminAddFlightSetup(String Arrive,String Departure,String flightNo,String flightName,String ArrivalTime,String DepartureTime,String fare) {
	for(Flight flight:flightdetails) {
		if(flight.getFlightNo().equals(flightNo)) {
			return false;
		}
	}
 flightdetails.add(new Flight(Arrive, Departure, flightNo, flightName, ArrivalTime, DepartureTime, fare));
	return true;	
		
	
}
public boolean adminDeleteFlightSetup(String flightNo) {
	for(Flight flight:flightdetails) {
		if(flight.getFlightNo().equals(flightNo)) {
			flightdetails.remove(flight);
			return true;
		}		
	}
	return false;
}


public User checkValidUser(String userID, String password) {
	for (Credentials credential : userCredentials) {
		if (credential.getUserId().equals(userID) && credential.getPassword().equals(password)) {
			return credential;
		}
	}
	return null;
}
public AdminCredentials checkValidAdmin(String AdminID, String password) {
	for (AdminCredentials credential : credentials) {
		if (credential.getAdminId().equals(AdminID) && credential.getPassword().equals(password)) {
			return credential;
		}
	}
	return null;
}
public Flight showFlights(String arrival,String departure) {
	for(Flight flight:flightdetails) {
		if(flight.getArrive().equals(arrival)&&flight.getDepart().equals(departure)) {
			return flight;
		}
	}
	return null;
}
public Tickets viewTickets(User userdetails,Flight flightdetails) {
	flightDbInstance.initialTicketSetup(userdetails,flightdetails);
	return userTickets.get(userTickets.size()-1) ;
	
}
public List<Tickets> viewAllTickets(User userdetails) {
	List<Tickets> viewTickets =new ArrayList();
	for(Tickets ticket:userTickets) {
		if(ticket.getUserName().equals(userdetails.getUserName())) {
			viewTickets.add(ticket);
			
		}
		
	}
	return viewTickets;
}


public boolean addCredentials(String userName, String userId, String password) {
	for (Credentials credential : userCredentials) {
	if (credential.getUserId().equals(userId) && credential.getPassword().equals(password)) {
	return false;}
}
	
	userCredentials.add(new Credentials(userId, userName,password));
	return true;
}


public List<Flight> viewFlights() {
	return flightdetails;
	
	
}


public boolean cancelTickets(String ticketId) {
	for(Tickets ticket:userTickets) {
		if(ticket.getTicketId().equals(ticketId)) {
			userTickets.remove(ticket);
			return true;
		}
		
	}
	return false;
}
	
	
}



