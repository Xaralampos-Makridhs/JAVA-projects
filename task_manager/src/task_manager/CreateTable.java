package task_manager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;


public class CreateTable {
	public static void createTaskTable() throws SQLException{
		String sql="""
				CREATE TABLE IF NOT EXISTS task_table(
					id INT AUTO_INCREMENT PRIMARY KEY,
					title VARCHAR(255),
					category VARCHAR(255),
					completed BOOLEAN
				)
				""";
		
		try(Connection conn=DBHelper.getConnection();
			Statement stmt=conn.createStatement();){
			stmt.execute(sql);
			System.out.println("Done");
		}catch(SQLException e) {
			System.out.println("Error"+ e.getMessage());
		}
	}

}
