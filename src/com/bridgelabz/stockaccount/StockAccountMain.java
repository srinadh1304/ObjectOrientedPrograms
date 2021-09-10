package com.bridgelabz.stockaccount;


import java.util.Scanner;

public class StockAccountMain {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome to stock account management program");
		StockPortfolio myStocks = new StockPortfolio();
		myStocks.readStocks();
		myStocks.calculateValues();
		myStocks.display();
		sc.close();
	}
	
}