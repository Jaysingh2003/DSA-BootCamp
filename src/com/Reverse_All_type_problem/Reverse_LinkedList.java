package com.Reverse_All_type_problem;


/// Q-1 Reverse a linkedlist using the   in place reverse
/// original 1 → 2 → 3 → null  after reverse 3 → 2 → 1 → null
public class Reverse_LinkedList {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public Node reverseList(Node head) {

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;  // store next
            curr.next = prev;       // reverse link
            prev = curr;            // move prev
            curr = next;            // move curr
        }

        return prev;  // new head
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {// print current node value and move to the next node
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");// print null at the end of the list
    }

    public static void main(String[] args) {
        Reverse_LinkedList list = new Reverse_LinkedList();

        // Creating linked list: 1 -> 2 -> 3 -> null
        Node head = list.new Node(1);
        head.next = list.new Node(2);
        head.next.next = list.new Node(3);

        System.out.println("Original List:");
        list.printList(head);

        // Reverse the list
        head = list.reverseList(head);

        System.out.println("Reversed List:");
        list.printList(head);
    }
}