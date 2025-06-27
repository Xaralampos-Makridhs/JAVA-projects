package student_app;
import java.util.*;
import java.io.*;

public class StudentManager {
	private List<Student> students=new ArrayList<>();
	
	public void addStudent(Student aStudent) {
		students.add(aStudent);
	}

	public List<Student> getStudents() {
		return students;
	}
	
	public double getAverage() {
		double sum=0;
		if(students.isEmpty()) {
			return 0.0;
		}else {
			for(Student s:students) {
				sum+=s.getGrade();
			}
		}
		return sum/students.size();
	}
	
	public void SavetoFile(String filename) throws Exception{
		PrintWriter pw=new PrintWriter(filename);
		for(Student s:students) {
			pw.write(s.toFileString());
		}
		pw.close();
	}
	
	public void loadFromFile(String filename) throws IOException{
		students.clear();
		
		BufferedReader br=new BufferedReader(new FileReader(filename));
		String line;
		
		while((line=br.readLine()) != null) {
			students.add(Student.FromFileString(line));
		}
		br.close();
	}
}
