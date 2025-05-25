package morsecodetranslator;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MorseCodeGUI extends JFrame {
	private JTextArea inputText,outputText;
	private JButton toMorseButton,toEnglishButton;
	private JPanel buttonPanel;

	
	public MorseCodeGUI() {
		setTitle("Morse Code Translator");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		inputText=new JTextArea(5,40);
		outputText=new JTextArea(5,40);
		
		outputText.setEditable(false);
		
		toMorseButton=new JButton("Convert to Morse");
		toEnglishButton=new JButton("Convert to English");
		
		buttonPanel=new JPanel();
		buttonPanel.add(toMorseButton);
		buttonPanel.add(toEnglishButton);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(inputText), BorderLayout.NORTH);
		add(new JScrollPane(outputText), BorderLayout.SOUTH);
		
		add(buttonPanel, BorderLayout.CENTER);
		
		toMorseButton.addActionListener(e->{
			String input=inputText.getText();
			String morse=MorseTranslator.toMorse(input);
			outputText.setText(morse);
		});
		
		toEnglishButton.addActionListener(e->{
			String input=inputText.getText();
			String english=MorseTranslator.toEnglish(input);
			outputText.setText(english);
		});		
		
	}
	
}
