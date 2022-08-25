package ru.geekbrains.lesson2.linkedList;


public class MainApp2 {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.insertFirst("1");
        linkedList.insertLast("2");
        linkedList.insertLast("3");
        linkedList.insertLast("4");
        linkedList.insert(1, "5");
        System.out.println(linkedList.toString());

        linkedList.insert(3, "555");
        System.out.println(linkedList.toString());

        linkedList.insert(5, "!!!");
        System.out.println(linkedList.toString());

        linkedList.removeFirst();
        System.out.println(linkedList.toString());

        linkedList.removeLast();
        System.out.println(linkedList.toString());

        linkedList.remove("!!!");
        System.out.println(linkedList.toString());

        System.out.println(linkedList.indexOf("!!!"));
    }
}
