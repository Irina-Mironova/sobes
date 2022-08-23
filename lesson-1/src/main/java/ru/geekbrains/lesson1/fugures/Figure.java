package ru.geekbrains.lesson1.fugures;

public abstract class Figure {
    protected abstract String getName();

    protected abstract float getPerimetr();

    public void info() {
        System.out.println("Периметр " + getName() + "а:" + getPerimetr());
    }
}
