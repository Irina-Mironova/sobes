package ru.geekbrains.lesson2.arrayList;

import java.util.Arrays;

public class MyArrayList<T> {

    private final static int CAPACITY_DEFAULT = 10;

    private T[] array;
    private int capacity;
    private int size;

    public MyArrayList() {
        capacity = CAPACITY_DEFAULT;
        this.array = (T[]) new Object[capacity];
        size = 0;
    }

    //размер листа
    public int getSize() {
        return size;
    }

    //добавление элемента в конец листа
    public void add(T element) {
        checkCapacity();
        size++;
        array[size - 1] = element;

    }

    //добавление элемента в указанную позицию листа
    public void add(int index, T element) {
        checkOutOfBounds(index);
        checkCapacity();
        swapRight(index);
        array[index] = element;
        size++;
    }

    //смещение элементов вправо
    private void swapRight(int index) {
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
    }

    //удаление элемента
    public void remove(int index) {
        checkOutOfBounds(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    @Override
    public String toString() {
        return Arrays.toString(array) + " capacity = " + capacity + " size = " + size;
    }

    //проверка capacity и увеличение capacity
    public void checkCapacity() {
        if (size == (capacity - 1)) {
            capacity = (int) (capacity * 1.5);
            array = Arrays.copyOf(array, capacity);
        }
    }

    //поиск индекса указанного элемента
    public int indexOf(T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i + 1;
            }
        }
        return -1;
    }

    //проверка выхода за границы массива
    private void checkOutOfBounds(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Вы за пределами ArrayList");
        }
    }

    //очистка листа
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }


}
