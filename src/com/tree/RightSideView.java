package com.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-right-side-view/
public class RightSideView {
    public List<Double> rightSideView(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result; // handle empty tree
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//offer adds the element to the queue and returns true
        while (!queue.isEmpty()) {
            int levelSize = queue.size();// number of nodes at the current level
            for (int i = 0; i < levelSize; i++){
                TreeNode current = queue.poll();//poll retrieves and removes the head of the queue
                /// as the last node in the level we add its value to the result
                if (i == levelSize - 1) {
                    result.add((double) current.val);
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }


        }
        return result;

    }

    //left side view
    public List<Double> leftSideView(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                /// FIRST node of the level
            /// Note :- Only this leine is different from right side view
                if (i == 0) {
                    result.add((double) current.val);
                }

                if (current.left != null){
                    queue.offer(current.left);
                }
                if (current.right != null){
                    queue.offer(current.right);
                }
            }
        }
        return result;
    }


    
}
