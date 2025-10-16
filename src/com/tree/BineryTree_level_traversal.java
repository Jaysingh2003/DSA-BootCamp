package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BineryTree_level_traversal {
    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result; // handle empty tree
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);//add the root node to the queue , it will not throw exception if root is null

        while (!queue.isEmpty()) {
            int levelsize = queue.size();
            List<Integer> currentlevel = new ArrayList<>(levelsize);//it will store the element of the current level
            for (int i = 0; i < levelsize; i++) {
                Node current = queue.poll();//	Returns: the head of the queue, or null if the queue is empty.,not throws exception if queue is empty
                currentlevel.add(current.value);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add(currentlevel);
        }
        return result;
    }

    //Q-2 https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
     public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result; // handle empty tree
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);//add the root node to the queue , it will not throw exception if root is null

            while (!queue.isEmpty()) {
                int levelsize = queue.size();
                List<Integer> currentlevel = new ArrayList<>(levelsize);//it will store the element of the current level
                for (int i = 0; i < levelsize; i++) {
                    TreeNode current = queue.poll();//	Returns: the head of the queue, or null if the queue is empty.,not throws exception if queue is empty
                    currentlevel.add(current.val);
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
                result.add(0,currentlevel);
                //it means that the new list will add a index zero instad going to the last index
            }
            return result;
        }
}
