package com.tree;

import java.util.*;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> dq = new LinkedList<>();//data can be added or removed from both ends
        dq.offer(root);
        boolean reverse = false;
        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> currentLevel = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                if (!reverse) {
                    // left -> right: take from front, add children to back (left then right)
                    TreeNode node = dq.pollFirst();//remove first element and return it
                    currentLevel.add(node.val);
                    if (node.left != null) dq.addLast(node.left);
                    if (node.right != null) dq.addLast(node.right);
                } else {
                    // right -> left: take from back, add children to front (right then left)
                    TreeNode node = dq.pollLast();
                    currentLevel.add(node.val);
                    if (node.right != null) dq.addFirst(node.right);
                    if (node.left != null) dq.addFirst(node.left);
                }
            }

            result.add(currentLevel);
            reverse = !reverse;
        }

        return result;
    }
}

