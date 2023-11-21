package com.solvd.lawfirm.collections;

import com.solvd.lawfirm.controller.Creator;
import com.solvd.lawfirm.entity.persons.ProsecutorPerson;
import java.util.LinkedList;

public class ProsecutorLinkedList<T> {
    private Creator creator;

    public ProsecutorLinkedList() {
        this.creator = new Creator();
    }
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
        public void removeIndex(int index, T element) {
            if (index == 0) {
                head = head.next;
            } else {
                Node currentNode = head;
                for (int i = 0; i < index - 1; i++ ) {
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
            } return false;
        }
        public int getSize() {
            return size;
        }
    }
    //ProsecutorLinkedList<T> prosecutorLinkedList = new ProsecutorLinkedList<>();
    public LinkedList<ProsecutorPerson> createProsecutorPersonLinkedList() {
        LinkedList<ProsecutorPerson> prosecutorPersonLinkedList = new LinkedList<>();
        prosecutorPersonLinkedList.add(creator.createProsecutorPerson('m', "johnny", "depp", 50, 3));
        prosecutorPersonLinkedList.add(creator.createProsecutorPerson('m', "brad", "pitt", 50, 1));
        prosecutorPersonLinkedList.add(creator.createProsecutorPerson('m', "leo", "dicaprio", 40, 2));
        return prosecutorPersonLinkedList;
    }

    public ProsecutorPerson findSProsecutor(int level) throws Exception {
        LinkedList<ProsecutorPerson> prosecutorList = createProsecutorPersonLinkedList();
        for (ProsecutorPerson prosecutor : prosecutorList) {
            if (prosecutor.getProsecutorLevel() == level) {
                return prosecutor;
            }
        }
        throw new Exception("Cannot find prosecutor");
    }
}
