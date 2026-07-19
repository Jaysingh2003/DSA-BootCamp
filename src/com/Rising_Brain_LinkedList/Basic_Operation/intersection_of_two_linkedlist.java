package com.Rising_Brain_LinkedList.Basic_Operation;
import java.util.HashSet;


////https://www.geeksforgeeks.org/problems/intersection-of-two-linked-list/1
public class intersection_of_two_linkedlist {

    public static Node findIntersection(Node head1, Node head2) {

        HashSet<Integer> set = new HashSet<>();
        // Store values of second list
        while (head2 != null) {
            set.add(head2.data);
            head2 = head2.next;
        }
        Node dummy = new Node(-1);
        Node tail = dummy;
        // Traverse first list
        while (head1 != null) {
            if (set.contains(head1.data)) {
                tail.next = new Node(head1.data);
                tail = tail.next;

            }
            head1 = head1.next;
        }
        return dummy.next;

    }
}
