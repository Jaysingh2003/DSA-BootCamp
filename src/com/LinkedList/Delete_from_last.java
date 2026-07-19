package com.LinkedList;

public class Delete_from_last {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public Node deleet_from_last(Node head, int n) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(0); // create a dummy node to handle edge cases like deleting the head node
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;

        /// move fast pointer n steps ahead and just like the racing game so that they get  they have travle equal distannce
        /// note: this loop first moves n+1 steps, after that the below while loop starts
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        /// now both fast and slow will start moving together
        /// when fast reaches the end (null),
        /// slow will reach just before the node to delete (nth from end)
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete node (nth node from end)
        slow.next = slow.next.next;

        return dummy.next;
    }
}