package hotels;

public class AllInclusiveRes extends Reservation {
	private int meals;

	public AllInclusiveRes(int days, int meals) {
		super(days);
		this.meals = meals;
	}
	
	public int calculateCost() {
		return days*(120+meals*30);
	}

}
