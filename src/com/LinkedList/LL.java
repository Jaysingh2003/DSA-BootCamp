package com.LinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;

   public LL(){//constructor
        this.size=0;
    }

    //insert at very first position
    public void insertFirst(int val){
        Node node= new Node(val);
        node.next=head;
        head=node;

        if(tail == null){
            tail= head;
        }
        size+=1;
    }
    public void display(){
        Node temp= head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
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
