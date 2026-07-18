package com.Rising_Brain_LinkedList.Basic_Operation;

public class Delete_First_Last_Index {

    ///Delete from the first
    public Node deleteFirst(Node head) {

        if (head == null) {
            throw new RuntimeException("Cannot delete from an empty list");
        }

        return head.next;
    }

    ///Delete from the Last
    public Node deleteLast(Node head) {

        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        // Only one node
        if (head.next == null) {
            return null;
        }

        Node temp = head;

        // Stop at the second last node
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    ///From the index
    public Node deleteAtIndex(Node head, int index) {

        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        if (index == 0) {
            return deleteFirst(head);
        }

        Node prev = head;

        // Reach the node before the index
        for (int i = 1; i < index; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return head;
    }

    ///Display
    public void display(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    ///Main Method
    public static void main(String[] args) {

        InsertNode_First_Last_Index insert = new InsertNode_First_Last_Index();
        Delete_First_Last_Index delete = new Delete_First_Last_Index();

        Node head = null;

        head = insert.insertLast(head, 10);
        head = insert.insertLast(head, 20);
        head = insert.insertLast(head, 30);
        head = insert.insertLast(head, 40);

        delete.display(head);

        head = delete.deleteAtIndex(head, 2);

        delete.display(head);
    }
}