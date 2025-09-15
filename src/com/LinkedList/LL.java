package com.LinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {//constructor
        this.size = 0;
    }

    //insert at very first position
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;//
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

    //insert at an index
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
        Node node = new Node(val, temp.next);//next is the next of the temp node temp.next is position
        //temp.next me temp ki next ki value aa jayegi
        temp.next = node;//
        size++;
    }

    //Delete
    //delete from the firstposition
    public int deleteFirst() {
        if (head == null) {
            throw new RuntimeException("Cannot delete from an empty list");
        }

        int val = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    //delete from the last position
    public int deleteLast() {
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

    //delete from a particular index
    public int deleteAt(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node prev = get(index - 1);
        int val = prev.next.data;//value of the node which is to be deleted for the return
        prev.next = prev.next.next;
        size--;
        return val;
    }


    //Node type ka return fuction karega
    public Node get(int index) {//get the node at a particular index
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.data == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }


    //us ethe temp node to traverse the linked list do not interfare then original structures
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

   public class Node {

         int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            //by default if bed did not provide the the next it will be taken as null this.next=null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
