//package com.LinkedList;
//
//
//import static com.LinkedList.Reverse_linkedlist.reverseInplace;
//import static com.LinkedList.Middle_linkedList.middleNode;
//
//
////https://leetcode.com/problems/palindrome-linked-list/
//public class Palindrome {
//    public boolean isPalindrome(ListNode head) {
//        ListNode mid = middleNode(head);
//        ListNode headSecond = reverseInplace(mid);//mid se revse karga
//        ListNode reversehead = headSecond;
//
//        while (head != null && headSecond != null) {
//            if (head.val != headSecond.val) {
//                return false;
//            }
//            head = head.next;
//            headSecond = headSecond.next;
//        }
//        reverseInplace(reversehead);
//        if (head = null || headSecond = null) {
//            return true;
//        }
//        return false;
//    }
//
//
//}