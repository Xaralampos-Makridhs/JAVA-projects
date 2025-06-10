package expense_tracker;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;


public class CreateTable {
	public static void createExpensesTable() throws SQLException {
		String sql="""
				CREATE TABLE IF NOT EXISTS expenses(
				id INT AUTO_INCREMENT PRIMARY KEY,
				amount DOUBLE NOT NULL,
				description VARCHAR(255),
				category VARCHAR(100),
				date DATE
				);
				""";
		
		try(Connection conn=DBHelper.getConnection(); Statement 
				stmt=conn.createStatement()){
			stmt.execute(sql);
			System.out.println("Table Created Successfully");
		}catch(SQLException e) {
			System.err.println("Error"+e.getMessage());
		}
	}

}
