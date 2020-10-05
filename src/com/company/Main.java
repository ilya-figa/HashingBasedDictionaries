package com.company;

public class Main {

    public static void main(String[] args) {
        MyLinkedList MyTableList = new MyLinkedList("Привет", "Сегодня","привет","угадай","Завтра","Приветули","Завтрак","приветули");
        System.out.println("Просто словарь");
        MyTableList.getAll();
        System.out.println("Добавляем элементы");
        MyTableList.add("удалить");//вставка
        MyTableList.add("Удалить");
        MyTableList.getAll();
        System.out.println("Удаляем элементы из конца");
        MyTableList.delete("Удалить");
        MyTableList.getAll();
        System.out.println("Ищем элементы удалить и Удалить");
        MyTableList.search("удалить");
        MyTableList.search("Удалить");
        System.out.println("Удаляем элементы из середины");
        MyTableList.delete("Завтрак");
        MyTableList.getAll();
    }
}
