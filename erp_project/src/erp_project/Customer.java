package erp_project;

public class Customer {
	private String name;

	public Customer(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public String toFileLine() {
		return name;
	}
	
	public static Customer fromFileLine(String line) {
		return new Customer(line);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
