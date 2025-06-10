package expense_tracker;
import java.sql.SQLException;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SwingUtilities.invokeLater(() -> {
	            try {
	                // create table if not exists
	                CreateTable.createExpensesTable();
	            } catch (SQLException e) {
	                System.err.println("Could not create table: " + e.getMessage());
	            }

	            // start GUI
	            new ExpenseTracker();
	        });

	}

}
