package com.bridgelabz.inventorymanagement;

import com.bridgelabz.datastructures.*;

public class InventoryManager {
	MyLinkedList<Inventory> inventoryList;
	
	public void readInventory() {
		InventoryFactory inventoryFactory = new InventoryFactory();
		this.inventoryList =  inventoryFactory.addInventories();			
	}
	
	public void ComputeValue() {
		InventoryNode tempNode = (InventoryNode) inventoryList.head;
		while(tempNode != null) {
			Inventory current = tempNode.getKey();
			current.setValue(current.getPrice()*current.getWeight());
			tempNode = (InventoryNode)tempNode.getNext();
		}
		System.out.println("Successfully computed values of each Inventory");
	}
	
	public void display() {
		inventoryList.display();
	}
}