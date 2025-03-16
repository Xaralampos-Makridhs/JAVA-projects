package com.example;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class ChargeCalc extends JFrame {	
	private JPanel panel;
	private JButton button1, button2;
	private JTextField totalChargeTF;
	private JList list;
	private ArrayList<Ship> ships;
	
	public ChargeCalc(ArrayList<Ship> someShips) {
		ships = someShips;
		
		panel = new JPanel();
		button1 = new JButton("Calculate Charge");		
		panel.add(button1);
		button2 = new JButton("Create Container");
		panel.add(button2);
		
		list = new JList();
		DefaultListModel model = new DefaultListModel();		
		for(Ship ship: ships) {
			String shipName = ship.getName();
			model.addElement(shipName);
		}
		list.setModel(model);
		panel.add(list);
		
		totalChargeTF = new JTextField("Total charge");
		panel.add(totalChargeTF);
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		button1.addActionListener(listener);
		button2.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(400, 200);
		this.setTitle("Charge Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {		
		public void actionPerformed(ActionEvent e) {
		
			if (e.getSource() == button1 )
			{
				String selectedShipName = (String) list.getSelectedValue();
			
				Ship selectedShip = null;
				for(Ship ship: ships) {
					if(ship.getName().equals(selectedShipName))
						selectedShip = ship;
				}
				double totalCharge = selectedShip.getTotalCharge();
				String totalChargeText = Double.toString(totalCharge);
				totalChargeTF.setText(totalChargeText);
			}
			else
			{
				ContainerFrame cf = new ContainerFrame(ships);
        		cf.setLocation(0, 210);	
			}
		}
		
	}

}
