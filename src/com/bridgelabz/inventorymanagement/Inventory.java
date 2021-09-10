package com.bridgelabz.inventorymanagement;

public class Inventory {
	private String name;
	private double weight;
	private double price;
	private double value;

	public Inventory(String name, double weight, double price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
		this.value =0;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name; 
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getWeight() {
		return this.weight; 
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return this.price; 
	}

	public void setValue(double value) {
		this.value = value;
	}
	public double getValue() {
		return this.value; 
	}


	@Override
	public String toString() {
		return "Invetory{ name : "+ this.name+", weight : "+this.weight+", price : "+this.price+ ((this.value == 0)?" }":(" value : "+this.value+" }"));
	}

}