package gui;

import interfaces.IFlightClient;
import model.Flight;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FlightListGUI {

	private IFlightClient flightClient;
	private List<Flight> flights = new ArrayList<Flight>();
	public JFrame frmTkAirportArrivals;
	private JTable flightListTable;
	private int selectedRow;  // detect which row to be updated/deleted

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
		// ******************
		// just for testing function of edit button clicked without dependencies to client and server.
//		Flight flight1 = new Flight("LH1234");
//		List<Integer> counters = Arrays.asList(100, 101, 102, 103, 104, 105);
//		List<String> gates = Arrays.asList("E12", "E13");
//		flight1.setFlightInfo("Lufthansa", "A380", LocalDate.of(2021, 11, 24), "FRA", "HKG");
//		flight1.setDeparture(LocalDateTime.of(2021, 11, 24, 05, 12), 1, gates, LocalDateTime.of(2021, 11, 24, 05, 17));
//		flight1.setCheckIn("3", counters, LocalDateTime.of(2021, 11, 24, 00, 00), LocalDateTime.of(2021, 11, 24, 04, 42));
//		flights.add(flight1);
//		
//		Flight flight2 = new Flight("CX4321");
//		gates = Arrays.asList("A03", "A04");
//		flight2.setFlightInfo("Cathy Pacific", "B747", LocalDate.of(2021, 11, 25), "LAX", "FRA");
//		flight2.setArrival(LocalDateTime.of(2021, 11, 25, 15, 43), 1, gates, LocalDateTime.of(2021, 11, 25, 15, 43));
//		flight2.setStatus("B");
//		flights.add(flight2);
		// ******************
		
		frmTkAirportArrivals = new JFrame();
		frmTkAirportArrivals.addWindowListener(new WindowAdapter() {
			// **************************
			// uncomment below once connection with client has been succeed (i.e. once we made it to run gradle tasks)
			// if you uncomment below without connection with client, you will not be able to close the window due to error
//			@Override
//			public void windowClosing(WindowEvent e) {
//				try {
//					flightClient.logout();
//				} catch (RemoteException re) {
//					re.printStackTrace();
//				}
//			}
			// **************************
		});
		frmTkAirportArrivals.setTitle("TK Airport Arrivals / Departures");
		frmTkAirportArrivals.setBounds(100, 100, 957, 636);
		frmTkAirportArrivals.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTkAirportArrivals.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 923, 528);
		frmTkAirportArrivals.getContentPane().add(scrollPane);
		
		flightListTable = new JTable();
		flightListTable.setEnabled(true);  // set to true allows user to edit the value in table which we don't want to, but if set to false, listener cannot detect selected row
		flightListTable.setRowSelectionAllowed(true);
		flightListTable.setColumnSelectionAllowed(true);
		flightListTable.setCellSelectionEnabled(true);
		// below is just another option for addMouseListener
//		flightListTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				selectedRow = flightListTable.getSelectedRow();
//				System.out.println(selectedRow);
//			}
//		});
		flightListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//selectedRow = flightListTable.rowAtPoint(SwingUtilities.convertPoint(frmTkAirportArrivals, e.getPoint(), flightListTable));
				selectedRow = flightListTable.getSelectedRow();
				System.out.println(selectedRow);
			}
		});
		flightListTable.setModel(new DefaultTableModel(
			new Object[][] {
				// initial rows just for testing behaviour when edit button clicked
//				{"LH", "1234", "FRA", "HKG", "1", "2021-11-24 05:12:00", "2021-11-24 05:17:00"},
//				{"CX", "4321", "LAX", "FRA", "1", "2021-11-25 15:43:00", "2021-11-25 15:43:00"}
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
		newButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FlightDetailsGUI flightDetailsGUI = new FlightDetailsGUI(true);  // open DetailsGUI with create==true flag
				flightDetailsGUI.setFlightClient(flightClient);
				flightDetailsGUI.frmFlightDetails.setVisible(true);
			}
		});
		newButton.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		newButton.setBounds(298, 564, 103, 30);
		frmTkAirportArrivals.getContentPane().add(newButton);
		
		JButton editButton = new JButton("Edit");
		editButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FlightDetailsGUI flightDetailsGUI = new FlightDetailsGUI(false, flights.get(selectedRow));  // open DetailsGUI with create==false flag and flight data; assume flights and rows in table have same structure
				flightDetailsGUI.setFlightClient(flightClient);
				flightDetailsGUI.frmFlightDetails.setVisible(true);
			}
		});
		editButton.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		editButton.setBounds(411, 564, 103, 30);
		frmTkAirportArrivals.getContentPane().add(editButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					flightClient.sendUpdatedFlight(flights.get(selectedRow), 'D');  // ask client to send delete request to server
				} catch (RemoteException re) {
					re.printStackTrace();
				}
			}
		});
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
		 		
		 		model.addRow(new Object[] {
						flight.getAirline(),
						flight.getFlightNum(),
						flight.getD_airport(),
						flight.getA_airport(),
						flight.getTerminal(),
						flight.getScheduledDT(),
						flight.getEstDT()
						});
		 		
		 		break;
		 	case 'U':  // update
		 		for (Flight f : flights) {
					if (f.getFlightNum() == flight.getFlightNum()) {  // assume flight number can function as the primary key
						// replace (i.e. update) existing flight data that have the same flight number with the received flight data
						int idx = flights.indexOf(f);
						flights.set(idx, flight);
						
						// assume flights and rows in model have same structure
						model.setValueAt(flight.getAirline(), idx, 0);
						model.setValueAt(flight.getFlightNum(), idx, 1);
						model.setValueAt(flight.getD_airport(), idx, 2);
						model.setValueAt(flight.getA_airport(), idx, 3);
						model.setValueAt(flight.getTerminal(), idx, 4);
						model.setValueAt(flight.getScheduledDT(), idx, 5);
						model.setValueAt(flight.getEstDT(), idx, 6);
						
						break;
					}
				}
		 		
		 		break;
		 	case 'D':  // delete
		 		for (int i = 0; i < flights.size(); i++) {
		 			System.out.println(flights.get(i).getFlightNum());
		 			System.out.println(flight.getFlightNum());
		 			System.out.println(flights.get(i).getFlightNum() == flight.getFlightNum());
					if (flights.get(i).getFlightNum() == flight.getFlightNum()) {  // not falling into this condition for some reason...
						System.out.println("HELLLLLLLLLLOOOOOOOOOOOOOOOO");
						flights.remove(i);
						model.removeRow(i);
						break;
					}
				}
//		 		int idx = flights.indexOf(flight);
//		 		flights.remove(idx);
//		 		model.removeRow(idx);  // assume flights and rows in model have same structure
		 		
		 		break;
		}
		
		model.fireTableDataChanged();
	}

}
