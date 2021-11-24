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
import gui.FlightDetailsGUI;
import gui.FlightListGUI;

public class FlightClient implements IFlightClient {

	private static Logger logger = Logger.getLogger(FlightServer.class.getName());

	// ui
	private FlightListGUI flightListGUI = new FlightListGUI();

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
		logger.log(Level.INFO, "Flight updated: " + flight.getFlightNum().toString());
		flightListGUI.setUpdatedFlight(flight, operation);
	}
	
	// called by GUI
	// send updated flight to server (call create/update/delete Flight function in FlightServer depending on value of operation)
	public void sendUpdatedFlight(Flight flight, char operation) throws RemoteException {
		logger.log(Level.INFO, "sendUpdatedFlight");
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
		Registry registry = LocateRegistry.getRegistry();
		IFlightServer stubServer = (IFlightServer) registry.lookup("FlightServer");

		// client creates a stub of itself to send it to the server
		IFlightClient stubClient = (IFlightClient) UnicastRemoteObject.exportObject(this, 0);

		this.flightServer = stubServer;
			
		// calls the remote login method
		this.flightListGUI = new FlightListGUI();
		flightListGUI.setFlightClient(this);
		flightListGUI.frmTkAirportArrivals.setVisible(true);  // start (open) FlightListGUI
		
		// calls the remote login method
		stubServer.login(this.clientName, stubClient);
	}

	public static void main(String[] args) throws RemoteException, NotBoundException {
		FlightClient client = new FlightClient(UUID.randomUUID().toString());
		client.startup();
	}

}
