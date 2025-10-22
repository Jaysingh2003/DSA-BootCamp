package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Check {
    public List<List<Integer>> check(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return null; // handle empty tree
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentList = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                currentList.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add(currentList);
        }
        return result;
    }


    public List<Integer> AvergerSum(TreeNode root) {
     List<Integer> result = new ArrayList<>();
     if (root == null) return result;
     Queue<TreeNode> queue = new LinkedList<>();
     queue.offer(root);
     while (!queue.isEmpty()) {
          int levelSize = queue.size();
          Double averg=0.0;
          for (int i = 0; i < levelSize; i++) {
             TreeNode current =  queue.poll();
             averg+=current.val;
             if (current.left != null) {
                 queue.offer(current.left);
             }
             if (current.right != null) {
                 queue.offer(current.right);
             }

          }
     }
    }

}
