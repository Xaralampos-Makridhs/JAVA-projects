package studentmanagement;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;




public class DataInputGui extends JFrame  {
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem printItem,exitItem,newItem;
	private ButtonGroup sex;
	private JRadioButton male,female;
	private JTextField tf1,tf2,tf3,tf4;
	private JLabel lb1,lb2,lb3,lb4,lb5;
	private JButton bt1,bt2;
	private JComboBox<String> ch; 
	
	private ArrayList<Student> db;
	private StudentsFileHandler filehandler;
	
	public DataInputGui() throws IOException,ClassNotFoundException{
		super("Data Input");
		makeFrame();
		filehandler=new StudentsFileHandler();
		if(filehandler.readFromBinaryFile()!=null) {
			db=filehandler.readFromBinaryFile();
		}else {
			db=new ArrayList<Student>();
		}
	}
	
	public void makeFrame() {
		Container contentpane=getContentPane();
		contentpane.setLayout(new BorderLayout());
		
		Font f;
		String s="";
		
		menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		fileMenu=new JMenu("File");
		menuBar.add(fileMenu);
		newItem=new JMenuItem("New");
		newItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fillIn();
			}
			});
		
		
		fileMenu.add(newItem);
		printItem=new JMenuItem("Print");
		printItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					filehandler.readFromTextFile();
				}catch(IOException ev)
				{
				
				}
			}
		});
		fileMenu.add(printItem);
		
		fileMenu.add(printItem);
		exitItem=new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					filehandler.writeToBinaryFile(db);
					setVisible(true);
					dispose();
				}catch(IOException ev) {
					
				}
			}
		});
		
		fileMenu.add(exitItem);
		
		JPanel northPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		sex=new ButtonGroup();
		male=new JRadioButton(" male",true);
		female=new JRadioButton(" female",false);
		sex.add(male);
		sex.add(female);
		northPanel.add(male);
		northPanel.add(female);
		contentpane.add(northPanel,BorderLayout.NORTH);
		
		
		JPanel westPanel=new JPanel(new GridLayout(0,1,5,10));
		lb1=new JLabel("Surname*:");
		lb1.setForeground(Color.blue);
		westPanel.add(lb1);
		lb2=new JLabel("Address:");
		westPanel.add(lb2);
		lb3=new JLabel("Mobile:");
		westPanel.add(lb3);
		lb4=new JLabel("Email*:");
		lb4.setForeground(Color.blue);
		westPanel.add(lb4);
		lb5=new JLabel("Semester:");
		westPanel.add(lb5);
		contentpane.add(westPanel,BorderLayout.WEST);
		
		JPanel centerPanel=new JPanel(new GridLayout(0,1,5,10));
		tf1=new JTextField(15);
		centerPanel.add(tf1);
		tf2=new JTextField(15);
		centerPanel.add(tf2);
		tf3=new JTextField(15);
		centerPanel.add(tf3);
		tf4=new JTextField(15);
		centerPanel.add(tf4);
		
		ch=new JComboBox<String>();
		
		ch.addItem(" 1");
		ch.addItem(" 2");
		ch.addItem(" 3");
		ch.addItem(" 4");
		ch.addItem(" 5");
		ch.addItem(" 6");
		ch.addItem(" 7");
		ch.addItem(" 8");
		ch.setSelectedIndex(7);
		centerPanel.add(ch);
		contentpane.add(centerPanel,BorderLayout.CENTER);
		
		JPanel southPanel=new JPanel(new FlowLayout());
		bt1=new JButton("SAVE");
		f=new Font("TimesRoman", Font.BOLD, 15);
		bt1.setFont(f);
		bt1.setBackground(Color.green);
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillIn();
			}
		});
		
		bt2=new JButton(" CANCEL");
		f=new Font("TimesRoman",Font.BOLD,15);
		bt2.setFont(f);
		bt2.setBackground(Color.red);
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		
		southPanel.add(bt1);
		southPanel.add(bt2);
		contentpane.add(southPanel,BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void fillIn() {
		if(tf1.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"You must enter the name!");
			return;
		}
		if(tf2.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"You must enter the address!");
			return;
		}
		if(tf3.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"You must enter the mobile number!");
			return;
		}
		if(tf4.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"You must enter the email!");
			return;
		}
		if(!tf1.getText().equals("") && !tf2.getText().equals("") && !tf3.getText().equals("") && !tf4.getText().equals("")) {
			int sex;
			if(male.isSelected()) {
				sex=1;
			}else {
				sex=2;
			}
			Student aStudent=new Student(sex, tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText(), (String)ch.getSelectedItem());
			db.add(aStudent);
			try {
				filehandler.writeToTextFile(aStudent);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void clear() {
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
	}
}
