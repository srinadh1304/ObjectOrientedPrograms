package com.bridgelabz.stockaccount;

import java.util.Scanner;
import com.bridgelabz.datastructures.*;
public class StockPortfolio {
	private MyLinkedList<Stock> stocksList = new MyLinkedList<Stock>();
	private double totalValue;

	public void readStocks() {
		System.out.println("Enter the number of stocks");
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for(int i=0;i<count;i++) {
			System.out.println("enter the name of stock");
			String name = sc.next();
			System.out.println("Enter the number of shares");
			int numOfShares = sc.nextInt();
			System.out.println("Enter the price of one share");
			double price = sc.nextDouble();
			Stock stock = new Stock(name,numOfShares,price);
			MyNode<Stock> myStockNode = new MyNode<Stock>(stock);
			stocksList.append(myStockNode);
		}
	}

	public void calculateValues() {
		MyNode<Stock> tempNode = (MyNode<Stock>) stocksList.head;

		while(tempNode != null) {
			int numberOfShares = tempNode.getKey().getNumberOfShares();
			double price = tempNode.getKey().getSharePrice();
			tempNode.getKey().setValue(numberOfShares*price);
			totalValue += numberOfShares*price;
			tempNode = (MyNode<Stock>)tempNode.getNext();
		}
		System.out.println("Calculated share values");
	}

	public void display() {
		System.out.println("**** The stock report ****");
		System.out.println("The total value is : "+ this.totalValue);
		stocksList.display();
	}
}