package com.LinkedList;

/// in circular linked list last node points to first node
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

    public void delete(int val) {
        Node node = head;
        if (node == null) {
            return;
        }
        if (node.val == val) {/// if head is to be deleted
            head = head.next;//move head to next node
            tail.next = head;//joint he last node to the head
            return;
        }
        do {/// if any other node is to be deleted
            Node n = node.next;
            if (n.val == val) {
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);
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
