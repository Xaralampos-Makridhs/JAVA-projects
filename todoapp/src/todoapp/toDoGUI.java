package todoapp;
import java.util.*;
import java.io.* ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class toDoGUI extends JFrame {
	private DefaultListModel<String> taskListModel;
	private JList<String> tasksList;
	
	private JTextField taskField;
	private TaskManager taskManager;
	
	private JPanel buttonPanel;
	private JButton addButton,removeButton,saveButton,loadButton;
	
	public toDoGUI(TaskManager taskManager) {
		this.taskManager=taskManager;
		
		setTitle("To Do List App");
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		taskField=new JTextField();
		add(taskField, BorderLayout.NORTH);
		
		taskListModel=new DefaultListModel<>();
		tasksList=new JList<>(taskListModel);
		add(new JScrollPane(tasksList),BorderLayout.CENTER);
		
		
		buttonPanel=new JPanel();
		addButton=new JButton("Add");
		removeButton=new JButton("Remove");
		saveButton=new JButton("Save");
		loadButton=new JButton("Load");
		
		buttonPanel.add(addButton);
		buttonPanel.add(removeButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		addButton.addActionListener(e-> addTask());
		removeButton.addActionListener(e-> removeTask());
		saveButton.addActionListener(e-> saveTask());
		loadButton.addActionListener(e-> loadTask());
		
		
		setVisible(true);	
	}
	
	private void addTask() {
		String task=taskField.getText().trim();
		if(!task.isEmpty()) {
			taskManager.addTask(task);
			taskListModel.addElement(task);
			taskField.setText("");
		}
	}
	
	private void removeTask() {
		int selectindex=tasksList.getSelectedIndex();
		if(selectindex!=-1) {
			taskManager.removeTask(selectindex);
			taskListModel.remove(selectindex);
		}
	}
	
	private void saveTask() {
		try {
			taskManager.saveTasks();
			JOptionPane.showMessageDialog(this,"Successfully Saved");
		}catch(IOException ev) {
			JOptionPane.showMessageDialog(this,"Error :/");
		}
	}
	
	private void updateList() {
		taskListModel.clear();
		for(String task:taskManager.getTasks()) {
			taskListModel.addElement(task);
		}
	}
	
	
	private void loadTask() {
		try {
			taskManager.loadTasks();
			updateList();
			JOptionPane.showMessageDialog(this,"Successfully Loaded.");	
		}catch (IOException ev) {
			JOptionPane.showMessageDialog(this,"Error :/");
		}
	}	
}
