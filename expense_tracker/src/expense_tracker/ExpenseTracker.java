package expense_tracker;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;


public class ExpenseTracker extends JFrame{
	private JTextField amountField,descriptionField,categoryField;
	private JTable table;
	private DefaultTableModel model;
	private JLabel totalLabel;
	
	//connection infos
	private final String DB_URL="jdbc:mysql://localhost:3306/expenses_java";
	private final String USER="root";
	private final String PASS="";//your password
	
	public ExpenseTracker() {
		setTitle("Expense Tracker");
		setSize(700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//insert expenses
		JPanel inputPanel=new JPanel(new GridLayout(5,2,5,5));
		inputPanel.setBorder(BorderFactory.createTitledBorder("New expense"));
		
		amountField=new JTextField();
		descriptionField=new JTextField();
		categoryField=new JTextField();
		
		inputPanel.add(new JLabel("Amount(Euros): "));
		inputPanel.add(amountField);
		inputPanel.add(new JLabel("Description: "));
		inputPanel.add(descriptionField);
		inputPanel.add(new JLabel("Category "));
		inputPanel.add(categoryField);
		
		JButton addBtn=new JButton("Insert");
		
		addBtn.addActionListener(e->{
			try {
				insertExpense();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		
		inputPanel.add(addBtn);
		totalLabel=new JLabel("Total: ");
		inputPanel.add(totalLabel);
		
		add(inputPanel,BorderLayout.NORTH);
		
		//Expense Table
		
		model=new DefaultTableModel(new String[] {"ID","Amount","Description","Category","Date"}, 0);
		table=new JTable(model);
		JScrollPane scrollPane=new JScrollPane(table);
		
		loadExpenses();
		
		setVisible(true);
	}

	
	private void insertExpense() throws SQLException {
		try(Connection conn=DBHelper.getConnection()){
			double amount=Double.parseDouble(amountField.getText());
			String desc=descriptionField.getText();
			String category=categoryField.getText();
			LocalDate date=LocalDate.now();
			
			String sql="INSERT INTO expenses (amount,description,category,date) VALUES (?,?,?,?)";
			PreparedStatement stmt=conn.prepareStatement(sql);
			
			stmt.setDouble(1, amount);
			stmt.setString(2, desc);
			stmt.setString(3, category);
			stmt.setDate(4, Date.valueOf(date));
			stmt.executeUpdate();
			
			amountField.setText("");
			descriptionField.setText("");
			categoryField.setText("");
			
			loadExpenses();
		}catch(Exception e) {
			 JOptionPane.showMessageDialog(this, "Error:/" + e.getMessage());
			
		}
	}
	
    private void loadExpenses() {
        model.setRowCount(0);
        double total = 0.0;

        try (Connection conn = DBHelper.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM expenses ORDER BY date DESC");

            while (rs.next()) {
                int id = rs.getInt("id");
                double amount = rs.getDouble("amount");
                String desc = rs.getString("description");
                String cat = rs.getString("category");
                Date date = rs.getDate("date");

                model.addRow(new Object[]{id, amount, desc, cat, date});
                total += amount;
            }

            totalLabel.setText("Total: " + total + " €");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error:/: " + e.getMessage());
        }
    }
		
	
}
