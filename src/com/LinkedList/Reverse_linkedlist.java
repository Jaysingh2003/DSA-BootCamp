package com.LinkedList;

import static com.LinkedList.Node.size;

class Node1 {
    int data;
    Node next;
    Node tail; // not used for singly list nodes; can be removed

    Node1(int data) {
        this.data = data;
    }

    Node1(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class Reverse_linkedlist {
    private Node head;
    private Node tail;
    private Node node;

    //This the main code  revese a linkedlist using the     -=----->recursion
    private void reverse(Node head) {
        if (node == tail) {//base case w
            head = tail;
            return;
        }
        reverse(node.next);//make a recursive call till the end
        //when the base case it then it  will come out of the stack
        tail.next = node;
        tail = node;
        tail.next = null;

    }

    //In place revese-------------Inplace revese
    public void reverseInplace() {
        if(size<2){
            return;
        }
        Node prev = null;
        Node present=head;
        Node next=present.next;
        while(present != null){
            present.next=prev;
            prev = present;
            present = next;
            if(next!=null){//to avoid null pointer exception
                next=next.next;
            }
        }
        head=prev;//previus par hi head lie karega

    }


}


//se siolution in the merge