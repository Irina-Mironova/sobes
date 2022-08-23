package ru.geekbrains.lesson1.fugures;

public class Square extends Figure {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public float getPerimetr() {
        return 4 * side;
    }

    @Override
    public String getName() {
        return "квадрат";
    }
}
