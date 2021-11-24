package gui;

import interfaces.IFlightClient;
import model.Flight;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FlightListGUI {

	private IFlightClient flightClient;
	private List<Flight> flights;
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
		frmTkAirportArrivals = new JFrame();
		frmTkAirportArrivals.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
//			@Override
//			public void windowClosing(WindowEvent e) {
//				try {
//					flightClient.logout();
//				} catch (RemoteException re) {
//					re.printStackTrace();
//				}
//			}
		});
		frmTkAirportArrivals.setTitle("TK Airport Arrivals / Departures");
		frmTkAirportArrivals.setBounds(100, 100, 957, 636);
		frmTkAirportArrivals.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTkAirportArrivals.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 923, 528);
		frmTkAirportArrivals.getContentPane().add(scrollPane);
		
		flightListTable = new JTable();
		flightListTable.setEnabled(false);
		flightListTable.setColumnSelectionAllowed(true);
		flightListTable.setCellSelectionEnabled(true);
		flightListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//**********************
				// TODO: having problem detecting which row in table user selected
				//**********************
				selectedRow = flightListTable.rowAtPoint(SwingUtilities.convertPoint(frmTkAirportArrivals, e.getPoint(), flightListTable));
				//selectedRow = flightListTable.getSelectedRow();
			}
		});
		flightListTable.setModel(new DefaultTableModel(
			new Object[][] {
				{"AH", "123", "TK", "FRA", "1", "2018-10-09 15:20:00", "2018-10-09 15:25:00"}  // initial row just for testing behaviour when edit button clicked
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
		 		int idx = flights.indexOf(flight);
		 		flights.remove(idx);
		 		model.removeRow(idx);  // assume flights and rows in model have same structure
		}
		
		model.fireTableDataChanged();
	}

}
