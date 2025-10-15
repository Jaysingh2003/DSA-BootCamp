package com.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

///https://leetcode.com/problems/average-of-levels-in-binary-tree/submissions/1801915164/
class  TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class averageOfLevels_BFS {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result; // handle empty tree
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//add the root node to the queue , it will not throw exception if root is null

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double averagelevel=0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();//	Returns: the head of the queue, or null if the queue is empty.,not throws exception if queue is empty
                averagelevel+=current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            averagelevel=  averagelevel/levelSize;
            result.add(averagelevel);
        }
        return result;
    }
}
