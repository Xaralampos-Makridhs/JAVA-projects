package passwrodgeneration;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;


public class GenerationGui extends JFrame {
	private JTextField lengthField;
	private JTextArea resultarea;
	private JLabel lengthlabel;
	private JLabel resultlabel;
	private JButton generateButton;
	private JButton saveButton;
	
	
	public GenerationGui() {
		
		setTitle("Password Generation.");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		JPanel northPanel=new JPanel();
		lengthlabel=new JLabel("Password length");
		lengthField=new JTextField("12",10);
		generateButton=new JButton("Generate");
		generateButton.setBackground(Color.GREEN);
		saveButton=new JButton("SAVE");
		saveButton.setBackground(Color.BLUE);
		northPanel.add(generateButton);
		northPanel.add(lengthlabel);
		northPanel.add(lengthField);
		northPanel.add(saveButton);
		
		
		resultarea=new JTextArea();
		resultarea.setLineWrap(true);
		resultarea.setWrapStyleWord(true);
		JScrollPane scrollPane=new JScrollPane(resultarea);
		add(northPanel,BorderLayout.NORTH);
		add(scrollPane,BorderLayout.CENTER);
	
	
		generateButton.addActionListener(new ActionListener(){
		@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int length=Integer.parseInt(lengthField.getText());
					if(length<8) {
						resultarea.setText("Password Must be at least 8 characters");
					}else {
						String password=PasswordGeneration.generate(length);
						resultarea.setText("Your password is:\n"+password);
					}
				}catch(NumberFormatException ev) {
					resultarea.setText("Please insert a number");
				}
			}
		});
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.setDialogTitle("Save Password");
				int userSel=fileChooser.showSaveDialog(saveButton.getParent());
				
				if(userSel==JFileChooser.APPROVE_OPTION) {
					try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()))){
						writer.write(resultarea.getText());
						JOptionPane.showMessageDialog(saveButton.getParent(),"Password saved succesfully");
					}catch(IOException ev) {
						JOptionPane.showMessageDialog(saveButton.getParent(),"Error!"+ev.getMessage());
					}
				}
				
				
			}
		});
	}
}

