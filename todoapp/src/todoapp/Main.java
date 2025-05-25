package todoapp;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(()->{
			TaskManager taskManager=new TaskManager();
			new toDoGUI(taskManager);
		});
		
		
		

	}

}
