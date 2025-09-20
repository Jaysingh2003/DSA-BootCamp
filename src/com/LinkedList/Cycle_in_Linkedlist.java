package com.LinkedList;


 class ListNode {
      int val;
     ListNode next;
      ListNode(int x) {
          val = x;
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

    }
}

