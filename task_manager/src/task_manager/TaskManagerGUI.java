package task_manager;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;


public class TaskManagerGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private TaskManager manager;
	private DefaultListModel<Task> listModel;
	private JList<Task> taskList;
	private JTextField titleField;
	private JTextField categoryField;
	
	public TaskManagerGUI(TaskManager manager) {
		this.manager=manager;
		setTitle("Task Manager");
		setSize(400,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		initComponents();
		setVisible(true);
	}
	
	private void initComponents() {
		listModel=new DefaultListModel<>();
		taskList=new JList<>(listModel);
		JScrollPane scrollPane=new JScrollPane(taskList);
		
		JPanel inputPanel=new JPanel(new GridLayout(2,2));
		titleField=new JTextField();
		categoryField=new JTextField();
		
		inputPanel.add(new JLabel("Title: "));
		inputPanel.add(titleField);
		inputPanel.add(new JLabel("Category: "));
		inputPanel.add(categoryField);
		
		JButton addButton=new JButton("Insert");
		addButton.addActionListener(e-> {
			try {
				addTask();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		JButton deleteButton=new JButton("Delete");
		deleteButton.addActionListener(e-> {
			try {
				deleteTask();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		
		JButton toggleButton=new JButton("Toggle");
		toggleButton.addActionListener(e-> {
			try {
				toggleTask();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		JPanel buttonPanel=new JPanel(new GridLayout(1,3));
		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(toggleButton);
		
		add(inputPanel,BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		refreshList();
	}
	
	
	private void addTask() throws SQLException {
		String title=titleField.getText();
		String category=categoryField.getText();
		
		if(!title.isEmpty()) {
			Task task=new Task(title,category);
			manager.addTask(task);
			refreshList();
			titleField.setText("");
			categoryField.setText("");
		}
	}
	
	private void deleteTask() throws SQLException {
		int index=taskList.getSelectedIndex();
		manager.deleteTask(index);
		refreshList();
	}
	
	private void toggleTask() throws SQLException {
		int index=taskList.getSelectedIndex();
		manager.toggleTaskComplete(index);
		refreshList();
	}
	
	private void refreshList() {
		listModel.clear();
		for(Task t:manager.getTasks()) {
			listModel.addElement(t);
		}
	}
}
