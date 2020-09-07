package com.company;

public class NodeTable {
	char value;
	Node first;
	NodeTable nextTable;
	
	NodeTable(NodeTable nextTable,Node next, String value){
		this.nextTable = nextTable;
		this.value = value.charAt(0);
		this.first = next;
	}
	
	public void getAll(NodeTable nodeTable){
		if (nodeTable.first != null){
			for (Node node = nodeTable.first; node != null; node = node.next){
				System.out.print(node.value + " ");
			}
			System.out.println();
		}
	}
	
	public char getValue() {
		return value;
	}
}
