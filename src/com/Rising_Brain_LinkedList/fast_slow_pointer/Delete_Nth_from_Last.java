package com.Rising_Brain_LinkedList.fast_slow_pointer;



public class Delete_Nth_from_Last {
    public Node removeNthFromEnd(Node head, int n) {

        /// We create a dummy node to handle edge cases, especially when the head node
        /// needs to be deleted.
        /// For example, if the linked list has 5 nodes and n = 5, the node to remove
        /// is the head.
        /// By placing a dummy node before the head, we ensure that every node,
        /// including the head, has a previous node.
        /// This allows us to delete the head using the same logic as any other node,
        /// without writing a separate if-condition.
        /// Finally, we return dummy.next, which points to the new head of the list.
        Node dummy = new Node(0);
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;

        /// Move fast n+1 steps
        /// ahead so that there is a gap of n nodes between fast and slow pointers
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }///nthe node is one step ahed so that when slow pointer last me pahuche tab tak ham exactly n-1 node
        ///  distance travel kar chuke honge and slow pointer will be just before the node to delete

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
