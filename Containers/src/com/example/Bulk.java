package com.example;

public class Bulk extends Container {
	private double kw;

	public Bulk(String code, String destination, double kw) {
		super(code, destination);
		this.kw = kw;
	}
	
	public double getCharge() {
		return kw*2000;
	}

}
