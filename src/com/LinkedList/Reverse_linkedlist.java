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

    /// Q-2In place reverse-------------Inplace revese

    public void reverseInplace() {
        if (size < 2) {
            return;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;
        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {//to avoid null pointer exception
                next = next.next;
            }
        }
        head = prev;//previus par hi head lie karega

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




