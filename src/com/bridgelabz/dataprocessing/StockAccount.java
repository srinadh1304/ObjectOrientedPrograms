package com.bridgelabz.dataprocessing;

import java.util.Scanner;	
import com.bridgelabz.datastructures.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;  

public class StockAccount {
	MyLinkedList<CompanyShare> myShareList;
	MyStack<String> purchasedStack = new MyStack<String>();
	MyStack<String> soldStack = new MyStack<String>();
	MyQueue<String> transactionQueue = new MyQueue<String>();
	Double total ;
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	public StockAccount() {
		myShareList =new MyLinkedList<CompanyShare>();
		total = 0.0;
	}
	public void addCompanyShares() {
		System.out.println("Enter the number of CompanyShares");
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for(int i=0;i<count;i++) {
			System.out.println("enter the Stock Symbol");
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
	
	public void removeCompanyShares(String symbol) {
		Scanner sc = new Scanner(System.in);
		MyNode<CompanyShare> tempNode = (MyNode<CompanyShare>) myShareList.head;
		while(tempNode != null) {
			String currentSymbol = tempNode.getKey().getStockSymbol();
			if(currentSymbol.equals(symbol)) {
				myShareList.delete(tempNode.getKey());
				System.out.println("deleted Company share with symbol : "+tempNode.getKey().getStockSymbol());
				return;
			}
			tempNode = (MyNode<CompanyShare>)tempNode.getNext();
		}
		System.out.println("CompanyShare with symbol "+symbol+" is not found");
	}
	public double valueOf() {
		this.total = 0.0;
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
				purchasedStack.push(symbol);
				System.out.println(" added "+amount+" shares to stockSymbol "+symbol+" updated value is "+value);
				tempNode.getKey().setDateTime(LocalDateTime.now());
				transactionQueue.enqueue(LocalDateTime.now().format(format).toString());
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
				soldStack.push(symbol);
				System.out.println(" sold "+amount+" shares of stockSymbol "+symbol+" updated value is "+value);
				tempNode.getKey().setDateTime(LocalDateTime.now());
				transactionQueue.enqueue(LocalDateTime.now().format(format).toString());
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
	
	public void printStacks() {
		System.out.println("The purchased stocks are (Latest first) ");
		MyStack<String> buffer = new MyStack<String>();
		while(!purchasedStack.isEmpty()) {
			String str = purchasedStack.pop();
			buffer.push(str);
			System.out.print(str+" ");
		}
		purchasedStack = new MyStack<String>();
		while(!buffer.isEmpty()) {
			purchasedStack.push(buffer.pop());
		}
		System.out.println();
		buffer = new MyStack<String>();
		System.out.println("The sold stocks are (Latest first) ");
		while(!soldStack.isEmpty()) {
			String str = soldStack.pop();
			buffer.push(str);
			System.out.print(str+" ");
		}
		soldStack = new MyStack<String>();
		while(!buffer.isEmpty()) {
			soldStack.push(buffer.pop());
		}
		System.out.println();
	}
	
	public void printTimeLineQueue() {
		System.out.println(" transactions processed till now");
		MyQueue<String> buffer = new MyQueue<String>();
		while(!transactionQueue.isEmpty()) {
			String str = transactionQueue.dequeue();
			buffer.enqueue(str);
			System.out.print(str + " -- ");
		}
		transactionQueue = new MyQueue<String>();
		while(!buffer.isEmpty()) {
			transactionQueue.enqueue(buffer.dequeue());
		}
		System.out.println();
	}
}