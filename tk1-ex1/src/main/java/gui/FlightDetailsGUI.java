package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class FlightDetailsGUI {

	private JFrame frmFlightDetails;
	private JTextField IATATxtField;
	private JTextField AircraftModelNameTxtField;
	private JTextField TrackingNumberTxtField;
	private JTextField DepartureAirportTxtField;
	private JTextField OriginDateTxtField;
	private JTextField ScheduledDepartureTxtField;
	private JTextField DepartureTerminalTxtField;
	private JTextField DepartureGatesTxtField;
	private JTextField EstimatedDepartureTxtField;
	private JTextField CheckinLocationTxtField;
	private JTextField CheckinCounterTxtField;
	private JTextField CheckinStartTxtField;
	private JTextField OperatingAirlineTxtField;
	private JTextField ArrivalAirportTxtField;
	private JTextField ScheduledArrivalTxtField;
	private JTextField ArrivalTerminalTxtField;
	private JTextField ArrivalGatesTxtField;
	private JTextField EstimatedArrivalTxtField;
	private JTextField CheckinEndTxtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightDetailsGUI window = new FlightDetailsGUI();
					window.frmFlightDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FlightDetailsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFlightDetails = new JFrame();
		frmFlightDetails.setTitle("Flight Details");
		frmFlightDetails.setBounds(100, 100, 945, 661);
		frmFlightDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel IATALabel = new JLabel("IATA Code:");
		IATALabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel AircraftModelNameLabel = new JLabel("Aircraft Model Name:");
		AircraftModelNameLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel TrackingNumberLabel = new JLabel("Tracking Number:");
		TrackingNumberLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel DepartureAirportLabel = new JLabel("Departure Airport:");
		DepartureAirportLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel OriginDateLabel = new JLabel("Origin Date:");
		OriginDateLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel ScheduledDepartureLabel = new JLabel("Scheduled Departure:");
		ScheduledDepartureLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel DepartureTerminalLabel = new JLabel("Departure Terminal:");
		DepartureTerminalLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel DepartureGatesLabel = new JLabel("Departure Gates:");
		DepartureGatesLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel EstimatedDepartureLabel = new JLabel("Estimated Departure:");
		EstimatedDepartureLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel CheckinLocationLabel = new JLabel("Check-in Location:");
		CheckinLocationLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel CheckinCounterLabel = new JLabel("Check-in Counter:");
		CheckinCounterLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel CheckinStartLabel = new JLabel("Check-in Start:");
		CheckinStartLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel OperatingAirlineLabel = new JLabel("Operating Airline:");
		OperatingAirlineLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel ArrivalAirportLabel = new JLabel("Arrival Airport:");
		ArrivalAirportLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel ScheduledArrivalLabel = new JLabel("Scheduled Arrival:");
		ScheduledArrivalLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel ArrivalTerminalLabel = new JLabel("Arrival Terminal:");
		ArrivalTerminalLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel ArrivalGatesLabel = new JLabel("Arrival Gates:");
		ArrivalGatesLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel EstimatedArrivalLabel = new JLabel("Estimated Arrival:");
		EstimatedArrivalLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel CheckinEndLabel = new JLabel("Check-in End:");
		CheckinEndLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel FlightStatusLabel = new JLabel("Flight Status:");
		FlightStatusLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		IATATxtField = new JTextField();
		IATATxtField.setColumns(10);
		
		AircraftModelNameTxtField = new JTextField();
		AircraftModelNameTxtField.setColumns(10);
		
		TrackingNumberTxtField = new JTextField();
		TrackingNumberTxtField.setColumns(10);
		
		DepartureAirportTxtField = new JTextField();
		DepartureAirportTxtField.setColumns(10);
		
		OriginDateTxtField = new JTextField();
		OriginDateTxtField.setColumns(10);
		
		ScheduledDepartureTxtField = new JTextField();
		ScheduledDepartureTxtField.setColumns(10);
		
		DepartureTerminalTxtField = new JTextField();
		DepartureTerminalTxtField.setColumns(10);
		
		DepartureGatesTxtField = new JTextField();
		DepartureGatesTxtField.setColumns(10);
		
		EstimatedDepartureTxtField = new JTextField();
		EstimatedDepartureTxtField.setColumns(10);
		
		CheckinLocationTxtField = new JTextField();
		CheckinLocationTxtField.setColumns(10);
		
		CheckinCounterTxtField = new JTextField();
		CheckinCounterTxtField.setColumns(10);
		
		CheckinStartTxtField = new JTextField();
		CheckinStartTxtField.setColumns(10);
		
		OperatingAirlineTxtField = new JTextField();
		OperatingAirlineTxtField.setColumns(10);
		
		ArrivalAirportTxtField = new JTextField();
		ArrivalAirportTxtField.setColumns(10);
		
		ScheduledArrivalTxtField = new JTextField();
		ScheduledArrivalTxtField.setColumns(10);
		
		ArrivalTerminalTxtField = new JTextField();
		ArrivalTerminalTxtField.setColumns(10);
		
		ArrivalGatesTxtField = new JTextField();
		ArrivalGatesTxtField.setColumns(10);
		
		EstimatedArrivalTxtField = new JTextField();
		EstimatedArrivalTxtField.setColumns(10);
		
		CheckinEndTxtField = new JTextField();
		CheckinEndTxtField.setColumns(10);
		
		JComboBox FlightStatusComboBox = new JComboBox();
		FlightStatusComboBox.addItem("-");
		FlightStatusComboBox.addItem("B");
		FlightStatusComboBox.addItem("D");
		FlightStatusComboBox.addItem("I");
		FlightStatusComboBox.addItem("L");
		FlightStatusComboBox.addItem("M");
		FlightStatusComboBox.addItem("S");
		FlightStatusComboBox.addItem("X");
		FlightStatusComboBox.addItem("Y");
		FlightStatusComboBox.addItem("Z");
		
		JButton SaveButton = new JButton("Save");
		SaveButton.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JButton CancelButton = new JButton("Cancel");
		CancelButton.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		GroupLayout groupLayout = new GroupLayout(frmFlightDetails.getContentPane());
		frmFlightDetails.getContentPane().setLayout(groupLayout);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(IATALabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(68)
					.addComponent(IATATxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(OperatingAirlineLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(OperatingAirlineTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(AircraftModelNameLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(AircraftModelNameTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(TrackingNumberLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(TrackingNumberTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(DepartureAirportLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(DepartureAirportTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ArrivalAirportLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(ArrivalAirportTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(OriginDateLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(OriginDateTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(ScheduledDepartureLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(ScheduledDepartureTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(ScheduledArrivalTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
						.addComponent(ScheduledArrivalLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(DepartureTerminalLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(DepartureTerminalTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ArrivalTerminalLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(ArrivalTerminalTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(DepartureGatesLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(DepartureGatesTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ArrivalGatesLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(ArrivalGatesTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(EstimatedDepartureLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(EstimatedDepartureTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(EstimatedArrivalLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(EstimatedArrivalTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(CheckinLocationLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(CheckinLocationTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(CheckinCounterLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(CheckinCounterTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(CheckinStartLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(CheckinStartTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(CheckinEndTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
						.addComponent(CheckinEndLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(FlightStatusLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(FlightStatusComboBox, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(668)
					.addComponent(CancelButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(SaveButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(IATALabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(IATATxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(OperatingAirlineLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(OperatingAirlineTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(AircraftModelNameLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(AircraftModelNameTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(TrackingNumberLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(TrackingNumberTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(DepartureAirportLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(DepartureAirportTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(ArrivalAirportLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(ArrivalAirportTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(OriginDateLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(OriginDateTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ScheduledDepartureLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(ScheduledDepartureTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(ScheduledArrivalTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(ScheduledArrivalLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(DepartureTerminalLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(DepartureTerminalTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(ArrivalTerminalLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(ArrivalTerminalTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(DepartureGatesLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(DepartureGatesTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(ArrivalGatesLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(ArrivalGatesTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(EstimatedDepartureLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(EstimatedDepartureTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(EstimatedArrivalLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(EstimatedArrivalTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(CheckinLocationLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(CheckinLocationTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(CheckinCounterLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(CheckinCounterTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(CheckinStartLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(CheckinStartTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(CheckinEndTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(CheckinEndLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(FlightStatusLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(FlightStatusComboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(CancelButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(SaveButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
		);
	}
}
