package morsecodetranslator;
import javax.swing.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(()->{
			new MorseCodeGUI().setVisible(true);
		});
	}
}
