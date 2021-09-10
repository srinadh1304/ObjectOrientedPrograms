package com.bridgelabz.inventorymanagement;
import com.bridgelabz.datastructures.*;

public class InventoryNode implements INode<Inventory> {
	Inventory key;
	InventoryNode next;
	
	public InventoryNode(Inventory key) {
		this.key = key;
		next = null;
	}

	@Override
	public Inventory getKey() {
		return this.key;
	}

	@Override
	public INode<Inventory> getNext() {
		return this.next;
	}

	@Override
	public void setKey(Inventory key) {
		this.key = key;
	}

	@Override
	public void setNext(INode<Inventory> next) {
		this.next =(InventoryNode) next;
	}
}