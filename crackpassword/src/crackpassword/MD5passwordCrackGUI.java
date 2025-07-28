package crackpassword;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.security.MessageDigest;

public class MD5passwordCrackGUI extends JFrame {
	private JTextField hashtextField;
	private JButton crackBtn;
	private JTextArea resultArea;
	private JFileChooser fileChooser;
	private JLabel hashLabel;
	
	public MD5passwordCrackGUI() {
		setTitle("CrackPassword");
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		hashLabel=new JLabel("Enter MD5 Hash: ");
		hashtextField=new JTextField(32);
		
		crackBtn=new JButton("Crack");
		
		resultArea=new JTextArea();
		resultArea.setEditable(false);
		JScrollPane scrollPane=new JScrollPane(resultArea);
		
		fileChooser=new JFileChooser();
		
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout(5,5));
		
		panel.add(hashLabel, BorderLayout.WEST);
		panel.add(hashtextField, BorderLayout.CENTER);
		panel.add(crackBtn, BorderLayout.EAST);
		
		add(panel,BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		
		crackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crackBtn.setEnabled(false);
				resultArea.setText("");
				String hashtocrack=hashtextField.getText().trim().toLowerCase();
				if(hashtocrack.length()!=32) {
					JOptionPane.showMessageDialog(null,"Enter a valid hash!");
					crackBtn.setEnabled(true);
					return;
				}
				int catalog=fileChooser.showOpenDialog(MD5passwordCrackGUI.this);
				if(catalog==JFileChooser.APPROVE_OPTION) {
					File file=fileChooser.getSelectedFile();
					new Thread(()-> crackPassword(hashtocrack,file));
				}else {
					crackBtn.setEnabled(true);
				}
			}
		});		
	}
	
	private void crackPassword(String hashtocrack, File file) {
		try(BufferedReader br=new BufferedReader(new FileReader(file))){
			String line;
			while((line =br.readLine())!=null) {
				String candidate=line.trim();
				String MD5candidate=md5(candidate);
				if(MD5candidate.equals(hashtocrack)) {
					final String found=candidate;
					SwingUtilities.invokeLater(()->
					{resultArea.append("Password found "+found+"\n");
					crackBtn.setEnabled(true);
				});
					return;
				}
			}
			SwingUtilities.invokeLater(()->{
				resultArea.append("Password Not Found.");
				crackBtn.setEnabled(true);
			});
		}catch(IOException ex) {
			SwingUtilities.invokeLater(()->{
				resultArea.append("Error reading dictionary file.");
				crackBtn.setEnabled(true);
			});
		}
	}
	
	private String md5(String input) {
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			byte[] bytes=md.digest(input.getBytes());
			StringBuilder sb=new StringBuilder();
			for(byte b:bytes) {
				sb.append(String.format("%02x",b));
			}
			return sb.toString();
		}catch(Exception e) {
			return "";
		}
	}
}
