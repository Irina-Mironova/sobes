package ru.geekbrains.lesson1.fugures;

public class Circle extends Figure {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "круг";
    }

    @Override
    public float getPerimetr() {
        return (float) (2 * radius * 3.14);
    }

}
