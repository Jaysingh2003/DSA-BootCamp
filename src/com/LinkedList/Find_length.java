package com.LinkedList;
//https://leetcode.com/problems/linked-list-cycle/description/
class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int x) {
        val = x;
        next = null;
    }
}

public class Find_length {
    public int lengthcycle(ListNode1 head) {
        ListNode1 slow = head;
        ListNode1 fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                //calculate the length

                ListNode1 temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;


            }
        }
        return 0;

    }
}
