package com.LinkedList;

public class Remove_duplicate {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                // skip the duplicate node
                temp.next = temp.next.next;
            } else {
                // move forward only if no deletion
                temp = temp.next;
            }
        }

        return head; // return updated head
    }

    // ✅ Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create list: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(
                1, new ListNode(
                1, new ListNode(
                2, new ListNode(
                3, new ListNode(3)
        )
        )
        )
        );

        Remove_duplicate rd = new Remove_duplicate();
        ListNode result = rd.deleteDuplicates(head);

        // Print the result
        printList(result); // ✅ Expected output: 1 -> 2 -> 3
    }
}