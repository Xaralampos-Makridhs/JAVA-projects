package erp_project;

import javax.swing.*;
import java.awt.*;
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

        JPanel searchPanel = new JPanel();
        searchCustomerField = new JTextField(10);
        JButton searchBtn = new JButton("Search");
        searchPanel.add(new JLabel("Search"));
        searchPanel.add(searchCustomerField);
        searchPanel.add(searchBtn);

        JPanel editPanel = new JPanel();
        editCustomerField = new JTextField(10);
        JButton editBtn = new JButton("Edit");
        editPanel.add(new JLabel("Edit"));
        editPanel.add(editCustomerField);
        editPanel.add(editBtn);

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
                customerArea.setText("No customers found.");
            } else {
                int i = 1;
                for (Customer c : customers) {
                    customerArea.append(i++ + ". " + c + "\n");
                }
            }
        });

        saveBtn.addActionListener(e -> saveCustomersToFile());

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
            String newName = JOptionPane.showInputDialog(this, "Enter new name:");
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
            boolean removed = customers.removeIf(c -> c.getName().equalsIgnoreCase(name));
            if (removed) {
                deleteCustomerField.setText("");
                updateStats();
                customerArea.setText("Customer deleted.");
            } else {
                customerArea.setText("No customer found with that name.");
            }
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

        JPanel searchPanel = new JPanel();
        searchProductField = new JTextField(10);
        JButton searchBtn = new JButton("Search");
        searchPanel.add(new JLabel("Search"));
        searchPanel.add(searchProductField);
        searchPanel.add(searchBtn);

        JPanel editPanel = new JPanel();
        editProductField = new JTextField(10);
        editProductPriceField = new JTextField(10);
        JButton editBtn = new JButton("Edit");
        editPanel.add(new JLabel("Edit Name"));
        editPanel.add(editProductField);
        editPanel.add(new JLabel("New Price:"));
        editPanel.add(editProductPriceField);
        editPanel.add(editBtn);

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
                JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        listBtn.addActionListener(e -> {
            productArea.setText("");
            int i = 1;
            for (Product p : products) {
                productArea.append(i++ + ". " + p + "\n");
            }
        });

        saveBtn.addActionListener(e -> saveProductsToFile());

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
                JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        deleteBtn.addActionListener(e -> {
            String name = deleteProductField.getText().trim();
            boolean removed = products.removeIf(p -> p.getName().equalsIgnoreCase(name));
            if (removed) {
                deleteProductField.setText("");
                updateStats();
                productArea.setText("Product deleted.");
            } else {
                productArea.setText("No product found with that name.");
            }
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
        statsArea.append("Statistics:\n");
        statsArea.append("Customers: " + customers.size() + "\n");
        statsArea.append("Products: " + products.size() + "\n");

        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }

        double average = products.isEmpty() ? 0 : total / products.size();
        statsArea.append("Average Product Price: " + String.format("%.2f", average) + " Euros\n");
    }

    private void saveCustomersToFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a file to save Customers");
        int choice = fileChooser.showSaveDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (PrintWriter writer = new PrintWriter(file)) {
                for (Customer c : customers) {
                    writer.println(c.toFileLine());
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving customers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveProductsToFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a file to save Products");
        int choice = fileChooser.showSaveDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (PrintWriter writer = new PrintWriter(file)) {
                for (Product p : products) {
                    writer.println(p.toFileline());
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving products.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
