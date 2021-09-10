package com.bridgelabz.dataprocessing;

import java.util.Scanner;

public class StockAccountMain {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome to stock account management program");
		StockAccount myStocks = new StockAccount();
		myStocks.addCompanyShares();
		myStocks.valueOf();
		boolean flag = true;
		while(flag) {
			System.out.println("Select option 1:buy shares   2:sell shares   3: get Report  4:get value  5:exit");
			int option = sc.nextInt();
			switch(option) {
				case 1:
					System.out.println("enter the amount of share");
					int amount = sc.nextInt();
					System.out.println("enter the stock symbol");
					String symbol = sc.next();
					myStocks.buy(amount, symbol);
					break;
				case 2:
					System.out.println("enter the amount of share");
					int amount1 = sc.nextInt();
					System.out.println("enter the stock symbol");
					String symbol1 = sc.next();
					myStocks.sell(amount1, symbol1);
					break;
				case 3:
					myStocks.printReport();
					break;
				case 4:
					System.out.println("the total value of shares : " +myStocks.valueOf());
					break;
				default:
					flag = false;
					break;	
			}
		}
			
		sc.close();

	}

}
