package student_app;

public class Student {
	private String name;
	private String id;
	private double grade;
	
	public Student(String name, String id, double grade) {
		this.name = name;
		this.id = id;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public double getGrade() {
		return grade;
	}
	
	public String toString() {
		return name+"( "+id+" )"+grade;
	}
	
	public String toFileString() {
		return name+","+id+","+grade;
	}
	
	public static Student FromFileString(String line) {
		String[] parts=line.split(",");
		return new Student(parts[0],parts[1],Double.parseDouble(parts[2]));
	}
}
