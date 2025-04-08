package hotels;
import java.util.*;
import java.io.*;

public class Hotel implements Serializable, Comparable<Hotel>{
	private String name;
	private ArrayList<Reservation> reservations=new ArrayList<>();
	
	public Hotel(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
	public void addRes(Reservation r) {
		reservations.add(r);
	}
	
	public int compareTo(Hotel one) {
		return this.name.compareTo(one.name);
	}
	
	public int calculateTotalCost() {
		int total=0;
		for(Reservation r:reservations) {
			total+=r.calculateCost();
		}
		return total;
	}
	
	
	
	
	

}
