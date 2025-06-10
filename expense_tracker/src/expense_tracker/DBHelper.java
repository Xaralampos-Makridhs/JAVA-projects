package expense_tracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	//make sure you have created the database in phpmyadmin or in Heidi SQL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/expenses_java";
    private static final String USER = "root";
    private static final String PASS = "";//your password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
