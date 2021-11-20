package model;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Flight {
	private String airline;
	private String model;
	private String IATA;
	private String flightNum;
	private boolean depart; //true if departure flight, false if arrival flight
	
	private LocalDate oriDate;
	private String D_airport;
	private String A_airport;
	
	private LocalDateTime scheduledDT;
	private int terminal;
	private List<String> gates;
	
	private LocalDateTime estDT; //for arrival only
	private int ci_location; //for departure only
	private List<Integer> ci_counters; //for departure only
	private LocalDateTime ci_start; //for departure only
	private LocalDateTime ci_end; //for departure only
	
	private char status;
	
	public Flight(String flightNum){
		this.flightNum = flightNum;
		this.IATA = flightNum.substring(0,2);
	}
	
	public void setFlightInfo(String airline, String model, boolean depart, LocalDate oriDate, String D_airport, String A_airport) {
		this.airline = airline;
		this.model = model;
		this.depart = depart;
		this.oriDate = oriDate;
		this.D_airport = D_airport;
		this.A_airport = A_airport;
	}
	
	public void setDeparture(LocalDateTime scheduledDT, int terminal, List<String> gates) {
		this.scheduledDT = scheduledDT;
		this.terminal = terminal;
		this.gates = gates;
	}
	
	public void setCheckIn(int ci_location, List<Integer> ci_counters, LocalDateTime ci_start, LocalDateTime ci_end) {
		this.ci_location = ci_location;
		this.ci_counters = ci_counters;
	}
	
	public void setArrival(LocalDateTime scheduledDT, int terminal, List<String> gates, LocalDateTime estDT) {
		this.scheduledDT = scheduledDT;
		this.terminal = terminal;
		this.gates = gates;
		this.estDT = estDT;
	}
	
	public void setStatus(char status) {
		this.status = status;
	}

}
