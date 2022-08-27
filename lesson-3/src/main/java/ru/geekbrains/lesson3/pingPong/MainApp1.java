package ru.geekbrains.lesson3.pingPong;

public class MainApp1 {
    private static final Object mon = new Object();
    private static volatile String word = "pong";

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mon) {
                    try {
                        for (int i = 0; i < 10; i++) {
                            while (word.equals("ping")){
                                mon.wait();
                            }
                            System.out.println("ping");
                            word = "ping";
                            mon.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mon) {
                    try {
                        for (int i = 0; i < 10; i++) {
                            while(word.equals("pong")){
                                mon.wait();
                            }
                            System.out.println("pong");
                            word = "pong";
                            mon.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
