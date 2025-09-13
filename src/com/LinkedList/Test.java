package com.LinkedList;


import org.w3c.dom.Node;

public class Test {
    private Node head;
    private Node tail;
    private int size;

    public Test() {//
        this.size = 0;
    }

    public void insertFirst(int val) {

        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;

    }

    //insert at last position
    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;

    }

    //inset at any position
    public void insertAt(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);//naye node ka reference temp.next pe point karega
        temp.next = node;
        size++;

    }

    //delete from first position
    public int deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }
        int val = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    //delete from last position
    public int deleteLast() {
        if (tail == null) {
            System.out.println("List is empty");
            return -1;
        }
        if (size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.data;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;

    }
    //delete from any position
    public int deleteAt(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node prev = get(index - 1);
        int val = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
