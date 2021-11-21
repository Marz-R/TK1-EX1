package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;

public class FlightListGUI {

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
				"Operating Airline", "IATA Code", "Tracking Number", "Departure", "Arrival", "Terminal", "Scheduled Depature", "Estimated Departure", "Scheduled Arrival", "Estimated Arrival"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, Integer.class, Object.class, Object.class, Object.class, Object.class
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

}
