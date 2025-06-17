package task_manager;
import java.sql.*;
import java.util.*;


public class TaskManager {
	private List<Task> tasks;
	
	public TaskManager() {
		tasks=new ArrayList<>();
	}
	
	public List<Task> getTasks(){
		return tasks;
	}
	
	public void addTask(Task task) throws SQLException {
		try(Connection conn=DBHelper.getConnection()){
			String sql="INSERT INTO task_table(title,category,completed) VALUES (?,?,?)";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, task.getTitle());
			stmt.setString(2, task.getCategory());
			stmt.setBoolean(3, task.isCompleted());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		loadTasks();
	}
	
	public void deleteTask(int index) throws SQLException {
		if(index>=0 && index<tasks.size()) {
			int id=getTaskID(tasks.get(index));
			try(Connection conn=DBHelper.getConnection()){
				String sql="DELETE FROM task_table WHERE id=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, id);
				stmt.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			loadTasks();
		}
	}
	
	public void toggleTaskComplete(int index) throws SQLException {
		if(index>=0 && index<tasks.size()) {
			Task task=tasks.get(index);
			boolean newStatus=!task.isCompleted();
			int id=getTaskID(task);
			
			try(Connection conn=DBHelper.getConnection()){
				String sql="UPDATE task_table SET completed=? WHERE id=?";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setBoolean(1,newStatus);
				stmt.setInt(2, id);
				stmt.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			loadTasks();
		}
	}
	
	public void loadTasks() throws SQLException {
		tasks.clear();
		
		try(Connection conn=DBHelper.getConnection()){
			String sql="SELECT * FROM task_table";
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				Task task=new Task(rs.getString("title"), rs.getString("category"));
				task.setCompleted(rs.getBoolean("completed"));
				tasks.add(task);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private int getTaskID(Task task) throws SQLException {
		try(Connection conn=DBHelper.getConnection()){
			String sql="SELECT id FROM task_table WHERE title=? AND category=? AND completed=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, task.getTitle());
			stmt.setString(2, task.getCategory());
			stmt.setBoolean(3, task.isCompleted());
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("id");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}		
}
