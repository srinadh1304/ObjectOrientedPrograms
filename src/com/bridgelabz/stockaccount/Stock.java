package com.bridgelabz.stockaccount;

public class Stock {
	private String name;
	private int numberOfShares;
	private double sharePrice;
	private double value;
	
	public Stock(String name, int numberOfShares, double sharePrice) {
		this.setName(name);
		this.setNumberOfShares(numberOfShares);
		this.setSharePrice(sharePrice);
		this.setValue(0);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	@Override 
	public String toString() {
		return "{ name : "+this.name+" numberOfShares : "+ this.numberOfShares+" SharePrice : "+ this.sharePrice+((this.value == 0)?" }":" value : "+this.value+" }");
	}
	
}
