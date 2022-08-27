package ru.geekbrains.lesson3.counter;

public class MainApp2 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        new Thread(new Start(1, counter)).start();
        new Thread(new Start(2, counter)).start();
        new Thread(new Start(3, counter)).start();

    }
}
