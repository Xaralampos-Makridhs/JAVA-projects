package hotels;

public class Reservation {
	protected int days;

	public Reservation(int days) {
		this.days = days;
	}
	
	public int calculateCost() {
		return 120*days;
	}
}
