import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import interfaces.IFlightClient;
import interfaces.IFlightServer;
import model.Flight;
import gui.FlightListGUI;

public class FlightClient extends UnicastRemoteObject implements IFlightClient {

	private static Logger logger = Logger.getLogger(FlightServer.class.getName());

	// ui
	private FlightListGUI flightListGUI;

	// global state
	private String clientName;
	private IFlightServer flightServer;

	public FlightClient(String clientName) throws RemoteException {
		this.clientName = clientName;
	}

	@Override
	public void receiveListOfFlights(List<Flight> flights) {
		logger.log(Level.INFO, "List of flights received: " + flights.size());
		flightListGUI.setListOfFlights(flights);
	}

	@Override
	public void receiveUpdatedFlight(Flight flight, boolean deleted) {
		logger.log(Level.INFO, "Flight updated: " + flight.toString());
	}
	
	public void updateFlight() {
		
	}
	
	public void deleteFlight() {
		
	}

	public void logout() throws RemoteException {
		flightServer.logout(clientName, this);
	}
	
	public void startup() throws RemoteException, NotBoundException {
		this.flightListGUI = new FlightListGUI();
		flightListGUI.setFlightClient(this);
		
		Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
		IFlightServer flightServer = (IFlightServer) registry.lookup("FlightServer");
		this.flightServer = flightServer;
		
		flightServer.login(clientName, this);
	}

	public static void main(String[] args) throws RemoteException, NotBoundException {
		FlightClient client = new FlightClient(UUID.randomUUID().toString());
		client.startup();
	}

}
