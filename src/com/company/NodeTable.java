package com.company;

public class NodeTable {//класс для (первого толбика балицы) разбития всех слов по критериям(в моём случае я беру первую букву из слова)
	private char value;//критерий
	private Node first;//ссылка на первое слово
	private NodeTable nextTable;//ссылка на следующий критерий
	
	NodeTable(NodeTable nextTable,Node next, String value){//конструктор
		this.nextTable = nextTable;
		this.value = value.charAt(0);
		this.first = next;
	}
	
	public void getAll(){//выводим все слова по критерию
		if (first != null){
			for (Node node = first; node != null; node = node.getNext()){
				System.out.print(node.getValue() + " ");
			}
			System.out.println();
		}
	}
	
	public Node getFirst() {
		return first;
	}
	
	public void setFirst(Node first) {
		this.first = first;
	}
	
	public NodeTable getNextTable() {
		return nextTable;
	}
	
	public void setNextTable(NodeTable nextTable) {
		this.nextTable = nextTable;
	}
	
	public char getValue() {
		return value;
	}
	
	public void setValue(char value) {
		this.value = value;
	}
}
