package com.LinkedList;

//https://leetcode.com/problems/middle-of-the-linked-list/description/

public class ListNode4 {
    int val;
    ListNode4 next;

    ListNode4() {
    }

    ListNode4(int val) {
        this.val = val;
    }

    ListNode4(int val, ListNode4 next) {
        this.val = val;
        this.next = next;
    }


    public class Middle_linkedList {
        public ListNode4 middleNode(ListNode4 head) {
            ListNode4 slow = head;
            ListNode4 fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }

