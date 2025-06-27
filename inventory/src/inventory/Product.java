package inventory;

public class Product {
	private String name;
	private int stock;
	
	public Product(String name, int stock) {
		this.name = name;
		this.stock=stock;
	}
	
	public void addStock(int quantity) {
		stock+=quantity;
	}
	
	public boolean sell(int quantity) {
		if(quantity>stock) {
			System.out.println("Insufficient Stock");
			return false;
		}else {
			stock-=quantity;
			return true;
		}
	}

	public String getName() {
		return name;
	}

	public int getStock() {
		return stock;
	}
	
	@Override
	public String toString() {
		return name+"(Stock: "+stock+")";
	}
}
