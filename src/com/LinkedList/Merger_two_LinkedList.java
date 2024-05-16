package com.LinkedList;

public class Merger_two_LinkedList {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public class MergeSortedLists {

        public static Node merge(Node l1, Node l2) {

            Node dummy = new Node(-1);   // temporary starter
            Node tail = dummy;

            while (l1 != null && l2 != null) {

                if (l1.val <= l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }

                tail = tail.next;
            }

            // attach remaining
            if (l1 != null) tail.next = l1;
            if (l2 != null) tail.next = l2;

            return dummy.next;
        }
    }
}
