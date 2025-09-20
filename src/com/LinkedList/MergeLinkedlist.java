//package com.LinkedList;
//
//public class MergeLinkedlist {
//
//    public static LL mergeLinkedlist(LL first, LL second) {
//        Node f = first.head;
//        Node s = second.head;
//
//        LL ans = new LL();
//
//        while (f != null && s != null) {
//            if (f.val < s.val) {
//                ans.insertLast(f.val);
//                f = f.next;
//            } else {
//                ans.insertLast(s.val);
//                s = s.next;
//            }
//        }
//
//        while (f != null) {
//            ans.insertLast(f.val);
//            f = f.next;
//        }
//
//        while (s != null) {
//            ans.insertLast(s.val);
//            s = s.next;
//        }
//
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        LL list1 = new LL();
//        list1.insertLast(1);
//        list1.insertLast(3);
//        list1.insertLast(5);
//
//        LL list2 = new LL();
//        list2.insertLast(2);
//        list2.insertLast(4);
//        list2.insertLast(6);
//
//        System.out.println("First list:");
//        list1.display();
//
//        System.out.println("Second list:");
//        list2.display();
//
//        LL merged = mergeLinkedlist(list1, list2);
//        System.out.println("Merged list:");
//        merged.display();
//    }
//}