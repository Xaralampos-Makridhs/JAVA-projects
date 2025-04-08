package inventory;
import java.time.LocalDateTime;
import java.time.format.*;


public class Order {
	public enum OrderType{
		PURCHASE,RESTOCK;
	}
	private Product product;
	private int quantity;
	private OrderType type;
	private LocalDateTime timestamp;
	
	public Order(Product product, int quantity, OrderType type) {
		this.product = product;
		this.quantity = quantity;
		this.type = type;
		this.timestamp=LocalDateTime.now();
		
		processOrder();
	}
	
	private void processOrder() {
		if(type==OrderType.RESTOCK){
			product.addStock(quantity);
			System.out.println("Product restocked succesfully!");
		}else if(type==OrderType.PURCHASE) {
			boolean success=product.sell(quantity);
			if(!success) {
				System.out.println("Ιnsufficient stock");
			}
			
		}
	}
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return "["+formatter.format(timestamp)+"]"+
				(type==OrderType.RESTOCK?"RESTOCK":"PURCHASE")+": "+
				quantity+"x"+product.getName()+
				"(Stock: "+product.getStock()+")";
	}	
	
}
