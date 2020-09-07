package com.company;

public class Node {
	String value;
	Node next;
	
	Node(Node next, String value){
		this.next = next;
		this.value = value;
	}
}
