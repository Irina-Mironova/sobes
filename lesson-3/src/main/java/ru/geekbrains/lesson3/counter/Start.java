package ru.geekbrains.lesson3.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Start implements Runnable {
    private int number;
    private Lock lock;
    private Counter counter;

    public Start(int number, Counter counter) {
        this.number = number;
        this.lock = new ReentrantLock();
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            lock.lock();
            try {
                counter.increment();
                System.out.println("Поток " + number + ": " + counter.getValue());
            } finally {
                lock.unlock();
            }
        }
    }
}
