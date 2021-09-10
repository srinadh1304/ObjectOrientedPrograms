package com.bridgelabz.dataprocessing;

import java.util.Scanner;	
import com.bridgelabz.datastructures.*;
import java.time.LocalDateTime;


public class StockAccount {
	MyLinkedList<CompanyShare> myShareList;
	Double total ;
	public StockAccount() {
		myShareList =new MyLinkedList<CompanyShare>();
		total = 0.0;
	}
	public void addCompanyShares() {
		System.out.println("Enter the number of CompanyShares");
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for(int i=0;i<count;i++) {
			System.out.println("enter the Stock Symble");
			String symble = sc.next();
			System.out.println("Enter the number of shares");
			int numOfShares = sc.nextInt();
			System.out.println("Enter the price of one share");
			double price = sc.nextDouble();
			CompanyShare stock = new CompanyShare(symble,numOfShares,price);
			MyNode<CompanyShare> myStockNode = new MyNode<CompanyShare>(stock);
			myShareList.append(myStockNode);
			
		}
	}
	
	public double valueOf() {
		MyNode<CompanyShare> tempNode = (MyNode<CompanyShare>) myShareList.head;
		while(tempNode != null) {
			this.total += tempNode.getKey().getValue();
			tempNode = (MyNode<CompanyShare>)tempNode.getNext();
		}
		return this.total;
	}
	
	public void buy(int amount, String symbol) {
		MyNode<CompanyShare> tempNode = (MyNode<CompanyShare>) myShareList.head;
		while(tempNode != null) {
			if(tempNode.getKey().getStockSymbol().equals(symbol)) {
				int currentShares = tempNode.getKey().getNumberOfShare();
				tempNode.getKey().setNumberOfShare(amount+currentShares);
				double value = tempNode.getKey().getPricePerShare() * (amount+currentShares);
				this.total = value;
				tempNode.getKey().setValue(value);
				System.out.println(" added "+amount+" shares to stockSymbol "+symbol+" updated value is "+value);
				return;
			}
			tempNode = (MyNode<CompanyShare>)tempNode.getNext();
		}
		System.out.println("Symbol not found");
	}
	
	public void sell(int amount, String symbol) {
		MyNode<CompanyShare> tempNode = (MyNode<CompanyShare>) myShareList.head;
		while(tempNode != null) {
			if(tempNode.getKey().getStockSymbol().equals(symbol)) {
				int currentShares = tempNode.getKey().getNumberOfShare();
				if(currentShares-amount < 0) {
					System.out.println("There is not enough shares to sell. pls reduce amount!");
					return;
				}
				tempNode.getKey().setNumberOfShare(currentShares-amount);
				double value = tempNode.getKey().getPricePerShare() * (currentShares-amount);
				tempNode.getKey().setValue(value);
				this.total = value;
				System.out.println(" sold "+amount+" shares of stockSymbol "+symbol+" updated value is "+value);
				return;
			}
			tempNode = (MyNode<CompanyShare>)tempNode.getNext();
		}
		System.out.println("Symbol not found");
	}
	
	public void printReport() {
		System.out.println("**** The stock report ****");
		System.out.println("The total value is : "+ this.total);
		myShareList.display();
	}
	
}
