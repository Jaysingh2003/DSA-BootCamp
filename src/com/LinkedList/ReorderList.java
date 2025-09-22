package com.LinkedList;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    //https://leetcode.com/problems/reorder-list/description/
    public class ReorderList {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }

            // 1. Find middle
            ListNode middle = middleNode(head);
            ListNode secondHalf = reverseList(middle.next);
            middle.next = null; // split into two lists

            ListNode firstHalf = head;

            // 2. Merge two lists
            while (firstHalf != null && secondHalf != null) {
                ListNode temp1 = firstHalf.next;
                ListNode temp2 = secondHalf.next;

                firstHalf.next = secondHalf;
                secondHalf.next = temp1;

                firstHalf = temp1;
                secondHalf = temp2;
            }
        }

        // ✅ Correct middle (second half start)
        private ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow; // true middle
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;

            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;
        }
    }
}