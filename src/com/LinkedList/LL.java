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
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }
    //insert at an index
    public void insertAt(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i = 1; i<index; i++){
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);//next is the next of the temp node temp.next is position
                                               //temp.next me temp ki next ki value aa jayegi
        temp.next = node;//
        size++;
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

    private class Node {
        private int data;
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
