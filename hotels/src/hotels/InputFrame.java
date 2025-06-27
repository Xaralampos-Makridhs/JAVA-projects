package hotels;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class InputFrame extends JFrame {
	private JPanel panel;
	private JPanel diamonipanel;
	private JPanel allinclusivepanel;
	private JPanel buttonpanel;
	
	private JLabel diamonilabel;
	private JLabel hotellabel;
	private JLabel allinclusivelabel;

	private JList<String> listview;
	private DefaultListModel<String> model;
	
	private JTextField hmeresField;
	private JTextField mealsField;
	private JTextField costField;
	
	private JButton storeButton;
	private JButton calculateButton;
	
	private ArrayList<Hotel> hotels;

	public InputFrame() {
		try {
			FileInputStream fileIn=new FileInputStream("hotels.ser");
			ObjectInputStream in=new ObjectInputStream(fileIn);
			hotels=(ArrayList<Hotel>)in.readObject();
		}catch(IOException exc1) {
			exc1.printStackTrace();
		}catch(ClassNotFoundException exc2) {
			exc2.printStackTrace();
		}
		
		
		panel=new JPanel();
		diamonipanel=new JPanel();
		allinclusivepanel=new JPanel();
		buttonpanel=new JPanel();
		
		listview=new JList<String>();
		model=new DefaultListModel<String>();
		
		Collections.sort(hotels);
		
		for(Hotel h:hotels) {
			model.addElement(h.getName());
		}
		listview.setModel(model);
		
		diamonilabel=new JLabel("Stoixeia Diamonis");
		hotellabel=new JLabel("Hotel");
		allinclusivelabel=new JLabel("All Inclusive");
		
		hmeresField=new JTextField("Hmeres Diamonis");
		mealsField=new JTextField("Plithos gevmatwn(1,2,3)");
		costField=new JTextField("Synoliko kostos");
		
		storeButton=new JButton("Apothikefsi krathshs");
		calculateButton=new JButton("Ypologismos kostous");
		
		diamonipanel.setLayout(new BoxLayout(diamonipanel,BoxLayout.Y_AXIS));
		diamonipanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		diamonipanel.add(diamonilabel);
		hotellabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		diamonipanel.add(hotellabel);
		diamonipanel.add(listview);
		diamonipanel.add(hmeresField);
		diamonipanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		allinclusivepanel.setLayout(new GridLayout(2,0));
		allinclusivepanel.add(allinclusivelabel);
		allinclusivepanel.add(mealsField);
		allinclusivepanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		buttonpanel.setLayout(new GridLayout(2,0));
		buttonpanel.add(storeButton);
		buttonpanel.add(calculateButton);
		buttonpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		ButtonListener listener = new ButtonListener();
		storeButton.addActionListener(listener);
		calculateButton.addActionListener(listener);
	
		panel.add(diamonipanel);
		panel.add(allinclusivepanel);
		panel.add(buttonpanel);
		panel.add(costField);
		
		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(300,300);
		this.setLocation(200,0);
		this.setTitle("Inputs");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String selectedHotelname=listview.getSelectedValue();
			Hotel selectedHotel=null;
			for(Hotel h:hotels) {
				if(h.getName().equals(selectedHotelname)) {
					selectedHotel=h;
					break;
				}
			}
			if(selectedHotel!=null) {
				if(e.getSource().equals(storeButton)) {
					String daysText=hmeresField.getText();
					int days=Integer.parseInt(daysText);
					Reservation r;
					if(mealsField.getText().equals("")) {
						r=new Reservation(days);
					}else {
						int meals=Integer.parseInt(mealsField.getText());
						r=new AllInclusiveRes(days,meals);
					}
					selectedHotel.addRes(r);
				}else {
					int total=selectedHotel.calculateTotalCost();
					costField.setText(Integer.toString(total));
				}
			}else {
				JOptionPane.showMessageDialog(null, "No hotel selected!");
				System.out.println("No hotel selected");
			}
		}
	}	
}
