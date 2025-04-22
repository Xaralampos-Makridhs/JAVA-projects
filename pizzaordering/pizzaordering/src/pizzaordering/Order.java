package pizzaordering;
import java.util.*;

public class Order {
	private int orderno;
	private String customername;
	private PizzaType pizzatype;
	private List<Topping> toppings;
	private int quantity;
	private double rate;
	private double toppingcost;
	private double totalamount;
	public Order(int orderno, String customername, PizzaType pizzatype, List<Topping> toppings, int quantity,
			double rate, double toppingcost, double totalamount) {
		super();
		this.orderno = orderno;
		this.customername = customername;
		this.pizzatype = pizzatype;
		this.toppings = toppings;
		this.quantity = quantity;
		this.rate = rate;
		this.toppingcost = toppingcost;
		this.totalamount =(rate+toppingcost)*quantity;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public PizzaType getPizzatype() {
		return pizzatype;
	}
	public void setPizzatype(PizzaType pizzatype) {
		this.pizzatype = pizzatype;
	}
	public List<Topping> getToppings() {
		return toppings;
	}
	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getToppingcost() {
		return toppingcost;
	}
	public void setToppingcost(double toppingcost) {
		this.toppingcost = toppingcost;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	
	
	public String toString() {
	  
	    String toppingsList = "";
	    if (toppings.isEmpty()) {
	        toppingsList = "No toppings";
	    } else {
	        for (Topping topping : toppings) {
	            toppingsList += topping.getName() + ", ";
	        }
	        
	        if (!toppings.isEmpty()) {
	            toppingsList = toppingsList.substring(0, toppingsList.length() - 2);
	        }
	    }

	    return "Order Summary:\n" +
	            "-------------------------------\n" +
	            "Order Number: " + orderno + "\n" +
	            "Customer Name: " + customername + "\n" +
	            "Pizza Type: " + pizzatype + "\n" +
	            "Toppings: " + toppingsList + "\n" +
	            "Quantity: " + quantity + "\n" +
	            "Rate: " + String.format("%.2f", rate) + "\n" +
	            "Topping Cost: " + String.format("%.2f", toppingcost) + "\n" +
	            "Total Amount: " + String.format("%.2f", totalamount) + "\n" +
	            "-------------------------------\n";
	}
}
	

