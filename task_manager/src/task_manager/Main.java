package task_manager;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		
		try {
			CreateTable.createTaskTable();
		}catch(Exception e) {
			System.out.println("DB init Error"+ e.getMessage());
		}
		
		
		
		
		SwingUtilities.invokeLater(()->{
			TaskManager manager=new TaskManager();
			new TaskManagerGUI(manager);
		});

	}

}
