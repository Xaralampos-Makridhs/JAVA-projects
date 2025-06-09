package erp_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class ErpApp extends JFrame {
    private JTextField customerNameField, searchCustomerField, editCustomerField, deleteCustomerField;
    private JTextField productNameField, productPriceField, searchProductField, editProductField, editProductPriceField, deleteProductField;
    private JTextArea customerArea, productArea, statsArea;
    private JTabbedPane tabs;

    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();

    public ErpApp() {
        setTitle("Mini ERP");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tabs = new JTabbedPane();
        tabs.add("Customers", createCustomerPanel());
        tabs.add("Products", createProductsPanel());
        tabs.add("Statistics", createStatisticsPanel());
        add(tabs, BorderLayout.CENTER);

        setVisible(true);
        LoadFromFile();
        updateStats();
    }

    private JPanel createCustomerPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();

        customerNameField = new JTextField(15);

        JButton addBtn = new JButton("Insert");
        JButton listBtn = new JButton("View List");
        JButton saveBtn = new JButton("Save");

        topPanel.add(new JLabel("Name"));
        topPanel.add(customerNameField);
        topPanel.add(addBtn);
        topPanel.add(listBtn);
        topPanel.add(saveBtn);

        customerArea = new JTextArea(10, 50);
        customerArea.setEditable(false);

        JPanel searchEditDelete = new JPanel(new GridLayout(3, 1));

        // Search
        JPanel searchPanel = new JPanel();
        searchCustomerField = new JTextField(10);
        JButton searchBtn = new JButton("Search");
        searchPanel.add(new JLabel("Search"));
        searchPanel.add(searchCustomerField);
        searchPanel.add(searchBtn);

        // Edit
        JPanel editPanel = new JPanel();
        editCustomerField = new JTextField(10);
        JButton editBtn = new JButton("Edit");
        editPanel.add(new JLabel("Edit"));
        editPanel.add(editCustomerField);
        editPanel.add(editBtn);

        // Delete
        JPanel deletePanel = new JPanel();
        deleteCustomerField = new JTextField(10);
        JButton deleteBtn = new JButton("Delete");
        deletePanel.add(new JLabel("Delete"));
        deletePanel.add(deleteCustomerField);
        deletePanel.add(deleteBtn);

        searchEditDelete.add(searchPanel);
        searchEditDelete.add(editPanel);
        searchEditDelete.add(deletePanel);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(customerArea), BorderLayout.CENTER);
        panel.add(searchEditDelete, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> {
            String name = customerNameField.getText().trim();
            if (!name.isEmpty()) {
                customers.add(new Customer(name));
                customerNameField.setText("");
                updateStats();
            }
        });

        listBtn.addActionListener(e -> {
            customerArea.setText("");
            if (customers.isEmpty()) {
                customerArea.setText("Δεν υπάρχουν πελάτες.");
            } else {
                int i = 1;
                for (Customer c : customers) {
                    customerArea.append(i++ + ". " + c + "\n");
                }
            }
        });

        saveBtn.addActionListener(e -> saveToFile());

        searchBtn.addActionListener(e -> {
            String keyword = searchCustomerField.getText().trim().toLowerCase();
            customerArea.setText("");
            int i = 1;
            for (Customer c : customers) {
                if (c.getName().toLowerCase().contains(keyword)) {
                    customerArea.append(i++ + ". " + c + "\n");
                }
            }
        });

        editBtn.addActionListener(e -> {
            String name = editCustomerField.getText().trim();
            String newName = JOptionPane.showInputDialog(this, "New Name:");
            if (newName != null) {
                for (Customer c : customers) {
                    if (c.getName().equalsIgnoreCase(name)) {
                        c.setName(newName);
                        updateStats();
                        break;
                    }
                }
            }
        });

        deleteBtn.addActionListener(e -> {
            String name = deleteCustomerField.getText().trim();
            customers.removeIf(c -> c.getName().equalsIgnoreCase(name));
            updateStats();
        });

        return panel;
    }

    public JPanel createProductsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();

        productNameField = new JTextField(10);
        productPriceField = new JTextField(8);

        JButton addBtn = new JButton("Insert");
        JButton listBtn = new JButton("View List");
        JButton saveBtn = new JButton("Save");

        topPanel.add(new JLabel("Name:"));
        topPanel.add(productNameField);
        topPanel.add(new JLabel("Price:"));
        topPanel.add(productPriceField);
        topPanel.add(addBtn);
        topPanel.add(saveBtn);
        topPanel.add(listBtn);

        productArea = new JTextArea(10, 50);
        productArea.setEditable(false);

        JPanel searchEditDelete = new JPanel(new GridLayout(3, 1));

        // Search
        JPanel searchPanel = new JPanel();
        searchProductField = new JTextField(10);
        JButton searchBtn = new JButton("Search");
        searchPanel.add(new JLabel("Search"));
        searchPanel.add(searchProductField);
        searchPanel.add(searchBtn);

        // Edit
        JPanel editPanel = new JPanel();
        editProductField = new JTextField(10);
        editProductPriceField = new JTextField(10);
        JButton editBtn = new JButton("Edit");
        editPanel.add(new JLabel("Edit Name"));
        editPanel.add(editProductField);
        editPanel.add(new JLabel("New Price:"));
        editPanel.add(editProductPriceField);
        editPanel.add(editBtn);

        // Delete
        JPanel deletePanel = new JPanel();
        deleteProductField = new JTextField(10);
        JButton deleteBtn = new JButton("Delete");
        deletePanel.add(new JLabel("Delete"));
        deletePanel.add(deleteProductField);
        deletePanel.add(deleteBtn);

        searchEditDelete.add(searchPanel);
        searchEditDelete.add(editPanel);
        searchEditDelete.add(deletePanel);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(productArea), BorderLayout.CENTER);
        panel.add(searchEditDelete, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> {
            try {
                String name = productNameField.getText().trim();
                double price = Double.parseDouble(productPriceField.getText());
                products.add(new Product(name, price));
                productNameField.setText("");
                productPriceField.setText("");
                updateStats();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Λάθος τιμή!", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
            }
        });

        listBtn.addActionListener(e -> {
            productArea.setText("");
            int i = 1;
            for (Product p : products) {
                productArea.append(i++ + ". " + p + "\n");
            }
        });

        saveBtn.addActionListener(e -> saveToFile());

        searchBtn.addActionListener(e -> {
            String keyword = searchProductField.getText().trim().toLowerCase();
            productArea.setText("");
            int i = 1;
            for (Product p : products) {
                if (p.getName().toLowerCase().contains(keyword)) {
                    productArea.append(i++ + ". " + p + "\n");
                }
            }
        });

        editBtn.addActionListener(e -> {
            String name = editProductField.getText().trim();
            try {
                double newPrice = Double.parseDouble(editProductPriceField.getText());
                for (Product p : products) {
                    if (p.getName().equalsIgnoreCase(name)) {
                        String newName = JOptionPane.showInputDialog(this, "New name:", p.getName());
                        if (newName != null) {
                            p.setName(newName);
                            p.setPrice(newPrice);
                            updateStats();
                            break;
                        }
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Λάθος νέα τιμή!", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
            }
        });

        deleteBtn.addActionListener(e -> {
            String name = deleteProductField.getText().trim();
            products.removeIf(p -> p.getName().equalsIgnoreCase(name));
            updateStats();
        });

        return panel;
    }

    private JPanel createStatisticsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        statsArea = new JTextArea();
        statsArea.setEditable(false);
        panel.add(new JScrollPane(statsArea), BorderLayout.CENTER);
        return panel;
    }

    private void updateStats() {
        statsArea.setText("");
        statsArea.append(" Analytics:\n");
        statsArea.append("Customers: " + customers.size() + "\n");
        statsArea.append("Products: " + products.size() + "\n");

        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }

        double average = 0;
        if (products.size() > 0) {
            average = total / products.size();
        }

        statsArea.append("Average Product Price: " + String.format("%.2f", average) + " Euros\n");
    }

    private void saveToFile() {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setDialogTitle("Choose a file for Customer saving");
        int customerChoice = fileChooser.showSaveDialog(this);
        if (customerChoice == JFileChooser.APPROVE_OPTION) {
            File customerFile = fileChooser.getSelectedFile();
            try (PrintWriter writer = new PrintWriter(customerFile)) {
                for (Customer c : customers) {
                    writer.println(c.toFileLine());
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error during saving.", "Try Again", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        fileChooser.setDialogTitle("Choose a file for Product saving");
        int productChoice = fileChooser.showSaveDialog(this);
        if (productChoice == JFileChooser.APPROVE_OPTION) {
            File productFile = fileChooser.getSelectedFile();
            try (PrintWriter writer = new PrintWriter(productFile)) {
                for (Product p : products) {
                    writer.println(p.toFileline());
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error during saving.", "Try Again", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void LoadFromFile() {
    	 JFileChooser fileChooser = new JFileChooser();
    	 
    	    fileChooser.setDialogTitle("Choose customer file to load");
    	    int customerChoice = fileChooser.showOpenDialog(this);
    	    if (customerChoice == JFileChooser.APPROVE_OPTION) {
    	        File customerFile = fileChooser.getSelectedFile();
    	        try (BufferedReader reader = new BufferedReader(new FileReader(customerFile))) {
    	            String line;
    	            customers.clear();
    	            while ((line = reader.readLine()) != null) {
    	                customers.add(Customer.fromFileLine(line));
    	            }
    	        } catch (IOException e) {
    	            JOptionPane.showMessageDialog(this, "Error;/", "Try Again", JOptionPane.ERROR_MESSAGE);
    	        }
    	    }


    	    fileChooser.setDialogTitle("Choose product file to load");
    	    int productChoice = fileChooser.showOpenDialog(this);
    	    if (productChoice == JFileChooser.APPROVE_OPTION) {
    	        File productFile = fileChooser.getSelectedFile();
    	        try (BufferedReader reader = new BufferedReader(new FileReader(productFile))) {
    	            String line;
    	            products.clear();
    	            while ((line = reader.readLine()) != null) {
    	                products.add(Product.fromFileLine(line));
    	            }
    	        } catch (IOException e) {
    	            JOptionPane.showMessageDialog(this, "Error:/", "Try Again", JOptionPane.ERROR_MESSAGE);
    	        }
    	    }

    	    updateStats();
    }   
    
}
