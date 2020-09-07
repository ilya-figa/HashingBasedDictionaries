package com.company;

import org.w3c.dom.traversal.NodeFilter;

public class MyLinkedList {
	private int size = 0;
	private NodeTable firstTable;
	
	MyLinkedList(){
	
	}
	
	MyLinkedList(String... values){
		addAll(values);
	}
	
	public void clear(){
		this.firstTable = null;
		this.size = 0;
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return this.size == 0;
	}
	
	public void add(String value){
		if (this.firstTable == null){
			firstTable = new NodeTable(null, new Node(null, value), value);
			this.size++;
		}else{
			boolean check = false;
			for (NodeTable nodeTable = firstTable; nodeTable != null; nodeTable = firstTable.nextTable){
				if (value.charAt(0) == nodeTable.getValue()){
					Node prevElement = new Node(nodeTable.first, value);
					nodeTable.first = prevElement;
					check = true;
					break;
				}
			}
			
			if (!check){
				NodeTable nodeTable = this.firstTable;
				while (nodeTable.nextTable != null){
					nodeTable = nodeTable.nextTable;
				}
				nodeTable.nextTable = new NodeTable(null, new Node(null, value), value);
				this.size++;
			}
		}
	}
	
	public boolean addAll(String... values){
		boolean result = values != null && values.length > 0;
		if(result){
			for(String value : values){
				add(value);
			}
		}
		return result;
	}
	
	public void getAll() {
		if (!isEmpty()) {
			for (NodeTable nodeTable = this.firstTable; nodeTable != null; nodeTable = nodeTable.nextTable){
				System.out.print(nodeTable.value + " = ");
				firstTable.getAll(nodeTable);
			}
			System.out.println();
		}
	}
}
