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
	
	public void setListOfFlights(List<Flight> flights) {
		this.flights = flights;
		DefaultTableModel model = (DefaultTableModel) flightListTable.getModel();
		for (int i = 0; i < flights.size(); i++) {
			model.addRow(new Object[] {
					flights.get(i).getAirline(),
					flights.get(i).getFlightNum(),
					flights.get(i).getD_airport(),
					flights.get(i).getA_airport(),
					flights.get(i).getTerminal(),
					flights.get(i).getScheduledDT(),
					flights.get(i).getEstDT()
					});
		}
		model.fireTableDataChanged();
	}

}
