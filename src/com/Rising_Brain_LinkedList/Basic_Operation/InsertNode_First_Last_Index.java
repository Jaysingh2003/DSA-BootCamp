package com.Rising_Brain_LinkedList.Basic_Operation;


public class InsertNode_First_Last_Index {

    ///Insert At first index
    public Node insertFirst(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return newNode;
        }
        newNode.next = head;
        return newNode;
    }

    ///insert At last
    public Node insertLast(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public Node insertAtIndex(Node head, int data, int index) {
        Node newNode = new Node(data);
        if (index == 0) {///means first par hi insert karna h
            newNode.next = head;
            return newNode;
        }
        Node temp = head;
        for (int i = 1; i < index ; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;/// new node ko refrence diya temp ke next node ka
        temp.next = newNode;
        return head;
    }
}



