package erp_project;

public class Product {
	private String name;
	private double price;
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String toString() {
		return name + "-" + price + " €";
	}
	
	public String toFileline() {
		return name + ";" + price;
	}
	
	public static Product fromFileLine(String line) {
		String parts[]= line.split(";");
		
		if(parts.length!=2) {
			throw new IllegalArgumentException("Invalid Line:"+line);
		}
		
		try {
			String name=parts[0];
			double price=Double.parseDouble(parts[1]);
			return new Product(name,price);
		}catch(NumberFormatException e) {
			throw new IllegalArgumentException("Invalid price:"+parts[1]);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
