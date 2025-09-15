package com.LinkedList;

public class DLL {
    private Node head;

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    //insert last
    public void insertLast(int val) {
        Node node = new Node(val);
        Node last = head;// to traverse the list last is a temp variable

        //if there is no node
        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
    }

    public void display() {
        Node node = head;//node is a temp variable
        Node last = null;
        while (node != null) {
            System.out.print(node.val + " -> ");
            last = node;  // to use it in reverse display beacuse in this last contains the refrence  of last node
            node = node.next;
        }
        System.out.println("END");
        System.out.println("Display in reverse");
        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }
    //


    private class Node {
        int val;
        Node next;
        Node prev;

        Node(int data) {
            this.val = data;// this.next = null; this.prev = null; // by default

        }

        public Node(int data, Node next, Node prev) {
            this.val = data;
            this.next = next;
            this.prev = prev;
        }
    }
}

