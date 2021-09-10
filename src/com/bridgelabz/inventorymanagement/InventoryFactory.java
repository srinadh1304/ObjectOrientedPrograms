package com.bridgelabz.inventorymanagement;

import java.util.Scanner;

import com.bridgelabz.datastructures.MyLinkedList;

public class InventoryFactory {
	public MyLinkedList addInventories(){
		MyLinkedList<Inventory> inventoryList = new MyLinkedList<Inventory>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of Inventory that you want to add");
		int count  = sc.nextInt();
		
		for(int i=0;i<count;i++) {
			System.out.println("Enter name of inventory");
			String name  = sc.next();
			System.out.println("Enter weight in kg");
			double weight  = sc.nextDouble();
			System.out.println("Enter the price per kg");
			double price = sc.nextDouble();
			Inventory inventory = new Inventory(name, weight, price);
			InventoryNode newNode = new InventoryNode(inventory);
			inventoryList.add(newNode);
		}
		return inventoryList;
	}
}