package com.bridgelabz.inventorymanagement;

import com.bridgelabz.datastructures.*;
import java.util.Scanner;

public class InventoryManagementMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome to inventory management");
		InventoryManager inventoryManager = new InventoryManager();
		inventoryManager.readInventory();
		System.out.println("entred inventory is");
		inventoryManager.display();
		inventoryManager.ComputeValue();
		inventoryManager.display();

	}

}
