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
			System.out.println("Select 1:add Companyshares   2: remove companyshares   3:buy shares   4:sell shares   5: get Report  6:get value  7:purchased-sold stocks  8:timeline   9:exit");
			int option = sc.nextInt();
			switch(option) {
				case 1:
					myStocks.addCompanyShares();
					myStocks.valueOf();
					break;
				case 2:
					System.out.println("Enter the Share Symbol is remove it");
					myStocks.removeCompanyShares(sc.next());
					myStocks.valueOf();
					break;
				case 3:
					System.out.println("enter the amount of share");
					int amount = sc.nextInt();
					System.out.println("enter the stock symbol	");
					String symbol = sc.next();
					myStocks.buy(amount, symbol);
					myStocks.valueOf();
					break;
				case 4:
					System.out.println("enter the amount of share");
					int amount1 = sc.nextInt();
					System.out.println("enter the stock symbol");
					String symbol1 = sc.next();
					myStocks.sell(amount1, symbol1);
					myStocks.valueOf();
					break;
				case 5:
					myStocks.printReport();
					break;
				case 6:
					System.out.println("the total value of shares : " +myStocks.valueOf());
					break;
				case 7:
					myStocks.printStacks();
					break;
				case 8:
					myStocks.printTimeLineQueue();
					break;
				default:
					flag = false;
					break;	
			}
		}
			
		sc.close();

	}

}
