package com.LinkedList;
//https://leetcode.com/problems/linked-list-cycle-ii/submissions/1776769307/

class ListNode3 {
    int val;
    ListNode3 next;

    ListNode3(int x) {
        val = x;
        next = null;
    }
}

public class First_Index_ofcycle {
    //for the finding the length of the cycle
    public int lengthCycle(ListNode3 head) {
        ListNode3 fast = head;
        ListNode3 slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode3 temp = slow;
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


    public ListNode3 detectCycle(ListNode3 head) {//first detct the cycle and then find the lenth of the cycle
        int len = 0;
        ListNode3 fast = head;
        ListNode3 slow = head;

        while (fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                len = lengthCycle(slow);
                break;
            }
        }

        if(len == 0){
            return null;
        }
        //find the first element
        ListNode3 f =head;
        ListNode3 s=head;

        while( len > 0){
            s = s.next;
            len--;
        }
        //keep moving both when the not fist meet
        while(f != s){
            f = f.next;
            s = s.next;
        }
        return f;//we can also return s because both are point to the same object


    }
}