package com.tree;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1 next;

    TreeNode1(int x) {
        val = x;
        left = null;
        right = null;
        next = null;
    }
}

public class Connect_Node {
    public TreeNode1 connnect(TreeNode1 root) {
        if (root == null) {
            return null;
        }
        TreeNode1 leftmost = root;
        while (leftmost.left != null) {
            TreeNode1 current = leftmost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;//it is the bridge between two parents
                }
                current = current.next;
            }
            leftmost = leftmost.left;

        }
        return root;
    }
}
