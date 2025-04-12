package onlinesurvey;

public class Answer {
	private String answertext;
	private Question question;
	
	public Answer(Question question,String answertext) {
		this.answertext = answertext;
		this.question = question;
	}

	public String getAnswertext() {
		return answertext;
	}

	public Question getQuestion() {
		return question;
	}

}
