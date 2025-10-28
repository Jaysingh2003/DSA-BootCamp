package com.tree;






//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class test {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node leftmost = root;
        while (leftmost != null) {
            Node dummy = new Node(0); // dummy head for next level
            Node prev = dummy;        // builds next level's next pointers
            Node current = leftmost;

            while (current != null) {// iterate over current level
                if (current.left != null) {// connect left child
                    prev.next = current.left;
                    prev = prev.next;
                }
                if (current.right != null) {
                    prev.next = current.right;
                    prev = prev.next;
                }
                current = current.next;
            }

            leftmost = dummy.next; // move to first node of next level
        }
        return root;
    }
}
