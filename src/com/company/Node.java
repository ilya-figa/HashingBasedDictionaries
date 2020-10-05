package com.company;

public class Node {//класс для слов
	private String value;//слово
	private Node next;//ссылка на следующее слово
	
	Node(Node next, String value){//конструктор
		this.next = next;
		this.value = value;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
