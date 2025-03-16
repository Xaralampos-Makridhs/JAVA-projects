package com.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;

public class ContainerFrame extends JFrame {
	
	private JTextField codeField = new JTextField("Code*");
	private JTextField destinationField = new JTextField("Destination*");
	private JTextField weightField = new JTextField("Weight (for Bulk)");
	private JTextField powerField = new JTextField("Power (for refridgerator)");
	private JButton bulkButton = new JButton("Create Bulk");
	private JButton refridgeratorButton = new JButton("Create Refridgerator");
	private JPanel containerPanel; 
	private JPanel centralPanel;
	private JList<String> shipList;
	private ArrayList<Ship> ships;
	
	public ContainerFrame(ArrayList<Ship> someShips) {
		ships = someShips;
		
		centralPanel = new JPanel(new BorderLayout());
		
		containerPanel = new JPanel(new GridLayout(3, 2));
		containerPanel.add(codeField);
		containerPanel.add(destinationField);
		containerPanel.add(weightField);
		containerPanel.add(powerField);
		containerPanel.add(bulkButton);
		containerPanel.add(refridgeratorButton);
		centralPanel.add(containerPanel, BorderLayout.CENTER);
		
		shipList = new JList<String>();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for(Ship ship: ships) {
			listModel.addElement(ship.getName());
		}		
		shipList.setModel(listModel);				
		centralPanel.add(shipList, BorderLayout.NORTH);
		
		this.setContentPane(centralPanel);
		
		ButtonListener listener = new ButtonListener();
		bulkButton.addActionListener(listener);
		refridgeratorButton.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(400, 200);
		this.setTitle("Container Frame");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			String code = codeField.getText();
			String destination = destinationField.getText();
			
			String selectedShipName = shipList.getSelectedValue();
	
			Ship selectedShip = null;
			for(Ship ship: ships) {
				if(ship.getName().equals(selectedShipName))
					selectedShip = ship;
			}
			
			Container newContainer;
			if(e.getSource() == bulkButton) {
				String weightText = weightField.getText();
				int weight = Integer.parseInt(weightText);
				newContainer = new Bulk(code, destination, weight);
			}
			else {
				String powerText = powerField.getText();
				double power = Double.parseDouble(powerText);
				newContainer = new Refridgerator(code, destination, power);
			}
			selectedShip.addContainer(newContainer);
			System.out.println("Ship name: " + selectedShip.getName());
			System.out.println("Ship charge: " + selectedShip.getTotalCharge());
		}
		
	}

}

