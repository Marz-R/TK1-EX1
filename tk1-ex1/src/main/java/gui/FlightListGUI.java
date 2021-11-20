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
	private JTable table;

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
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
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
		scrollPane.setViewportView(table);
		
		JButton NewButton = new JButton("New");
		NewButton.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		NewButton.setBounds(298, 564, 103, 30);
		frmTkAirportArrivals.getContentPane().add(NewButton);
		
		JButton EditButton = new JButton("Edit");
		EditButton.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		EditButton.setBounds(411, 564, 103, 30);
		frmTkAirportArrivals.getContentPane().add(EditButton);
		
		JButton DeleteButton = new JButton("Delete");
		DeleteButton.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		DeleteButton.setBounds(525, 564, 103, 30);
		frmTkAirportArrivals.getContentPane().add(DeleteButton);
	}

}
