package com.LinkedList;

//https://leetcode.com/problems/linked-list-cycle/description/
 class ListNode5 {
      int val;
     ListNode next;
      ListNode5() {
          val = 0;
          next = null;
      }
  }

  //main method is here
public class Cycle_in_Linkedlist {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast =head;
        while(fast !=null && fast.next !=null){
            fast= fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }

        }
        return false;
    }



    public static void main(String[] args) {
            ListNode head = new ListNode();
            head.val = 1;
            ListNode second = new ListNode();
            second.val = 2;
            head.next = second;
            second.next = head; // creates a cycle

            Cycle_in_Linkedlist cycleChecker = new Cycle_in_Linkedlist();
            boolean hasCycle = cycleChecker.hasCycle(head);
            System.out.println("Does the linked list have a cycle? " + hasCycle); // Expected output: true
    }
}

