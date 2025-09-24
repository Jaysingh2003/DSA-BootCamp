package com.LinkedList;


import java.util.List;

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

    /// Q-1 Reorder the linkedlist
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


    ///  Q-2 revese the linkedlist into k grups
    //https://leetcode.com/problems/reverse-nodes-in-k-group/description/
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) return head;

        // Check if there are at least k nodes left
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) return head;
            node = node.next;
        }

        // Reverse k nodes
        ListNode prev = null, curr = head, next = null;
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Recursively call for the next group
        head.next = reverseKGroup(curr, k);
        return prev;
    }

    /// Q-3 revesres the alternate grups of k elements
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        //skip the first  left-1 left elment
        ListNode prev = null;
        ListNode current = head;

        //when the there are more nodes left
        while (current != null) {//last and newwnd will we used for the next  group  for the update opf privius and current
            ListNode last = prev;//last points to the node before the current group.
            ListNode newEnd = current; // newEnd marks the start of the group to be reversed will become the end after reversal).

            //reverse between the left and right
            ListNode next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }
            /// Connect the previous group (last) to the new head of the reversed group (prev)
            /// if it's the first group, update head.
            /// Connect the end of the reversed group (newEnd) to the next node (current)

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;//if the next group is not present
            }
            newEnd.next = current;

//          Skip the next k nodes (do not reverse them), updating prev and current.
            for (int i = 0; current != null && i < k; i++) {
                prev = current;
                current = current.next;


            }
        }
        return head;
    }

    /// Q-4
    //https://leetcode.com/problems/rotate-list/description/
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        //for finding the lase node
        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }
        last.next = head;
        int rotations = k % length;//no of rotations
        int skip = length - rotations;//kitne length tak jana h
        ListNode newlast = head;//head se last elemnt tak jana h
        for (int i = 0; i < skip - 1; i++) {
            newlast = newlast.next;
        }
        head = newlast.next;
        newlast.next = null;
        return head;


    }
}

