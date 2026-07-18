package com.Rising_Brain_LinkedList.Basic_Operation;



public class Search {
    public boolean searchKey(Node head, int key) {
        // Code here
        if (head == null) {
            return false;
        }
        Node temp = head;
        while (temp != null) {

            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;

    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        Search s = new Search();
        System.out.println(s.searchKey(head, 5));
    }
}
