package gui;

import interfaces.IFlightClient;
import model.Flight;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.awt.event.WindowAdapter;

public class FlightListGUI {

	private IFlightClient flightClient;
	private List<Flight> flights;
	private JFrame frmTkAirportArrivals;
	private JTable flightListTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightListGUI window = new FlightListGUI();
					window.frmTkAirportArrivals.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FlightListGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTkAirportArrivals = new JFrame();
		frmTkAirportArrivals.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					flightClient.logout();
				} catch (RemoteException re) {
					re.printStackTrace();
				}
			}
		});
		frmTkAirportArrivals.setTitle("TK Airport Arrivals / Departures");
		frmTkAirportArrivals.setBounds(100, 100, 957, 636);
		frmTkAirportArrivals.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTkAirportArrivals.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 923, 528);
		frmTkAirportArrivals.getContentPane().add(scrollPane);
		
		flightListTable = new JTable();
		flightListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Operating Airline", "Flight Number", "Departure", "Arrival", "Terminal", "Scheduled Time", "Estimated Time"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Integer.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(flightListTable);
		
		JButton newButton = new JButton("New");
		newButton.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		newButton.setBounds(298, 564, 103, 30);
		frmTkAirportArrivals.getContentPane().add(newButton);
		
		JButton editButton = new JButton("Edit");
		editButton.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		editButton.setBounds(411, 564, 103, 30);
		frmTkAirportArrivals.getContentPane().add(editButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		deleteButton.setBounds(525, 564, 103, 30);
		frmTkAirportArrivals.getContentPane().add(deleteButton);
	}
	
	public void setFlightClient(IFlightClient flightClient) {
		this.flightClient = flightClient;
	}
	
	// set flights when the GUI was initially called (when client logged into server)
	public void setListOfFlights(List<Flight> flights) {
		this.flights = flights;
		DefaultTableModel model = (DefaultTableModel) flightListTable.getModel();
		
		for (Flight flight : flights) {
			model.addRow(new Object[] {
					flight.getAirline(),
					flight.getFlightNum(),
					flight.getD_airport(),
					flight.getA_airport(),
					flight.getTerminal(),
					flight.getScheduledDT(),
					flight.getEstDT()
					});
		}
		
		model.fireTableDataChanged();
	}
	
	public void setUpdatedFlight(Flight flight, char operation) {
		DefaultTableModel model = (DefaultTableModel) flightListTable.getModel();
		
		// for now, assume no operation value other than C, U, and D will be assigned
		switch(operation) {
		 	case 'C':  // create
		 		flights.add(flight);
		 		break;
		 	case 'U':  // update
		 		for (Flight f : flights) {
					if (f.getFlightNum() == flight.getFlightNum()) {  // assume flight number can function as the primary key
						flights.set(flights.indexOf(f), flight);  // replace (i.e. update) existing flight data that have the same flight number with the received flight data
						break;
					}
				}
		 		break;
		 	case 'D':  // delete
		 		flights.remove(flights.indexOf(flight));
		 		break;
		}
		
		model.fireTableDataChanged();
	}

}
