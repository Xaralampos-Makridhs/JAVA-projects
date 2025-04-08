package inventory;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


public class Frame extends JFrame {
	private DefaultListModel<Product> productListModel;
	private JList<Product> productJList;
	private JTextField nameField,stockField,quantityField;
	private JComboBox<Order.OrderType> orderTypeBox;
	private JButton addProdButt,executeOrderButt;
	private List<Product> products=new ArrayList<>();
	
	public Frame() {
		setTitle("Production Mangement");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		productListModel=new DefaultListModel<>();
		productJList=new JList<>(productListModel);
		productJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(productJList),BorderLayout.CENTER);
		
		add(createTopPanel(),BorderLayout.NORTH);
		add(createBotPanel(),BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	private JPanel createTopPanel() {
	    JPanel topPanel = new JPanel();
	    topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

	    
	    JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    namePanel.add(new JLabel("Name: "));
	    nameField = new JTextField(15);
	    namePanel.add(nameField);

	  
	    JPanel stockPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    stockPanel.add(new JLabel("Initial Stock:"));
	    stockField = new JTextField(5);
	    stockPanel.add(stockField);

	   
	    addProdButt = new JButton("Add Product");
	    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    buttonPanel.add(addProdButt);

	    
	    topPanel.add(namePanel);
	    topPanel.add(stockPanel);
	    topPanel.add(buttonPanel);

	    // Λογική για το κουμπί
	    addProdButt.addActionListener(e -> {
	        String name = nameField.getText().trim();
	        String stockText = stockField.getText().trim();
	        if (name.isEmpty() || stockText.isEmpty()) {
	            return;
	        }
	        try {
	            int stock = Integer.parseInt(stockText);
	            Product newProduct = new Product(name, stock);
	            products.add(newProduct);
	            productListModel.addElement(newProduct);
	            nameField.setText("");
	            stockField.setText("");
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "Stock must be Number!");
	        }
	    });

	    return topPanel;
	}

	
	private JPanel createBotPanel() {
		JPanel botPanel=new JPanel(new GridLayout(2,3,5,5));
		botPanel.setBorder(BorderFactory.createTitledBorder("Order"));
		
		quantityField=new JTextField();
		orderTypeBox=new JComboBox<>(Order.OrderType.values());
		executeOrderButt=new JButton("Execute Order");
		
		botPanel.add(new JLabel("Quantity: "));
		botPanel.add(quantityField);
		botPanel.add(orderTypeBox);
		botPanel.add(new JLabel());
		botPanel.add(executeOrderButt);
		
		executeOrderButt.addActionListener(e->executeOrder());
		return botPanel;
	}
	
	private void executeOrder() {
		Product selectedProduct=productJList.getSelectedValue();
		if(selectedProduct==null) {
			JOptionPane.showMessageDialog(this,"Choose Product: ");
			return;
		}
		
		try {
			int quantity=Integer.parseInt(quantityField.getText().trim());
			if(quantity<=0) throw new NumberFormatException();
			
			Order.OrderType type=(Order.OrderType) orderTypeBox.getSelectedItem();
			new Order(selectedProduct,quantity,type);
			refreshList();
			quantityField.setText("");
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this,"Quantity must be positive number");
		}
	}
	
	private void refreshList() {
		productJList.repaint();
	}
}
