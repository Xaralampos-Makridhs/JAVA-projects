package onlinesurvey;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SurveyGUI extends JFrame {
	private Survey survey;
	private JLabel questionLabel;
	private JTextField answerField;
	private int currentquestion=0;
	private JFrame frame;
	private JButton nextButton;
	
	public SurveyGUI(Survey survey){
		this.survey=survey;
		InitializeGUI();
	}
	
	private void InitializeGUI() {
		frame=new JFrame("Online Survey System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(new BorderLayout());
		
		questionLabel=new JLabel("Question:");
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);//centerd horizontal
		
		answerField=new JTextField();
		
		nextButton=new JButton("Next");
		
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitAnswer();
			}
		});
		
		frame.add(questionLabel,BorderLayout.NORTH);
		frame.add(answerField,BorderLayout.CENTER);
		frame.add(nextButton,BorderLayout.SOUTH);
		
		loadQuestion();
		frame.setVisible(true);
		
	}
	
	private void loadQuestion() {
		if(currentquestion<survey.getQuestions().size()) {
			questionLabel.setText(survey.getQuestions().get(currentquestion).getQuestiontext());
			answerField.setText("");
		}else {
			showSummary();
		}
	}
	
	private void submitAnswer() {
		String answer=answerField.getText();
		if(!answer.isEmpty()) {
			survey.answerQuestion(currentquestion,answer);
			currentquestion++;
			loadQuestion();
		}else {
			JOptionPane.showMessageDialog(frame,"Please enter the answer!");
		}
	}
	
	private void showSummary() {
		StringBuilder summary=new StringBuilder("Answers:\n");
		for(Answer a:survey.getAnswers()) {
			summary.append(a.getQuestion().getQuestiontext())
				   .append("----->")
				   .append(a.getAnswertext())
				   .append("\n");
		}
		saveData();
		dispose();
		
	}
	

	private void saveData() {
		JFileChooser fileChooser=new JFileChooser();
		int option=fileChooser.showSaveDialog(this);
		
		if(option==JFileChooser.APPROVE_OPTION) {
			File file=fileChooser.getSelectedFile();
				try(BufferedWriter writer=new BufferedWriter(new FileWriter(file))){
					for(Answer ans:survey.getAnswers()) {
						writer.write("Question: "+ans.getQuestion().getQuestiontext());
						writer.write("\n");
						writer.write("Answer: "+ans.getAnswertext());
						writer.newLine();
						writer.newLine();
					}
					JOptionPane.showInternalMessageDialog(this,"File Saved Succesfully");
				}catch(IOException ev) {
					ev.printStackTrace();
					JOptionPane.showMessageDialog(this,"Error!");
				}
		}
	}
	
	
	


}
