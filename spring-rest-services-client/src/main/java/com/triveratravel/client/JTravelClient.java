package com.triveratravel.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.triveratravel.client.config.JavaConfig;
import com.triveratravel.model.Flight;
import com.triveratravel.model.Reservation;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC., Worldwide
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Technologies, LLC.
 *
 * Copyright (c) 2023 Trivera Technologies, LLC. http://www.triveratech.com
 * </p>
 * 
 * 
 */
@Component
public class JTravelClient extends JFrame {

	@Autowired
	private JTravelFacade travelFacade;
	private JFormattedTextField reservationNumberField;
	private FlightDataModel flightDataModel;
	private JTable flightsTable;
	private JTextField flightNumberField;
	private JButton makeReservationButton;
	private JTextField nameOnReservationField;
	private ShowReservationPanel showReservationPanel;

	public static void main(String[] args) {
		final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				JavaConfig.class);
		JTravelClient client = applicationContext.getBean(JTravelClient.class);
		client.showFrame();

	}

	public void showFrame() {
		setTitle("JTravel");
		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Make Reservation", createMakeReservationPanel());
		tabs.addTab("Find Reservation", createSearchReservationPanel());
		add(tabs, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		centerFrame();
		setVisible(true);
	}

	private JPanel createSearchReservationPanel() {
		JPanel searchReservationPanel = new JPanel();
		searchReservationPanel.setOpaque(true);
		searchReservationPanel.setLayout(new BorderLayout());

		searchReservationPanel.add(createSearchPanel(), BorderLayout.NORTH);
		showReservationPanel = new ShowReservationPanel();
		searchReservationPanel.add(showReservationPanel, BorderLayout.CENTER);
		return searchReservationPanel;
	}

	private JPanel createSearchPanel() {
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Search Reservations"));
		panel.add(new JLabel("Reservation Number"));
		reservationNumberField = new JFormattedTextField(NumberFormat.getInstance());
		reservationNumberField.setColumns(10);
		panel.add(reservationNumberField);

		JButton searchButton = new JButton("Search");
		panel.add(searchButton);

		searchButton.addActionListener(e -> {
			showReservationPanel.clearReservation();
			String reservationNumber = reservationNumberField.getText();
			if (reservationNumber.equals(""))
				return;
			Number value = (Number) reservationNumberField.getValue();

			Reservation reservation = travelFacade.getReservation(value.intValue());
			showReservationPanel.setReservation(reservation);

		});
		return panel;
	}

	// Make New Reservations
	private JPanel createMakeReservationPanel() {
		JPanel makeReservationPanel = new JPanel();
		makeReservationPanel.setOpaque(true);
		makeReservationPanel.setLayout(new BorderLayout());
		makeReservationPanel.add(createTablePanel(), BorderLayout.CENTER);
		makeReservationPanel.add(createReservationPanel(), BorderLayout.SOUTH);
		return makeReservationPanel;
	}

	private JPanel createReservationPanel() {
		JPanel reservationPanel = new JPanel(new GridLayout(0, 1));
		reservationPanel.setBorder(new TitledBorder("Reservation"));

		JPanel namePanel = new JPanel();
		namePanel.add(new JLabel("Name On Reservation"));
		nameOnReservationField = new JTextField(20);
		namePanel.add(nameOnReservationField);
		reservationPanel.add(namePanel);

		JPanel flightNumberPanel = new JPanel();
		flightNumberPanel.add(new JLabel("FlightNumber "));
		flightNumberField = new JTextField(12);

		flightNumberPanel.add(flightNumberField);
		reservationPanel.add(flightNumberPanel);

		makeReservationButton = new JButton("Make Reservation");
		makeReservationButton.setEnabled(false);
		enableMakeReservationButton(nameOnReservationField, flightNumberField);
		reservationPanel.add(makeReservationButton);

		makeReservationButton.addActionListener(e -> makeReservation());
		return reservationPanel;
	}

	private JPanel createTablePanel() {
		JPanel tablePanel = new JPanel();
		tablePanel.setOpaque(true);
		tablePanel.setLayout(new BorderLayout());
		tablePanel.setBorder(new TitledBorder("Flights By Destination"));

		JPanel entryPanel = new JPanel();
		entryPanel.add(new JLabel("Destination Code"));

		final JTextField destinationCodeField = new JTextField(12);
		destinationCodeField.setText("LAS");
		entryPanel.add(destinationCodeField);

		JButton searchButton = new JButton("Search");
		entryPanel.add(searchButton);

		searchButton.addActionListener(e -> {
			String destinationCode = destinationCodeField.getText().trim();
			if (destinationCode.equals(""))
				return;
			List<Flight> flightsByDestinationCode = travelFacade.getFlightsByDestinationCode(destinationCode);
			flightDataModel.flights.clear();
			flightDataModel.flights.addAll(flightsByDestinationCode);
			flightDataModel.fireTableDataChanged();
		});

		tablePanel.add(entryPanel, BorderLayout.NORTH);

		flightDataModel = new FlightDataModel();

		flightsTable = new JTable(flightDataModel);
		flightsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		flightsTable.getSelectionModel().addListSelectionListener(e -> {
			if (flightsTable.getSelectedRow() < 0)
				return;
			flightNumberField.setText(flightsTable.getValueAt(flightsTable.getSelectedRow(), 0).toString());
		});
		flightsTable.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(flightsTable);

		scrollPane.setPreferredSize(new Dimension(500, 200));
		tablePanel.add(scrollPane, BorderLayout.CENTER);
		return tablePanel;
	}

	public void centerFrame() {
		pack();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension m = getSize();
		d.width -= m.width;
		d.height -= m.height;
		d.width /= 2;
		d.height /= 2;
		setLocation(d.width, d.height);
	}

	@SuppressWarnings("serial")
	class FlightDataModel extends AbstractTableModel {

		List<Flight> flights = new ArrayList<>();
		final String[] columnNames = { "Flight Number", "Destination", "Airline", "Departure Time" };

		@Override
		public String getColumnName(int column) {
			return columnNames[column];
		}

		@Override
		public int getRowCount() {
			return flights.size();
		}

		@Override
		public int getColumnCount() {
			return 4;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Flight flight = flights.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return flight.getFlightNumber();
			case 1:
				return flight.getDestination();
			case 2:
				return flight.getAirlineName();
			case 3:
				return flight.getDepartureTime().toString();

			}
			return "";
		}

	}

	private void makeReservation() {
		String flightNumber = flightNumberField.getText();
		String nameOnReservation = nameOnReservationField.getText();
		travelFacade.makeReservation(nameOnReservation, flightNumber);
	}

	private void enableMakeReservationButton(JTextField... textFields) {

		for (JTextField textField : textFields) {
			textField.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void removeUpdate(DocumentEvent e) {
					update();

				}

				@Override
				public void insertUpdate(DocumentEvent e) {
					update();

				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					update();

				}

				private void update() {
					makeReservationButton.setEnabled(false);
					for (JTextField textField : textFields) {
						if (!(textField.getText().trim().length() > 0)) {
							return;
						}
					}
					makeReservationButton.setEnabled(true);
				}
			});
		}
	}

	public class ShowReservationPanel extends JPanel {
		private JLabel nameOnReservationField;
		private JLabel flightNumberField;
		private JLabel flightdestinationField;
		private JLabel flightAirlineNameField;
		private JLabel flightDepartureTimeField;

		public ShowReservationPanel() {
			init();
		}

		public void clearReservation() {
			nameOnReservationField.setText("n/a");
			flightAirlineNameField.setText("n/a");
			flightNumberField.setText("n/a");
			flightdestinationField.setText("n/a");
			flightDepartureTimeField.setText("n/a");
		}

		public void setReservation(Reservation reservation) {
			if (reservation == null) {
				return;
			}
			nameOnReservationField.setText(reservation.getNameOnReservation());
			flightAirlineNameField.setText(reservation.getFlightAirlineName());
			flightNumberField.setText(reservation.getFlightNumber());
			flightdestinationField.setText(reservation.getFlightDestination());
			flightDepartureTimeField.setText(reservation.getFlightDepartureTime().toString());
		}

		private void init() {
			setLayout(new GridLayout(0, 2));

			setBorder(new TitledBorder("Reservation"));
			nameOnReservationField = addField("Name on Reservation:");
			flightNumberField = addField("Flight Number:");
			flightdestinationField = addField("Destination:");
			flightAirlineNameField = addField("Airline:");
			flightDepartureTimeField = addField("Departure Time:");
		}

		private JLabel addField(String label) {
			JLabel jLabel = new JLabel(label);
			add(jLabel);
			JLabel textField = new JLabel("n/a");
			add(textField);
			textField.setBackground(Color.white);
			jLabel.setLabelFor(textField);
			return textField;
		}
	}

	@EventListener
	public void onReservationEvent(ReservationEvent event) {
		String msg = String.format("HTTP Status (%d),\nReservation ID %d,\nURLs %s", event.getHttpStatusCode(),
				event.getReservation().getReservationNumber(), event.getUrls());
		JOptionPane.showMessageDialog(this, msg, "Info", JOptionPane.INFORMATION_MESSAGE);
		reservationNumberField.setText(event.getReservation().getReservationNumber().toString());
	}

	@EventListener
	public void onReservationException(ReservationExceptionEvent event) {
		Exception exception = event.getException();
		String msg = String.format("%s -> %s", exception.getClass().getName(), exception.getMessage());
		JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);

	}
}
