package ru.geekbrains.lesson2.arrayList;

public class MainApp1 {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(2);
        list.add(9);
        list.add(7);
        list.add(91);
        System.out.println(list.toString());

        list.add(1,"вставка");
        System.out.println(list.toString());

        list.add("вставкаКонец");
        System.out.println(list.toString());

        list.remove(1);
        System.out.println(list.toString());

        list.clear();
        System.out.println(list.toString());
       }
    }

