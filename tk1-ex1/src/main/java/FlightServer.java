import java.util.logging.Level;
import java.util.logging.Logger;

import interfaces.IFlightClient;
import interfaces.IFlightServer;
import model.Flight;

public class FlightServer implements IFlightServer {

	private static Logger logger = Logger.getLogger(FlightServer.class.getName());


	protected FlightServer() {
		super();

		// initialize with some flights
		Flight flight1 = new Flight("LH1234");
		List<Integer> counters = Arrays.asList(100, 101, 102, 103, 014, 105);
		List<String> gates = Arrays.asList("E12", "E13");
		flight1.setFlightInfo("Lufthansa", "A380", true, LocalDate.of(2021, 11, 24), "FRA", "HKG");
		flight1.setDeparture(LocalDateTime.of(2021, 11, 24, 05, 12), 1, gates);
		flight1.setCheckIn(3, counters, LocalDateTime.of(2021, 11, 24, 00, 00), LocalDateTime.of(2021, 11, 24, 04, 42));
		
		Flight flight2 = new Flight("CX4321");
		flight2.setFlightInfo("Cathy", "B747", false, LocalDate.of(2021, 11, 25), "LAX", "FRA");
		flight2.setArrival(LocalDateTime.of(2021, 11, 25, 15, 43), 1, LocalDateTime.of(2021, 11, 25, 15, 43));
		// ...
	}

	@Override
	public void login(String clientName, IFlightClient client) {
		logger.log(Level.INFO, "New client logged in: " + clientName);
	}

	@Override
	public void logout(String clientName) {
		logger.log(Level.INFO, "Client logged out: " + clientName);
	}

	@Override
	public void updateFlight(String clientName, Flight flight) {
		logger.log(Level.INFO, "Update flight: " + flight.toString());
	}

	@Override
	public void deleteFlight(String clientName, Flight flight) {
		logger.log(Level.INFO, "Delete flight: " + flight.toString());
	}

	private void informAllClients(Flight flight, boolean deleted) {
		
	}

	public static void main(String[] args) {
		try {
			// generate local registry

			// generate game server

			logger.info("Server is ready");
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Server exception", ex);
		}
	}

}
