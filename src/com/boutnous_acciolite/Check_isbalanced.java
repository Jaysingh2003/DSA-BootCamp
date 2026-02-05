package com.boutnous_acciolite;

public class Check_isbalanced {
    public class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
  //time complexity: O(n^2) in worst case
    public boolean isBalanced(Node root){
        if(root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }

    // Helper method to calculate height of a tree
    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Optimized approach: O(n) time complexity
    public boolean isBalancedOptimized(Node root) {
        checkBalance(root);
        return isBalanced;
    }

    private boolean isBalanced = true;

    private int checkBalance(Node node) {
        if (node == null) return 0;

        int left = checkBalance(node.left);
        int right = checkBalance(node.right);

        if (Math.abs(left - right) > 1)
            isBalanced = false;

        return 1 + Math.max(left, right);
    }
}
