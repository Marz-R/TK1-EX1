package model;

import java.util.List;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Flight implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String airline;
	private String model;
	private String IATA;
	private String flightNum;
	private boolean depart;  // true if departure flight, false if arrival flight
	
	private LocalDate oriDate;
	private String D_airport;
	private String A_airport;
	
	private LocalDateTime scheduledDT;  // used for both arrival and departure
	private int terminal;
	private List<String> gates;
	
	private LocalDateTime estDT;  // used for both arrival and departure
	private String ci_location;  // for departure only
	private List<Integer> ci_counters;  // for departure only
	private LocalDateTime ci_start;  // for departure only
	private LocalDateTime ci_end;  // for departure only
	
	private String status;
	
	public Flight(String flightNum){
		this.flightNum = flightNum;
		this.IATA = flightNum.substring(0,2);
	}
	
	public String getAirline() {
		return this.airline;
	}
	
	public String getIATA() {
		return this.IATA;
	}
	
	public String getFlightNum() {
		return this.flightNum;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public boolean getDepart() {
		return this.depart;
	}
	
	public LocalDate getOriDate() {
		return this.oriDate;
	}
	
	public String getD_airport() {
		return this.D_airport;
	}
	
	public String getA_airport() {
		return this.A_airport;
	}
	
	public LocalDateTime getScheduledDT() {
		return this.scheduledDT;
	}
	
	public int getTerminal() {
		return this.terminal;
	}
	
	public List<String> getGates(){
		return this.gates;
	}
	
	public LocalDateTime getEstDT() {
		return this.estDT;
	}
	
	public String getCI_location() {
		return this.ci_location;
	}
	
	public List<Integer> getCI_counters(){
		return this.ci_counters;
	}
	
	public LocalDateTime getCI_start() {
		return this.ci_start;
	}
	
	public LocalDateTime getCI_end() {
		return this.ci_end;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setFlightInfo(String airline, String model, LocalDate oriDate, String D_airport, String A_airport) {
		this.airline = airline;
		this.model = model;
		this.oriDate = oriDate;
		this.D_airport = D_airport;
		this.A_airport = A_airport;
	}
	
	public void setDeparture(LocalDateTime scheduledDT, int terminal, List<String> gates, LocalDateTime estDT) {
		this.depart = true;  // calling setDeparture implicates that this flight is a departure flight
		this.scheduledDT = scheduledDT;
		this.terminal = terminal;
		this.gates = gates;
		this.estDT = estDT;
	}
	
	public void setCheckIn(String ci_location, List<Integer> ci_counters, LocalDateTime ci_start, LocalDateTime ci_end) {
		this.ci_location = ci_location;
		this.ci_counters = ci_counters;
		this.ci_start = ci_start;
		this.ci_end = ci_end;
	}
	
	public void setArrival(LocalDateTime scheduledDT, int terminal, List<String> gates, LocalDateTime estDT) {
		this.depart = false;  // calling setArrival implicates that this flight is a arrival flight
		this.scheduledDT = scheduledDT;
		this.terminal = terminal;
		this.gates = gates;
		this.estDT = estDT;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

}
