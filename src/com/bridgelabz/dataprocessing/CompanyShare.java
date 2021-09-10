package com.bridgelabz.dataprocessing;

import java.time.LocalDateTime; 

public class CompanyShare {
	private String stockSymbol;
	private int numberOfShare;
	private double pricePerShare;
	private double value;
	private LocalDateTime dateTime;
	
	public CompanyShare(String stockSimble, int numberOfShare, double pricePerShare){
		this.stockSymbol = stockSimble;
		this.numberOfShare = numberOfShare;
		this.pricePerShare = pricePerShare;
		this.value = numberOfShare*pricePerShare;
		this.setDateTime(LocalDateTime.now());
	}
	
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public int getNumberOfShare() {
		return numberOfShare;
	}
	public void setNumberOfShare(int numberOfShare) {
		this.numberOfShare = numberOfShare;
	}
	public double getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	
	@Override 
	public String toString() {
		return "{ st0ckSymbol : "+this.stockSymbol+" numberOfShares : "+ this.numberOfShare+" pricePerShare : "+ this.pricePerShare+" DateTime : "+
	this.dateTime +((this.value == 0)?" }":" value : "+this.value+" }");
	}
}
