import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.IFlightClient;
import interfaces.IFlightServer;
import model.Flight;
import gui.FlightListGUI;

public class FlightClient implements IFlightClient {

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
	public void receiveUpdatedFlight(Flight flight, char operation) {
		logger.log(Level.INFO, "Flight updated: " + flight.toString());
		flightListGUI.setUpdatedFlight(flight, operation);
	}
	
	// called by GUI
	// send updated flight to server (call create/update/delete Flight function in FlightServer depending on value of operation)
	public void sendUpdatedFlight(Flight flight, char operation) throws RemoteException {
		switch(operation) {
			case 'C':
				flightServer.createFlight(clientName, this, flight);
				break;
			case 'U':
				flightServer.updateFlight(clientName, this, flight);
				break;
			case 'D':
				flightServer.deleteFlight(clientName, this, flight);
				break;
		}
	}

	public void logout() throws RemoteException {
		flightServer.logout(clientName, this);
	}
	
	public void startup() throws RemoteException, NotBoundException {
		logger.log(Level.INFO, "Client start up");
		// get the servers stub
		//Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
		//IFlightServer flightServer = (IFlightServer) registry.lookup("FlightServer");
		Registry registry = LocateRegistry.getRegistry();
		IFlightServer stubServer = (IFlightServer) registry.lookup("FlightServer");

		// client creates a stub of itself to send it to the server
		//IFlightClient stubClient = (IFlightClient) UnicastRemoteObject.exportObject(this, 0);

		this.flightServer = stubServer;
			
		// calls the remote login method
		stubServer.login(this.clientName, this);
		//stubServer.login(this.clientName, stubClient);
		//flightServer.login(clientName, this);
		
		this.flightListGUI = new FlightListGUI();
		flightListGUI.setFlightClient(this);
		flightListGUI.frmTkAirportArrivals.setVisible(true);  // start (open) FlightListGUI
	}

	public static void main(String[] args) throws RemoteException, NotBoundException {
		FlightClient client = new FlightClient(UUID.randomUUID().toString());
		client.startup();
	}

}
