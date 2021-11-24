import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.time.LocalDate;
import java.time.LocalDateTime;

import interfaces.IFlightClient;
import interfaces.IFlightServer;
import model.Flight;
import gui.FlightDetailsGUI;

public class FlightServer implements IFlightServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(FlightServer.class.getName());

	private List<IFlightClient> loggedInClients = new ArrayList<IFlightClient>();
	private List<Flight> flights = new ArrayList<Flight>();

	protected FlightServer() throws RemoteException{
		super();
		
		// initialize with some flights
		Flight flight1 = new Flight("LH1234");
		List<Integer> counters = Arrays.asList(100, 101, 102, 103, 104, 105);
		List<String> gates = Arrays.asList("E12", "E13");
		flight1.setFlightInfo("Lufthansa", "A380", LocalDate.of(2021, 11, 24), "FRA", "HKG");
		flight1.setDeparture(LocalDateTime.of(2021, 11, 24, 05, 12), 1, gates, LocalDateTime.of(2021, 11, 24, 05, 17));
		flight1.setCheckIn("3", counters, LocalDateTime.of(2021, 11, 24, 00, 00), LocalDateTime.of(2021, 11, 24, 04, 42));
		
		Flight flight2 = new Flight("CX4321");
		gates = Arrays.asList("A03", "A04");
		flight2.setFlightInfo("Cathy Pacific", "B747", LocalDate.of(2021, 11, 25), "LAX", "FRA");
		flight2.setArrival(LocalDateTime.of(2021, 11, 25, 15, 43), 1, gates, LocalDateTime.of(2021, 11, 25, 15, 43));
		flight2.setStatus("B");

		flights.add(flight1);
		flights.add(flight2);
	}

	@Override
	public void login(String clientName, IFlightClient client) throws RemoteException {
		if (loggedInClients.contains(client)) {
			logger.log(Level.INFO, clientName + "has already logged in.");
		} else {
			loggedInClients.add(client);  // if client haven't logged in, add to list
			logger.log(Level.INFO, "New client logged in: " + clientName);
			
			client.receiveListOfFlights(this.flights);  // send client current list of flights
		}		
	}

	@Override
	public void logout(String clientName, IFlightClient client) throws RemoteException {
		if (loggedInClients.contains(client)) {
			loggedInClients.remove(client);
			logger.log(Level.INFO, "Client logged out: " + clientName);
		} else {
			logger.log(Level.INFO, clientName + "doesn't exist.");
		}
	}
	
	@Override
	public void createFlight(String clientName, IFlightClient client, Flight flight) throws RemoteException{
		if (loggedInClients.contains(client)) {
			flights.add(flight);
			
			logger.log(Level.INFO, "Created flight: " + flight.toString() + "by " + clientName);
			informAllClients(flight, 'C');
		} else {
			logger.log(Level.INFO, "Invalid client: " + clientName);
		}
	}

	@Override
	public void updateFlight(String clientName, IFlightClient client, Flight flight) throws RemoteException{
		if (loggedInClients.contains(client)) {
			for (Flight f : flights) {
				if (f.getFlightNum() == flight.getFlightNum()) {  // assume flight number can function as the primary key
					flights.set(flights.indexOf(f), flight);  // replace (i.e. update) existing flight data that have the same flight number with the received flight data
					break;
				}
			}
			
			logger.log(Level.INFO, "Updated flight: " + flight.toString() + "by " + clientName);
			informAllClients(flight, 'U');
		} else {
			logger.log(Level.INFO, "Invalid client: " + clientName);
		}
	}

	@Override
	public void deleteFlight(String clientName, IFlightClient client, Flight flight) throws RemoteException{
		if (loggedInClients.contains(client)) {
			flights.remove(flights.indexOf(flight));
			
			logger.log(Level.INFO, "Deleted flight: " + flight.toString() + "by " + clientName);
			informAllClients(flight, 'D');
		} else {
			logger.log(Level.INFO, "Invalid client: " + clientName);
		}	
	}

	// operation:
	// C: create
	// U: update
	// D: delete
	private void informAllClients(Flight flight, char operation) throws RemoteException{
		for (IFlightClient client : loggedInClients) {
			client.receiveUpdatedFlight(flight, operation);
		}
	}

	public static void main(String[] args) {
		try {
			// generate local registry
			//Registry registry = LocateRegistry.getRegistry(); 
			//registry.bind("FlightServer", new FlightServer());
			Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT); 
			registry.bind("FlightServer", new FlightServer());

			logger.info("Server is ready");
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Server exception", ex);
		}
	}

}
