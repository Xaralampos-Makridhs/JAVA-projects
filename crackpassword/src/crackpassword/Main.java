package crackpassword;
import javax.swing.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(()->{
			new MD5passwordCrackGUI().setVisible(true);
		});

	}
}
