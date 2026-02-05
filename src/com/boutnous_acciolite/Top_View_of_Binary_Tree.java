package com.boutnous_acciolite;
import java.util.*;

///Top View = BFS + HD + first entry
/// Bottom View = BFS + HD + overwrite
/// 	•	Time: O(n log n) → TreeMap
/// 	•	Space: O(n)
/// Top View -> Insert only if HD not present
/// Bottom View->Always overwrite

public class Top_View_of_Binary_Tree {
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Pair class to store node with its horizontal distance
    class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public  List<Integer> topView(TreeNode root) {

        // Stores the final top view result
        List<Integer> result = new ArrayList<>();

        // If tree is empty, return empty list
        if (root == null) return result;

        // TreeMap keeps horizontal distances sorted (left to right)
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue for BFS traversal
        Queue<Pair> queue = new ArrayDeque<>();

        // Start BFS with root at horizontal distance 0
        queue.offer(new Pair(root, 0));

        // Perform level order traversal
        while (!queue.isEmpty()) {

            // Remove front element from queue
            Pair current = queue.poll();
            TreeNode node = current.node;
            int hd = current.hd;

            // IMPORTANT:
            // Store the first node encountered at each horizontal distance
            // This represents the topmost visible node
            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
            }

            // Move left: horizontal distance decreases by 1
            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }

            // Move right: horizontal distance increases by 1
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        // Extract values from map in sorted order
        for (int value : map.values()) {
            result.add(value);
        }

        return result;
    }



    ///bottom view
    ///  In botton view only the line 108 is different from top view

    public List<Integer> bottomView(TreeNode root) {

        // Stores the final bottom view result
        List<Integer> result = new ArrayList<>();

        // If tree is empty, return empty list
        if (root == null) return result;

        // TreeMap keeps horizontal distances sorted (left to right)
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue for BFS traversal
        Queue<Pair> queue = new ArrayDeque<>();

        // Start BFS with root at horizontal distance 0
        queue.offer(new Pair(root, 0));

        // Perform level order traversal
        while (!queue.isEmpty()) {

            // Remove front element from queue
            Pair current = queue.poll();
            TreeNode node = current.node;
            int hd = current.hd;

            // IMPORTANT:
            // Always overwrite value at the same horizontal distance
            // This ensures the bottom-most node is stored
            map.put(hd, node.val);

            // Move left: horizontal distance decreases by 1
            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }

            // Move right: horizontal distance increases by 1
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        // Extract values from map in sorted order
        for (int value : map.values()) {
            result.add(value);
        }

        return result;
    }

}
