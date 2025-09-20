package com.LinkedList;


class Middle_linkedList {
    public  ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid= middleNode(head);
        ListNode left=sortList(head);
        ListNode rigth= sortList(mid);
        return merge(left,rigth);
    }

    ListNode merge(ListNode first, ListNode second) {

        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while (first != null && second != null) {
            if (first.val < second.val) {
                tail.next = first;
                first = first.next;
                tail = tail.next;
            } else {
                tail.next = second;
                second = second.next;
                tail = tail.next;
            }
        }
        tail.next = (first != null) ? first : second;
        return dummyHead.next;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

        }
        return prev;
    }
}
