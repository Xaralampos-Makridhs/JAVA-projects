package student_app;

import java.awt.*;
import javax.swing.*;


public class StudentAppGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	StudentManager manager=new StudentManager();
	private JTextField nameField,gradeField,idField;

	private JTextArea displayArea;
	
	public StudentAppGUI() {
		setTitle("Student Managment System");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel inputpanel=new JPanel();
		
		JLabel nameLabel=new JLabel("Name: ");
		inputpanel.add(nameLabel);
		nameField=new JTextField(10);
		inputpanel.add(nameField);
		
		JLabel idLabel=new JLabel("ID: ");
		idField=new JTextField(10);
		inputpanel.add(idLabel);
		inputpanel.add(idField);
		
		JLabel gradeLabel=new JLabel("Grade: ");
		gradeField=new JTextField();
		inputpanel.add(gradeLabel);
		inputpanel.add(gradeField);
	
		JButton addBtn=new JButton("Add");
		
		displayArea.setEditable(false);
	
		JScrollPane scroll=new JScrollPane(displayArea);
		
		JPanel buttonPanel=new JPanel();
		
		JButton saveBtn=new JButton("Save");
		JButton loadBtn=new JButton("Load");
		JButton avgBtn=new JButton("Average");
		buttonPanel.add(saveBtn);
		buttonPanel.add(loadBtn);
		buttonPanel.add(avgBtn);
		
		add(inputpanel,BorderLayout.NORTH);
		add(scroll,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		
		addBtn.addActionListener(e->addStudent());
		saveBtn.addActionListener(e->saveToFile());
		loadBtn.addActionListener(e->loadFromFile());
		avgBtn.addActionListener(e->showAverage());
		
		pack();
		setVisible(true);
		
	}
	
	private void addStudent() {
		try {
			String name=nameField.getText();
			String id=idField.getText();
			double grade=Double.parseDouble(gradeField.getText());
			Student s=new Student(name,id,grade);
			manager.addStudent(s);
			displayArea.append(s.toFileString()+"\n");
			nameField.setText("");
			idField.setText("");
			gradeField.setText("");
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(this,"Invalid Input");
		}
	}
	
	private void saveToFile() {
		try {
			manager.SavetoFile("students.txt");
			JOptionPane.showMessageDialog(this,"Saved to File: students.txt");
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(this,"Error Saving File");
		}
	}
	
	
	private void loadFromFile() {
		try {
			manager.loadFromFile("students.txt");
			displayArea.setText("");
			for(Student s: manager.getStudents()) {
				displayArea.setText(s.toString()+"\n");
			}	
			}catch(Exception e) {
				JOptionPane.showMessageDialog(this,"Error Loading File");	
		}
	}
	
	private void showAverage() {
		double avg=Double.parseDouble(gradeField.getText());
		manager.getAverage();
		JOptionPane.showMessageDialog(this,"Average"+avg);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
