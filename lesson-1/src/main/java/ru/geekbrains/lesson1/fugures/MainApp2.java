package ru.geekbrains.lesson1.fugures;

public class MainApp2 {
    public static void main(String[] args) {
        Figure circle = new Circle(5);
        circle.info();

        Figure square = new Square(4);
        square.info();

        Figure triangle = new Triangle(1, 2, 3);
        triangle.info();
    }
}
