package com.LinkedList;

import static com.LinkedList.Node.size;

class Node1 {
    int data;
    Node1 next;
    Node1 tail; // not used for singly list nodes; can be removed

    Node1(int data) {
        this.data = data;
    }

    Node1(int data, Node1 next) {
        this.data = data;
        this.next = next;
    }
}

public class Reverse_linkedlist {
    private Node head;
    private Node tail;
    private Node node;

    /// Q-1 Reverse a linkedlist using the     -=----->recursion
    ///
    /// this is the for  recusion and the time complexity is O(n) and space complexity is O(n) because of the recursive stack space.
    /// static class Node {
    ///         int val;
    ///         Node next;
    ///
    ///         Node(int val) {
    ///             this.val = val;
    ///             this.next = null;
    ///         }
    ///     }

    public Node reverse(Node head) {

        // Base Case
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverse(head.next);// Recursive call to reverse the rest of the list( But in the last call the ->head.next is null
         //but we  do not exetcte the line head.next.next = head; because of the base case is alredy  return the head .


        head.next.next = head;  // Reverse the link
        head.next = null;       // Break old connection

        return newHead;
    }

    /// Q-2In place reverse-------------Inplace revese complexity is O(n) and space complexity is O(1) because we are not using any extra space for the recursive stack.

    public Node reverse1(Node head) {

        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;  // store next
            current.next = prev;       // reverse link
            prev = current;            // move prev
            current = next;            // move current
        }

        return prev;  // new head
    }

    // https://leetcode.com/problems/reverse-linked-list/submissions/
    // google, apple, amazon, microsoft
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    /// Q-2 question Revesere some part of the linked list
    //https://leetcode.com/problems/reverse-linked-list-ii/description/
    public Node1 reversePart(Node1 head, int left, int right) {

        if (left == right) {
            return head;
        }
        Node1 present = head;
        Node1 prev = null;
        for (int i = 0; present != null && i < left - 1; i++) {
            prev = present;
            present = present.next;
        }
        Node1 last = prev;
        Node1 newNode = present;
        Node1 next = present.next;
        for (int i = 0; present != null && i < right - left + 1; i++) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newNode.next = present;
        return head;

    }
}




