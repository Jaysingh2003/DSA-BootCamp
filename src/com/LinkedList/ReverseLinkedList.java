package com.LinkedList;


/// Q-1 Reverse a linkedlist using the   in place reverse
/// Time Complexity: O(n) where n is the number of nodes in the linked list.
/// Space Complexity: O(1) as we are using only a constant amount of extra space
public class ReverseLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Reverse function (your logic)
    public static Node reverse1(Node head) {

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

    // Print Linked List
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {

        // Creating linked list: 1 -> 2 -> 3 -> 4 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original List:");
        printList(head);

        // Reverse the list
        head = reverse1(head);

        System.out.println("Reversed List:");
        printList(head);
    }
}