package com.company;

public class MyLinkedList {
	private int size = 0;//кол слов в словаре
	private NodeTable firstTable;//первый элемент в хеш табл
	
	MyLinkedList(){
	
	}//пустой конструктор
	
	MyLinkedList(String... values){//конструктор для добавления множество слов
		addAll(values);//метод для множественного добавления
	}
	
	public void clear(){//очищаем всю хеш таблицу
		this.firstTable = null;
		this.size = 0;
	}
	
	public int getSize(){//возвращаем количество слов в таблице
		return size;
	}
	
	public boolean isEmpty(){//проверка пустая ли таблица
		return this.size == 0;
	}
	
	public void add(String value){//добавление одного элемента таблицы
		if (this.firstTable == null){
			firstTable = new NodeTable(null, new Node(null, value), value);//если первого элемента нет, то добавлем его
			this.size++;
		}else{
			boolean check = false;
			for (NodeTable nodeTable = firstTable; nodeTable != null; nodeTable = nodeTable.getNextTable()){//если критерий уже есть, то добавляем в него слово
				if (value.charAt(0) == nodeTable.getValue()){
					Node prevElement = new Node(nodeTable.getFirst(), value);
					nodeTable.setFirst(prevElement);
					check = true;
					this.size++;
					break;
				}
			}
			
			if (!check){//если критерия нет, то добавляем критерий, а после в него слово
				NodeTable nodeTable = this.firstTable;
				while (nodeTable.getNextTable() != null){
					nodeTable = nodeTable.getNextTable();
				}
				nodeTable.setNextTable(new NodeTable(null, new Node(null, value), value));
				this.size++;
			}
		}
	}
	
	public boolean addAll(String... values){//метод для множественного добавления
		boolean result = values != null && values.length > 0;//если есть что добавлять, то добавляем
		if(result){
			for(String value : values){
				add(value);//перебираем все элементы и поочередно их добавляем
			}
		}
		return result;
	}
	
	public void search(String searchItem){// поиск
		
		Boolean check = false;
		for (NodeTable nodeTable = firstTable; nodeTable != null; nodeTable = nodeTable.getNextTable()){
			if (nodeTable.getValue() == searchItem.charAt(0)){
				for (Node node = nodeTable.getFirst(); node != null; node = node.getNext()){
					if (node.getValue() == searchItem){
						check = true;
						break;
					}
				}
				break;
			}
		}
		
		if (check){
			System.out.println("there is such a word");
		}else {
			System.out.println("such a word is no");
		}
	}
	
	public void delete(String deleteItem){//удаление
		
		for (NodeTable nodeTable = firstTable; nodeTable != null; nodeTable = nodeTable.getNextTable()){
			if (nodeTable.getValue() == deleteItem.charAt(0)){
				for (Node node = nodeTable.getFirst(); node != null; node = node.getNext()){
					if (node.getValue() == deleteItem){//если находим элемент который нам нужен
						
						if (nodeTable.getFirst() == node && node.getNext() == null){//то проверяем, если этой единсвенное слово в критерии, то удаляем весь критерий
							NodeTable deleteNodeTable = nodeTable;
							for (nodeTable = firstTable; nodeTable != null; nodeTable = nodeTable.getNextTable()){
								if (nodeTable.getNextTable() == deleteNodeTable){
									nodeTable.setNextTable(deleteNodeTable.getNextTable());
								}
							}
						}else{//если не единсвенное, то удаляем одно слово
							if (node == nodeTable.getFirst()){
								nodeTable.setFirst(node.getNext());
							}else {
								Node deleteNode = node;
								for (node = nodeTable.getFirst(); node != null; node = node.getNext()) {
									if (node.getNext() == deleteNode) {
										node.setNext(deleteNode.getNext());
									}
								}
							}
						}
						break;
					}
				}
				break;
			}
		}
	}
	
	public void getAll() {//выводим всё, но выбираем критерий, а после по критерию выводим все слова из него
		if (!isEmpty()) {
			for (NodeTable nodeTable = this.firstTable; nodeTable != null; nodeTable = nodeTable.getNextTable()){
				System.out.print(nodeTable.getValue() + " = ");
				nodeTable.getAll();
			}
			System.out.println();
		}
	}
}
