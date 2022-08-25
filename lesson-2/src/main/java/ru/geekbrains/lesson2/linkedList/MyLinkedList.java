package ru.geekbrains.lesson2.linkedList;

public class MyLinkedList<T> {

    private class Node {
        Node preview;
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(Node preview, T value, Node next) {
            this.preview = preview;
            this.value = value;
            this.next = next;
        }

        public Node getPreview() {
            return preview;
        }

        public void setPreview(Node preview) {
            this.preview = preview;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private int size;
    private Node first;
    private Node last;

    public int getSize() {
        return size;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("list is empty");
        }
        return first.getValue();
    }

    public T getLast() {
        if (isEmpty()) {
            throw new RuntimeException("list is empty");
        }
        return last.getValue();
    }

    //вставка первого элемента
    public void insertFirst(T element) {
        Node newNode = new Node(element, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPreview(newNode);
        }
        first = newNode;
        size++;
    }

    //вставка последнего элемента
    public void insertLast(T element) {
        Node newNode = new Node(last, element, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    //вставка элемента в указанную позицию
    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index: " + index);
        }

        if (size == 0 || index == 0) {
            insertFirst(element);
            return;
        }

        if (index == size) {
            insertLast(element);
            return;
        }

        //обход листа слева
        if (index < (size / 2)) {
            Node current = first;

            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }

            Node newNode = new Node(current, element, current.getNext());
            current.getNext().setPreview(newNode);
            current.setNext(newNode);
            size++;
            return;
        }

        //обход листа справа
        Node current = last;

        for (int i = size; i > index + 1; i--) {
            current = current.getPreview();
        }

        Node newNode = new Node(current.getPreview(), element, current);
        current.getPreview().setNext(newNode);
        current.setPreview(newNode);
        size++;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public boolean isEmpty() {
        return first == null;
    }

    //удаление первого элемента
    public T removeFirst() {
        T temp = getFirst();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPreview(null);
        }
        size--;
        return temp;
    }

    //удаление последнего элемента
    public T removeLast() {
        T temp = getLast();
        if (last.getPreview() != null) {
            last.getPreview().setNext(null);
        } else {
            first = null;
        }
        last = last.getPreview();
        size--;
        return temp;
    }

    //удаление указанного элемента
    public boolean remove(T element) {
        if (isEmpty()) {
            return false;
        }

        if (first.getValue().equals(element)) {
            removeFirst();
            return true;
        }

        if (last.getValue().equals(element)) {
            removeLast();
            return true;
        }

        Node current = first;
        for (int i = 1; i < size; i++) {
            if (current.getValue().equals(element)) {
                current.getPreview().setNext(current.getNext());
                current.getNext().setPreview(current.getPreview());
                size--;
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    //поиск элемента
    public int indexOf(T item) {
        Node current = first;
        int i = 0;

        while (current != null) {
            if (current.getValue().equals(item)) {
                return i;
            }
            current = current.getNext();
            i++;
        }

        return -1;
    }

    @Override
    public String toString() {
        Node current = first;

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(current.getValue() + ", ");
            current = current.getNext();
        }

        if (size != 0) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("]");
        return sb.toString();
    }
}
