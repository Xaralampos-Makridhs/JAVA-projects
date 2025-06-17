package task_manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java .sql.SQLException;


public class DBHelper {
	private static final String URL="jdbc:mysql://localhost:3306/tasks";
	private static final String USER="root";
	private static final String PASS="";//enter your own password
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL,USER,PASS);
	}
	
}
