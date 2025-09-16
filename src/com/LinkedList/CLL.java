package com.LinkedList;

public class CLL {

    private Node head;
    private Node tail;

    // constructor
    public CLL() {
        this.head = null;
        this.tail = null;
    }

    //insert
    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    // display
    public void display() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            } while (temp != head);
        }
        System.out.println("HEAD");
    }

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            //this.next = null; // by default next is null
        }
    }

}
