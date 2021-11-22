package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTextField;

import model.Flight;
import interfaces.IFlightServer;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class FlightDetailsGUI {

	private JFrame frmFlightDetails;
	private JTextField IATATxtField;
	private JTextField aircraftModelNameTxtField;
	private JTextField trackingNumberTxtField;
	private JTextField departureAirportTxtField;
	private JTextField originDateTxtField;
	private JTextField scheduledDepartureTxtField;
	private JTextField departureTerminalTxtField;
	private JTextField departureGatesTxtField;
	private JTextField estimatedDepartureTxtField;
	private JTextField checkInLocationTxtField;
	private JTextField checkInCounterTxtField;
	private JTextField checkInStartTxtField;
	private JTextField operatingAirlineTxtField;
	private JTextField arrivalAirportTxtField;
	private JTextField scheduledArrivalTxtField;
	private JTextField arrivalTerminalTxtField;
	private JTextField arrivalGatesTxtField;
	private JTextField estimatedArrivalTxtField;
	private JTextField checkInEndTxtField;
	private JComboBox flightStatusComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightDetailsGUI window = new FlightDetailsGUI(true);// true when create, false when edit
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
	public FlightDetailsGUI(boolean create) {
		initialize(create);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(boolean create) {
		frmFlightDetails = new JFrame();
		frmFlightDetails.setTitle("Flight Details");
		frmFlightDetails.setBounds(100, 100, 945, 661);
		frmFlightDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel IATALabel = new JLabel("IATA Code:");
		IATALabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel aircraftModelNameLabel = new JLabel("Aircraft Model Name:");
		aircraftModelNameLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel trackingNumberLabel = new JLabel("Tracking Number:");
		trackingNumberLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel departureAirportLabel = new JLabel("Departure Airport:");
		departureAirportLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel originDateLabel = new JLabel("Origin Date:");
		originDateLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel scheduledDepartureLabel = new JLabel("Scheduled Departure:");
		scheduledDepartureLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel departureTerminalLabel = new JLabel("Departure Terminal:");
		departureTerminalLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel departureGatesLabel = new JLabel("Departure Gates:");
		departureGatesLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel estimatedDepartureLabel = new JLabel("Estimated Departure:");
		estimatedDepartureLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel checkInLocationLabel = new JLabel("Check-in Location:");
		checkInLocationLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel checkInCounterLabel = new JLabel("Check-in Counter:");
		checkInCounterLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel checkInStartLabel = new JLabel("Check-in Start:");
		checkInStartLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel operatingAirlineLabel = new JLabel("Operating Airline:");
		operatingAirlineLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel arrivalAirportLabel = new JLabel("Arrival Airport:");
		arrivalAirportLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel scheduledArrivalLabel = new JLabel("Scheduled Arrival:");
		scheduledArrivalLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel arrivalTerminalLabel = new JLabel("Arrival Terminal:");
		arrivalTerminalLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel arrivalGatesLabel = new JLabel("Arrival Gates:");
		arrivalGatesLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel estimatedArrivalLabel = new JLabel("Estimated Arrival:");
		estimatedArrivalLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel checkInEndLabel = new JLabel("Check-in End:");
		checkInEndLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JLabel flightStatusLabel = new JLabel("Flight Status:");
		flightStatusLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		IATATxtField = new JTextField();
		IATATxtField.setColumns(10);
		if(!create) {
			IATATxtField.setEditable(false); //set false if edit
		}
		
		aircraftModelNameTxtField = new JTextField();
		aircraftModelNameTxtField.setColumns(10);
		
		trackingNumberTxtField = new JTextField();
		trackingNumberTxtField.setColumns(10);
		if(!create) {
			trackingNumberTxtField.setEditable(false); //set false if edit
		}
		
		departureAirportTxtField = new JTextField();
		departureAirportTxtField.setColumns(10);
		
		originDateTxtField = new JTextField();
		originDateTxtField.setColumns(10);
		
		scheduledDepartureTxtField = new JTextField();
		scheduledDepartureTxtField.setColumns(10);
		
		departureTerminalTxtField = new JTextField();
		departureTerminalTxtField.setColumns(10);
		
		departureGatesTxtField = new JTextField();
		departureGatesTxtField.setColumns(10);
		
		estimatedDepartureTxtField = new JTextField();
		estimatedDepartureTxtField.setColumns(10);
		
		checkInLocationTxtField = new JTextField();
		checkInLocationTxtField.setColumns(10);
		
		checkInCounterTxtField = new JTextField();
		checkInCounterTxtField.setColumns(10);
		
		checkInStartTxtField = new JTextField();
		checkInStartTxtField.setColumns(10);
		
		operatingAirlineTxtField = new JTextField();
		operatingAirlineTxtField.setColumns(10);
		if(!create) {
			operatingAirlineTxtField.setEditable(false); //set false if edit
		}
		
		arrivalAirportTxtField = new JTextField();
		arrivalAirportTxtField.setColumns(10);
		
		scheduledArrivalTxtField = new JTextField();
		scheduledArrivalTxtField.setColumns(10);
		
		arrivalTerminalTxtField = new JTextField();
		arrivalTerminalTxtField.setColumns(10);
		
		arrivalGatesTxtField = new JTextField();
		arrivalGatesTxtField.setColumns(10);
		
		estimatedArrivalTxtField = new JTextField();
		estimatedArrivalTxtField.setColumns(10);
		
		checkInEndTxtField = new JTextField();
		checkInEndTxtField.setColumns(10);
		
		flightStatusComboBox = new JComboBox();
		flightStatusComboBox.addItem("-");
		flightStatusComboBox.addItem("B");
		flightStatusComboBox.addItem("D");
		flightStatusComboBox.addItem("I");
		flightStatusComboBox.addItem("L");
		flightStatusComboBox.addItem("M");
		flightStatusComboBox.addItem("S");
		flightStatusComboBox.addItem("X");
		flightStatusComboBox.addItem("Y");
		flightStatusComboBox.addItem("Z");
		
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		
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
						.addComponent(operatingAirlineLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(operatingAirlineTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(aircraftModelNameLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(aircraftModelNameTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(trackingNumberLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(trackingNumberTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(departureAirportLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(departureAirportTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(arrivalAirportLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(arrivalAirportTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(originDateLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(originDateTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(scheduledDepartureLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(scheduledDepartureTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(scheduledArrivalTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
						.addComponent(scheduledArrivalLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(departureTerminalLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(departureTerminalTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(arrivalTerminalLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(arrivalTerminalTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(departureGatesLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(departureGatesTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(arrivalGatesLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(arrivalGatesTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(estimatedDepartureLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(estimatedDepartureTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(estimatedArrivalLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(estimatedArrivalTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(checkInLocationLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(checkInLocationTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(checkInCounterLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(checkInCounterTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(checkInStartLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(checkInStartTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(checkInEndTxtField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
						.addComponent(checkInEndLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(flightStatusLabel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(flightStatusComboBox, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(668)
					.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
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
								.addComponent(operatingAirlineLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(operatingAirlineTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(aircraftModelNameLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(aircraftModelNameTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(trackingNumberLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(trackingNumberTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(departureAirportLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(departureAirportTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(arrivalAirportLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(arrivalAirportTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(originDateLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(originDateTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scheduledDepartureLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(scheduledDepartureTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(scheduledArrivalTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(scheduledArrivalLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(departureTerminalLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(departureTerminalTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(arrivalTerminalLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(arrivalTerminalTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(departureGatesLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(departureGatesTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(arrivalGatesLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(arrivalGatesTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(estimatedDepartureLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(estimatedDepartureTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(estimatedArrivalLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(estimatedArrivalTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(checkInLocationLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(checkInLocationTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(checkInCounterLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(checkInCounterTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(checkInStartLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(checkInStartTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(checkInEndTxtField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(checkInEndLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(flightStatusLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(flightStatusComboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
		);
	}
	
	public void getEditInput(Flight flight) {
		//to convert string to date time
		DateTimeFormatter dta1 = DateTimeFormatter.ofPattern("yyyy-MM-ddTHH:mm:ss");
		DateTimeFormatter dta2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		//set flight basic info
		flight.setFlightInfo(operatingAirlineTxtField.getText(), aircraftModelNameTxtField.getText(), LocalDate.parse(originDateTxtField.getText(), dta2), departureAirportTxtField.getText(), arrivalAirportTxtField.getText());
		
		if(arrivalAirportTxtField.getText() == "FRA") {
			
			//set arrival details
			flight.setArrival(LocalDateTime.parse(scheduledArrivalTxtField.getText(), dta1), Integer.parseInt(arrivalTerminalTxtField.getText()), LocalDateTime.parse(estimatedArrivalTxtField.getText(), dta1));
			
		} else if(departureAirportTxtField.getText() == "FRA"){
			
			//to convert string to list<integer>
			Scanner scanner = new Scanner(checkInCounterTxtField.getText());
			List<Integer> counter = new ArrayList<Integer>();
			while (scanner.hasNextInt()) {
			    counter.add(scanner.nextInt());
			}
			
			//set departure details
			flight.setDeparture(LocalDateTime.parse(scheduledDepartureTxtField.getText(), dta1), Integer.parseInt(departureTerminalTxtField.getText()), Arrays.asList(departureGatesTxtField.getText().split(",")));
			flight.setCheckIn(Integer.parseInt(checkInLocationTxtField.getText()), counter, LocalDateTime.parse(checkInStartTxtField.getText(), dta1), LocalDateTime.parse(checkInEndTxtField.getText(), dta1));
			
		}
		
		//to convert string to char, then set flight status
		char[] status = new char[1];
		status = flightStatusComboBox.getSelectedItem().toString().toCharArray();
		flight.setStatus(status[0]);
	}
	
	public void createFLight() {
		
	}
	
}

