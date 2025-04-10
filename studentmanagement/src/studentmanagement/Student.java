package studentmanagement;
import java.io.Serializable;

public class Student implements Serializable {
	private int gender;
	private String name;
	private String address;
	private String mobile;
	private String email;
	private String semester;
	
	
	public Student(int gender, String name, String address, String mobile, String email,String semester) {
		this.gender = gender;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.semester=semester;
	}
	@Override
	public String toString() {
		if(gender==1) {
			return "Κος,"+name+"\n"+"Φοιτητης,"+semester+"'"+"Εξαμήνου"+"\n"+address+"\n"+"Τηλ:"+mobile+"\n"+email;
		}else {
			return "Κα,"+name+"\n"+"Φοιτητρια,"+semester+"'"+"Εξαμήνου"+"\n"+address+"\n"+"Τηλ:"+mobile+"\n"+email;
		}
	}
}
