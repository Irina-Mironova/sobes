package ru.geekbrains.lesson1.car;

interface Moveable {
    //метод move() имеет одинаковую реализацию для классов, можно для сокращения кол-ва кода
    // сделать его дефолтную реализацию:
    //  default void move() {
    //      System.out.println("Car is moving");
    //  }
    void move();
}

interface Stopable {
    void stop();
}

abstract class Car {
    public Engine engine;  // Отсутствует класс Engine
    private String color;  // модификаторы доступа переменных лучше сделать protected
    private String name;

    // необходимо добавить конструктор
//    public Car(Engine engine, String color, String name) {
//        this.engine = engine;
//        this.color = color;
//        this.name = name;
//    }

    protected void start() {   // protected исправить на public
        System.out.println("Car starting");
    }

    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class LightWeightCar extends Car implements Moveable {
    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}

class Lorry extends Car implements Moveable, Stopable {  // ошибка: class Lorry extends Car implements Moveable, Stopable

    public void move() {
        System.out.println("Car is moving");
    }

    public void stop() {
        System.out.println("Car is stop");
    }

    // не реализован метод open:
    // @Override
    // void open() {}
}

