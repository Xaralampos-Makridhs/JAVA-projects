package onlinesurvey;

public class Main {

	public static void main(String[] args) {
		Survey mySurvey=new Survey();
		
		mySurvey.addQuestion("What is Java and what are its main characteristics as a programming language?");
		
		new SurveyGUI(mySurvey);

	}

}
