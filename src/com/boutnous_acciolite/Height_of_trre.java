package com.boutnous_acciolite;

public class Height_of_trre {
    public static class Node{
        int data;
        Node left, right;

        public Node(int item){
            data = item;
            left = right = null;
        }
    }
  public static int height(Node root){
        if(root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

}
