package com.example;
import java.util.*;

public class Ship {
	private String name;
	private int capacity;
	private ArrayList<Container> containers=new ArrayList<Container>();
	
	
	public Ship(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		
	}
	
	public void addContainer(Container aCon) {
		if(capacity>containers.size()) {
			containers.add(aCon);
		}else {
			System.out.println("Sorry,the ship is full");
		}
	}
	
	public double getTotalCharge() {
		
		double total=0;
		
		for(Container con:containers) {
			total+=con.getCharge();
		}
		return total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
