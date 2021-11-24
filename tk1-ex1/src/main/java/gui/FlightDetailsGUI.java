package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.JTextField;

import model.Flight;
import interfaces.IFlightClient;
import interfaces.IFlightServer;
import gui.FlightListGUI;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class FlightDetailsGUI {

	JFrame frmFlightDetails;
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
	
	//to convert string to date time
	private DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private Flight tempFlight = new Flight();
	private IFlightClient flightClient;
	private FlightListGUI flightListGUI;
	
	private boolean create = false;

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
	// flights argument is optional; in fact, only one flight which the user selected will be passed, it will receive as Flight[]
	// due to behaviour of varargs
	public FlightDetailsGUI(boolean create, Flight... flights) {
		if (create) {
			initialize(create);
		} else {
			initialize(create, flights);  // assume FlightDetailsGUI will be instantiated with flight only when create==false, which means update
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(boolean create, Flight... flights) {  // assume only one flight (flights[0]) will be passed
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
		
		aircraftModelNameTxtField = new JTextField();
		aircraftModelNameTxtField.setColumns(10);
		
		trackingNumberTxtField = new JTextField();
		trackingNumberTxtField.setColumns(10);
		
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
		
		
		if (!create) {
			IATATxtField.setEditable(false); //set false if edit
			IATATxtField.setText(flights[0].getIATA());
			
			aircraftModelNameTxtField.setText(flights[0].getModel());
			
			trackingNumberTxtField.setEditable(false);
			trackingNumberTxtField.setText(flights[0].getFlightNum().substring(2));  // Flight number has format of "LH591" where first two letters are IATA and rest is tracking number
			
			departureAirportTxtField.setText(flights[0].getD_airport());
			
			originDateTxtField.setText(flights[0].getOriDate().format(localDateFormatter));
			
			operatingAirlineTxtField.setEditable(false);  // do we need to?
			operatingAirlineTxtField.setText(flights[0].getAirline());
			
			arrivalAirportTxtField.setText(flights[0].getA_airport());
			
			if (flights[0].getStatus() == null) {
				flightStatusComboBox.setSelectedItem("-");
			} else {
				flightStatusComboBox.setSelectedItem(flights[0].getStatus());
			}
			
			if (flights[0].getDepart()) {  // this is departure flight, fill text field with existing info and don't allow user to edit text fields for arrival
				scheduledDepartureTxtField.setText(flights[0].getScheduledDT().format(localDateTimeFormatter));
				scheduledArrivalTxtField.setEditable(false);
				
				departureTerminalTxtField.setText(String.valueOf(flights[0].getTerminal()));
				arrivalTerminalTxtField.setEditable(false);
				
				departureGatesTxtField.setText(stringifyElementsOfList(flights[0].getGates()));
				arrivalGatesTxtField.setEditable(false);
				
				estimatedDepartureTxtField.setText(flights[0].getEstDT().format(localDateTimeFormatter));
				estimatedArrivalTxtField.setEditable(false);
				
				checkInLocationTxtField.setText(flights[0].getCI_location());
				
				checkInCounterTxtField.setText(stringifyElementsOfList(flights[0].getCI_counters()));
				
				checkInStartTxtField.setText(flights[0].getCI_start().format(localDateTimeFormatter));
				
				checkInEndTxtField.setText(flights[0].getCI_start().format(localDateTimeFormatter));
				
			} else {  // this is arrival flight, fill text field with existing info and don't allow user to edit text fields for departure
				scheduledArrivalTxtField.setText(flights[0].getScheduledDT().format(localDateTimeFormatter));
				scheduledDepartureTxtField.setEditable(false);
				
				arrivalTerminalTxtField.setText(String.valueOf(flights[0].getTerminal()));
				departureTerminalTxtField.setEditable(false);
				
				arrivalGatesTxtField.setText(stringifyElementsOfList(flights[0].getGates()));
				departureGatesTxtField.setEditable(false);
				
				estimatedArrivalTxtField.setText(flights[0].getEstDT().format(localDateTimeFormatter));
				estimatedDepartureTxtField.setEditable(false);
				
				checkInLocationTxtField.setEditable(false);
				
				checkInCounterTxtField.setEditable(false);
				
				checkInStartTxtField.setEditable(false);
				
				checkInEndTxtField.setEditable(false);
			}
		}
		
		
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getEditInput(tempFlight);
				try {
					if(create) {
						flightClient.sendUpdatedFlight(tempFlight, 'C');
					} else {
						flightClient.sendUpdatedFlight(tempFlight, 'U');
					}
					
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmFlightDetails.setVisible(false);
				frmFlightDetails.dispose(); //destroy JFrame object
			}
		});
		
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
	
	public void setFlightClient(IFlightClient flightClient) {
		this.flightClient = flightClient;
	}
	
	public String stringifyElementsOfList(List<?> list) {
	    String result = list.stream()
	      .map(n -> String.valueOf(n))
	      .collect(Collectors.joining(", "));  // output: A03, A04, ... or 101, 102, ...
	 
	    return result;
	}

	public void getEditInput(Flight flight) {
		String num = IATATxtField.getText() + trackingNumberTxtField.getText();
		flight.setFlightNum(num); //set flightNum
		
		//set flight basic info
		flight.setFlightInfo(operatingAirlineTxtField.getText(), aircraftModelNameTxtField.getText(), LocalDate.parse(originDateTxtField.getText(), localDateFormatter), departureAirportTxtField.getText(), arrivalAirportTxtField.getText());
		
		if(arrivalAirportTxtField.getText() == "FRA") {
			
			//set arrival details
			flight.setArrival(LocalDateTime.parse(scheduledArrivalTxtField.getText().replace("", "T"), localDateTimeFormatter), Integer.parseInt(arrivalTerminalTxtField.getText()), Arrays.asList(departureGatesTxtField.getText().split(",")), LocalDateTime.parse(estimatedArrivalTxtField.getText().replace("", "T"), localDateTimeFormatter));
			
		} else if(departureAirportTxtField.getText() == "FRA"){
			
			//to convert string to list<integer>
			Scanner scanner = new Scanner(checkInCounterTxtField.getText());
			List<Integer> counter = new ArrayList<Integer>();
			while (scanner.hasNextInt()) {
			    counter.add(scanner.nextInt());
			}
			
			//set departure details
			flight.setDeparture(LocalDateTime.parse(scheduledDepartureTxtField.getText().replace("", "T"), localDateTimeFormatter), Integer.parseInt(departureTerminalTxtField.getText()), Arrays.asList(departureGatesTxtField.getText().split(",")), LocalDateTime.parse(estimatedDepartureTxtField.getText().replace("", "T"), localDateTimeFormatter));
			flight.setCheckIn(checkInLocationTxtField.getText(), counter, LocalDateTime.parse(checkInStartTxtField.getText().replace("", "T"), localDateTimeFormatter), LocalDateTime.parse(checkInEndTxtField.getText().replace("", "T"), localDateTimeFormatter));
			
		}
		
		// set flight status
		String status = flightStatusComboBox.getSelectedItem().toString();
		flight.setStatus(status);
	}
	
	public void createFlight() { //call by listGUI if "new" button is clicked
		IATATxtField.setEditable(true);
		trackingNumberTxtField.setEditable(true); 
		operatingAirlineTxtField.setEditable(true);
		create = true;
	}
	
}
