package com.solvd.lawfirm.collections;

public class CustomLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    private int size = 0;
    Node<T> next;

    static class Node<T> {
        Node<T> head;
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    public CustomLinkedList() {
        this.head = null;
        this.next = null;
        this.tail = null;
    }
    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (this.head == null) {
            this.head = node;
        } else {
            Node<T> iterator = this.head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = node;
        }
        size++;
    }
    public void remove(T value) {
        Node<T> node = new Node<>(value);
        if (this.head != null) {
            this.head = node;
        } else {
            Node<T> iterator = this.next;
            while (iterator.head != null) {
                iterator = iterator.next;
            }
            iterator.next = node;
        }
        size--;
    }
    public void addAtFirst(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
        size++;
    }
    public void addIndex(int index, T value) {
        if (index == 0) {
            addAtFirst(value);
        } else {
            Node<T> node = new Node<>(value);
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            node.next = currentNode.next;
            currentNode.next = node;
        }
        size++;
    }
    public void removeIndex(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
        size--;
    }
    public Node<T> getNode(int index) {
        Node<T> temp;
        if (index < (size >> 1)) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = size - 1; i > index; i++) {
                temp = temp.prev;
            }
        }
        return temp;
    }
    public Node<T> getIndex(int index) {
        return getNode(index);
    }
    public void set(int index, T value) {
        Node<T> node = getNode(index);
        node.value = value;
    }
    public void clear() {
        head = null;
        size = 0;
    }
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }
    public int getSize() {
        return size;
    }
}

