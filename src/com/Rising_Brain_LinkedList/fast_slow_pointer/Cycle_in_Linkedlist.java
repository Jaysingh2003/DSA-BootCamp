package com.Rising_Brain_LinkedList.fast_slow_pointer;

public class Cycle_in_Linkedlist {
    public boolean detectLoop(Node head) {
        // code here

        Node fast= head;
        Node slow= head;

        while (fast != null && fast.next != null) {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;

    }
}
