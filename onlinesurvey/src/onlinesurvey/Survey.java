package onlinesurvey;
import java.util.*;

public class Survey {
	private List<Question> questions;
	private List<Answer> answers;
	
	public Survey() {
		questions=new ArrayList<>();
		answers=new ArrayList<>();
	}
	
	public void addQuestion(String text) {
		questions.add(new Question(text));
	}
	
	public void answerQuestion(int index,String answertext) {
		if(index>=0 && index<questions.size()) {
			answers.add(new Answer(questions.get(index),answertext));
		}
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public List<Answer> getAnswers() {
		return answers;
	}
}
