package com.boutnous_acciolite;

public class Kth_smallest_kth_gratest {
    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }

    }
    private Node root;

    public Kth_smallest_kth_gratest() {

    }

    int count;
    int ans;

    public int kthSmallest(Node root, int k) {
        int count =0;
        int ans=-1;
        inorder(root, k);
        return ans;
    }
    private void inorder(Node node, int k) {
        if (node == null) {
            return;
        }
        inorder(node.left, k);
        count++;
        if (count == k) {
            ans = node.value;
            return;
        }
        inorder(node.right, k);
    }

    //kth greatest

    public int kthGreatest(Node root, int k) {
       int count1 = 0;
       int  ans = -1;
        reverseInorder(root, k);
        return ans;
    }
    private void reverseInorder(Node node, int k) {
        if (node == null) {
            return;
        }
        reverseInorder(node.right, k);
        count++;
        if (count == k) {
            ans = node.value;
            return;
        }
        reverseInorder(node.left, k);
    }
}
