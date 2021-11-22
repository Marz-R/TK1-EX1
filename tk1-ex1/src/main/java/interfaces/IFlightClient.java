package interfaces;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

import model.Flight;

public interface IFlightClient extends Remote {
	
	public void logout() throws RemoteException;
	
	public void receiveListOfFlights(List<Flight> flights) throws RemoteException;
	
	public void receiveUpdatedFlight(Flight flight, char operation) throws RemoteException;

}
