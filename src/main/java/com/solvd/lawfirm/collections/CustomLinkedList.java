package com.solvd.lawfirm.collections;

public class CustomLinkedList<T> {
    class Node {
        private Node head;
        private int size = 0;
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
        public void add(T element) {
            Node node = new Node(element);
            if (this.head == null) {
                this.head = node;
            } else {
                Node iterator = this.head;
                while (iterator.next != null) {
                    iterator = iterator.next;
                }
                iterator.next = node;
            }
            size++;
        }
        public void remove(T element) {
            Node node = new Node(element);
            if (this.head != null) {
                this.head = node;
            } else {
                Node iterator = this.next;
                while (iterator.head != null) {
                    iterator = iterator.next;
                }
                iterator.next = node;
            }
            size--;
        }
        public void addAtFirst(T element) {
            Node node = new Node(element);
            node.next = head;
            head = node;
            size++;
        }
        public void addIndex(int index, T element) {
            if (index == 0) {
                addAtFirst(element);
            } else {
                Node node = new Node(element);
                Node currentNode = head;
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
                Node currentNode = head;
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.next;
                }
                currentNode.next = currentNode.next.next;
            }
            size--;
        }
        public void clear() {
            head = null;
            size = 0;
        }
        public boolean empty() {
            if (head == null) {
                return true;
            }
            return false;
        }
        public int getSize() {
            return size;
        }
    }
}
